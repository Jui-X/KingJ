package com.tyrantx.kingj.Aspect;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

/**
 * @param: none
 * @description: 用户权限验证
 * @author: KingJ
 * @create: 2019-02-20 20:33
 **/

/**
 * @Aspect注解 是不能通过类路径自动检测发现的，所以需要配合@Component注释
 * 可以通过&&、||、! 进行组合切面编程
 */
@Aspect
@Component
public class UserAspectJ {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Pointcut("within(com.tyrantx.kingj.Controller.*.*)" +
            "&& !execution(public * com.tyrantx.kingj.Controller.*.*(..))")
    private void verify() { }

    @Before("verify()")
    private void user_verify(){ }

    @Pointcut("within(com.tyrantx.kingj.Controller.UserController.*)")
    private void authorized() {}

    @Before("authorized()")
    private void user_authorized() {}

    @AfterReturning(pointcut = "execution(public * com.tyrantx.kingj.Controller.UserController.queryAllUsers(..))",
            returning = "retVal")
    public void AfterReturningUser(Object retVal) {}
}
