package com.frankstar.july.mode.observermode;

import java.util.List;

/**
 * Author    :  frankstar
 * AddTime   :  2017/8/3
 * EMail     :  yehongxing@meituan.com
 * Project   :  java-improve
 */
public class Memento {

    private List<String> states;

    private int index;

    public Memento(List<String> states, int index) {
        this.states = states;
        this.index = index;
    }

    public List<String> getStates() {
        return states;
    }

    public int getIndex() {
        return index;
    }
}
