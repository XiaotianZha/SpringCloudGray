package com.zhang.springcloud.service.config;

import com.zhang.springcloud.service.interceptor.CoreFeignRequestInterceptor;
import feign.Contract;
import feign.RequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
 * 该类为Feign的配置类
 * 注意：该类不应该在主应用程序上下文的@ComponentScan中
 * @author EdisonZhou
 */
@Configuration
public class FeignConfiguration {

    @Bean
    public RequestInterceptor interceptor(){
        return new CoreFeignRequestInterceptor();
    }
}
