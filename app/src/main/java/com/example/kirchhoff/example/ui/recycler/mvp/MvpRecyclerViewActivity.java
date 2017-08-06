package com.example.kirchhoff.example.ui.recycler.mvp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.kirchhoff.example.R;

/**
 * @author Kirchhoff-
 */

public class MvpRecyclerViewActivity extends AppCompatActivity {


    public static void startMe(Context context) {
        Intent intent = new Intent(context, MvpRecyclerViewActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_mvp_recycler_view);


        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        RepositoriesRecyclerAdapter adapter =
                new RepositoriesRecyclerAdapter(new RepositoriesListPresenter());
        recyclerView.setAdapter(adapter);
    }
}
