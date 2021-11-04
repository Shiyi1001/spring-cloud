package com.shiyi.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @ClassName PayMentApplication
 * @Description
 * @Author FengL
 * @Date 2021/11/02 16:38
 * @Version V1.0
 */
@SpringBootApplication
@MapperScan("com.shiyi.springcloud.mapper") //或者直接在mapper类上添加注解@Mapper
@EnableEurekaClient
public class PayMentApplication8001 {
    public static void main(String[] args) {
        SpringApplication.run(PayMentApplication8001.class, args);
    }
}
