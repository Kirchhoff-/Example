package com.example.timediffutils

import android.support.v7.util.DiffUtil
import com.example.timediffutils.data.Time

class TimeDiffCallback(private val oldList: List<Time>, private val newList: List<Time>) : DiffUtil.Callback() {

    companion object {
        const val ID = "ID"
        const val HOURS = "HOURS"
        const val MINUTES = "MINUTES"
        const val SECONDS = "SECONDS"
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
            oldList[oldItemPosition].id == newList[newItemPosition].id

    override fun getOldListSize(): Int = oldList.size

    override fun getNewListSize(): Int = newList.size

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val new = newList[newItemPosition]
        val old = oldList[oldItemPosition]
        val isIdEquals = new.id == old.id
        val isHoursEquals = new.hours == old.hours
        val isMinuteEquals = new.minute == old.minute
        val isSecondsEquals = new.seconds == old.seconds
        return isIdEquals && isHoursEquals && isMinuteEquals && isSecondsEquals
    }

    override fun getChangePayload(oldItemPosition: Int, newItemPosition: Int): Any? {
        val new = newList[newItemPosition]
        val old = oldList[oldItemPosition]
        val isIdEquals = new.id == old.id
        val isHoursEquals = new.hours == old.hours
        val isMinuteEquals = new.minute == old.minute
        val isSecondsEquals = new.seconds == old.seconds
        val set = mutableSetOf<String>()

        if (isIdEquals.not()) {
            set.add(ID)
        }

        if (isHoursEquals.not()) {
            set.add(HOURS)
        }

        if (isMinuteEquals.not()) {
            set.add(MINUTES)
        }

        if (isSecondsEquals.not()) {
            set.add(SECONDS)
        }

        return set
    }

}