package com.frankstar.springboot.permission.dao;

import com.frankstar.springboot.permission.enity.UserEntity;
import org.apache.ibatis.annotations.Param;

/**
 * @Author :  frankstar
 * @AddTime :  2019/6/21
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc :
 */
public interface UserDao {

    UserEntity findByUserLogin(@Param("userId") int userId, @Param("login") String login);

}
