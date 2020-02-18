package com.kirchhoff.thingdiffutils

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.util.Pair
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import io.reactivex.disposables.Disposable
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

        disposable = getThings()
    }

    override fun onStop() {
        super.onStop()
        disposable?.dispose()
    }

    private fun getThings(): Disposable {
        return ThingRepository
                .simulateThings(2, TimeUnit.SECONDS)
                .scan(Pair.create<List<Thing>, DiffUtil.DiffResult>(emptyList(), null), getScanPair())
                .skip(1)
                .workComputationObserveOnMain()
                .subscribe(getSubscriber())
    }

    private fun getScanPair(): (Pair<List<Thing>, DiffUtil.DiffResult>, List<Thing>) ->
    Pair<List<Thing>, DiffUtil.DiffResult> {
        return { pair, next ->
            val callback = DiffUtilCallback(pair.first!!, next)
            val result = DiffUtil.calculateDiff(callback)
            Pair.create(next, result)
        }
    }

    private fun getSubscriber(): (Pair<List<Thing>, DiffUtil.DiffResult>) -> Unit {
        return { listDiffResultPair ->
            adapter.setThings(listDiffResultPair.first!!)
            listDiffResultPair.second?.dispatchUpdatesTo(adapter)
        }
    }
}
