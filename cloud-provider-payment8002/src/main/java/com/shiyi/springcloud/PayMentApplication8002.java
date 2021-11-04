package com.shiyi.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @ClassName PayMentApplication8002
 * @Description
 * @Author FengL
 * @Date 2021/11/04 15:48
 * @Version V1.0
 */
@SpringBootApplication
@MapperScan("com.shiyi.springcloud.mapper")
@EnableEurekaClient
public class PayMentApplication8002 {
    public static void main(String[] args) {
        SpringApplication.run(PayMentApplication8002.class, args);
    }
}
