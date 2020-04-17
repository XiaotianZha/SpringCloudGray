package com.zhang.springcloud.zuul;

import com.netflix.hystrix.strategy.concurrency.HystrixRequestContext;
import com.netflix.loadbalancer.IRule;
import com.zhang.springcloud.zuul.filter.PostRequestGrayFilter;
import com.zhang.springcloud.zuul.filter.PreRequestGrayFilter;
import com.zhang.springcloud.zuul.ribbon.GrayMetadataRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableZuulProxy
public class ZuulServiceApplication {

	@Bean
	public PreRequestGrayFilter getFilter(){
		return new PreRequestGrayFilter();
	}

//	@Bean
//	public PostRequestGrayFilter getPostFilter(){
//		return new PostRequestGrayFilter();
//	}

	@Bean
	public IRule ribbonRule() {
		return new GrayMetadataRule();//这里配置策略，和配置文件对应
	}

	public static void main(String[] args) {

		SpringApplication.run(ZuulServiceApplication.class, args);
	}
}
