package com.frankstar.july.mode.observermode;

/**
 * Author    :  frankstar
 * AddTime   :  2017/8/3
 * EMail     :  yehongxing@meituan.com
 * Project   :  java-improve
 */
public class Main {

    public static void main(String[] args) {

        ConcreteSubject subject = new ConcreteSubject();

        Observer observer = new ConcreteObserver();

        subject.attach(observer);

        subject.change("new State!");
    }
}
