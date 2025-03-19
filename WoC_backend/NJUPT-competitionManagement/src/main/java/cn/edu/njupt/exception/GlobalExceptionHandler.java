package cn.edu.njupt.exception;

import cn.edu.njupt.common.enums.ErrorEnum;
import cn.edu.njupt.response.GlobalResponse;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.validation.ObjectError;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<GlobalResponse<?>> handleBusinessException(BusinessException e) {
        ErrorEnum errorEnum = e.getErrorEnum();
        return ResponseEntity.ok(
                GlobalResponse.failure(errorEnum)
        );
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<GlobalResponse<?>> handleException(Exception e) {
        return ResponseEntity.ok(
                GlobalResponse.failure(
                        ErrorEnum.COMMON_ERROR,"系统异常"+e.getMessage())
        );
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<GlobalResponse<?>> handlerValidationException(MethodArgumentNotValidException e) {
        String messages = e.getBindingResult().getAllErrors().stream()
                .map(ObjectError::getDefaultMessage)
                .collect(Collectors.joining("\n"));
        return ResponseEntity.ok(
                GlobalResponse.failure(
                        ErrorEnum.PARAM_ERROR,
                        messages
                )
        );
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<GlobalResponse<?>> handlerMissingServletRequestParameterException(MissingServletRequestParameterException e) {
        return ResponseEntity.ok(
                GlobalResponse.failure(
                        ErrorEnum.PARAM_ERROR,
                        "参数缺失: " + e.getParameterName() + " 必须提供"
                )
        );
    }

    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public ResponseEntity<GlobalResponse<?>> handlerSQLIntegrityConstraintViolationException(SQLIntegrityConstraintViolationException e) {
        return ResponseEntity.ok(
                GlobalResponse.failure(
                        ErrorEnum.DATA_CONFLICT,
                        "数据冲突: " + e.getMessage()
                )
        );
    }

    @ExceptionHandler(HttpServerErrorException.class)
    public ResponseEntity<GlobalResponse<?>> handlerHttpServerErrorException(HttpServerErrorException e) {
        return ResponseEntity.ok(
                GlobalResponse.failure(
                        ErrorEnum.HTTP_SERVER_ERROR,
                        "服务器内部错误: " + e.getMessage()
                )
        );
    }
}

