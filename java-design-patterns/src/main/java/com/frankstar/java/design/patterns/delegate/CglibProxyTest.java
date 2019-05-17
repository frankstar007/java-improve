package com.frankstar.java.design.patterns.delegate;

/**
 * @author : frankstar
 * @version V1.0
 * @Project: java-improve
 * @Package com.frankstar.java.design.patterns.delegate
 * @Description: TODO
 * @mail :  frankstar007@163.com
 * @date Date : 2019年05月05日 23:42
 */
public class CglibProxyTest {

    public static void main(String[] args) {
        Housing housing = new HousingImpl();
        CGlibProxy cGlibProxy = new CGlibProxy();
        Housing housingImpl = (Housing) cGlibProxy.getInstance(housing);
        housingImpl.buyHouse();
    }
}
