package com.frankstar.july.eleventh.dao;

import com.frankstar.july.eleventh.pojo.User;

import java.util.List;

/**
 * Author :  frankstar
 * Mail  :   frankstar@smail.nju.edu.cn
 * Time  :   2017/7/13
 * Project : java-improve
 */
public interface UserDao {

    public void insertUser(User user) throws Exception;
    public User findUserById(int id) throws Exception;
    public List<User> findUserByName(String name) throws Exception;//模糊查找
    public void deleteUser(int id) throws Exception;
}
