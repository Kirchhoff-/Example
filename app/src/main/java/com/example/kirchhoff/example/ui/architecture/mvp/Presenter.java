package com.example.kirchhoff.example.ui.architecture.mvp;

import android.support.annotation.NonNull;

import com.example.kirchhoff.example.ui.architecture.data.Source;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;

/**
 * @author Kirchhoff-
 */

public class Presenter implements MvpContract.Presenter {


    @NonNull
    private final Source source;

    @NonNull
    private final MvpContract.View view;

    private CompositeDisposable disposable;

    public Presenter(@NonNull final Source source,
                     @NonNull final MvpContract.View view) {
        this.source = source;
        this.view = view;
    }

    @Override
    public void bind() {
        disposable = new CompositeDisposable();

        disposable.add(source.getText().subscribe(new Consumer<String>() {
            @Override
            public void accept(@io.reactivex.annotations.NonNull String string) throws Exception {
                view.setText(string);
            }
        }));
    }

    @Override
    public void unBind() {
        if (!disposable.isDisposed()) {
            disposable.dispose();
        }
    }
}
