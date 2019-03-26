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

        int num = 1;
        Converter<Integer, String> stringConverter = from -> String.valueOf(from + num);
        String result = stringConverter.convert(2);
        System.out.println(result);
        //num = 3(lambda表达式引用的本地变量必须是最终变量或实际上的最终变量);
        System.out.println(num);


    }
}
