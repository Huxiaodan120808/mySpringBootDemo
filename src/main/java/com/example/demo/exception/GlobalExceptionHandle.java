package com.example.demo.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;


@Slf4j // 实现该类里面写日志输出了 log.info（）即可
@ControllerAdvice // 全局异常处理、全局数据绑定、全局数据预处理
public class GlobalExceptionHandle {
    /**
     * 系统自定义异常
     *
     * @param request 请求对象
     * @param e       异常对象
     * @return
     */
    @ResponseBody
    @ExceptionHandler(value = BusinessException.class)
    // 铺抓到BusinessException时就执行以下方法
    public ResponseEntity<Object> businessExceptionHandler(HttpServletRequest request, BusinessException e) {
        if (e.getStatusCode() == null) {
            return ErrorInfo.response(StatusCode.DEFINED_CODE, e.getMessage());
        }
        String message = e.getMessage();
        log.error("url={},message={}, stack:", request.getRequestURL().toString(), message, e);
        return ErrorInfo.response(e.getStatusCode(), message);
    }
    @ResponseBody
    @ExceptionHandler(value = RuntimeException.class)
    public ResponseEntity<Object> exceptionHandler(HttpServletRequest request, Exception e) {
        log.error("url={},stack:", request.getRequestURL().toString(), e);
        String message = e.getMessage();
        return  ErrorInfo.response(StatusCode.DEFINED_CODE, message);
    }
}
