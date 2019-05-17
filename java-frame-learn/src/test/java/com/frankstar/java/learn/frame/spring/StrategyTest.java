package com.frankstar.java.learn.frame.spring;

import com.frankstar.java.frame.learn.spring.strategy.IContext;
import com.frankstar.java.learn.frame.BaseTest;
import org.junit.Test;

import javax.annotation.Resource;

/**
 * @author : frankstar
 * @version V1.0
 * @Project: java-improve
 * @Package com.frankstar.java.learn.frame.spring
 * @Description: TODO
 * @mail :  frankstar007@163.com
 * @date Date : 2019年05月06日 22:52
 */
public class StrategyTest extends BaseTest {

    @Resource
    private IContext iContext;

    @Test
    public void testStrategy() {
        iContext.doStrategy("mtdpStrategy").say("frankstar");
    }
}
