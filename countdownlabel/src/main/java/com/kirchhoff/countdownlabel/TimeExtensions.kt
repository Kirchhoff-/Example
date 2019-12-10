package com.kirchhoff.countdownlabel

fun Long.days(): Int {
   return (this / (1000 * 60 * 60 * 24) % 7).toInt()
}

fun Long.hours(): Int {
    return (this / (1000 * 60 * 60) % 24).toInt()
}

fun Long.minutes(): Int {
    return (this / (1000 * 60) % 60).toInt()
}

fun Long.seconds(): Int {
    return (this / 1000).toInt() % 60
}
