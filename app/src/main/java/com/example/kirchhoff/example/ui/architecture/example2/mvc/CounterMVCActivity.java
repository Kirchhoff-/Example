package com.example.kirchhoff.example.ui.architecture.example2.mvc;

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

public class CounterMVCActivity extends AppCompatActivity implements OnCounterIncreaseListener {

    private Button bIncrease;
    private CounterController controller;

    public static void start(Context context) {
        Intent intent = new Intent(context, CounterMVCActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_counter);

        bIncrease = (Button) findViewById(R.id.bIncrease);

        controller = new CounterControllerImp();
        controller.setOnCounterIncreaseListener(this);
        bIncrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                controller.increase();
            }
        });
    }

    @Override
    public void onCounterIncreased(int value) {
        bIncrease.setText(String.valueOf(value));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        controller.setOnCounterIncreaseListener(null);
    }
}
