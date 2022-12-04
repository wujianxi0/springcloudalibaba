package com.academy.loadbalancerule;

import com.alibaba.nacos.shaded.io.grpc.netty.shaded.io.netty.util.internal.ThreadLocalRandom;
import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

import java.util.List;

public class CustomRule extends AbstractLoadBalancerRule {
    public void initWithNiwsConfig(IClientConfig iClientConfig) {

    }

    public Server choose(Object key) {
        ILoadBalancer loadBalancer = this.getLoadBalancer();
        List<Server> reachableServers = loadBalancer.getReachableServers();
        int i = ThreadLocalRandom.current().nextInt(reachableServers.size());
        return reachableServers.get(i);
    }
}
