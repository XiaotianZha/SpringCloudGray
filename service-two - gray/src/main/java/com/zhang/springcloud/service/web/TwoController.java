package com.zhang.springcloud.service.web;

import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TwoController {

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/service-instance")
    public String showInfo(){
        return "gray true";
    }
}
