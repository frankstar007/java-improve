package com.frankstar.java.basic.learn.example;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author : frankstar
 * @version V1.0
 * @Project: java-improve
 * @Package com.frankstar.java.basic.learn.example
 * @Description: Person实体
 * @mail :  frankstar007@163.com
 * @date Date : 2019年03月26日 23:22
 */
@Data
@AllArgsConstructor
public class Person {

    private String firstName;

    private String lastName;

    public Person() {

    }
}
