package com.example.kirchhoff.example.ui.drawer.simple;

import com.example.kirchhoff.example.ui.drawer.BasePresenter;
import com.example.kirchhoff.example.ui.drawer.BaseView;

/**
 * @author Kirchhoff-
 */

public class SimpleContract {

    interface SimpleView extends BaseView {
        void onActionDone();
    }

    interface SimplePresenter extends BasePresenter<SimpleView> {
        void onAction();
    }
}
