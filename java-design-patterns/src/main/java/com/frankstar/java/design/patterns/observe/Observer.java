package com.frankstar.java.design.patterns.observe;

/**
 * @author : frankstar
 * @version V1.0
 * @Project: java-improve
 * @Package com.frankstar.java.design.patterns.observe
 * @Description: 抽象观察者
 * @mail :  frankstar007@163.com
 * @date Date : 2019年05月07日 23:36
 */
public interface Observer {

    /**
     * 更新状态
     * @param temperature
     * @param humidity
     * @param pressure
     */
    void update(double temperature, double humidity, double pressure);
}
