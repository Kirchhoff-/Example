package com.example.kirchhoff.example.ui.recycler.diffutil.ex2;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.kirchhoff.example.R;

/**
 * @author Kirchhoff-
 */

public class ThingViewHolder extends RecyclerView.ViewHolder {

    private final TextView textView;

    public ThingViewHolder(View itemView) {
        super(itemView);
        textView = (TextView) itemView.findViewById(R.id.text);
    }

    public void bind(Thing thing) {
        itemView.setBackgroundColor(thing.getColor());
        textView.setText(thing.getText());
    }
}
