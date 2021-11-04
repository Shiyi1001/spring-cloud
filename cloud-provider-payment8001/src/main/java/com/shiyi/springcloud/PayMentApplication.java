package com.shiyi.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @ClassName PayMentApplication
 * @Description
 * @Author FengL
 * @Date 2021/11/02 16:38
 * @Version V1.0
 */
@SpringBootApplication
@MapperScan("com.shiyi.springcloud.mapper") //或者直接在mapper类上添加注解@Mapper
public class PayMentApplication {
    public static void main(String[] args) {
        SpringApplication.run(PayMentApplication.class, args);
    }
}
