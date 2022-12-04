package com.academy.nacosconfig.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/config")
@RefreshScope
public class ConfigController {
    @Value("${user.name:123}")
    private String username;

    @Value("${server.port}")
    private String applicationName;

    @RequestMapping("/get")
    private String get(){
        return username;
    }
    @RequestMapping("/applicationName")
    private String applicationName(){
        return applicationName;
    }

}
