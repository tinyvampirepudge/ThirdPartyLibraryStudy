package com.tinytongtong.thirdpartylibrarystudy.retrofit.proxy.invocationhandler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Description: 使用InvocationHandler实现动态代理
 * @Author wangjianzhou@qding.me
 * @Date 2019/4/3 8:00 PM
 * @Version TODO
 */
public class EngineerProxy implements InvocationHandler {
    private Object object;

    public Object bind(Object o) {
        this.object = o;
        return Proxy.newProxyInstance(object.getClass().getClassLoader(), object.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Engineer writes document...");
        Object res = method.invoke(object, args);
        return res;
    }
}
