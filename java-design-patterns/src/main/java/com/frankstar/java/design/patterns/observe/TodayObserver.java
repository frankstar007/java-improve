package com.frankstar.java.design.patterns.observe;

import lombok.Data;

/**
 * @author : frankstar
 * @version V1.0
 * @Project: java-improve
 * @Package com.frankstar.java.design.patterns.observe
 * @Description: 具体的观察者
 * @mail :  frankstar007@163.com
 * @date Date : 2019年05月07日 23:50
 */
@Data
public class TodayObserver implements Observer {

    private double temperature;

    private double humidity;

    private double pressure;

    @Override
    public void update(double temperature, double humidity, double pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;

        display();
    }

    private void display() {

        System.out.println("today " + temperature + "," + humidity + "," + pressure);
    }
}
