package com.frankstar.java.basic.learn.java8;

import com.google.common.collect.Lists;

import java.util.Collections;
import java.util.List;

public class LambdaLearn {

    private List<String> names = Lists.newArrayList("peter", "anna", "mike", "xenia");

    public List<String> sort() {
        names.sort(String::compareTo);
        return names;
    }

    public List<String> sortLambda() {
        names.sort((a, b) -> a.compareTo(b));
        return names;
    }

}
