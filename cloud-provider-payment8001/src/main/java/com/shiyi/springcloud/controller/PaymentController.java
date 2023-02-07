package com.shiyi.springcloud.controller;

import com.shiyi.springcloud.entities.CommonResponseResult;
import com.shiyi.springcloud.entities.Payment;
import com.shiyi.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName PaymentController
 * @Description
 * @Author FengL
 * @Date 2021/11/03 15:23
 * @Version V1.0
 */
@RestController
@RequestMapping("payment")
@Slf4j
public class PaymentController {

    @Value("${server.port}")
    private String serverport;

    @Resource
    private DiscoveryClient discoveryClient;
    @Resource
    PaymentService paymentService;

    @PostMapping("insertPayment")
    public CommonResponseResult insertPayment(@RequestBody Payment payment) {
        int result = paymentService.insertPayment(payment);
        if (result > 0) {
            return CommonResponseResult.successResult("插入成功,serverport:" + serverport);
        } else {
            return CommonResponseResult.successResult("插入失败,serverport:" + serverport);
        }
    }

    @GetMapping("get/{id}")
    public CommonResponseResult getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        return CommonResponseResult.successResult("查询成功，serverport：" + serverport,payment);
    }

    @GetMapping("getDiscovery")
    public Object discovery() {
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            log.info(service);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info(instance.getServiceId() + "\t" + instance.getHost() + "\t" + instance.getPort() + "\t" + instance.getUri());
        }
        return this.discoveryClient;
    }

    @GetMapping(value = "lb")
    public String getPaymentLB()
    {
        return serverport;
    }
}
