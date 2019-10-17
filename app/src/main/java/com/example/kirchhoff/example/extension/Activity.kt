package com.example.kirchhoff.example.extension

import android.app.Activity
import android.content.Intent

fun Activity.startActivity(cls: Class<*>) {
    startActivity(Intent(this, cls))
}
