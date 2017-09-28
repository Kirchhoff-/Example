package com.example.kirchhoff.example.ui.recycler.diffutil.ex1

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import com.example.kirchhoff.example.R
import io.reactivex.Flowable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import java.util.*
import java.util.Calendar.*
import java.util.concurrent.TimeUnit

/**
 * @author Kirchhoff-
 */
class DiffUtilActivity : AppCompatActivity() {

    private val recyclerView by lazy { findViewById<RecyclerView>(R.id.recyclerView) }

    private val adapter = TimeAdapter()

    var disposable: Disposable? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.a_diff_util)

        val timeZonesIds = resources.getStringArray(R.array.timezones_ids).asIterable()

        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = adapter

        val flowable = Flowable.fromIterable(timeZonesIds)
                .map { getInstance(TimeZone.getTimeZone(it)) }
                .map { Time(it.timeZone.id, it.get(HOUR_OF_DAY), it.get(MINUTE), it.get(SECOND)) }
                .toList()
                .repeatWhen { it.delay(1, TimeUnit.SECONDS) }
                .subscribeOn(Schedulers.computation())

        disposable = adapter.setDataSource(flowable)
    }

    override fun onDestroy() {
        if (disposable?.isDisposed ?: false)
            disposable?.dispose()

        super.onDestroy()
    }
}