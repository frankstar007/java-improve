package com.frankstar.java.design.patterns.observe;

/**
 * @author : frankstar
 * @version V1.0
 * @Project: java-improve
 * @Package com.frankstar.java.design.patterns.observe
 * @Description: 观察者模式测试
 * @mail :  frankstar007@163.com
 * @date Date : 2019年05月07日 23:53
 */
public class ObserverTest {

    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();

        TodayObserver todayObserver = new TodayObserver();
        TomorrowObserver tomorrowObserver = new TomorrowObserver();

        weatherData.registerObservers(todayObserver);
        weatherData.registerObservers(tomorrowObserver);

        weatherData.setData(100, 20, 30);

    }
}
