package com.example.kirchhoff.example.ui.drawer;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @author Kirchhoff-
 */

public abstract class BaseActivityDelegate<V extends BaseView,
        P extends BasePresenterImpl<V>> {

    protected P presenter;
    private Unbinder unbinder = null;

    public void onCreate(P presenter) {
        this.presenter = presenter;
        unbinder = ButterKnife.bind(this, presenter.getView().getContentView());
    }

    public void onDestroy() {
        unbinder.unbind();
    }
}
