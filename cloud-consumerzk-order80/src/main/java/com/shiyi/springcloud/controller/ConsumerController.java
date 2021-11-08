package com.shiyi.springcloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @ClassName ConsumerController
 * @Description
 * @Author FengL
 * @Date 2021/11/08 15:32
 * @Version V1.0
 */
@RestController
@RequestMapping("consumer")
public class ConsumerController {

    private static final String INVOLE_URL = "http://cloud-provider-payment";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("payment/zk")
    public String getPaymentzk(){
       return restTemplate.getForObject(INVOLE_URL + "/payment/zk", String.class);
    }
}
