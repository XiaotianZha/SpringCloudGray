package com.zhang.springcloud.service.interceptor;

import com.zhang.springcloud.service.util.GrayHolder;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.client.support.HttpRequestWrapper;

import java.io.IOException;

public class CoreHttpRequestInterceptor implements ClientHttpRequestInterceptor {

    @Override
    public ClientHttpResponse intercept(HttpRequest httpRequest, byte[] bytes, ClientHttpRequestExecution clientHttpRequestExecution) throws IOException {
        HttpRequestWrapper requestWrapper = new HttpRequestWrapper(httpRequest);
        String gray = GrayHolder.isGray();
        requestWrapper.getHeaders().add("gray-head", gray);
        return clientHttpRequestExecution.execute(requestWrapper, bytes);
    }
}
