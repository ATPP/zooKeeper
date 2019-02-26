package com.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * 该终止操作能够通过某一个方法，对元素进行削减操作。该操作的结果会放在一个Optional变量里返回。
 */
public class ReduceDemo {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("ali", "didi", "tencent", "baidu", "meituan", "123", "hom", "wing", "action", "tiantian", "nihao", "ttt");
        Optional<String> reduce = names.stream().sorted().reduce((s1, s2) -> s1 + "**" + s2);
        reduce.ifPresent(System.out::println);
    }
}
