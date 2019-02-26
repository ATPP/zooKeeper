package com.lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Sorted是一个中间操作，能够返回一个排过序的流对象的视图。这些元素按自然顺序排序，除非你经过一个自定义比较器（实现Comparator接口）
 * 要记住，排序只会创建一个流的排序视图，而不处理支持集合的排序。原来string集合中的元素顺序是没有改变的
 */

public class SortDemo {

    public static void main(String[] args) {

        List<String> names = Arrays.asList("ali","didi","tencent","baidu","meituan","123","hom","wing","action");
        //old
//        Collections.sort(names, new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                return o1.compareTo(o2);
//            }
//        });

        //lambda1
//        Collections.sort(names,(String o1,String o2)->{
//            return o1.compareTo(o2);
//        });
        //lambda2
//        Collections.sort(names,(String o1,String o2)->o1.compareTo(o2));
        //lambda3
//        Collections.sort(names,(o1,o2)->o1.compareTo(o2));
        //lambda4
//        Collections.sort(names,(String::compareTo));

        names.stream().sorted((o1,o2)->o2.compareTo(o1)).forEach(System.out::println);
//        System.out.println(names);
    }
}
