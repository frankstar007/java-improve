package com.frankstar.java.frame.learn.mybatis.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author : frankstar
 * @version V1.0
 * @Project: java-improve
 * @Package com.frankstar.java.frame.learn.mybatis
 * @Description: TODO
 * @mail :  frankstar007@163.com
 * @date Date : 2019年04月29日 22:27
 */
@Data
public class UserEntity {

    /**
     * 用户id
     */
    private int userId;

    private String userName;

    private int age;

    private Date birthday;

    private Date addTime;

    private Date updateTime;
}
