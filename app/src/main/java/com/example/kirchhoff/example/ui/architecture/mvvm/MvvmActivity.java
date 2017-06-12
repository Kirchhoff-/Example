package com.example.kirchhoff.example.ui.architecture.mvvm;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.kirchhoff.example.R;
import com.example.kirchhoff.example.ui.architecture.data.DataModel;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;

/**
 * @author Kirchhoff-
 */

public class MvvmActivity extends AppCompatActivity {

    @NonNull
    private CompositeDisposable disposable;

    @NonNull
    private ViewModel viewModel;

    @NonNull
    private TextView tvText;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_mvp_mvvm);

        viewModel = new ViewModel(new DataModel());
        tvText = (TextView) findViewById(R.id.tvText);
    }


    @Override
    protected void onResume() {
        super.onResume();
        bind();
    }

    @Override
    protected void onPause() {
        unbind();
        super.onPause();
    }

    private void bind() {
        disposable = new CompositeDisposable();

        disposable.add(viewModel.getText().subscribe(new Consumer<String>() {
            @Override
            public void accept(@io.reactivex.annotations.NonNull String s) throws Exception {
                tvText.setText(s);
            }
        }));
    }

    private void unbind() {
        if (!disposable.isDisposed())
            disposable.dispose();
    }
}
