package com.academy.order.conf;

import com.academy.order.interceptor.CustomInterceptor;
import feign.Logger;
import feign.RequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class FeignConfig {

    @Bean
    public Logger.Level feignLoggerLevel(){
        return Logger.Level.FULL;
    }

//    @Bean
//    public RequestInterceptor requestInterceptor(){
//        return new CustomInterceptor();
//    }
}
