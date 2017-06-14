package com.example.kirchhoff.example.ui.animation;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.kirchhoff.example.R;

/**
 * @author Kirchhoff-
 */

public class SimpleTransitionDetailsActivity extends AppCompatActivity {

    private TextView tvDesc;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_simple_transition_details);

        String[] array = getIntent().getStringArrayExtra("parameter");

        RelativeLayout layout = (RelativeLayout) findViewById(R.id.layout);
        layout.setBackgroundColor(Color.parseColor(array[3]));

        TextView tvHeading = (TextView) findViewById(R.id.tvHeading);
        TextView tvLanguage = (TextView) findViewById(R.id.tvLanguage);
        tvDesc = (TextView) findViewById(R.id.tvDesc);

        tvHeading.setText(array[0]);
        tvLanguage.setText(array[1]);
        tvDesc.setText(array[2]);
    }

    @Override
    public void onBackPressed() {
        tvDesc.setVisibility(View.GONE);
        ActivityCompat.finishAfterTransition(this);
    }
}
