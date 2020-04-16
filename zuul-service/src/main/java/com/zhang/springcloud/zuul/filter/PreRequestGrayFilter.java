package com.zhang.springcloud.zuul.filter;

import com.netflix.hystrix.strategy.concurrency.HystrixRequestContext;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.zhang.springcloud.zuul.util.GrayHolder;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

/**
 *  grayFilter
 */
public class PreRequestGrayFilter extends ZuulFilter {
    private static final Logger LOGGER = LoggerFactory.getLogger(PreRequestGrayFilter.class);

    // 返回过滤器的类型
    // 可选项：pre, route, post, error
    @Override
    public String filterType() {
        return "pre";
    }

    // 返回一个int值来指定过滤器的执行顺序
    // 不同的过滤器允许返回相同的数字
    @Override
    public int filterOrder() {
        return 1;
    }

    // 返回一个boolean值来判断该过滤器是否要执行
    @Override
    public boolean shouldFilter() {
        return true;
    }

    // 过滤器具体逻辑
    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        String gray=request.getParameter("gray");
        //add header
        ctx.addZuulRequestHeader("gray-head", gray);
//        HystrixRequestContext.initializeContext();
        if (StringUtils.isNotEmpty(gray)){
            GrayHolder.setGray();
        }
        LOGGER.info(GrayHolder.isGray());
        LOGGER.info(String.format("send %s request to %s",
                request.getMethod(),
                request.getRequestURL().toString()));

        return null;
    }
}
