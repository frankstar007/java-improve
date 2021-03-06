package com.frankstar.java.design.patterns.strategy;

/**
 * @author : frankstar
 * @version V1.0
 * @Project: java-improve
 * @Package com.frankstar.java.design.patterns.strategy
 * @Description: 乘法策略
 * @mail :  frankstar007@163.com
 * @date Date : 2019年05月06日 22:33
 */
public class MultiplyStrategy implements Strategy {
    @Override
    public int doOperation(int num1, int num2) {
        return num1 * num2;
    }
}
