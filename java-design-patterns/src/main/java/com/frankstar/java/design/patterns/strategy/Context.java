package com.frankstar.java.design.patterns.strategy;

/**
 * @author : frankstar
 * @version V1.0
 * @Project: java-improve
 * @Package com.frankstar.java.design.patterns.strategy
 * @Description: 策略模式的环境角色
 * @mail :  frankstar007@163.com
 * @date Date : 2019年05月06日 22:25
 */
public class Context {

    private Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public int executeStrategy(int num1, int num2) {
        return strategy.doOperation(num1, num2);
    }


}
