package com.yk.example;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by yk on 16/2/25.
 */
@ControllerAdvice
public class ApplicationExceptionHandler {

    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(NullPointerException.class)
    @ResponseBody
    public Object unauthorized(HttpServletRequest request,Exception e) {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        if (e instanceof NullPointerException) {
            resultMap.put("error","空指针");
        }
        return resultMap;
    }
}
