package com.shiyi.springcloud.service;

import com.shiyi.springcloud.entities.Payment;

public interface PaymentService {

    int insertPayment(Payment payment);

    Payment getPaymentById(Long id);
}
