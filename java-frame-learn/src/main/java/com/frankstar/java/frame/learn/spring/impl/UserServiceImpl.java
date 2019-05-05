package com.frankstar.java.frame.learn.spring.impl;

import com.frankstar.java.frame.learn.mybatis.dao.UserDao;
import com.frankstar.java.frame.learn.mybatis.entity.UserEntity;
import com.frankstar.java.frame.learn.spring.bean.User;
import com.frankstar.java.frame.learn.spring.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author : frankstar
 * @version V1.0
 * @Project: java-improve
 * @Package com.frankstar.java.frame.learn.spring.impl
 * @Description: TODO
 * @mail :  frankstar007@163.com
 * @date Date : 2019年05月03日 13:09
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    @Override
    public User loadUser(int userId) {
        UserEntity userEntity = userDao.loadUserById(userId);
        User user = new User();
        BeanUtils.copyProperties(userEntity, user);
        return user;
    }
}
