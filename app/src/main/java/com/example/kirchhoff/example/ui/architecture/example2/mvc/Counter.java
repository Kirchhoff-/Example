package com.example.kirchhoff.example.ui.architecture.example2.mvc;

/**
 * @author Kirchhoff-
 */

public class Counter {

    private int value;

    private OnCounterIncreaseListener onCounterIncreaseListener;

    public Counter(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public int increase() {
        value++;

        if (onCounterIncreaseListener != null) {
            onCounterIncreaseListener.onCounterIncreased(value);
        }

        return value;
    }

    public void setOnCounterIncreaseListener(OnCounterIncreaseListener onCounterIncreaseListener) {
        this.onCounterIncreaseListener = onCounterIncreaseListener;
    }
}
