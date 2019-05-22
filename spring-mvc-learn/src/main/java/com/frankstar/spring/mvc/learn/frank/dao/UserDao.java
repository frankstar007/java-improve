package com.frankstar.spring.mvc.learn.frank.dao;

import com.frankstar.spring.mvc.learn.frank.entity.UserEntity;

/**
 * @Author :  frankstar
 * @AddTime :  2019/5/22
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc :
 */
public interface UserDao {
	/**
	 * 通过用户id获取用户
	 * @param userId
	 * @return
	 */
	UserEntity loadUserById(int userId);

	boolean addUser(UserEntity userEntity);

	UserEntity loadUser(String username, String password);
}
