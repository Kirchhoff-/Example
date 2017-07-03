package com.example.kirchhoff.example.ui.recycler.diffutil.ex2;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.kirchhoff.example.R;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Kirchhoff-
 */

public class ThingAdapter extends RecyclerView.Adapter<ThingViewHolder> {

    private List<Thing> things = new ArrayList<>();

    @Override
    public ThingViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.r_thing, parent, false);
        return new ThingViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ThingViewHolder holder, int position) {
        Thing thing = things.get(position);
        holder.bind(thing);
    }

    @Override
    public int getItemCount() {
        return things.size();
    }

    public void setThings(List<Thing> things) {
        this.things = things;
    }
}
