package com.kirchhoff.thingdiffutils

import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

fun <T>Flowable<T>.workComputationObserveOnMain(): Flowable<T> {
    return this.
            subscribeOn(Schedulers.computation())
            .observeOn(AndroidSchedulers.mainThread())

}