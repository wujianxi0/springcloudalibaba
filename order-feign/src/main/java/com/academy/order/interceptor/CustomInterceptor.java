package com.academy.order.interceptor;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.apache.juli.logging.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CustomInterceptor implements RequestInterceptor {
    Logger logger = LoggerFactory.getLogger(CustomInterceptor.class);
    public void apply(RequestTemplate template) {
//        template.query("orderId", "9");
//        template.uri("9", false);
        logger.info("进入custom interceptor");
    }
}
