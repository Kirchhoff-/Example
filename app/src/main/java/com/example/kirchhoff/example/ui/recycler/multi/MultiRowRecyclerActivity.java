package com.example.kirchhoff.example.ui.recycler.multi;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.kirchhoff.example.R;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Kirchhoff-
 */

public class MultiRowRecyclerActivity extends AppCompatActivity {

    public static void start(Context context) {
        context.startActivity(new Intent(context, MultiRowRecyclerActivity.class));
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_multi_row_recycler);

        MultiRowAdapter adapter = new MultiRowAdapter(getData());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.setAdapter(adapter);
    }


    private List<CityEvent> getData() {
        List<CityEvent> list = new ArrayList<>();
        list.add(new CityEvent("London", null, CityEvent.CITY_TYPE));
        list.add(new CityEvent("Droidcon", "Droidcon in London", CityEvent.EVENT_TYPE));
        list.add(new CityEvent("Some event", "Some event in London", CityEvent.EVENT_TYPE));
        list.add(new CityEvent("Amsterdam", null, CityEvent.CITY_TYPE));
        list.add(new CityEvent("Droidcon", "Droidcon in Amsterdam", CityEvent.EVENT_TYPE));
        list.add(new CityEvent("Berlin", null, CityEvent.CITY_TYPE));
        list.add(new CityEvent("Droidcon", "Droidcon in Berlin", CityEvent.EVENT_TYPE));
        return list;
    }
}
