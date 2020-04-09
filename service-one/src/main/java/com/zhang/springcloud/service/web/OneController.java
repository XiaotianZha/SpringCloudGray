package com.zhang.springcloud.service.web;

import com.zhang.springcloud.service.feign.TwoFeignClient;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class OneController {
    @Autowired
    private TwoFeignClient client;

    @RequestMapping(value = "/getTwoInfo", method = RequestMethod.GET)
    public String showTowInfo(){
        return client.showInfo();
    }

    @Autowired
    private DiscoveryClient discoveryClient;

}
