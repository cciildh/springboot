package com.example.exception;

import javax.servlet.http.HttpServletRequest;

import com.example.utils.JsonUtils;
import com.example.utils.ResponseMesg;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * GlobHandler 异常处理
 * 改方式在ctroller中不能try catch
 */
@ControllerAdvice//实现全局异常处理
public class GlobHandler {

    @ExceptionHandler(Exception.class)
    public Object handlerException(Exception e, HttpServletRequest req) {

        // 使用HttpServletRequest中的header检测请求是否为ajax, 如果是ajax则返回json,
        // 如果为非ajax则返回view(即ModelAndView)
        String contentTypeHeader = req.getHeader("Content-Type");
        String acceptHeader = req.getHeader("Accept");
        String xRequestedWith = req.getHeader("X-Requested-With");

        if ((contentTypeHeader != null && contentTypeHeader.contains("application/json"))
                || (acceptHeader != null && acceptHeader.contains("application/json"))
                || "XMLHttpRequest".equalsIgnoreCase(xRequestedWith)) {
            ResponseMesg mesg = new ResponseMesg();
            mesg.setStatus(400);
            mesg.setMsg(e.getMessage());

            return JsonUtils.objectToJson(mesg);

        } else {
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.addObject("msg", e.getMessage());
            modelAndView.addObject("url", req.getRequestURL());
            modelAndView.addObject("stackTrace", e.getStackTrace());
            modelAndView.setViewName("error");
            return modelAndView;
        }
    }
}