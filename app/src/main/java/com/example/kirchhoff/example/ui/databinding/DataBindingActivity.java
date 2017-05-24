package com.example.kirchhoff.example.ui.databinding;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.example.kirchhoff.example.R;
import com.example.kirchhoff.example.databinding.ADataBindingBinding;

/**
 * @author Kirchhoff-
 */

public class DataBindingActivity extends AppCompatActivity {

    private static final String TAG = DataBindingActivity.class.getSimpleName();

    ADataBindingBinding binding;

    public static void startMe(Context context) {
        Intent intent = new Intent(context, DataBindingActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.a_data_binding);
        User user = new User();
        user.setName("Test User Name");
        binding.setUser(user);
        binding.setActivity(this);
    }

    public void onButtonClick(String email) {
        Log.d(TAG, "Email :" + binding.getUser().getEmail());
        Log.d(TAG, "Email : " + email);
        Toast.makeText(this, email, Toast.LENGTH_SHORT).show();
    }
}
