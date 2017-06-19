package com.example.kirchhoff.example.ui.recycler.multi;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.kirchhoff.example.R;

import java.util.List;

import static com.example.kirchhoff.example.ui.recycler.multi.CityEvent.CITY_TYPE;
import static com.example.kirchhoff.example.ui.recycler.multi.CityEvent.EVENT_TYPE;

/**
 * @author Kirchhoff-
 */

public class MultiRowAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<CityEvent> mList;

    public MultiRowAdapter(List<CityEvent> list) {
        this.mList = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        switch (viewType) {
            case CITY_TYPE:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.r_multi_city, parent, false);
                return new CityViewHolder(view);
            case EVENT_TYPE:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.r_multi_event, parent, false);
                return new EventViewHolder(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        CityEvent object = mList.get(position);
        if (object != null) {
            switch (object.getType()) {
                case CITY_TYPE:
                    ((CityViewHolder) holder).tvTitle.setText(object.getName());
                    break;
                case EVENT_TYPE:
                    ((EventViewHolder) holder).tvTitle.setText(object.getName());
                    ((EventViewHolder) holder).tvDescription.setText(object.getDescription());
                    break;
            }
        }
    }

    @Override
    public int getItemCount() {
        if (mList == null)
            return 0;
        return mList.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (mList != null) {
            CityEvent object = mList.get(position);
            if (object != null) {
                return object.getType();
            }
        }
        return 0;
    }


    public static class CityViewHolder extends RecyclerView.ViewHolder {
        private TextView tvTitle;

        public CityViewHolder(View itemView) {
            super(itemView);
            tvTitle = (TextView) itemView.findViewById(R.id.tvTitle);
        }
    }

    public static class EventViewHolder extends RecyclerView.ViewHolder {
        private TextView tvTitle;
        private TextView tvDescription;

        public EventViewHolder(View itemView) {
            super(itemView);
            tvTitle = (TextView) itemView.findViewById(R.id.tvTitle);
            tvDescription = (TextView) itemView.findViewById(R.id.tvDescription);
        }
    }
}
