package com.yitu2.demo.error;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * 500异常捕获
 * @author Administrator
 */
@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(value = {Exception.class})
    @ResponseBody
    public Object error(Exception ex){

        Map<String,String> map = new HashMap<>();
        map.put("error", ex.getMessage());
        map.put("status", "500");
        return map;
    }
}