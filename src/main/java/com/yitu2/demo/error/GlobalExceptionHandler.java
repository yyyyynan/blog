package com.yitu2.demo.error;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
//@ControllerAdvice(basePackages = "com.yitu2.demo.controller")
/**
 * 全局异常捕获处理
 * @author Administrator
 */

@ControllerAdvice
//@Slf4j
public class GlobalExceptionHandler {

    private final static Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * 拦截运行时异常的代码
     *
     * @return
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Map<String, Object> errorResult(HttpServletRequest request, Exception ex) {
        Map<String, Object> errorResultMap = new HashMap<String, Object>();
        errorResultMap.put("status", "100");
        errorResultMap.put("errorMsg", ex.getMessage());
        log.error(request.getRemoteAddr() + "访问"+request.getRequestURI() + "时出现异常：" + ex.getMessage());
        return errorResultMap;
    }


//    @ExceptionHandler(NoHandlerFoundException.class)
//    @ResponseBody
//    @ResponseStatus(HttpStatus.NOT_FOUND)
//    public Map<String, Object> notFountHandler(HttpServletRequest request, NoHandlerFoundException ex) {
//        Map<String, Object> errorResultMap = new HashMap<String, Object>();
//        errorResultMap.put("status", "404");
//        errorResultMap.put("errorMsg", ex.getMessage());
//        log.info(request.getRemoteAddr() + "出现404异常：" + ex.getMessage());
//        return errorResultMap;
//    }

}
