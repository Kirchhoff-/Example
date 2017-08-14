package com.example.kirchhoff.example.ui.architecture.example1.mvp;

import android.support.annotation.NonNull;

/**
 * @author Kirchhoff-
 */

public interface MvpContract {

    interface View {

        void setText(@NonNull final String text);

    }

    interface Presenter {

        void bind();

        void unBind();
    }
}
