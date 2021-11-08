package com.shiyi.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @ClassName PaymentApplcation8004
 * @Description
 * @Author FengL
 * @Date 2021/11/08 14:50
 * @Version V1.0
 */
@SpringBootApplication
@EnableDiscoveryClient
public class PaymentApplcation8004 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentApplcation8004.class, args);
    }
}
