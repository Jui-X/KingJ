package com.tyrantx.kingj.Config;

import com.tyrantx.kingj.Controller.Interceptor.XInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @param: none
 * @description:
 * @author: KingJ
 * @create: 2019-02-08 16:56
 **/
@Configuration
public class WebConfigure implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        // "/*/**"代表对所有url请求进行拦截
        registry.addInterceptor(new XInterceptor()).addPathPatterns("/*/**");
    }
}
