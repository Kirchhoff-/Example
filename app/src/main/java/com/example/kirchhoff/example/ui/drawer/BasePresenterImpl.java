package com.example.kirchhoff.example.ui.drawer;

/**
 * @author Kirchhoff-
 */

public class BasePresenterImpl<V extends BaseView> implements BasePresenter<V> {

    protected V view;

    @Override
    public void attachView(V view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        view = null;
    }

    public V getView() {
        return view;
    }
}
