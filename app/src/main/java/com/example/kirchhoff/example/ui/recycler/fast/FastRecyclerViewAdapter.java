package com.example.kirchhoff.example.ui.recycler.fast;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.kirchhoff.example.R;

import java.util.List;

/**
 * @author Kirchhoff-
 */

public class FastRecyclerViewAdapter extends RecyclerView.Adapter<StateViewHolder> {

    private List<State> data;

    public FastRecyclerViewAdapter(List<State> data) {
        this.data = data;
    }

    @Override
    public StateViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View personCell = inflater.inflate(R.layout.r_fast_recycler, parent, false);
        return new StateViewHolder(personCell);
    }

    @Override
    public void onBindViewHolder(StateViewHolder holder, int position) {
        holder.name.setText(data.get(position).getName());
        holder.location.setText(data.get(position).getLocation());
    }

    @Override
    public int getItemCount() {
        return data != null ? data.size() : 0;
    }
}