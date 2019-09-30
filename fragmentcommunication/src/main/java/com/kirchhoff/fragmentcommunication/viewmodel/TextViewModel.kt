package com.kirchhoff.fragmentcommunication.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TextViewModel : ViewModel() {
    val message = MutableLiveData<String>()

    fun message(msg: String) {
        message.value = msg
    }
}