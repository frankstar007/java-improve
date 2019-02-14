package com.frankstar.july.mode.observermode;

/**
 * Author    :  frankstar
 * AddTime   :  2017/8/3
 * EMail     :  yehongxing@meituan.com
 * Project   :  java-improve
 */
public class ConcreteSubject extends Subject {

    private String state;

    public String getState() {
        return state;
    }


    /**
     * change state
     * @param newState
     */
    public void change(String newState) {

        state = newState;
        System.out.println("change new State！");

        this.notifyAllObservers(state);
    }
}
