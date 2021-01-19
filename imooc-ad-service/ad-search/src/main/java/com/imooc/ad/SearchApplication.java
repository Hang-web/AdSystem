package com.imooc.ad;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@EnableFeignClients //使用Feign去访问微服务
@EnableEurekaClient
@EnableHystrix //使用断路器
@EnableCircuitBreaker
@EnableDiscoveryClient //启动微服务的发现能力
@EnableHystrixDashboard //断路器的监控
@SpringBootApplication
public class SearchApplication {

    public static void main(String[] args) {

        SpringApplication.run(SearchApplication.class, args);
    }

    @Bean
    @LoadBalanced //开启负载均衡的能力，在使用SpringCloud Ribbon客户端时，在restTemplate bean上加此注解
    RestTemplate restTemplate() {

        return new RestTemplate();
    }
}
