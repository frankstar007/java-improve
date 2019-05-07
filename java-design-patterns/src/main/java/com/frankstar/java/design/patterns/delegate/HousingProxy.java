package com.frankstar.java.design.patterns.delegate;

/**
 * @author : frankstar
 * @version V1.0
 * @Project: java-improve
 * @Package com.frankstar.java.design.patterns.delegate
 * @Description: TODO
 * @mail :  frankstar007@163.com
 * @date Date : 2019年05月05日 23:17
 */
public class HousingProxy implements Housing {

    private Housing housing;


    public HousingProxy(Housing housing) {
        this.housing = housing;
    }

    @Override
    public void buyHouse() {
        System.out.println("before housing...");
        housing.buyHouse();
        System.out.println("after housing...");
    }
}
