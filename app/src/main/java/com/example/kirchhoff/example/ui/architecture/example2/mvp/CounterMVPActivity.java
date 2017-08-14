package com.example.kirchhoff.example.ui.architecture.example2.mvp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.kirchhoff.example.R;

/**
 * @author Kirchhoff-
 */

public class CounterMVPActivity extends AppCompatActivity implements CounterView {

    private Button bIncrease;
    private CounterPresenter presenter;

    public static void start(Context context) {
        Intent intent = new Intent(context, CounterMVPActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_counter);

        bIncrease = (Button) findViewById(R.id.bIncrease);
        bIncrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.onIncreaseClicked();
            }
        });

        presenter = new CounterPresenterImp();
        presenter.setView(this);
    }

    @Override
    public void setCounterText(String text) {
        bIncrease.setText(text);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.setView(null);
    }
}
