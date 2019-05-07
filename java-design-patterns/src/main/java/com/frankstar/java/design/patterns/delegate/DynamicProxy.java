package com.frankstar.java.design.patterns.delegate;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author : frankstar
 * @version V1.0
 * @Project: java-improve
 * @Package com.frankstar.java.design.patterns.delegate
 * @Description: TODO
 * @mail :  frankstar007@163.com
 * @date Date : 2019年05月05日 23:24
 */
public class DynamicProxy implements InvocationHandler {

    private Object object;

    DynamicProxy(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("买房前");
        Object result = method.invoke(object, args);
        System.out.println("买房后");

        return result;
    }
}
