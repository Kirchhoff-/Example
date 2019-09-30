package com.example.lazybind.extensions

import android.app.Activity
import android.view.View
import androidx.annotation.IdRes

fun <T> lazyUnsychronized(initializer: () -> T): Lazy<T> =
        lazy(LazyThreadSafetyMode.NONE, initializer)

fun <ViewT : View> Activity.bindView(@IdRes idRes: Int): Lazy<ViewT> {
    return lazyUnsychronized {
        findViewById<ViewT>(idRes)
    }
}