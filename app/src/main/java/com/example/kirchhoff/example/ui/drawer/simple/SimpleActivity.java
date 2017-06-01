package com.example.kirchhoff.example.ui.drawer.simple;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.example.kirchhoff.example.R;
import com.example.kirchhoff.example.ui.drawer.BaseActivity;
import com.example.kirchhoff.example.ui.drawer.delegation.NavigationDrawerActivity;

import butterknife.OnClick;

/**
 * @author Kirchhoff-
 */

public class SimpleActivity extends BaseActivity<SimpleContract.SimplePresenter>
        implements SimpleContract.SimpleView {

    public static void startMe(Context context) {
        Intent intent = new Intent(context, SimpleActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_navigation_simple);
    }

    @Override
    public void onActionDone() {
        NavigationDrawerActivity.startMe(this);
    }

    @OnClick(R.id.btnGo)
    public void onBtnGoClick() {
        presenter.onAction();
    }

    @NonNull
    @Override
    protected SimpleContract.SimplePresenter getPresenterInstance() {
        return new SimplePresenter();
    }
}
