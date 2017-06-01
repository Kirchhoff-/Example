package com.example.kirchhoff.example.ui.drawer;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.kirchhoff.example.R;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @author Kirchhoff-
 */

public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity
        implements BaseView {

    protected P presenter;
    private Unbinder unbinder;
    private ProgressDialog progressDialog = null;

    protected
    @NonNull
    abstract P getPresenterInstance();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = getPresenterInstance();
        presenter.attachView(this);
    }

    @Override
    protected void onDestroy() {
        presenter.detachView();
        unbinder.unbind();
        super.onDestroy();
    }

    @Override
    public void showProgress() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (progressDialog == null || !progressDialog.isShowing()) {
                    progressDialog = new ProgressDialog(BaseActivity.this);
                    progressDialog.setMessage(getString(R.string.loading));
                    progressDialog.setCancelable(false);
                    progressDialog.show();
                }
            }
        });

    }

    @Override
    public void hideProgress() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (progressDialog != null && progressDialog.isShowing()) {
                    progressDialog.dismiss();
                }
            }
        });
    }

    @Override
    public View getContentView() {
        return getWindow().getDecorView();
    }

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        super.setContentView(layoutResID);
        unbinder = ButterKnife.bind(this);
    }
}
