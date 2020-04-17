package com.zhang.springcloud.zuul.util;

import com.netflix.hystrix.strategy.concurrency.HystrixRequestContext;
import com.netflix.hystrix.strategy.concurrency.HystrixRequestVariableDefault;

public class GrayHolder {

    private  static  HystrixRequestVariableDefault<String> gray =  new HystrixRequestVariableDefault<>();
    private  static  HystrixRequestContext context;
   /* static {
        System.out.println("init holder");
    }*/


    public static String isGray(){
//        if (!HystrixRequestContext.isCurrentThreadInitialized()) {
//            HystrixRequestContext.initializeContext();
//        }
        return  gray.get();
    }

    public static void setGray(String isGray){
//        if (!HystrixRequestContext.isCurrentThreadInitialized()) {
        context= HystrixRequestContext.initializeContext();
//        }
//        gray =  new HystrixRequestVariableDefault<>();
        gray.set(isGray);
    }

    public static void reSet(){
//        gray.remove();
        context.shutdown();
//        gray.shutdown("true");
    }

}
