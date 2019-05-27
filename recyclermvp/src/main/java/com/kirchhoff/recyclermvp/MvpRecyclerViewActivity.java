package com.kirchhoff.recyclermvp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class MvpRecyclerViewActivity extends AppCompatActivity {

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.a_mvp_recycler_view);


		RecyclerView recyclerView = findViewById(R.id.recyclerView);
		recyclerView.setLayoutManager(new LinearLayoutManager(this));

		RepositoriesRecyclerAdapter adapter =
				new RepositoriesRecyclerAdapter(new RepositoriesListPresenter());
		recyclerView.setAdapter(adapter);
	}
}
