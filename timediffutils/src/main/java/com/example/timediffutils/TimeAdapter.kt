package com.example.timediffutils

import android.support.v7.util.DiffUtil.calculateDiff
import com.example.timediffutils.extensions.setFormatDigit
import com.kirchhoff.timediffutils.R
import io.reactivex.android.schedulers.AndroidSchedulers


class TimeAdapter : BaseAdapter<Time, TimeViewHolder>() {


    override fun getItemViewId() = R.layout.r_time_diff

    override fun instantiateViewHolder(view: android.view.View?) = TimeViewHolder(view)

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
    override fun onBindViewHolder(holder: TimeViewHolder?, position: Int, payloads: MutableList<Any>?) {
        if (payloads?.isEmpty() ?: true) {
            super.onBindViewHolder(holder, position, payloads)
        } else {
            val set = payloads?.firstOrNull() as Set<String>?
            set?.forEach {
                when (it) {
                    TimeDiffCallback.Companion.ID -> {
                        holder?.tvId?.text = getItem(position).id
                    }
                    TimeDiffCallback.Companion.HOURS -> {
                        holder?.tvHours?.setFormatDigit(getItem(position).hours)
                    }
                    TimeDiffCallback.Companion.MINUTES -> {
                        holder?.tvMinutes?.setFormatDigit(getItem(position).minute)
                    }
                    TimeDiffCallback.Companion.SECONDS -> {
                        holder?.tvSeconds?.setFormatDigit(getItem(position).seconds)
                    }
                    else -> super.onBindViewHolder(holder, position, payloads)
                }
            }
        }
    }

}