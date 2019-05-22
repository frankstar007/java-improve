package com.frankstar.spring.mvc.learn.service;

import com.frankstar.spring.mvc.learn.BaseTest;
import com.frankstar.spring.mvc.learn.dto.User;
import com.frankstar.spring.mvc.learn.frank.service.UserService;
import com.frankstar.spring.mvc.learn.utils.IdUtil;
import java.util.Date;
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

	@Test
	public void loadUserByPassword() {
		System.out.println(userService.login("kelly", ""));
	}

	@Test
	public void addUser() {
		User user = new User();
		user.setUserId(IdUtil.getId());
		user.setBirthday(new Date());
		user.setAge(29);
		user.setUserName("AD Stark");
		user.setUserPassword("21344");
		System.out.println(userService.addUser(user));
	}

}
