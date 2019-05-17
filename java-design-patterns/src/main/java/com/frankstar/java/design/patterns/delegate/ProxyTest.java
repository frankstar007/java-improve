package com.frankstar.java.design.patterns.delegate;

/**
 * @author : frankstar
 * @version V1.0
 * @Project: java-improve
 * @Package com.frankstar.java.design.patterns.delegate
 * @Description: TODO
 * @mail :  frankstar007@163.com
 * @date Date : 2019年05月05日 23:19
 */
public class ProxyTest {

    public static void main(String[] args) {
        Housing housing = new HousingImpl();
        housing.buyHouse();


        HousingProxy housingProxy = new HousingProxy(housing);
        housingProxy.buyHouse();
    }
}
