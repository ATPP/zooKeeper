package com.lambda;

import java.util.Arrays;
import java.util.List;

public class MapDemo {
    /**
     * map是一个对于流对象的中间操作，通过给定的方法，它能够把流对象中的每一个元素对应到另外一个对象上。
     * 下面的例子将每个字符串转换成一个大写字符串，但也可以使用map将每个对象转换为另一种类型。
     * 所得到的流的泛型类型取决于您传递给map方法的泛型类型
     * @param args
     */
    public static void main(String[] args) {
        List<String> names = Arrays.asList("ali","didi","tencent","baidu","meituan","123","hom","wing","action","tiantian","nihao","ttt");
        names.stream().map(String::toUpperCase).forEach(System.out::println);
    }
}
