package com.example.kirchhoff.example.ui.architecture.data;

import android.support.annotation.NonNull;

import io.reactivex.Observable;

/**
 * @author Kirchhoff-
 */

public interface Source {

    @NonNull
    Observable<String> getText();
}
