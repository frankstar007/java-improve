package com.frankstar.java.frame.learn.mybatis.dao;

import com.frankstar.java.frame.learn.mybatis.entity.UserEntity;

/**
 * @author : frankstar
 * @version V1.0
 * @Project: java-improve
 * @Package com.frankstar.java.frame.learn.mybatis.dao
 * @Description: TODO
 * @mail :  frankstar007@163.com
 * @date Date : 2019年05月03日 13:02
 */
public interface UserDao {

    /**
     * 通过用户id获取用户
     * @param userId
     * @return
     */
    UserEntity loadUserById(int userId);
}
