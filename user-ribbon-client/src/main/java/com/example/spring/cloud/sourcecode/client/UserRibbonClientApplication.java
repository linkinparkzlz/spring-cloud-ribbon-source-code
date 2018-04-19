package com.example.spring.cloud.sourcecode.client;


import com.example.spring.cloud.sourcecode.client.ping.MyPing;
import com.example.spring.cloud.sourcecode.rule.MyRule;
import com.netflix.loadbalancer.IPing;
import com.netflix.loadbalancer.IRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
@RibbonClient("user-service-provider") //  指定目标应用名称
public class UserRibbonClientApplication {


    public static void main(String[] args) {


        //   SpringApplication.run(UserRibbonClientApplication.class, args);


        UriComponentsBuilder builder = UriComponentsBuilder.newInstance();
        builder.scheme("http");
        builder.host("localhost");
        builder.port(9090);
        builder.path("/health");

    }

    @Bean //暴露成为Bean
    public IRule myRule() {

        return new MyRule();
    }

    @Bean
    public IPing myPing() {
        return new MyPing();
    }


}
