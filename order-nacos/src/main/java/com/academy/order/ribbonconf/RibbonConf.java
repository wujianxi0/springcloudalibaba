package com.academy.order.ribbonconf;

import com.alibaba.cloud.nacos.ribbon.NacosRule;
import com.netflix.loadbalancer.IRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class RibbonConf {
    @Bean
    public IRule iRule(){
        return new NacosRule();
    }
}
