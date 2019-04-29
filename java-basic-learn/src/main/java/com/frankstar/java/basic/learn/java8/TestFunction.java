package com.frankstar.java.basic.learn.java8;

import com.frankstar.java.basic.learn.example.Person;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @author : frankstar
 * @version V1.0
 * @Project: java-improve
 * @Package com.frankstar.java.basic.learn.java8
 * @Description: TODO
 * @mail :  frankstar007@163.com
 * @date Date : 2019年03月28日 22:20
 */
public class TestFunction {

    public static void main(String[] args) {
        Function<Integer, Integer> function = integer -> integer*2;
        Function<Integer, Integer> integerFunction = t -> t*t;
        functionTest(function, function, integerFunction.compose(integerFunction));
        int value1 = integerFunction.compose(function).apply(4);
        System.out.println(value1);
        functionTest(function, integerFunction, function.compose(integerFunction));

        Supplier<Person> personSupplier = Person::new;
        Consumer<Integer> consumer = (x) -> {
            int num = x*2;
            System.out.println(num);
        };
        Consumer<Integer> consumer1 = (x) -> {
            int num = x*3;
            System.out.println(num);
        };
        // andThen再执行完调用者方法后在执行传入参数的方法
        consumer.andThen(consumer1).accept(10);

    }

    private static void functionTest(Function<Integer, Integer> function, Function<Integer, Integer> integerFunction, Function<Integer, Integer> compose) {
        int value2 = function.andThen(integerFunction).apply(4);
        System.out.println(value2);
        int value3 = compose.apply(4);

        System.out.println(value3);
    }
}
