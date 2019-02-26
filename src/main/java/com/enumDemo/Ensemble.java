package com.enumDemo;

public enum Ensemble {
    SOLO(1), DUET(2), TRIO(3), QUARTET(4), QUINTET(5),
    SEXTET(6), SEPTET(7), OCTET(8), NONTET(9), DECTET(10);

    private final int number;

    Ensemble(int size) {
        this.number = size;
    }

    public int numberOfMusicians() {
        return number;
    }
}
