package com.example.kirchhoff.example.ui.architecture.example2.mvvm;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.kirchhoff.example.R;
import com.example.kirchhoff.example.databinding.ACounterMvvmBinding;

/**
 * @author Kirchhoff-
 */

public class CounterMVVMActivity extends AppCompatActivity {

    public static void start(Context context) {
        Intent intent = new Intent(context, CounterMVVMActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ACounterMvvmBinding binding =
                DataBindingUtil.setContentView(this, R.layout.a_counter_mvvm);
        binding.setData(new CounterViewModel(0));
    }
}
