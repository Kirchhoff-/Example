package com.kirchhoff.fragmentcommunication.viewmodel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel

class TextViewModel : ViewModel() {
    val message = MutableLiveData<String>()

    fun message(msg: String) {
        message.value = msg
    }
}