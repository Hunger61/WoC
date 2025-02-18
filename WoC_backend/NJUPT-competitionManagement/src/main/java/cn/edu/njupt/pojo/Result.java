package cn.edu.njupt.pojo;

import lombok.Data;

import java.io.Serializable;

//后端统一返回结果
@Data

public class Result implements Serializable {

    private Integer errCode;
    private String errMsg;
    private boolean success;
    private Object data;

    public static Result success(Object object) {
        Result result = new Result();
        result.errCode = 0;
        result.errMsg = "success";
        result.success = true;
        result.data = object;
        return result;
    }

    public static Result success() {
        Result result = new Result();
        result.errCode = 0;
        result.errMsg = "success";
        result.success = true;
//        将data赋值为{}
//        result.data = new Object();
        return result;
    }
    public static Result error(String msg) {
        Result result = new Result();
        result.errCode = 1;
        result.errMsg = msg;
        result.success = false;
        return result;
    }
}
