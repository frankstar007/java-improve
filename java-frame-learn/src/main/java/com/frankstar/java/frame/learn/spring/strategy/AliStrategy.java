package com.frankstar.java.frame.learn.spring.strategy;

import org.springframework.stereotype.Component;

/**
 * @author : frankstar
 * @version V1.0
 * @Project: java-improve
 * @Package com.frankstar.java.frame.learn.spring.strategy
 * @Description: TODO
 * @mail :  frankstar007@163.com
 * @date Date : 2019年05月06日 22:45
 */
@Component("aliStrategy")
public class AliStrategy implements Strategy {
    @Override
    public void say(String name) {
        System.out.println("Alibaba welcome " + name);
    }
}
