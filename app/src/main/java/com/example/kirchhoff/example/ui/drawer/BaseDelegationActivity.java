package com.example.kirchhoff.example.ui.drawer;

import android.os.Bundle;
import android.support.annotation.Nullable;

/**
 * @author Kirchhoff-
 */

public abstract class BaseDelegationActivity<
        V extends BaseView,
        P extends BasePresenterImpl<V>,
        D extends BaseActivityDelegate<V, P>> extends BaseActivity<P> {


    protected D delegate;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        delegate = instantiateDelegateInstance();
        delegate.onCreate(presenter);
    }

    protected abstract D instantiateDelegateInstance();

    @Override
    protected void onDestroy() {
        delegate.onDestroy();
        super.onDestroy();
    }
}
