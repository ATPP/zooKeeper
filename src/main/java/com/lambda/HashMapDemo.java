package com.lambda;

import java.util.HashMap;
import java.util.Map;

public class HashMapDemo {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        for (int i = 1; i <= 30; i++) {
            map.putIfAbsent(i, i + "num");
        }
        map.forEach((k, val) -> System.out.println(val));
    }
}
