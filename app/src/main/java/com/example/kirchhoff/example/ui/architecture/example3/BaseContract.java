package com.example.kirchhoff.example.ui.architecture.example3;

import android.arch.lifecycle.Lifecycle;
import android.os.Bundle;

/**
 * @author Kirchhoff-
 */

interface BaseContract {

    interface View {

    }

    interface Presenter<V extends BaseContract.View> {

        void attachLifecycle(Lifecycle lifecycle);

        void detachLifecycle(Lifecycle lifecycle);

        void attachView(V view);

        void detachView();

        V getView();

        boolean isViewAttached();

        Bundle getStateBundle();

        void onPresenterDestroy();
    }
}
