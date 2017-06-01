package com.example.kirchhoff.example.ui.drawer;

/**
 * @author Kirchhoff-
 */

public interface BasePresenter<V extends BaseView> {

    void attachView(V view);

    void detachView();
}
