package com.frankstar.spring.mvc.learn.frank.service;

import com.frankstar.spring.mvc.learn.dto.User;

/**
 * @Author :  frankstar
 * @AddTime :  2019/5/22
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc :
 */
public interface UserService {
	/**
	 * 获取用户
	 * @param userId
	 * @return
	 */
	User loadUser(int userId);

	boolean addUser(User user);

	User login(String username, String password);
}
