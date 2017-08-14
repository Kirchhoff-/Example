package com.example.kirchhoff.example.ui.architecture.example2.mvp;

import android.support.annotation.NonNull;

/**
 * @author Kirchhoff-
 */

public class CounterPresenterImp implements CounterPresenter {

    private CounterView view;
    private Counter counter;


    public CounterPresenterImp() {
        counter = new Counter(0);
    }

    public CounterPresenterImp(@NonNull Counter counter) {
        this.counter = counter;
    }

    public void setView(CounterView view) {
        this.view = view;
    }

    @Override
    public void onIncreaseClicked() {
        view.setCounterText(String.valueOf(counter.increase()));
    }
}
