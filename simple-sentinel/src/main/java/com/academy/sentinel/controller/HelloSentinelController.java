package com.academy.sentinel.controller;

import com.academy.sentinel.entity.User;
import com.alibaba.csp.sentinel.Entry;
import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.Tracer;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeRule;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeRuleManager;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@RestController
public class HelloSentinelController {
    public final static String RESOURCE_NAME_HELLO ="hello";
    public final static String RESOURCE_NAME_ANNOTATION ="annotation";

    @RequestMapping("/hello")
    public String hello(){
        String result = "hello sentinel";
        Entry entry = null;
        try{
            entry = SphU.entry(RESOURCE_NAME_HELLO);
        }catch (BlockException e) {
            result = "hello 被限流了";
        } catch (Exception e){
            Tracer.traceEntry(e, entry);
        }finally {
            if (entry != null){
                entry.exit();
            }
        }
        return result;
    }

    @RequestMapping("/annotation")
    @SentinelResource(value = RESOURCE_NAME_ANNOTATION, blockHandler = "blockHandle", fallback = "fallbackHandle")
    public User annotation(String username){
        int i = 10/0;
        return new User("hello, "+username+",  欢迎使用annotation");
    }

    public User blockHandle(String username, BlockException blockException){
        return new User("hello, "+username+",  使用annotation被限流/熔断了"+blockException.getMessage());
    }
    public User fallbackHandle(String username, Throwable t){
        return new User("hello, "+username+",  使用annotation异常了"+t.getMessage());
    }



    @PostConstruct
    private static void initFlowRules(){
        List<FlowRule> flowRules = new ArrayList<FlowRule>();
        FlowRule flowRule = new FlowRule();
        flowRule.setResource(RESOURCE_NAME_HELLO);
        flowRule.setCount(8);
        flowRule.setGrade(RuleConstant.FLOW_GRADE_QPS);
        flowRules.add(flowRule);

        /*FlowRule flowRule2 = new FlowRule();
        flowRule.setResource(RESOURCE_NAME_ANNOTATION);
        flowRule.setCount(1);
        flowRule.setGrade(RuleConstant.FLOW_GRADE_QPS);
        flowRules.add(flowRule2);*/

        FlowRuleManager.loadRules(flowRules);
    }

    @PostConstruct
    private static void initDegradeRules(){
        ArrayList<DegradeRule> degradeRules = new ArrayList<DegradeRule>();
        DegradeRule degradeRule = new DegradeRule();
        degradeRule.setResource(RESOURCE_NAME_ANNOTATION);
        degradeRule.setGrade(RuleConstant.DEGRADE_GRADE_EXCEPTION_COUNT);
        degradeRule.setCount(2);
        degradeRule.setTimeWindow(2);
        degradeRule.setStatIntervalMs(60*1000);
        degradeRule.setMinRequestAmount(20);
        degradeRules.add(degradeRule);
        DegradeRuleManager.loadRules((degradeRules));
    }

    public static void main(String[] args) {
        initFlowRules();
        while (true){
            Entry entry = null;
            try {
                entry = SphU.entry(RESOURCE_NAME_HELLO);
                System.out.println("hello sentinel");
            }catch (BlockException e) {
                System.out.println("hello 被限流了");
            } catch (Exception e){
                Tracer.traceEntry(e, entry);
            }finally {
                if (entry != null){
                    entry.exit();
                }
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

}
