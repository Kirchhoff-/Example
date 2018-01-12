package com.example.kirchhoff.example.ui.architecture.example3;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.os.Bundle;

/**
 * @author Kirchhoff-
 */

public abstract class BasePresenter<V extends BaseContract.View> implements LifecycleObserver, BaseContract.Presenter<V> {

    private V view;
    private Bundle stateBundle;

    @Override
    final public void attachLifecycle(Lifecycle lifecycle) {
        lifecycle.addObserver(this);
    }

    @Override
    final public void detachLifecycle(Lifecycle lifecycle) {
        lifecycle.removeObserver(this);
    }

    @Override
    final public void attachView(V view) {
        this.view = view;
    }

    @Override
    final public void detachView() {
        this.view = null;
    }

    @Override
    final public V getView() {
        return view;
    }

    @Override
    final public boolean isViewAttached() {
        return view != null;
    }

    @Override
    public Bundle getStateBundle() {
        return stateBundle == null ? stateBundle = new Bundle() : stateBundle;
    }

    @Override
    final public void onPresenterDestroy() {
        if (stateBundle != null && !stateBundle.isEmpty()) {
            stateBundle.clear();
        }
    }
}
