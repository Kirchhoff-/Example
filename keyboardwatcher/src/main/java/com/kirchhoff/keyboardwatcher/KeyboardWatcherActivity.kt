package com.kirchhoff.keyboardwatcher

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log

import com.azimolabs.keyboardwatcher.KeyboardWatcher

class KeyboardWatcherActivity : AppCompatActivity(), KeyboardWatcher.OnKeyboardToggleListener {

    private lateinit var keyboardWatcher: KeyboardWatcher

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.a_keyboard_watcher)

        keyboardWatcher = KeyboardWatcher(this)
        keyboardWatcher.setListener(this)
    }

    override fun onKeyboardShown(keyboardSize: Int) {
        Log.d("TAG", "onKeyboardShown, size = $keyboardSize")
    }

    override fun onKeyboardClosed() {
        Log.d("TAG", "onKeyboardClosed")
    }

    override fun onDestroy() {
        super.onDestroy()
        keyboardWatcher.destroy()
    }
}
