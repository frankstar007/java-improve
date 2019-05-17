package com.frankstar.java.frame.learn.spring.strategy;

import com.google.common.collect.Maps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author : frankstar
 * @version V1.0
 * @Project: java-improve
 * @Package com.frankstar.java.frame.learn.spring.strategy
 * @Description: TODO
 * @mail :  frankstar007@163.com
 * @date Date : 2019年05月06日 22:41
 */
@Component
public class IContext {

    @Autowired
    private Map<String, Strategy> contextStrategyMaps = Maps.newConcurrentMap();

    public Strategy doStrategy(String type) {
        return this.contextStrategyMaps.get(type);
    }

}
