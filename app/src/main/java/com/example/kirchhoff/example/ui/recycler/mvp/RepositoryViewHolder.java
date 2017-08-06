package com.example.kirchhoff.example.ui.recycler.mvp;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.kirchhoff.example.R;

/**
 * @author Kirchhoff-
 */

public class RepositoryViewHolder extends RecyclerView.ViewHolder implements RepositoryRowView {

    TextView titleTextView;
    TextView startCountTextView;


    public RepositoryViewHolder(View itemView) {
        super(itemView);
        titleTextView = (TextView) itemView.findViewById(R.id.repoTitleText);
        startCountTextView = (TextView) itemView.findViewById(R.id.repoStartCountText);
    }


    @Override
    public void setTitle(String title) {
        titleTextView.setText(title);
    }

    @Override
    public void setStarCount(int starCount) {
        startCountTextView.setText(String.format("%s start", starCount));
    }
}
