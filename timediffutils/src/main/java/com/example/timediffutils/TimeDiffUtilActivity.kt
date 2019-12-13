package com.example.timediffutils

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.timediffutils.adapter.TimeAdapter
import com.example.timediffutils.data.Time
import com.kirchhoff.timediffutils.R
import io.reactivex.Flowable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import java.util.Calendar.HOUR_OF_DAY
import java.util.Calendar.MINUTE
import java.util.Calendar.SECOND
import java.util.Calendar.getInstance
import java.util.TimeZone
import java.util.concurrent.TimeUnit

class TimeDiffUtilActivity : AppCompatActivity() {

    private val recyclerView by lazy { findViewById<RecyclerView>(R.id.recyclerView) }

    private val adapter = TimeAdapter()

    private var disposable: Disposable? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.a_time_diff_util)

        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = adapter

        disposable = adapter.setDataSource(createDataSource(resources.getStringArray(R.array.timezones_ids).asIterable()))
    }

    override fun onDestroy() {
        if (disposable?.isDisposed == true) {
            disposable?.dispose()
        }

        super.onDestroy()
    }

    private fun createDataSource(timeZonesIds: Iterable<String>): Flowable<List<Time>> {
        return Flowable.fromIterable(timeZonesIds)
                .map { getInstance(TimeZone.getTimeZone(it)) }
                .map { Time(it.timeZone.id, it.get(HOUR_OF_DAY), it.get(MINUTE), it.get(SECOND)) }
                .toList()
                .repeatWhen { it.delay(1, TimeUnit.SECONDS) }
                .subscribeOn(Schedulers.computation())
    }
}
