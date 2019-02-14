package com.frankstar.july.mode.observermode;

import java.util.ArrayList;
import java.util.List;

/**
 * Author    :  frankstar
 * AddTime   :  2017/8/3
 * EMail     :  yehongxing@meituan.com
 * Project   :  java-improve
 */
public abstract class Subject {

    private List<Observer> list = new ArrayList<>();

    /**
     * register observer mode
     * @param observer
     */
    public void attach(Observer observer) {
        list.add(observer);
        System.out.println("attach an observer!");
    }

    /**
     * delete observer
     * @param observer
     */
    public void detach(Observer observer) {
        list.remove(observer);
        System.out.println("delete an observer!");
    }

    /**
     * notify all observers
     * @param state
     */
    public void notifyAllObservers(String state) {

        for(Observer observer : list) {
            observer.update(state);
        }
    }


}
