package com.frankstar.java.basic.learn.java8;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author : frankstar
 * @version V1.0
 * @Project: java-improve
 * @Package com.frankstar.java.basic.learn.java8
 * @Description: TODO
 * @mail :  frankstar007@163.com
 * @date Date : 2019年06月24日 20:48
 */
public class MisSort {

    public static final List<String> names = Lists.newArrayList(
            "seven.zhang",
            "haiqian.wu",
            "yichao.wu",
            "zhe.lu",
            "yehongxing",
            "gaochao07",
            "yangliu26",
            "liruoqi02",
            "zhengdongxu",
            "liyuanchi",
            "xiazhenxing",
            "yangwenxiang",
            "wangyanan14",
            "duwenjun",
            "zhangyachao03",
            "taohongxing",
            "zhengchenyang02",
            "linshengguang",
            "gaohang04",
            "jinhuixuan",
            "sunzhongqi",
            "wangxin101",
            "xujie.wei",
            "lijingwei03",
            "wanghanyu",
            "renjing13"
    );


    public static void main(String[] args) {
        List<String> result = names.stream().sorted(String::compareTo).collect(Collectors.toList());
        System.out.println(result);

    }
}
