package com.kirchhoff.circularrevealfragment.utils

import android.app.FragmentManager
import android.app.FragmentTransaction

inline fun FragmentManager.open(block: FragmentTransaction.() -> Unit) {
    beginTransaction().apply {
        block()
        commit()
    }
}