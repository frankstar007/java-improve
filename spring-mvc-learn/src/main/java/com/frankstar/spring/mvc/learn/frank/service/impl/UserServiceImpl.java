package com.frankstar.spring.mvc.learn.frank.service.impl;

import com.frankstar.spring.mvc.learn.dto.User;
import com.frankstar.spring.mvc.learn.frank.dao.UserDao;
import com.frankstar.spring.mvc.learn.frank.entity.UserEntity;
import com.frankstar.spring.mvc.learn.frank.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author :  frankstar
 * @AddTime :  2019/5/22
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc :
 */
@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Override
	public User loadUser(int userId) {
		UserEntity userEntity = userDao.loadUserById(userId);
		User user = new User();
		BeanUtils.copyProperties(userEntity, user);
		return user;
	}

	@Override
	public boolean addUser(User user) {
		UserEntity userEntity = new UserEntity();
		BeanUtils.copyProperties(user, userEntity);
		return userDao.addUser(userEntity);
	}

	@Override
	public User login(String username, String password) {
		UserEntity userEntity = userDao.loadUser(username, password);
		if (userEntity != null) {
			User user = new User();
			BeanUtils.copyProperties(userEntity, user);
			return user;
		}
		return null;
	}

	@Override
	public User loadUserByName(String username) {
		User user = new User();
		UserEntity userEntity = userDao.loadByName(username);
		if (userEntity != null) {
			BeanUtils.copyProperties(userEntity, user);
			return user;
		}
		return null;
	}


}
