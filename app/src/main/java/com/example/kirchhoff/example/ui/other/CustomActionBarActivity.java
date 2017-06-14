package com.example.kirchhoff.example.ui.other;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.example.kirchhoff.example.R;

/**
 * @author Kirchhoff-
 */

public class CustomActionBarActivity extends AppCompatActivity {


    public static void start(Context context) {
        context.startActivity(new Intent(context, CustomActionBarActivity.class));
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_empty);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
            actionBar.setDisplayShowCustomEnabled(true);
            actionBar.setCustomView(R.layout.v_custom_action_bar);

            View view = actionBar.getCustomView();

            view.findViewById(R.id.ibBack).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(CustomActionBarActivity.this, "Back Button is clicked",
                            Toast.LENGTH_LONG).show();
                }
            });

            view.findViewById(R.id.ibForward).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(CustomActionBarActivity.this, "Forward Button is clicked",
                            Toast.LENGTH_LONG).show();
                }
            });
        }
    }
}
