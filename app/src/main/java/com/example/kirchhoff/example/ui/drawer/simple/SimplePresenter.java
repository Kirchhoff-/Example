package com.example.kirchhoff.example.ui.drawer.simple;

import com.example.kirchhoff.example.ui.drawer.BasePresenterImpl;

/**
 * @author Kirchhoff-
 */

public class SimplePresenter extends BasePresenterImpl<SimpleContract.SimpleView>
        implements SimpleContract.SimplePresenter {

    @Override
    public void onAction() {
        view.onActionDone();
    }
}
