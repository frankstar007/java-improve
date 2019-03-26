package com.frankstar.java.basic.learn.java8;

public class InterfaceConcreteOne implements InterfaceLearn {
    @Override
    public double calculate(int a) {
        return Math.abs(a*100);
    }
}
