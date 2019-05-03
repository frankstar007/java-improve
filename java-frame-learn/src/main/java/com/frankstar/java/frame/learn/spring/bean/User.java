package com.frankstar.java.frame.learn.spring.bean;

import lombok.Data;

import java.util.Date;

/**
 * @author : frankstar
 * @version V1.0
 * @Project: java-improve
 * @Package com.frankstar.java.frame.learn.spring.bean
 * @Description: TODO
 * @mail :  frankstar007@163.com
 * @date Date : 2019年05月03日 13:08
 */
@Data
public class User {

    private int userId;

    private String userName;

    private int age;

    private Date birthday;
}
