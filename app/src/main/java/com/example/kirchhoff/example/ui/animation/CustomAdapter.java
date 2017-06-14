package com.example.kirchhoff.example.ui.animation;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.kirchhoff.example.R;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Kirchhoff-
 */

public class CustomAdapter extends BaseAdapter {

    private ArrayList<String[]> arrayList;
    private Context context;

    public CustomAdapter(Context context, List<String[]> list) {
        this.context = context;
        arrayList = new ArrayList<>(list);
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row;
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) {
            row = inflater.inflate(R.layout.r_simple_transition, parent,
                    false);
        } else {
            row = convertView;
        }
        String[] detail = arrayList.get(position);


        LinearLayout layout = (LinearLayout) row.findViewById(R.id.layout);
        layout.setBackgroundColor(Color.parseColor(detail[3]));
        TextView tvName = (TextView) row.findViewById(R.id.tvName);
        tvName.setText(detail[0]);
        TextView tvEmail = (TextView) row.findViewById(R.id.tvEmail);
        tvEmail.setText(detail[1]);

        return row;
    }

}
