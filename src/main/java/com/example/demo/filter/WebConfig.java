package com.example.demo.filter;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {


    // credits:
    // http://www.javabyexamples.com/logging-with-request-correlation-using-mdc
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new MdcFilter());
    }


}
