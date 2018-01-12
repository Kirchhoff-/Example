package com.example.kirchhoff.example.ui.architecture.example3;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.kirchhoff.example.R;

/**
 * @author Kirchhoff-
 */

public class ArchitectureComponentActivity extends AppCompatActivity {


    public static void start(Context context) {
        Intent intent = new Intent(context, ArchitectureComponentActivity.class);
        context.startActivity(intent);
    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_architecture_component);
    }
}
