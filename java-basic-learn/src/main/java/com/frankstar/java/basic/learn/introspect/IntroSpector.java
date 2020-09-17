package com.frankstar.java.basic.learn.introspect;

import com.frankstar.java.basic.learn.example.Person;
import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;

/**
 * @Author :  yehongxing
 * @AddTime :  2020/8/11
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc :
 */
public class IntroSpector {


	public static void main(String[] args) throws IntrospectionException {
		BeanInfo beanInfo = Introspector.getBeanInfo(Person.class);

		PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
		for (PropertyDescriptor propertyDescriptor : propertyDescriptors) {
			if (!"class".equals(propertyDescriptor.getName())) {
				System.out.println(propertyDescriptor.getName());
				System.out.println(propertyDescriptor.getWriteMethod().getName());
				System.out.println(propertyDescriptor.getReadMethod().getName());
				System.out.println("=======================");
			}
		}


	}

}
