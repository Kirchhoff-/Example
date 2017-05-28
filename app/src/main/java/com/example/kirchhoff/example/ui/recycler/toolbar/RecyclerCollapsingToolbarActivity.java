package com.example.kirchhoff.example.ui.recycler.toolbar;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.example.kirchhoff.example.R;

/**
 * @author Kirchhoff-
 */

public class RecyclerCollapsingToolbarActivity extends AppCompatActivity {


    public static void startMe(Context context) {
        Intent intent = new Intent(context, RecyclerCollapsingToolbarActivity.class);
        context.startActivity(intent);
    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_recycler_collapsing_toolbard);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }
}
