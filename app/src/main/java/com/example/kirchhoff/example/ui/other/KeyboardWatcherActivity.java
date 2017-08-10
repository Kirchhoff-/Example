package com.example.kirchhoff.example.ui.other;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.azimolabs.keyboardwatcher.KeyboardWatcher;
import com.example.kirchhoff.example.R;

/**
 * @author Kirchhoff-
 */

public class KeyboardWatcherActivity extends AppCompatActivity implements KeyboardWatcher.OnKeyboardToggleListener {

    private KeyboardWatcher keyboardWatcher;

    public static void start(Context context) {
        Intent intent = new Intent(context, KeyboardWatcherActivity.class);
        context.startActivity(intent);
    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_keyboard_watcher);

        keyboardWatcher = new KeyboardWatcher(this);
        keyboardWatcher.setListener(this);
    }

    @Override
    public void onKeyboardShown(int keyboardSize) {
        Log.d("TAG", "onKeyboardShown, size = " + keyboardSize);
    }

    @Override
    public void onKeyboardClosed() {
        Log.d("TAG", "onKeyboardClosed");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        keyboardWatcher.destroy();
    }
}
