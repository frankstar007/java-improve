package com.frankstar.july.mode.observermode;

import java.util.ArrayList;
import java.util.List;

/**
 * Author    :  frankstar
 * AddTime   :  2017/8/3
 * EMail     :  yehongxing@meituan.com
 * Project   :  java-improve
 */
public class Caretaker {

    private Originator originator;

    private List<Memento> mementos = new ArrayList<>();

    private int current;


    public Caretaker(Originator originator) {
        this.originator = originator;
        this.current = 0;
    }

    public int createMemento() {
        Memento memento = originator.createMemento();
        mementos.add(memento);
        return current++;
    }

    /**
     * @param index
     */
    public void restoreMemento(int index) {
        Memento memento = mementos.get(index);
        originator.restoreMemento(memento);
    }

    public void removeMemento(int index) {
        mementos.remove(index);
    }



}
