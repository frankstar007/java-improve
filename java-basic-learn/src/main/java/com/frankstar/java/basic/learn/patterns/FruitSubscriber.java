package com.frankstar.java.basic.learn.patterns;

import com.google.common.eventbus.Subscribe;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @Author :  frankstar
 * @AddTime :  2020/9/28
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc :
 */
@Component
@Slf4j
public class FruitSubscriber {

	@Subscribe
	public void func(String msg) {
		System.out.println("fruit subscribe " + msg);
	}
}
