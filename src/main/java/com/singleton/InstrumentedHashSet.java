package com.singleton;

import java.util.Collection;
import java.util.HashSet;

public class InstrumentedHashSet<E> extends HashSet<E> {

    private int addCount;

    public InstrumentedHashSet() {
    }

    @Override
    public boolean add(E e) {
        addCount++;
        return super.add(e);
    }

    @Override
    public boolean addAll(Collection<? extends E> collection) {
        addCount++;
        return super.addAll(collection);
    }

    public int getAddCount() {
        return addCount;
    }
}
