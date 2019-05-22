package com.frankstar.spring.mvc.learn.frank.dao;

import com.frankstar.spring.mvc.learn.frank.entity.UserEntity;
import org.apache.ibatis.annotations.Param;

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

	/**
	 * 注册用户
	 * @param userEntity
	 * @return
	 */
	boolean addUser(@Param("userEntity") UserEntity userEntity);

	/**
	 * 获取登录用户
	 * @param username
	 * @param password
	 * @return
	 */
	UserEntity loadUser(@Param("username") String username,@Param("password") String password);

	/**
	 * 通过登录获取用户
	 * @param username
	 * @return
	 */
	UserEntity loadByName(@Param("username") String username);
}
