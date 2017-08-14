package com.example.kirchhoff.example.ui.architecture.example2.mvc;

import android.support.annotation.NonNull;

/**
 * @author Kirchhoff-
 */

public class CounterControllerImp implements CounterController {

    private Counter counter;

    public CounterControllerImp() {
        counter = new Counter(0);
    }

    public CounterControllerImp(@NonNull Counter counter) {
        this.counter = counter;
    }

    @Override
    public void increase() {
        counter.increase();
    }

    @Override
    public void setOnCounterIncreaseListener(OnCounterIncreaseListener listener) {
        counter.setOnCounterIncreaseListener(listener);
    }
}
