package com.frankstar.java.basic.learn;

import com.frankstar.java.basic.learn.example.Person;
import com.frankstar.java.basic.learn.java8.InterfaceConcreteOne;
import com.frankstar.java.basic.learn.java8.PersonFactory;

import java.util.Objects;
import java.util.function.Predicate;

/**
 * @Author :  frankstar
 * @AddTime :  2019/3/13
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc :
 */
public class Test {

    public static void main(String[] args) {
        InterfaceConcreteOne one = new InterfaceConcreteOne();
        System.out.println(one.calculate(4));
        System.out.println(one.sqrt(16));

        PersonFactory<Person> personFactory = Person::new;
        Person person = personFactory.create("frank", "star");

        Predicate<String> predicate = s -> s.length() > 0;

        predicate.test("foo");
        predicate.negate().test("frankstar");

        Predicate<Boolean> nonNull = Objects::nonNull;
        Predicate<Boolean> isNull = Objects::isNull;

        Predicate<String> isEmpty = String::isEmpty;
        Predicate<String> isNotEmpty = isEmpty.negate();



    }

}
