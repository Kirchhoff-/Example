package com.kirchhoff.autodisposable.extension

import com.kirchhoff.autodisposable.AutoDisposable
import io.reactivex.disposables.Disposable

fun Disposable.addTo(autoDisposable: AutoDisposable) {
    autoDisposable.add(this)
}
