package com.frankstar.java.frame.learn.spring.service;

import com.frankstar.java.frame.learn.spring.bean.User;

/**
 * @author : frankstar
 * @version V1.0
 * @Project: java-improve
 * @Package com.frankstar.java.frame.learn.spring.service
 * @Description: TODO
 * @mail :  frankstar007@163.com
 * @date Date : 2019年05月03日 13:06
 */
public interface UserService {

    /**
     * 获取用户
     * @param userId
     * @return
     */
    public User loadUser(int userId);
}
