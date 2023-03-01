package com.example.demo.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;

/**
 * Created by hxd 2020/7/30
 * 错误对象
 * {
 *     timestamp
 *     statusCode
 *     message
 * }
 * */
@Data // 可以实现不用写getter/setter方法
public class ErrorInfo {

    private LocalDateTime timestamp; // 字段1
    private StatusCode statusCode; // 字段2
    private String message; // 字段3

    public  ErrorInfo() {
        this.timestamp = LocalDateTime.now();
    }

    public static ResponseEntity<Object> response(StatusCode statusCode, String message){
        ErrorInfo errorInfo =  new ErrorInfo(); // 当创建错误对象时自动获取当前时间作为标记错误时间
        errorInfo.setStatusCode(statusCode);
        errorInfo.setMessage(message);
        return new ResponseEntity<>(errorInfo, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
