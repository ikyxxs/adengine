package com.ikyxxs.adengine.config;

import com.ikyxxs.adengine.intercepter.RequestThreadLocalInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * WebMVC配置
 *
 * @author 木白
 * @date 2022/05/11
 */
@Configuration
public class SpringMvcConfig implements WebMvcConfigurer {

    @Autowired
    private RequestThreadLocalInterceptor requestThreadLocalInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(requestThreadLocalInterceptor).addPathPatterns("/getAdvert");
    }
}
