package com.kirchhoff.countdownlabel

fun Long.days() = (this / (MILLISECOND * SECONDS_IN_MINUTE * MINUTES_IN_HOUR * HOURS_IN_DAY) % DAYS_IN_WEEK).toInt()

fun Long.hours() = (this / (MILLISECOND * SECONDS_IN_MINUTE * MINUTES_IN_HOUR) % HOURS_IN_DAY).toInt()

fun Long.minutes() = (this / (MILLISECOND * MINUTES_IN_HOUR) % SECONDS_IN_MINUTE).toInt()

fun Long.seconds() = (this / MILLISECOND).toInt() % SECONDS_IN_MINUTE

const val MILLISECOND = 1000
const val SECONDS_IN_MINUTE = 60
const val MINUTES_IN_HOUR = 60
const val HOURS_IN_DAY = 24
const val DAYS_IN_WEEK = 7
