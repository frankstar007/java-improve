package com.frankstar.java.basic.learn.java8;

/**
 * @author : frankstar
 * @version V1.0
 * @Project: java-improve
 * @Package com.frankstar.java.basic.learn.java8
 * @Description: TODO
 * @mail :  frankstar007@163.com
 * @date Date : 2019年03月26日 23:37
 */
public class LambdaStaticLearn {

    static int outerStaticNum;

    int outerNum;

    void testScope() {
        FunctionInterfaceLearn.Converter<Integer, String> stringConverter = from -> {
            outerNum = 23;
            System.out.println(String.valueOf(outerNum));
            return String.valueOf(outerNum);
        };
        System.out.println(stringConverter.convert(outerNum));

        FunctionInterfaceLearn.Converter<Integer, String> integerStringConverter = from -> {
            outerStaticNum = 83;
            System.out.println(String.valueOf(outerStaticNum));
            return String.valueOf(outerStaticNum);
        };
        System.out.println(integerStringConverter.convert(outerStaticNum));
    }


    public static void main(String[] args) {
        LambdaStaticLearn lambdaStaticLearn = new LambdaStaticLearn();
        lambdaStaticLearn.testScope();
    }
}
