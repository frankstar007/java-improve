package com.frankstar.java.basic.learn.java8;

import com.frankstar.java.basic.learn.example.Person;

/**
 * @author : frankstar
 * @version V1.0
 * @Project: java-improve
 * @Package com.frankstar.java.basic.learn.java8
 * @Description:
 * @mail :  frankstar007@163.com
 * @date Date : 2019年03月26日 23:24
 */
public interface PersonFactory<P extends Person> {

    P create(String firstName, String lastName);

}
