package com.dianping.overseas.data.service.impl;

import com.dianping.overseas.data.annotation.Extension;
import com.dianping.overseas.data.service.Person;

/**
 * @Author :  yehongxing
 * @AddTime :  2020/9/9
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc :
 */
@Extension("A")
public class PersonA implements Person{


	@Override
	public void getName() {
		System.out.println("Person A");
	}
}
