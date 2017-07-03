package com.example.kirchhoff.example.ui.recycler.diffutil.ex2;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.util.Pair;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;

import com.example.kirchhoff.example.R;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;

import static io.reactivex.android.schedulers.AndroidSchedulers.mainThread;
import static io.reactivex.schedulers.Schedulers.computation;

/**
 * @author Kirchhoff-
 */

public class ThingDiffUtilActivity extends AppCompatActivity {

    private ThingAdapter adapter;
    private Disposable disposable;

    public static void start(Context context) {
        context.startActivity(new Intent(context, ThingDiffUtilActivity.class));
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_thing_diff_util);
    }


    @Override
    protected void onStart() {
        super.onStart();

        adapter = new ThingAdapter();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.listOfThings);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);

        List<Thing> emptyList = new ArrayList<>();
        adapter.setThings(emptyList);
        final Pair<List<Thing>, DiffUtil.DiffResult> initialPair = Pair.create(emptyList, null);

        disposable = ThingRepository.simulateThings(2, TimeUnit.SECONDS)
                .scan(initialPair, new BiFunction<Pair<List<Thing>, DiffUtil.DiffResult>, List<Thing>,
                        Pair<List<Thing>, DiffUtil.DiffResult>>() {
                    @Override
                    public Pair<List<Thing>, DiffUtil.DiffResult> apply(@NonNull Pair<List<Thing>,
                            DiffUtil.DiffResult> pair, @NonNull List<Thing> next) throws Exception {
                        DiffUtilCallback callback = new DiffUtilCallback(pair.first, next);
                        DiffUtil.DiffResult result = DiffUtil.calculateDiff(callback);
                        return Pair.create(next, result);
                    }
                })
                .skip(1)
                .subscribeOn(computation())
                .observeOn(mainThread())
                .subscribe(new Consumer<Pair<List<Thing>, DiffUtil.DiffResult>>() {
                    @Override
                    public void accept(@NonNull Pair<List<Thing>, DiffUtil.DiffResult>
                                               listDiffResultPair) throws Exception {
                        adapter.setThings(listDiffResultPair.first);
                        listDiffResultPair.second.dispatchUpdatesTo(adapter);
                    }
                });
    }

    @Override
    protected void onStop() {
        super.onStop();
        disposable.dispose();
    }
}
