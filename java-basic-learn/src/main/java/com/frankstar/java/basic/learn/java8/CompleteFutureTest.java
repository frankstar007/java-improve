package com.frankstar.java.basic.learn.java8;

import com.frankstar.java.basic.learn.example.Student;
import com.google.common.collect.Lists;
import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

/**
 * @Author :  frankstar
 * @AddTime :  2019/5/5
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc :
 */
public class CompleteFutureTest {


	public static void main(String[] args) {

		Student student = new Student();
		student.setAge(1);
		student.setBirthday(new Date());
		student.setCode(29+"ss");
		student.setName("stark");

		Student student1 = new Student();
		student1.setName("loar");
		student1.setCode("20sdsdds");
		student1.setAge(35);
		student1.setBirthday(Date.from(Instant.EPOCH));

		List<Student> studentList = Lists.newArrayList();
		studentList.add(student);
		studentList.add(student1);


		studentList = studentList.stream().map(stu -> fillStudent(stu)).collect(Collectors.toList());


		System.out.println(studentList);

	}

	private static Student fillStudent(Student student) {
		CompletableFuture.runAsync(() -> {
			for (int i=1; i<1000; i++) {
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("age First");
			student.setAge(50);
		});

		CompletableFuture.runAsync(() -> {
			for (int j=1; j< 5000; j++) {
			}
			System.out.println("code second");
			student.setCode("fdsafghnas;gnad");
		});

		CompletableFuture.runAsync(() -> {
			for (int h = 1; h <3242; h++) {
			}
			System.out.println("birthday last");
			student.setBirthday(new Date());
		});

		return student;

	}

}
