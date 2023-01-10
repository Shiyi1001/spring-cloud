package com.shiyi.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @ClassName PaymentController
 * @Description
 * @Author FengL
 * @Date 2021/11/08 14:51
 * @Version V1.0
 */
@RestController
@RequestMapping("payment")
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("zk")
    public String paymentZk(){
        return "SpringCloud with Zookeeper:" + serverPort + "\t" + UUID.randomUUID();
    }
}
