package com.frankstar.java.learn.frame.spring;

import com.frankstar.java.frame.learn.spring.bean.HelloSpring;
import com.frankstar.java.learn.frame.BaseTest;
import javax.annotation.Resource;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * @Author :  frankstar
 * @AddTime :  2019/4/6
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc :
 */
public class HelloSpringTest extends BaseTest {


	@Autowired
	private HelloSpring helloSpring;

	@Test
	public void testHelloSpring() {
		helloSpring.setName("zoe");
		helloSpring.sayHello();
	}


}
