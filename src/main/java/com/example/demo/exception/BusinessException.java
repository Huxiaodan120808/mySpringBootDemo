package com.example.demo.exception;

/**
 * Created  by hxd on 2020/7/30
 * 自定义封装BusinessException
 */
public class BusinessException extends RuntimeException {
    /**
     * 异常码
     */
    protected int code;

    // 引入状态Enum
    private StatusCode statusCode;

    private static final long serialVersionUID = 3160241586346324994L;


    public BusinessException() {
    }

    public BusinessException(Throwable cause) {
        super(cause);
    }

    public BusinessException(String message) {
        super(message); // 调用父亲的构造器
    }

    public BusinessException(String message, Throwable cause) {
        super(message, cause);
    }

    public BusinessException(int code, String message) {
        super(message);
        this.code = code;
    }

    public BusinessException(int code, String msgFormat, Object... args) {
        super(String.format(msgFormat, args));
        this.code = code;
    }

    public BusinessException(StatusCode statusCode, Object... args) {
        super(String.format(statusCode.msg(), args));
        this.code = statusCode.code();
        this.statusCode = statusCode;
    }


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public StatusCode getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(StatusCode statusCode) {
        this.statusCode = statusCode;
    }
}
