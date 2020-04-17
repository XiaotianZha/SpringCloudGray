package com.zhang.springcloud.service;

import com.netflix.loadbalancer.IRule;
import com.zhang.springcloud.service.interceptor.CoreHttpRequestInterceptor;
import com.zhang.springcloud.service.ribbon.GrayMetadataRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;


@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class ServiceOneApplication {

	/*@Autowired
	private RestTemplateBuilder builder;

	@Bean
	public RestTemplate restTemplate(){
//		builder.setI
		RestTemplate template = builder.build();
		List<ClientHttpRequestInterceptor> interceptors = new ArrayList<>();
		interceptors.add(new CoreHttpRequestInterceptor());
//		template.setInterceptors(new ArrayList<ClientHttpRequestInterceptor>(new CoreHttpRequestInterceptor()));
		return template;
	}*/

	@Bean
	public IRule ribbonRule() {
		return new GrayMetadataRule();//这里配置策略，和配置文件对应
	}

	public static void main(String[] args) {
		SpringApplication.run(ServiceOneApplication.class, args);
	}
}
