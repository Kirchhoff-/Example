package com.example.kirchhoff.example.ui.recycler.search.data;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import com.example.kirchhoff.example.R;

import java.util.ArrayList;

/**
 * @author Kirchhoff-
 */

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> implements Filterable {

    private ArrayList<AndroidVersion> list;
    private ArrayList<AndroidVersion> filteredList;

    public DataAdapter(ArrayList<AndroidVersion> initialList) {
        list = new ArrayList<>(initialList);
        filteredList = new ArrayList<>(initialList);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.r_card, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bind(filteredList.get(position));
    }

    @Override
    public int getItemCount() {
        return filteredList.size();
    }

    @Override
    public Filter getFilter() {

        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {

                String charString = charSequence.toString();

                if (charString.isEmpty()) {
                    filteredList = list;
                } else {
                    ArrayList<AndroidVersion> filList = new ArrayList<>();

                    for (AndroidVersion androidVersion : list) {
                        if (androidVersion.getApi().toLowerCase().contains(charString) ||
                                androidVersion.getName().toLowerCase().contains(charString) ||
                                androidVersion.getVer().toLowerCase().contains(charString)) {
                            filList.add(androidVersion);
                        }
                    }

                    filteredList = filList;
                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = filteredList;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                filteredList = (ArrayList<AndroidVersion>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private TextView name;
        private TextView version;
        private TextView apiLevel;

        public ViewHolder(View view) {
            super(view);

            name = (TextView) view.findViewById(R.id.name);
            version = (TextView) view.findViewById(R.id.version);
            apiLevel = (TextView) view.findViewById(R.id.apiLevel);
        }

        public void bind(AndroidVersion item) {
            name.setText(item.getName());
            version.setText(item.getVer());
            apiLevel.setText(item.getApi());
        }
    }
}
