package com.example.kirchhoff.example.ui.architecture.example1.mvvm;

import android.support.annotation.NonNull;

import com.example.kirchhoff.example.ui.architecture.example1.data.Source;

import io.reactivex.Observable;

/**
 * @author Kirchhoff-
 */

//View model for the main activity.
public class ViewModel {

    @NonNull
    private final Source source;

    public ViewModel(@NonNull final Source source) {
        this.source = source;
    }

    @NonNull
    public Observable<String> getText() {
        return source.getText();
    }
}
