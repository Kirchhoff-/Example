package com.kirchhoff.thingdiffutils

import android.os.Bundle
import android.support.v4.util.Pair
import android.support.v7.app.AppCompatActivity
import android.support.v7.util.DiffUtil
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.RecyclerView
import io.reactivex.android.schedulers.AndroidSchedulers.mainThread
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers.computation
import java.util.*
import java.util.concurrent.TimeUnit

class ThingDiffUtilActivity : AppCompatActivity() {

    private lateinit var adapter: ThingAdapter
    private var disposable: Disposable? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.a_thing_diff_util)
    }

    override fun onStart() {
        super.onStart()

        adapter = ThingAdapter()
        val recyclerView: RecyclerView = findViewById(R.id.listOfThings)
        recyclerView.itemAnimator = DefaultItemAnimator()
        recyclerView.adapter = adapter

        val emptyList = ArrayList<Thing>()
        adapter.setThings(emptyList)
        val initialPair = Pair.create<List<Thing>, DiffUtil.DiffResult>(emptyList, null)

        disposable = ThingRepository
                .simulateThings(2, TimeUnit.SECONDS)
                .scan<Pair<List<Thing>, DiffUtil.DiffResult>>(initialPair) { pair, next ->
                    val callback = DiffUtilCallback(pair.first, next)
                    val result = DiffUtil.calculateDiff(callback)
                    Pair.create(next, result)
                }
                .skip(1)
                .subscribeOn(computation())
                .observeOn(mainThread())
                .subscribe { listDiffResultPair ->
                    adapter.setThings(listDiffResultPair.first)
                    listDiffResultPair.second.dispatchUpdatesTo(adapter)
                }
    }

    override fun onStop() {
        super.onStop()
        disposable?.dispose()
    }
}
