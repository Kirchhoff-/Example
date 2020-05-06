package com.kirchhoff.autodisposable

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import com.kirchhoff.autodisposable.extension.addTo
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import java.util.concurrent.TimeUnit

class AutoDisposableActivity : AppCompatActivity(R.layout.activity_auto_disposable) {

    private val autoDisposable = AutoDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        autoDisposable.bind(this.lifecycle)

        findViewById<View>(R.id.bTest).setOnClickListener {
            Observable.just("Hello, this text emitted by observable")
                    .delay(TIMEOUT, TimeUnit.MILLISECONDS)
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(
                            { toast(R.string.autodisposable_finish) },
                            { toast(R.string.autodisposable_error) }
                    )
                    .addTo(autoDisposable)
        }
    }

    private fun toast(@StringRes resId: Int) {
        Toast.makeText(this, resId, Toast.LENGTH_LONG).show()
    }

    companion object {
        const val TIMEOUT = 5000L
    }
}
