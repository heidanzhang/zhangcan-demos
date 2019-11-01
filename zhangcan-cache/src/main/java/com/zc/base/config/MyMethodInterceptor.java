package com.zc.base.config;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.stereotype.Component;

/**
 * @Auther: zhangcan
 * @Date: 2019/6/21 16:18
 * @Description:
 */
@Component
public class MyMethodInterceptor implements MethodInterceptor{

    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        Object[] args = methodInvocation.getArguments();
        System.out.println("aop方法拦截器进来了="+args);
        return args;
    }
}
