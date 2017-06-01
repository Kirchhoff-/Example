package com.example.kirchhoff.example.ui.drawer.delegation;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.kirchhoff.example.R;
import com.example.kirchhoff.example.ui.drawer.BaseDelegationActivity;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @author Kirchhoff-
 */

public class NavigationDrawerActivity extends BaseDelegationActivity<
        NavigationDrawerContract.NavigationDrawerView,
        NavigationDrawerPresenter,
        NavigationDrawerDelegate> implements NavigationDrawerContract.NavigationDrawerView {

    @BindView(R.id.toolbar)
    protected Toolbar toolbar;

    public static void startMe(Context context) {
        context.startActivity(new Intent(context, NavigationDrawerActivity.class));
    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        setContentView(R.layout.a_navigation_drawer);
        setSupportActionBar(toolbar);
        super.onCreate(savedInstanceState);
    }

    @Override
    public void openCamera() {
        Snackbar.make(getContentView(), "Open camera", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
    }

    @Override
    public void onActionDone() {
        Snackbar.make(getContentView(), "OnActionDone", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
    }

    @OnClick(R.id.fab)
    public void onFabClick(View view) {
        Snackbar.make(view, "Floating action button click", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
    }

    @Override
    public NavigationDrawerActivity getActivity() {
        return this;
    }

    @Override
    protected NavigationDrawerDelegate instantiateDelegateInstance() {
        return new NavigationDrawerDelegate();
    }

    @Override
    public void onBackPressed() {
        if (!delegate.closeDrawer()) {
            super.onBackPressed();
        }
    }

    @NonNull
    @Override
    protected NavigationDrawerPresenter getPresenterInstance() {
        return new NavigationDrawerPresenter();
    }
}
