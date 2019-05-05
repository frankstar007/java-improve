package com.frankstar.java.basic.learn.java8;

import com.frankstar.java.basic.learn.enums.StudentType;
import com.frankstar.java.basic.learn.example.Student;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
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

	public static List<Student> map(Map<StudentType, Student> studentMap) {
		return studentMap.keySet().stream().map(studentMap::get).collect(Collectors.toList());
	}


	public static Map<Integer, Student> transMap(List<Student> students) {
		return students.stream().collect(Collectors.toMap(student -> NumberUtils.toInt(student.getCode()), student -> student));
	}

	public static Map<StudentType, List<Student>> groupBy(Map<Student, StudentType> studentTypeMap) {
		Map<StudentType, List<Student>> result = studentTypeMap.keySet().
			stream().collect(Collectors.groupingBy(studentTypeMap::get));
		return result;
}


	public static void main(String[] args) {
		Map<Long, StudentType> studentTypeMap = Maps.newHashMap();
		studentTypeMap.put(1L, StudentType.Junoir);
		studentTypeMap.put(2L, StudentType.Superior);
		studentTypeMap.put(3L, StudentType.Senoir);
		studentTypeMap.put(4L, StudentType.Senoir);
		studentTypeMap.put(5L, StudentType.Superior);

		System.out.println(studentTypeMap.keySet().stream().map(Long::intValue).distinct().collect(Collectors.groupingBy(studentTypeMap::get)));


		List<Student> students = Lists.newArrayList();
		Student student = new Student(2, "frankstar", new Date(2019, 7, 10), "199");
		Student student1 = new Student(3, "kellystar", new Date(2019, 6, 10), "200");
		Student student2 = new Student(1, "afsf", new Date(2018, 3, 2), "400");
		students.add(student);
		students.add(student1);
		students.add(student2);


		Map<Student, StudentType> test = Maps.newHashMap();
		test.put(student, StudentType.Superior);
		test.put(student1, StudentType.Superior);

		test.put(student2, StudentType.Junoir);
		System.out.println(groupBy(test));
		System.out.println(groupBy(test).size());
		System.out.println(test);
		System.out.println(test.size());

//		List<Integer> nums = Lists.newArrayList(2,345,6547,23);
//
//		System.out.println(trans(students));
//		System.out.println("------");
//		System.out.println(transMap(students));
//		System.out.println("@@@@@@@@");
//
//		System.out.println(sort(students));
//		System.out.println(tranString(nums));

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
