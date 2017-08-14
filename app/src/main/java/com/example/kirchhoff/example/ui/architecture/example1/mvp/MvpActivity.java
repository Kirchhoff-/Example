package com.example.kirchhoff.example.ui.architecture.example1.mvp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.kirchhoff.example.R;
import com.example.kirchhoff.example.ui.architecture.example1.data.DataModel;

/**
 * @author Kirchhoff-
 */

public class MvpActivity extends AppCompatActivity implements MvpContract.View {

    @NonNull
    private MvpContract.Presenter presenter;

    @Nullable
    private TextView tvText;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_mvp_mvvm);

        presenter = new Presenter(new DataModel(), this);

        tvText = (TextView) findViewById(R.id.tvText);
    }

    @Override
    public void setText(@NonNull String text) {
        if (tvText != null)
            tvText.setText(text);
    }

    @Override
    protected void onPause() {
        super.onPause();
        presenter.unBind();
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.bind();
    }
}
