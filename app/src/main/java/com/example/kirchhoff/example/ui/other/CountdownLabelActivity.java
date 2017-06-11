package com.example.kirchhoff.example.ui.other;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.kirchhoff.example.R;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @author Kirchhoff-
 */

//TODO move to View.
public class CountdownLabelActivity extends AppCompatActivity {

    private static final int COUNTDOWN_UPDATE_INTERVAL = 500;

    private Handler countdownHandler;

    private TextView tvCount;
    private Date futureDate;
    private Runnable updateCountdown = new Runnable() {
        @Override
        public void run() {
            try {
                tvCount.setText(formatDate(futureDate));
            } finally {
                countdownHandler.postDelayed(updateCountdown, COUNTDOWN_UPDATE_INTERVAL);
            }
        }
    };

    public static void start(Context context) {
        context.startActivity(new Intent(context, CountdownLabelActivity.class));
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_countdown_label);

        futureDate = new Date();
        futureDate.setTime(futureDate.getTime() + 100000000);

        tvCount = (TextView) findViewById(R.id.tvCount);
    }

    private void stopCountdown() {
        if (countdownHandler != null) {
            countdownHandler.removeCallbacks(updateCountdown);
            countdownHandler = null;
        }
    }

    private void startCountdown() {
        stopCountdown();

        countdownHandler = new Handler();
        updateCountdown.run();
    }

    private String formatDate(Date date) {
        StringBuilder countdownText = new StringBuilder();

        long timeRemaining = date.getTime() - new Date().getTime();

        if (timeRemaining > 0) {

            int days = (int) TimeUnit.MILLISECONDS.toDays(timeRemaining);
            timeRemaining -= TimeUnit.DAYS.toMillis(days);
            int hours = (int) TimeUnit.MILLISECONDS.toHours(timeRemaining);
            timeRemaining -= TimeUnit.HOURS.toMillis(hours);
            int minutes = (int) TimeUnit.MILLISECONDS.toMinutes(timeRemaining);
            timeRemaining -= TimeUnit.MINUTES.toMillis(minutes);
            int seconds = (int) TimeUnit.MILLISECONDS.toSeconds(timeRemaining);

            if (days > 0) {
                countdownText.append(getResources().getQuantityString(R.plurals.days, days, days));
                countdownText.append(" ");
            }
            if (days > 0 || hours > 0) {
                countdownText.append(getResources().getQuantityString(R.plurals.hours, hours, hours));
                countdownText.append(" ");
            }
            if (days > 0 || hours > 0 || minutes > 0) {
                countdownText.append(getResources().getQuantityString(R.plurals.minutes, minutes, minutes));
                countdownText.append(" ");
            }
            if (days > 0 || hours > 0 || minutes > 0 || seconds > 0) {
                countdownText.append(getResources().getQuantityString(R.plurals.seconds, seconds, seconds));
                countdownText.append(" ");
            }
        }

        return countdownText.toString();
    }

    @Override
    protected void onStart() {
        super.onStart();
        startCountdown();
    }

    @Override
    protected void onStop() {
        super.onStop();
        stopCountdown();
    }
}
