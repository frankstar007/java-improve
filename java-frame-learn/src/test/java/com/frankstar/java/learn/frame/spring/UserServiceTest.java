package com.frankstar.java.learn.frame.spring;

import com.alibaba.fastjson.JSON;
import com.frankstar.java.frame.learn.spring.bean.User;
import com.frankstar.java.frame.learn.spring.service.UserService;
import com.frankstar.java.learn.frame.BaseTest;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import javax.annotation.Resource;

/**
 * @author : frankstar
 * @version V1.0
 * @Project: java-improve
 * @Package com.frankstar.java.learn.frame.spring
 * @Description: TODO
 * @mail :  frankstar007@163.com
 * @date Date : 2019年05月03日 13:11
 */
@Slf4j
public class UserServiceTest extends BaseTest {

    @Resource
    private UserService userService;

    @Test
    public void testLoadUser() {
        User user = userService.loadUser(1);
        System.out.println(user);
        log.info(JSON.toJSONString(user));
    }

}
