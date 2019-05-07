package com.frankstar.java.design.patterns.observe;

import com.google.common.collect.Lists;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author : frankstar
 * @version V1.0
 * @Project: java-improve
 * @Package com.frankstar.java.design.patterns.observe
 * @Description: 具体的被观察者
 * @mail :  frankstar007@163.com
 * @date Date : 2019年05月07日 23:38
 */
@Data
public class WeatherData implements Subject {

    private double temperature;

    private double humidity;

    private double pressure;

    private List<Observer> observerList;


    public WeatherData() {
        observerList = Lists.newArrayList();
    }

    public void setData(double temperature, double humidity, double pressure) {
        this.humidity = humidity;
        this.pressure = pressure;
        this.temperature = temperature;

        //通知观察者
        dataChanged();
    }

    private void dataChanged() {
        notifyObservers();
    }


    @Override
    public void registerObservers(Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void removeObservers(Observer observer) {
        int index = observerList.indexOf(observer);
        if (index >= 0) {
            observerList.remove(observer);
        }
    }

    @Override
    public void notifyObservers() {
        observerList.stream().map(observer -> {
            observer.update(temperature, humidity, pressure);
            return true;
        }).collect(Collectors.toList());
    }
}
