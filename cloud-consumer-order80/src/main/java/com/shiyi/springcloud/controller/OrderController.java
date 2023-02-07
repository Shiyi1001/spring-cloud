package com.shiyi.springcloud.controller;

import com.shiyi.springcloud.entities.CommonResponseResult;
import com.shiyi.springcloud.entities.Payment;
import com.shiyi.springcloud.lb.LoadBalance;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

/**
 * @ClassName OrderController
 * @Description
 * @Author FengL
 * @Date 2021/11/03 17:26
 * @Version V1.0
 */
@RestController
@RequestMapping("consumer")
public class OrderController {

//    private static final String PaymentSrv_URL = "http://localhost:8001";
    private static final String PaymentSrv_URL = "http://CLOUD-PAYMENT-SERVICE";

    @Resource
    private DiscoveryClient discoveryClient;
    @Resource
    private LoadBalance loadBalance;
    @Resource
    private RestTemplate restTemplate;

    @GetMapping("payment/insertPayment")//客户端用浏览器是get请求，但是底层实质发送post调用服务
    public CommonResponseResult insertPayment(Payment payment){
        CommonResponseResult commonResponseResult = restTemplate.postForObject(PaymentSrv_URL + "/payment/insertPayment", payment, CommonResponseResult.class);
        return commonResponseResult;
    }

    @GetMapping("payment/get/{id}")
    public CommonResponseResult getPayment(@PathVariable("id") Long id){
        CommonResponseResult commonResponseResult = restTemplate.getForObject(PaymentSrv_URL + "/payment/get/" + id, CommonResponseResult.class,id);
        return commonResponseResult;
    }

    @GetMapping("payment/getForEntity/{id}")
    public CommonResponseResult getPayment2(@PathVariable("id") Long id){
        ResponseEntity<CommonResponseResult> responseEntity = restTemplate.getForEntity(PaymentSrv_URL + "/payment/get/" + id, CommonResponseResult.class, id);
        if(responseEntity.getStatusCode().is2xxSuccessful()){
            return responseEntity.getBody();
        }else{
            return CommonResponseResult.failerResult("操作报错");
        }
    }

    @GetMapping("payment/lb")
    public String getPaymentlb(){
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        ServiceInstance serviceInstance = loadBalance.instances(instances);
        URI uri = serviceInstance.getUri();
       return  restTemplate.getForObject(uri + "/payment/lb", String.class);
    }

}
