package com.frankstar.java.basic.learn.java8;

public interface InterfaceLearn {

    double calculate(int a);

    /**
     * 默认实现
     * @param a
     * @return
     */
    default double sqrt(int a) {
        return Math.sqrt(a);
    }
}
