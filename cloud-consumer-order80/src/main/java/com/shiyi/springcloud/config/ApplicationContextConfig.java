package com.shiyi.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * @ClassName ApplicationContextConfig
 * @Description
 * @Author FengL
 * @Date 2021/11/03 17:26
 * @Version V1.0
 */
@Configuration
public class ApplicationContextConfig {

    //使用@LoadBalanced注解赋予RestTemplate负载均衡的能力
    @Bean
//    @LoadBalanced
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
