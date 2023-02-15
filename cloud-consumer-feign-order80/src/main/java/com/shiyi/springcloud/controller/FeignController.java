package com.shiyi.springcloud.controller;

import com.shiyi.springcloud.client.PaymentFeignClient;
import com.shiyi.springcloud.entities.CommonResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author FengL
 * @className FeignController
 * @description
 * @date 2023/2/15 21:40
 */
@RestController
@RequestMapping("feign")
public class FeignController {

    @Autowired
    private PaymentFeignClient paymentFeignClient;

    @GetMapping("get/{id}")
    public CommonResponseResult getPaymentById(@PathVariable("id") Long id){
        return paymentFeignClient.getPaymentById(id);
    }
}
