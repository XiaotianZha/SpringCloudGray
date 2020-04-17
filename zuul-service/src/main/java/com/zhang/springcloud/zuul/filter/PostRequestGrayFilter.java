package com.zhang.springcloud.zuul.filter;

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
public class PostRequestGrayFilter extends ZuulFilter {
    private static final Logger LOGGER = LoggerFactory.getLogger(PostRequestGrayFilter.class);

    // 返回过滤器的类型
    // 可选项：pre, route, post, error
    @Override
    public String filterType() {
        return "post";
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
        LOGGER.info(GrayHolder.isGray());

        return null;
    }
}
