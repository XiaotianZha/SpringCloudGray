package com.zhang.springcloud.zuul;

import com.zhang.springcloud.zuul.filter.PreRequestGrayFilter;
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

	public static void main(String[] args) {
		SpringApplication.run(ZuulServiceApplication.class, args);
	}
}
