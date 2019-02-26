package com.lambda;

import java.util.Arrays;
import java.util.List;

/**
 * 可以使用各种匹配操作来检查某个谓词是否匹配流。所有这些操作都是终止操作，返回一个布尔结果
 */
public class MathDemo {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("ali","didi","tencent","baidu","meituan","123","hom","wing","action","tiantian","nihao","ttt");
        boolean anyStartWithH = names.stream().anyMatch(t->t.startsWith("h"));
        System.out.println(anyStartWithH);

        System.out.println(names.stream().allMatch(t->t.startsWith("h")));

        System.out.println(names.stream().noneMatch(t->t.startsWith("h")));
    }

}
