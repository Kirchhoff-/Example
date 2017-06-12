package com.example.kirchhoff.example.ui.architecture.data;

import android.support.annotation.NonNull;

import io.reactivex.Observable;

/**
 * @author Kirchhoff-
 */

public class DataModel implements Source {

    @NonNull
    @Override
    public Observable<String> getText() {
        return Observable.just("MVP vs MVVM");
    }
}
