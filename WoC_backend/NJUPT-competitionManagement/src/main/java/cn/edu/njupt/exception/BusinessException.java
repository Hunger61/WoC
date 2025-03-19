package cn.edu.njupt.exception;

import cn.edu.njupt.common.enums.ErrorEnum;
import lombok.Getter;

@Getter
public class BusinessException extends RuntimeException {
    private final ErrorEnum errorEnum;

    public BusinessException(ErrorEnum errorEnum) {
        super(errorEnum.getErrMsg());
        this.errorEnum = errorEnum;
    }

}