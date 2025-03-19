package cn.edu.njupt.response;

import cn.edu.njupt.common.enums.ErrorEnum;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.HashMap;

//后端统一返回结果
//@Data
@Getter
@Setter
public class GlobalResponse<T> implements Serializable {

    private Integer errCode;
    private String errMsg;
    private boolean success;
    private T data;


//    带数据的成功响应
    public static <T>GlobalResponse<T> success(T data) {
        GlobalResponse<T> globalResponse = new GlobalResponse();
        globalResponse.setErrCode(0);
        globalResponse.setErrMsg("success");
        globalResponse.setSuccess(true);
        globalResponse.setData(data);
        return globalResponse;
    }

//    不带数据的成功响应
    public static <T>GlobalResponse<T> success() {
        return success((T) new HashMap<>());
    }

    public static <T> GlobalResponse<T> failure(ErrorEnum errorEnum, String message) {
        GlobalResponse<T> response = new GlobalResponse<>();
        response.setErrCode(errorEnum.getErrCode());
        response.setErrMsg(message); // 使用自定义信息
        response.setSuccess(false);
        return response;
    }

    public static <T> GlobalResponse<T> failure(String message) {
        return failure(ErrorEnum.COMMON_ERROR, message);
    }


    public static <T> GlobalResponse<T> failure(ErrorEnum errorEnum) {
        GlobalResponse<T> globalResponse = new GlobalResponse();
        globalResponse.setErrCode(errorEnum.getErrCode());
        globalResponse.setErrMsg(errorEnum.getErrMsg());
        globalResponse.setSuccess(false);
        return globalResponse;
    }

}
