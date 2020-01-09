package com.example.simpletransition

import android.os.Parcelable
import androidx.annotation.ColorRes
import kotlinx.android.parcel.Parcelize

@Parcelize
internal data class TransitionItem(
    val title: String,
    val language: String,
    val description: String,
    @ColorRes val color: Int
) : Parcelable
