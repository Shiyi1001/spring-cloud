package com.shiyi.springcloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @ClassName ConsulController
 * @Description
 * @Author FengL
 * @Date 2021/11/08 17:29
 * @Version V1.0
 */
@RestController
@RequestMapping("consumer")
public class ConsulController {

    private static final String INVOLE_URL = "http://consul-provider-payment";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("payment/consul")
    public String getPaymentzk(){
        return restTemplate.getForObject(INVOLE_URL + "/payment/consul", String.class);
    }
}
