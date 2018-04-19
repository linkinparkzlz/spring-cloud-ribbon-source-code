package com.example.spring.cloud.sourcecode.web.controller;

import com.example.spring.cloud.sourcecode.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

@RestController
public class UserRibbonController {


    /**
     * 负载均衡客户端
     */
    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Value("${provider.service.name}")
    private String providerServiceName;


    @GetMapping("")
    public String index() throws IOException {

        User user = new User();

        user.setId(1L);
        user.setName("zzz");

        //选择指定的  service  Id
        ServiceInstance serviceInstance = loadBalancerClient.choose(providerServiceName);

       return loadBalancerClient.execute(providerServiceName, serviceInstance, serviceInstance1 -> {

            //  服务器实例  ，获取主机名，和端口
            String host = serviceInstance1.getHost();

            int port = serviceInstance1.getPort();

            String url = "http://" + host + ":" + port + "/user/save";

            RestTemplate restTemplate = new RestTemplate();

            return restTemplate.postForObject(url, user, String.class);


        });


    }


}













