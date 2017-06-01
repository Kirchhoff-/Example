package com.example.kirchhoff.example.ui.drawer.delegation;

import com.example.kirchhoff.example.ui.drawer.BasePresenter;
import com.example.kirchhoff.example.ui.drawer.BaseView;

/**
 * @author Kirchhoff-
 */

public class NavigationDrawerContract {

    interface NavigationDrawerView extends BaseView {

        void openCamera();

        void onActionDone();

        NavigationDrawerActivity getActivity();
    }

    interface NavigationDrawerPresenter extends BasePresenter<NavigationDrawerView> {

        void onAction();
    }
}
