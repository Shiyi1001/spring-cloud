package com.shiyi.springcloud.service.impl;

import com.shiyi.springcloud.entities.Payment;
import com.shiyi.springcloud.mapper.PaymentMapper;
import com.shiyi.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @ClassName PaymentServiceImpl
 * @Description
 * @Author FengL
 * @Date 2021/11/03 9:28
 * @Version V1.0
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentMapper paymentMapper;

    @Override
    public int insertPayment(Payment payment) {
        return paymentMapper.insertPayment(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentMapper.getPaymentById(id);
    }
}
