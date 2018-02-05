package com.example.kirchhoff.example.ui.recycler.testable;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.kirchhoff.example.R;

/**
 * @author Kirchhoff-
 */

public class TestableRecyclerViewActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    public static void start(Context context) {
        Intent intent = new Intent(context, TestableRecyclerViewActivity.class);
        context.startActivity(intent);
    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_testable_recycler_view);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        //Start
       /* recyclerView.setAdapter(new RecyclerView.Adapter() {
            @Override
            public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                return new RecyclerView.ViewHolder(new TextView(parent.getContext())) {
                };
            }

            @Override
            public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
                ((TextView) holder.itemView).setText(String.valueOf(position));
            }

            @Override
            public int getItemCount() {
                return 100;
            }
        }); */

        recyclerView.setAdapter(new MyAdapter());
    }

    private static class MyAdapter extends RecyclerView.Adapter<SimpleListItemViewHolder> {

        @Override
        public SimpleListItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            final TextView itemView = new TextView(parent.getContext());
            itemView.setTag(new Presenter());
            return new SimpleListItemViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(SimpleListItemViewHolder holder, int position) {
            ((Presenter) holder.itemView.getTag()).presenterListItem(holder, position);
        }

        @Override
        public int getItemCount() {
            return 100;
        }
    }


    private static class SimpleListItemViewHolder extends RecyclerView.ViewHolder implements SimpleListItemView {

        SimpleListItemViewHolder(View itemView) {
            super(itemView);
        }

        @Override
        public void setText(String text) {
            ((TextView) itemView).setText(text);
        }
    }

    private static class Presenter {
        void presenterListItem(SimpleListItemView view, int position) {
            view.setText(String.valueOf(position));
        }
    }
}
