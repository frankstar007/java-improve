package com.frankstar.springboot.permission.enity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * @Author :  frankstar
 * @AddTime :  2019/6/21
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc :
 */
@Data
public class RoleEntity implements Serializable {

	private int id;

	private int roleId;

	private String roleName;

	private Date addTime;

	private Date updateTime;
}
