package com.frankstar.july.eleventh.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author :  frankstar
 * Mail  :   frankstar@smail.nju.edu.cn
 * Time  :   2017/7/11
 * Project : java-improve
 */
@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String hello() {
        return "hello,frankstar!";
    }
}
