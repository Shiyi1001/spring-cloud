package com.shiyi.springcloud.client;

import com.shiyi.springcloud.entities.CommonResponseResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignClient {

    @GetMapping("payment/get/{id}")
    CommonResponseResult getPaymentById(@PathVariable("id") Long id);
}
