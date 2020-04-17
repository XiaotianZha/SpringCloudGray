package com.zhang.springcloud.service.interceptor;

import com.zhang.springcloud.service.util.GrayHolder;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GrayInterceptor implements HandlerInterceptor {

    private static final Logger LOGGER = LoggerFactory.getLogger(GrayInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        String grayHead=httpServletRequest.getHeader("gray-head");
        LOGGER.info("head {}",grayHead);
        if ("true".equals(grayHead)){
            GrayHolder.setGray("true");
        }else {
            GrayHolder.setGray("false");
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
