package com.example.kirchhoff.example.ui.recycler.diffutil

import android.support.v7.util.DiffUtil
import android.view.View
import com.example.kirchhoff.example.R
import com.example.kirchhoff.example.ui.Extensions.setFormatDigit
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable


class TimeAdapter : BaseAdapter<Time, TimeViewHolder>() {


    override fun getItemViewId() = R.layout.r_diff

    override fun instantiateViewHolder(view: View?) = TimeViewHolder(view)

    fun setDataSource(flowable: Flowable<List<Time>>): Disposable {
        var newList: List<Time> = emptyList()
        return flowable
                .doOnNext { newList = it }
                .map { DiffUtil.calculateDiff(TimeDiffCallback(listSource, it)) }
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
                    TimeDiffCallback.ID -> {
                        holder?.tvId?.text = getItem(position).id
                    }
                    TimeDiffCallback.HOURS -> {
                        holder?.tvHours?.setFormatDigit(getItem(position).hours)
                    }
                    TimeDiffCallback.MINUTES -> {
                        holder?.tvMinutes?.setFormatDigit(getItem(position).minute)
                    }
                    TimeDiffCallback.SECONDS -> {
                        holder?.tvSeconds?.setFormatDigit(getItem(position).seconds)
                    }
                    else -> super.onBindViewHolder(holder, position, payloads)
                }
            }
        }
    }

}