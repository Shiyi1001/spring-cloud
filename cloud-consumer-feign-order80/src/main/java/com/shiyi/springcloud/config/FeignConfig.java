package com.shiyi.springcloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @author FengL
 * @className FeignConfig
 * @description
 * @date 2023/2/15 22:24
 */
@Component
public class FeignConfig {

    @Bean
    Logger.Level feignLoggerLevel()
    {
        return Logger.Level.FULL;
    }
}
