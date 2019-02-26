package com.lambda;

import java.util.Arrays;
import java.util.List;

/**
 * Count是一个终止操作返回流中的元素的数目，返回long类型
 */
public class CountDemo {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("ali","didi","tencent","baidu","meituan","123","hom","wing","action","tiantian","nihao","ttt");
        System.out.println(names.stream().filter(t->t.startsWith("t")).count());
    }
}
