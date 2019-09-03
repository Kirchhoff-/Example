package com.example.lazybind.extensions

import android.app.Activity
import android.support.annotation.IdRes
import android.view.View

fun <T> lazyUnsychronized(initializer: () -> T): Lazy<T> =
        lazy(LazyThreadSafetyMode.NONE, initializer)

fun <ViewT : View> Activity.bindView(@IdRes idRes: Int): Lazy<ViewT> {
    return lazyUnsychronized {
        findViewById<ViewT>(idRes)
    }
}