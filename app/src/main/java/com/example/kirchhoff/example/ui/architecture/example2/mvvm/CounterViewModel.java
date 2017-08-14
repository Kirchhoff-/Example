package com.example.kirchhoff.example.ui.architecture.example2.mvvm;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.view.View;

import com.example.kirchhoff.example.BR;

/**
 * @author Kirchhoff-
 */

public class CounterViewModel extends BaseObservable {

    private int value;

    public CounterViewModel(int value) {
        this.value = value;
    }

    @Bindable
    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
        notifyPropertyChanged(BR.value);
    }

    public int increase() {
        setValue(++value);
        return value;
    }

    public void onIncreaseClicked(View v) {
        increase();
    }
}
