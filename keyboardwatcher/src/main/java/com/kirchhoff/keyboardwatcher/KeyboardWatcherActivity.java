package com.kirchhoff.keyboardwatcher;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.azimolabs.keyboardwatcher.KeyboardWatcher;

public class KeyboardWatcherActivity extends AppCompatActivity implements KeyboardWatcher.OnKeyboardToggleListener {

    private KeyboardWatcher keyboardWatcher;

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
