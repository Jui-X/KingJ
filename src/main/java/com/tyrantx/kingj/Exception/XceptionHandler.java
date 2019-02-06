package com.tyrantx.kingj.Exception;

import com.tyrantx.kingj.Utils.JSONResult;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @param: none
 * @description: 全局异常捕获类
 * @author: KingJ
 * @create: 2019-02-06 20:17
 **/
@ControllerAdvice
public class XceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public Object errorHandler(HttpServletRequest request, HttpServletResponse response, Exception e) {

        e.printStackTrace();

        if(isAjax(request)) {
            return JSONResult.errorException(e.getMessage());
        } else {
            ModelMap m = new ModelMap();
            m.addAttribute("exception", e);
            m.addAttribute("url", request.getRequestURL());
            return m;
        }
    }

    /**
     *
     * @Title: IMoocExceptionHandler.java
     * @Package com.imooc.exception
     * @Description: 判断是否是ajax请求
     * Copyright: Copyright (c) 2017
     * Company:FURUIBOKE.SCIENCE.AND.TECHNOLOGY
     *
     */
    public static boolean isAjax(HttpServletRequest httpServletRequest) {
        return ( httpServletRequest.getHeader("X-Requested-With") != null &&
                "XMLHttpRequest".equals(httpServletRequest.getHeader("X-Requested-With").toString()) );
    }
}
