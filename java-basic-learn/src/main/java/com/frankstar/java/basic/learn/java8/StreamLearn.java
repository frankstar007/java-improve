package com.frankstar.java.basic.learn.java8;

import com.frankstar.java.basic.learn.example.Student;
import com.google.common.collect.Lists;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.commons.lang3.math.NumberUtils;

/**
 * @Author :  frankstar
 * @AddTime :  2019/3/13
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc :
 */
public class StreamLearn {


	private List<Student> studentList;


	public static List<Student> sort(List<Student> students) {
		return students.stream().sorted(Comparator.comparing(Student::getBirthday).reversed()).collect(
			Collectors.toList());
	}

	public static List<String> tranString(List<Integer> nums) {
		return nums.stream().map(String::valueOf).collect(Collectors.toList());
	}

	public static List<Integer> trans(List<Student> students) {
		return students.stream().map(student -> student.getAge(2)).map(Integer::valueOf).collect(
			Collectors.toList());
	}

	public static Map<Integer, Student> transMap(List<Student> students) {
		return students.stream().collect(Collectors.toMap(student -> NumberUtils.toInt(student.getCode()), student -> student));
	}


	public static void main(String[] args) {
		List<Student> students = Lists.newArrayList();
		Student student = new Student(2, "frankstar", new Date(2019, 7, 10), "199");
		Student student1 = new Student(3, "kellystar", new Date(2019, 6, 10), "200");
		Student student2 = new Student(1, "afsf", new Date(2018, 3, 2), "400");
		students.add(student);
		students.add(student1);
		students.add(student2);

		List<Integer> nums = Lists.newArrayList(2,345,6547,23);
		Stream.of(nums).findFirst().ifPresent(System.out::println);

		System.out.println(trans(students));
		System.out.println("------");
		System.out.println(transMap(students));
		System.out.println("@@@@@@@@");

		System.out.println(sort(students));
		Stream.of("d2", "a2", "b1", "b3", "c")
				.map(s -> {
					System.out.println("map" + s);
					return s.toUpperCase();
				})
				.anyMatch(s -> {
					System.out.println("anyMatch" + s);
					return s.startsWith("A");
				});



	}

}
