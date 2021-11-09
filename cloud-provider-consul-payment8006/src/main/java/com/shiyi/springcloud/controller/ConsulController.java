package com.shiyi.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @ClassName ConsulController
 * @Description
 * @Author FengL
 * @Date 2021/11/08 17:20
 * @Version V1.0
 */
@RestController
@RequestMapping("payment")
public class ConsulController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("consul")
    public String paymentConsul(){
        return "SpringCloud with Consul:" + serverPort + "\t" + UUID.randomUUID().toString();
    }
}
