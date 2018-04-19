package com.example.spring.cloud.sourcecode.rule;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

import java.util.List;

public class MyRule extends AbstractLoadBalancerRule {

    private ILoadBalancer iLoadBalancer;


    @Override
    public void initWithNiwsConfig(IClientConfig iClientConfig) {

    }

    @Override
    public Server choose(Object o) {
        ILoadBalancer loadBalancer = getLoadBalancer();

        //获取所有的可达服务器列表
        List<Server> servers = loadBalancer.getReachableServers();

        if (servers.isEmpty()) {
            return null;
        }

        //永远选择最后一台服务器

        Server server = servers.get(servers.size() - 1);

        return server;

    }
}



































