package com.example.kirchhoff.example.ui.architecture.example2;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.kirchhoff.example.R;
import com.example.kirchhoff.example.ui.architecture.example2.mvc.CounterMVCActivity;
import com.example.kirchhoff.example.ui.architecture.example2.mvp.CounterMVPActivity;


/**
 * @author Kirchhoff-
 */

public class ArchitectureExampleActivity extends AppCompatActivity {


    public static void start(Context context) {
        Intent intent = new Intent(context, ArchitectureExampleActivity.class);
        context.startActivity(intent);
    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_architecture_example);
    }


    public void mvcExample(View view) {
        CounterMVCActivity.start(this);
    }

    public void mvpExample(View view) {
        CounterMVPActivity.start(this);
    }

}
