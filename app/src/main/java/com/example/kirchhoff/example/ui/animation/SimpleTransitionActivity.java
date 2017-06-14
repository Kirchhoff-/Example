package com.example.kirchhoff.example.ui.animation;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.kirchhoff.example.R;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Kirchhoff-
 */

public class SimpleTransitionActivity extends AppCompatActivity {

    private List<String[]> values;

    public static void start(Context context) {
        context.startActivity(new Intent(context, SimpleTransitionActivity.class));
    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_simple_transition);

        values = new ArrayList<>();
        values.add(new String[]{"Android", "Java",
                getString(R.string.android), '#' + Integer.toHexString(ContextCompat.getColor(this,
                R.color.green_900))});
        values.add(new String[]{"iOS", "Swift", getString(R.string.ios), '#' +
                Integer.toHexString(ContextCompat.getColor(this, R.color.yellow_700))});
        values.add(new String[]{"Xamarin", "C#", getString(R.string.xamarin), '#' +
                Integer.toHexString(ContextCompat.getColor(this, R.color.pink_700))});
        values.add(new String[]{"PhoneGap", "HTML CSS and JScript", getString(R.string.phonegap), '#' +
                Integer.toHexString(ContextCompat.getColor(this, R.color.brown_800))});


        ListView list = (ListView) findViewById(R.id.list);
        CustomAdapter adapter = new CustomAdapter(this, values);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Intent intent = new Intent(SimpleTransitionActivity.this,
                        SimpleTransitionDetailsActivity.class);
                intent.putExtra("parameter", values.get(position));
                // Get the transition name from the string
                String transitionName = getString(R.string.transition);

                ActivityOptionsCompat options =

                        ActivityOptionsCompat.makeSceneTransitionAnimation(SimpleTransitionActivity.this,
                                view,   // Starting view
                                transitionName    // The String
                        );

                ActivityCompat.startActivity(SimpleTransitionActivity.this, intent, options.toBundle());
            }
        });
    }
}
