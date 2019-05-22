package com.frankstar.spring.mvc.learn.service;

import com.frankstar.spring.mvc.learn.BaseTest;
import com.frankstar.spring.mvc.learn.frank.service.UserService;
import javax.annotation.Resource;
import org.junit.Test;

/**
 * @Author :  frankstar
 * @AddTime :  2019/5/22
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc :
 */
public class UserServiceTest extends BaseTest {

	@Resource
	private UserService userService;

	@Test
	public void loadUser() {
		System.out.println(userService.loadUser(1));
	}

}
