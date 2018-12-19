package com.pattern;

import java.util.*;

public class Stack<E> {

    private Object[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    public Stack() {
        elements = new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(E e) {
        ensureCapacity();
        elements[size++] = e;
    }

    private void ensureCapacity() {
        if (elements.length == size) {
            elements = Arrays.copyOf(elements, elements.length);
        }
    }

    public static <E> Set<E> union(Set<? extends E> s1, Set<? extends E> s2) {
        Set<E> result = new HashSet<>(s1);
        result.addAll(s2);
        return result;
    }

    public static <T extends Comparable<? super T>> T max(List<? extends T> list) {
        Iterator<? extends T> i = list.iterator();
        T result = i.next();
        while (i.hasNext()) {
            T t = i.next();
            if (t.compareTo(result) > 0) {
                result = t;
            }
        }
        return result;
    }

    /**
     * 假如有一个Stack<Number>,调用了push<Integer>,因为Integer是Number的一个子类型，就会报错，但可以使用有限制但的通配符类型</>
     *
     * @param src
     */
    public void pushAll(Iterable<E> src) {
        for (E e : src) {
            push(e);
        }
    }

    /**
     * 有限制但的通配符类型
     *
     * @param src
     */
    public void pushAllWithBounded(Iterable<? extends E> src) {
        for (E e : src) {
            push(e);
        }
    }

    /**
     * 如果是E的某种超类的集合
     *
     * @param src
     */
    public void popAll(Iterable<? super E> src) {

    }




}
