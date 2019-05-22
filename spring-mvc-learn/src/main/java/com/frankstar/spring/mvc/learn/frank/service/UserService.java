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

	/**
	 * 用户注册
	 * @param user
	 * @return
	 */
	boolean addUser(User user);

	/**
	 * 获取登录用户
	 * @param username
	 * @param password
	 * @return
	 */
	User login(String username, String password);

	/**
	 * 根据用户姓名获取用户
	 * @param username
	 * @return
	 */
	User loadUserByName(String username);
}
