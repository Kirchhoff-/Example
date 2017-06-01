package com.example.kirchhoff.example.ui.drawer.delegation;

import com.example.kirchhoff.example.ui.drawer.BasePresenterImpl;

/**
 * @author Kirchhoff-
 */

public class NavigationDrawerPresenter extends
        BasePresenterImpl<NavigationDrawerContract.NavigationDrawerView>
        implements NavigationDrawerContract.NavigationDrawerPresenter {

    @Override
    public void onAction() {
        view.onActionDone();
    }
}
