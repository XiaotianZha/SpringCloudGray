package com.zhang.springcloud.zuul.util;

import com.netflix.hystrix.strategy.concurrency.HystrixRequestContext;
import com.netflix.hystrix.strategy.concurrency.HystrixRequestVariableDefault;

public class GrayHolder {

    private  static  HystrixRequestVariableDefault<String> gray ;
   /* static {
        System.out.println("init holder");
    }*/


    public static String isGray(){
//        if (!HystrixRequestContext.isCurrentThreadInitialized()) {
//            HystrixRequestContext.initializeContext();
//        }
        return  gray.get();
    }

    public static void setGray(){
//        if (!HystrixRequestContext.isCurrentThreadInitialized()) {
            HystrixRequestContext.initializeContext();
//        }
        gray =  new HystrixRequestVariableDefault<>();
        gray.set("true");
    }

    public static void reSet(){
//        gray.remove();
        gray.shutdown("true");
    }

}
