package com.academy.order.openfeign;

import com.academy.order.conf.FeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "mail-service", path = "/mail", configuration = {FeignConfig.class})
public interface MailFeignService {
    @RequestMapping("send/{orderId}")
    public String send(@PathVariable("orderId") String orderId);
}
