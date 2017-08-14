package com.example.kirchhoff.example.ui.architecture.example2.mvp;

/**
 * @author Kirchhoff-
 */

public class Counter {
    private int value;

    public Counter(int initialValue) {
        this.value = initialValue;
    }

    public int getValue() {
        return value;
    }

    public int increase() {
        return ++value;
    }
}
