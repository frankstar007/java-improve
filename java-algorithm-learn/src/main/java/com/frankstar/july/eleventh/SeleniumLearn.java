package com.frankstar.july.eleventh;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Author :  frankstar
 * Mail  :   frankstar@smail.nju.edu.cn
 * Time  :   2017/7/11
 * Project : java-improve
 */
public class SeleniumLearn {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.baidu.com");
    }

}
