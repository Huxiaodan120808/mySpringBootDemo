package com.example.demo.exception;

/**
 * Created by hxd on 2020/7/30
 */
public enum StatusCode {
    OK(200, "操作成功"),
    OPERATION_ERROR(500, "操作失败"),
    NO_PERMISSION(401, "无权限访问"),
    DEFINED_CODE(100, "未知异常"),
    BAD_REQUEST(400, "未知异常"),
    CURRENCE_USER_ERROR(600, "获取当前登录用户信息错误"),
    TOKEN_IS_EMTRY(601, "TOKEN为空"),
    INAVIGATION_sERVICE(1000, "微服务异常"),
    USER_NOT_FOUND(1001, "找不到该用户"),
    USER_HAD_REGISTER(1002, "该用户已经被注册"),
    ROLE_EXIST(1004, "该角色已经存在"),
    ROLE_NOT_FOUND(1005, "角色找不到"),
    PASSWORD_ERROR(1003, "密码错误");

    private int code;

    private String msg;

    public int code() {
        return code;
    }

    public String msg() {
        return msg;
    }

    StatusCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static StatusCode getEnum(int code) {
        for (StatusCode errorCodeEnum : StatusCode.values()) {
            if (errorCodeEnum.code == code) {
                return errorCodeEnum;
            }
        }
        return null;
    }

    public void setStatus(int code, String message) {
        this.code = code;
        this.msg = message;
    }
    }
