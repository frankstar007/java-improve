package com.frankstar.java.learn.frame;

import com.frankstar.java.frame.learn.spring.SpringConfig;
import lombok.extern.slf4j.Slf4j;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Author :  frankstar
 * @AddTime :  2019/4/6
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc :
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
@Slf4j
public abstract class BaseTest {

	public void start() {
		log.info("Spring test start");
		System.out.println("init and start");
	}
}
