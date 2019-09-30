package com.example.timediffutils.adapter

import androidx.recyclerview.widget.DiffUtil.calculateDiff
import com.example.timediffutils.TimeDiffCallback
import com.example.timediffutils.data.Time
import com.example.timediffutils.extensions.setFormatDigit
import com.kirchhoff.timediffutils.R
import io.reactivex.android.schedulers.AndroidSchedulers


class TimeAdapter : BaseAdapter<Time, TimeViewHolder>() {

    override fun getItemViewId() = R.layout.r_time_diff

    override fun instantiateViewHolder(view: android.view.View) = TimeViewHolder(view)

    fun setDataSource(flowable: io.reactivex.Flowable<List<Time>>): io.reactivex.disposables.Disposable {
        var newList: List<Time> = emptyList()
        return flowable
                .doOnNext { newList = it }
                .map { calculateDiff(TimeDiffCallback(listSource, it)) }
                .observeOn(AndroidSchedulers.mainThread())
                .doOnNext { listSource = newList }
                .subscribe { it.dispatchUpdatesTo(this) }
    }

    @Suppress("UNCHECKED_CAST")
    override fun onBindViewHolder(holder: TimeViewHolder, position: Int, payloads: MutableList<Any>) {
        if (payloads.isEmpty()) {
            super.onBindViewHolder(holder, position, payloads)
        } else {
            val set = payloads.firstOrNull() as Set<String>?
            set?.forEach {
                when (it) {
                    TimeDiffCallback.ID -> {
                        holder.tvId.text = getItem(position).id
                    }
                    TimeDiffCallback.HOURS -> {
                        holder.tvHours.setFormatDigit(getItem(position).hours)
                    }
                    TimeDiffCallback.MINUTES -> {
                        holder.tvMinutes.setFormatDigit(getItem(position).minute)
                    }
                    TimeDiffCallback.SECONDS -> {
                        holder.tvSeconds.setFormatDigit(getItem(position).seconds)
                    }
                    else -> super.onBindViewHolder(holder, position, payloads)
                }
            }
        }
    }

}