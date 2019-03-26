package com.frankstar.java.basic.learn.java8;

public class FunctionInterfaceLearn {

    @FunctionalInterface
    interface Converter<F, T> {
        T convert(F from);
    }

    class Something {
        String startsWith(String s) {
            return String.valueOf(s.charAt(0));
        }
    }


    public static void main(String[] args) {
        Converter<String, Integer> converter = Integer::valueOf;
        Integer convert = converter.convert("123");
        System.out.println(convert);

    }
}
