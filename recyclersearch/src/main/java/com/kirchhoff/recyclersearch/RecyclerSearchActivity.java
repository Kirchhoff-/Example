package com.kirchhoff.recyclersearch;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

import com.kirchhoff.recyclersearch.data.AndroidVersion;
import com.kirchhoff.recyclersearch.data.DataAdapter;

public class RecyclerSearchActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<AndroidVersion> arrayList;
    private DataAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_recycler_search);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        initData();
        initViews();
    }

    private void initViews() {
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new DataAdapter(arrayList);
        recyclerView.setAdapter(adapter);
    }

    private void initData() {

        arrayList = new ArrayList<>();

        AndroidVersion v1 = new AndroidVersion("1.5", "Cupcake", "API level 3");
        AndroidVersion v2 = new AndroidVersion("1.6", "Donut", "API level 4");
        AndroidVersion v3 = new AndroidVersion("2.0-2.1", "Eclair", "API level 5 - 7");
        AndroidVersion v4 = new AndroidVersion("2.2", "Froyo", "API level 8");
        AndroidVersion v5 = new AndroidVersion("2.3", "Gingerbread", "API level 9-10");
        AndroidVersion v6 = new AndroidVersion("3.0-3.2", "Honeycomb", "API level 11-13");
        AndroidVersion v7 = new AndroidVersion("4.0", "Ice Cream Sandwich", "API level 14-15");
        AndroidVersion v8 = new AndroidVersion("4.1-4.3", "JellyBean", "API level 16-18");
        AndroidVersion v9 = new AndroidVersion("4.4", "KitKat", "API level 19");
        AndroidVersion v10 = new AndroidVersion("5.0-5.1", "Lollipop", "API level 21-22");
        AndroidVersion v11 = new AndroidVersion("6.0", "Marshmallow", "API level 23");
        AndroidVersion v12 = new AndroidVersion("7.0-7.1", "Nougat", "API level 24-25");

        arrayList.add(v1);
        arrayList.add(v2);
        arrayList.add(v3);
        arrayList.add(v4);
        arrayList.add(v5);
        arrayList.add(v6);
        arrayList.add(v7);
        arrayList.add(v8);
        arrayList.add(v9);
        arrayList.add(v10);
        arrayList.add(v11);
        arrayList.add(v12);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.recycler_search, menu);

        MenuItem search = menu.findItem(R.id.search);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(search);
        search(searchView);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    private void search(SearchView searchView) {
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if (adapter != null) {
                    adapter.getFilter().filter(newText);
                }
                return true;
            }
        });
    }
}
