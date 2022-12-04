package com.academy.order.handler;

import com.alibaba.csp.sentinel.adapter.spring.webmvc.callback.BlockExceptionHandler;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.authority.AuthorityException;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeException;
import com.alibaba.csp.sentinel.slots.block.flow.FlowException;
import com.alibaba.csp.sentinel.slots.block.flow.param.ParamFlowException;
import com.alibaba.csp.sentinel.slots.system.SystemBlockException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
@Component
public class MyBlockExceptionHandler implements BlockExceptionHandler {
    Logger log = LoggerFactory.getLogger(MyBlockExceptionHandler.class);
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, BlockException e) throws Exception {
        log.error("BlockException ================== " + e.getRule());
        String result = "";
        if(e instanceof FlowException){
            result = "接口限流了";
        }else if(e instanceof DegradeException){
            result = "接口降级了";
        }else if(e instanceof ParamFlowException){
            result = "热点参数限流了";
        }else if(e instanceof SystemBlockException){
            result = "触发系统保护规则了";
        }else if(e instanceof AuthorityException){
            result = "授权规则不通过";
        }
        httpServletResponse.setStatus(500);
        httpServletResponse.setCharacterEncoding("UTF-8");
        httpServletResponse.setContentType(MediaType.APPLICATION_JSON_VALUE);
        PrintWriter writer = httpServletResponse.getWriter();
        new ObjectMapper().writeValue(writer, result);

    }
}
