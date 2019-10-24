package com.tyrantx.kingj.config;

import com.tyrantx.kingj.common.XInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @param: none
 * @description: 拦截器适配器
 *               负责拦截器的配置
 * @author: KingJ
 * @create: 2019-02-08 16:56
 **/
@Configuration
public class InterceptorWebConfigure implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        // "/*/**"代表对所有url请求进行拦截
        registry.addInterceptor(new XInterceptor()).addPathPatterns("/test/**");
    }
}
