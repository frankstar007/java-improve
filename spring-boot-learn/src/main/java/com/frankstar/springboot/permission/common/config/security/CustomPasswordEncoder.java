package com.frankstar.springboot.permission.common.config.security;

import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author : frankstar
 * @version V1.0
 * @Project: java-improve
 * @Package com.frankstar.springboot.permission.common.config.security
 * @Description: spring security 登录的密码进行MD5加密传到数据库
 * @mail :  frankstar007@163.com
 * @date Date : 2019年06月24日 21:18
 */
public class CustomPasswordEncoder implements PasswordEncoder {
    @Override
    public String encode(CharSequence charSequence) {
        return null;
    }

    @Override
    public boolean matches(CharSequence charSequence, String s) {
        return false;
    }
}
