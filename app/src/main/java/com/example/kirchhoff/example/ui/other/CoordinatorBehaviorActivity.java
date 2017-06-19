package com.example.kirchhoff.example.ui.other;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.kirchhoff.example.R;

/**
 * @author Kirchhoff-
 */

public class CoordinatorBehaviorActivity extends AppCompatActivity {


    public static void start(Context context) {
        context.startActivity(new Intent(context, CoordinatorBehaviorActivity.class));
    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_coordinate_behavior);

        findViewById(R.id.bApply).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Button with custom behavior",
                        Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

     /*   findViewById(R.id.fab).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Button with custom behavior",
                        Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        }); */
    }
}
