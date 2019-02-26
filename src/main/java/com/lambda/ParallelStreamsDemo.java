package com.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class ParallelStreamsDemo {
    public static void main(String[] args) {
        int max = 1000000;
        List<String> values = new ArrayList<>(max);
        for (int i = 0; i < max; i++) {
            UUID uuid = UUID.randomUUID();
            values.add(uuid.toString());
        }

        //单独的线程上进行操作 904ms
//        long beginTime = System.nanoTime();
//        long count = values.stream().sorted().count();
//        System.out.println(count);
//        long endTime = System.nanoTime();
//        long millis = TimeUnit.NANOSECONDS.toMillis(endTime - beginTime);
//        System.out.println(String.format("sequential sort took: %d ms",millis));

        //同时在多个线程上执行并行操作 700ms
        long beginTime = System.nanoTime();
        long count = values.parallelStream().sorted().count();
        System.out.println(count);
        long endTime = System.nanoTime();
        long millis = TimeUnit.NANOSECONDS.toMillis(endTime - beginTime);
        System.out.println(String.format("sequential sort took: %d ms",millis));
    }
}
