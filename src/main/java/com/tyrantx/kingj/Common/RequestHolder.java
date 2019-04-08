package com.tyrantx.kingj.Common;

import com.tyrantx.kingj.DO.User;

import javax.servlet.http.HttpServletRequest;

/**
 * @param: none
 * @description: 在请求发送过来之前拦截请求并将其中用户信息放入ThreadLocal变量当中
 * @author: KingJ
 * @create: 2019-03-31 14:00
 **/
public class RequestHolder {

    private static final ThreadLocal<Long> requestHolder = new ThreadLocal<>();

    public static void add(Long id) {
        requestHolder.set(id);
    }

    public static long getID() {
        return requestHolder.get();
    }

    public static void remove() {
        requestHolder.remove();
    }
}
