package com.shiyi.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @ClassName ApplicationContexConfig
 * @Description
 * @Author FengL
 * @Date 2021/11/08 15:31
 * @Version V1.0
 */
@Configuration
public class ApplicationContexConfig {

    @Bean
    @LoadBalanced   //使用负载均衡机制  如果不加访问会报错？
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
