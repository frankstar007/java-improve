package com.frankstar.java.design.patterns.observe;

/**
 * @author : frankstar
 * @version V1.0
 * @Project: java-improve
 * @Package com.frankstar.java.design.patterns.observe
 * @Description: 抽象被观察者
 * @mail :  frankstar007@163.com
 * @date Date : 2019年05月07日 23:35
 */
public interface Subject {

    /**
     * 注册观察者
     * @param observer
     */
    void registerObservers(Observer observer);

    /**
     * 去除观察者
     * @param observer
     */
    void removeObservers(Observer observer);

    /**
     * 通知观察者
     */
    void notifyObservers();
}
