package com.frankstar.july.mode.observermode;

import java.util.ArrayList;
import java.util.List;

/**
 * Author    :  frankstar
 * AddTime   :  2017/8/3
 * EMail     :  yehongxing@meituan.com
 * Project   :  java-improve
 */
public class Originator {

    private List<String> states;

    private int index;

    public Originator() {
        this.states = new ArrayList<>();
        this.index = 0;
    }

    /**
     * new memento
     */
    public Memento createMemento() {
        return new Memento(states, index);
    }

    /**
     * @param memento
     */
    public void restoreMemento(Memento memento) {
        this.states = memento.getStates();
        this.index = memento.getIndex();
    }


    /**
     * @param state
     */
    public void setStates(String state) {
        this.states.add(state);
        this.index++;
    }


    public void printStates() {
        for(String state : states) {
            System.out.println(state);
        }
    }

}
