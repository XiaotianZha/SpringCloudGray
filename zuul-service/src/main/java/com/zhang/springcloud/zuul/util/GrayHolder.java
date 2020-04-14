package com.zhang.springcloud.zuul.util;

import com.netflix.hystrix.strategy.concurrency.HystrixRequestVariableDefault;

public class GrayHolder {

    private static final HystrixRequestVariableDefault<Boolean> variable =  new HystrixRequestVariableDefault();

    public static boolean isGray(){
        return  variable.get();
    }

    public static void setGray(){
        variable.set(true);
    }
}
