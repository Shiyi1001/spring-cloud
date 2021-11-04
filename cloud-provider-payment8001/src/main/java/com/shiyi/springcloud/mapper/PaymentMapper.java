package com.shiyi.springcloud.mapper;

import com.shiyi.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName PaymentMapper
 * @Description
 * @Author FengL
 * @Date 2021/11/03 9:15
 * @Version V1.0
 */
public interface PaymentMapper {

    int insertPayment(@Param("payment") Payment payment);

    Payment getPaymentById(@Param("id") Long id);
}
