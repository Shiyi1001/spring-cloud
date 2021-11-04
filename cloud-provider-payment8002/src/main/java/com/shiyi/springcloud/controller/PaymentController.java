package com.shiyi.springcloud.controller;

import com.shiyi.springcloud.entities.CommonResponseResult;
import com.shiyi.springcloud.entities.Payment;
import com.shiyi.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @ClassName PaymentController
 * @Description
 * @Author FengL
 * @Date 2021/11/03 15:23
 * @Version V1.0
 */
@RestController
@RequestMapping("payment")
public class PaymentController {

    @Value("${server.port}")
    private String serverport;
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
}
