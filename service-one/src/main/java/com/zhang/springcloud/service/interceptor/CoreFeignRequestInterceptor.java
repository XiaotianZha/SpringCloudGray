package com.zhang.springcloud.service.interceptor;

import com.zhang.springcloud.service.util.GrayHolder;
import feign.RequestInterceptor;
import feign.RequestTemplate;

public class CoreFeignRequestInterceptor implements RequestInterceptor {
    @Override
    public void apply(RequestTemplate requestTemplate) {
        String gray = GrayHolder.isGray();
        requestTemplate.header("gray-head", gray);
    }
}
