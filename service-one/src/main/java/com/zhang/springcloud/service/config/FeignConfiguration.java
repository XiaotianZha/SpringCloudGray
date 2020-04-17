package com.zhang.springcloud.service.config;

import com.zhang.springcloud.service.interceptor.CoreFeignRequestInterceptor;
import feign.RequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class FeignConfiguration {

    @Bean
    public RequestInterceptor interceptor(){
        return new CoreFeignRequestInterceptor();
    }
}
