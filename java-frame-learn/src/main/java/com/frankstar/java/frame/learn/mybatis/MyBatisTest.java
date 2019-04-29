package com.frankstar.java.frame.learn.mybatis;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

/**
 * @author : frankstar
 * @version V1.0
 * @Project: java-improve
 * @Package com.frankstar.java.frame.learn.mybatis
 * @Description: TODO
 * @mail :  frankstar007@163.com
 * @date Date : 2019年04月29日 22:44
 */
@Slf4j
public class MyBatisTest {

    public static void main(String[] args) {
        //指定全局配置文件
        String resouce = "mybatis/mybatis-config.xml";
        //读取配置文件
        try {
            InputStream inputStream = Resources.getResourceAsStream(resouce);
            // 构建sqlSessionFactory
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            //获取sqlSessionFactory
            SqlSession sqlSession = sqlSessionFactory.openSession();
            User user = sqlSession.selectOne("UserMapper.selectUser", 1);
            System.out.println(user);
        } catch (Exception e) {
            log.error("", e);
        }

    }
}
