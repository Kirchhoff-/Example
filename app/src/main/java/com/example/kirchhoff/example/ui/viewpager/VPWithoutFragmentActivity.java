package com.example.kirchhoff.example.ui.viewpager;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.kirchhoff.example.R;

/**
 * @author Kirchhoff-
 */

public class VPWithoutFragmentActivity extends AppCompatActivity {

    public static void startMe(Context context) {
        Intent intent = new Intent(context, VPWithoutFragmentActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_vp_without_fragment);

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setAdapter(new CustomPagerAdapter(this));
    }
}
