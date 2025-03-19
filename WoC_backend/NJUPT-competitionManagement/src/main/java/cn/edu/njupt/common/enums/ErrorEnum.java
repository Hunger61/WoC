package cn.edu.njupt.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorEnum {

//    成员错误
    MEMBER_NOT_FOUND(2000, "成员不存在"),
    DUPLICATE_STUDENT_ID(2001, "学号已存在"),
    INVALID_ISCAPTAIN(2002, "队长标识无效（0或1）"),
    TEAM_NOT_FOUND(2003, "团队不存在"),

    /* 错误 */
    COMMON_ERROR(1000, "错误"),

    /* 登录异常 */
    LOGIN_ERROR(1009, "登陆失败") ,

    /* 参数错误 */
    PARAM_ERROR(1005, "参数错误") ,
    DATA_CONFLICT(1012, "数据冲突"),
    HTTP_SERVER_ERROR(5000, "服务器内部错误"),


    /* 权限错误 */
    PERMISSION_ERROR(1001, "权限错误"),
    //    签名错误
    TOKEN_SIGNATURE_ERROR(3001,"无效签名，token被篡改"),
    TOKEN_EXPIRED(3002,"token已过期"),
    TOKEN_DECODE_ERROR(3003,"token解析失败");










    private final Integer errCode;
    private final String errMsg;
}