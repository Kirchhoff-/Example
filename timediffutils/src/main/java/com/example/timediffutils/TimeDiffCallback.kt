package com.example.timediffutils

import android.support.v7.util.DiffUtil

/**
 * @author Kirchhoff-
 */
class TimeDiffCallback(val oldList: List<Time>, val newList: List<Time>) : DiffUtil.Callback() {

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
        val isIdEquels = new.id == old.id
        val isHoursEquels = new.hours == old.hours
        val isMinuteEquels = new.minute == old.minute
        val isSecondsEquels = new.seconds == old.seconds
        return isIdEquels && isHoursEquels && isMinuteEquels && isSecondsEquels
    }

    override fun getChangePayload(oldItemPosition: Int, newItemPosition: Int): Any? {
        val new = newList[newItemPosition]
        val old = oldList[oldItemPosition]
        val isIdEquels = new.id == old.id
        val isHoursEquels = new.hours == old.hours
        val isMinuteEquels = new.minute == old.minute
        val isSecondsEquels = new.seconds == old.seconds
        val set = mutableSetOf<String>()

        if (isIdEquels.not()) {
            set.add(TimeDiffCallback.Companion.ID)
        }

        if (isHoursEquels.not()) {
            set.add(TimeDiffCallback.Companion.HOURS)
        }

        if (isMinuteEquels.not()) {
            set.add(TimeDiffCallback.Companion.MINUTES)
        }

        if (isSecondsEquels.not()) {
            set.add(TimeDiffCallback.Companion.SECONDS)
        }

        return set
    }

}