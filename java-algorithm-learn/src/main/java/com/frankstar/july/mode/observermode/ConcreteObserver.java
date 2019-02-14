package com.frankstar.july.mode.observermode;

/**
 * Author    :  frankstar
 * AddTime   :  2017/8/3
 * EMail     :  yehongxing@meituan.com
 * Project   :  java-improve
 */
public class ConcreteObserver implements Observer {

    private String observerState;

    /**
     * update state
     * @param state
     */
    @Override
    public void update(String state) {
        observerState = state;
        System.out.println("update observer State! " + observerState);
    }
}
