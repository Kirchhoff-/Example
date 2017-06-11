package com.example.kirchhoff.example.ui.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.kirchhoff.example.R;

/**
 * @author Kirchhoff-
 */

public class ViewActivity extends AppCompatActivity {

    public static void start(Context context) {
        context.startActivity(new Intent(context, ViewActivity.class));
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_view);
        overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left);
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_from_left, R.anim.slide_to_right);
    }
}
