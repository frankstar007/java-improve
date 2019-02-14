package com.frankstar.july.eleventh.controller;

import com.frankstar.july.eleventh.dao.UserDao;
import com.frankstar.july.eleventh.dao.UserMapper;
import com.frankstar.july.eleventh.pojo.User;
import com.frankstar.july.eleventh.service.UserDaoImpl;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;


import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Author :  frankstar
 * Mail  :   frankstar@smail.nju.edu.cn
 * Time  :   2017/7/13
 * Project : java-improve
 */
public class UserDaoImplTest {

    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void setUp() throws IOException {
        String resource = "spring.config/SqlMapConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

//    @Test
//    public void findUserByIdTest() throws Exception{
//        UserDao userDao = new UserDaoImpl(sqlSessionFactory);
//        User user = userDao.findUserById(1);
//        System.out.println(user);
//    }

    @Test
    public void findUserByNameTest() throws Exception{
        UserDao userDao = new UserDaoImpl(sqlSessionFactory);
        List<User> userList = userDao.findUserByName("小明");
        System.out.println(userList);
    }

    @Test
    public void findUserByIdTest() throws Exception{
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);//生成代理对象userMapper
        User user = userMapper.findUserById(3);
        System.out.println(user);
    }
}
