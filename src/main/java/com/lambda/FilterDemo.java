package com.lambda;

import java.util.Arrays;
import java.util.List;

/**
 * Filter接受一个predicate来过滤流的所有元素。这个中间操作能够调用另一个流的操作（Foreach）的结果。ForEach接受一个消费者为每个元素执行过滤流
 */
public class FilterDemo {

    public static void main(String[] args) {
        List<String> names = Arrays.asList("ali","didi","tencent","baidu","meituan","123","hom","wing","action","tiantian","nihao","ttt");
        names.stream().filter(t->t.startsWith("t")).forEach(System.out::println);
    }
}
