package com.frankstar.java.design.patterns.delegate;

import java.lang.reflect.Proxy;

/**
 * @author : frankstar
 * @version V1.0
 * @Project: java-improve
 * @Package com.frankstar.java.design.patterns.delegate
 * @Description: TODO
 * @mail :  frankstar007@163.com
 * @date Date : 2019年05月05日 23:27
 */
public class DynamicProxyTest {

    public static void main(String[] args) {
        Housing housing = new HousingImpl();
        Housing housingProxy = (Housing) Proxy.newProxyInstance(Housing.class.getClassLoader(),
                new Class[]{Housing.class}, new DynamicProxy(housing));
        housingProxy.buyHouse();
    }
}
