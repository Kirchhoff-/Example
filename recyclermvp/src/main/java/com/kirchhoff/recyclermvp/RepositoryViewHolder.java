package com.kirchhoff.recyclermvp;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;


/**
 * @author Kirchhoff-
 */

public class RepositoryViewHolder extends RecyclerView.ViewHolder implements RepositoryRowView {

    TextView titleTextView;
    TextView startCountTextView;


    public RepositoryViewHolder(View itemView) {
        super(itemView);
        titleTextView = itemView.findViewById(R.id.repoTitleText);
        startCountTextView = itemView.findViewById(R.id.repoStartCountText);
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
