package com.example.kirchhoff.example.ui.tinder;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.kirchhoff.example.R;
import com.example.kirchhoff.example.ui.utils.TinderUtils;
import com.mindorks.placeholderview.SwipeDecor;
import com.mindorks.placeholderview.SwipePlaceHolderView;


/**
 * @author Kirchhoff-
 */

public class TinderActivity extends AppCompatActivity {

    private SwipePlaceHolderView swipeView;

    public static void startMe(Context context) {
        Intent intent = new Intent(context, TinderActivity.class);
        context.startActivity(intent);
    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_tinder);

        swipeView = (SwipePlaceHolderView) findViewById(R.id.swipeView);

        swipeView.getBuilder()
                .setDisplayViewCount(3)
                .setSwipeDecor(new SwipeDecor()
                        .setPaddingTop(20)
                        .setRelativeScale(0.01f)
                        .setSwipeInMsgLayoutId(R.layout.v_tinder_swipe_in)
                        .setSwipeOutMsgLayoutId(R.layout.v_tinder_swipe_out));

        for (Profile profile : TinderUtils.loadProfiles(this)) {
            swipeView.addView(new TinderCard(this, profile, swipeView));
        }

        findViewById(R.id.rejectBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                swipeView.doSwipe(false);
            }
        });

        findViewById(R.id.acceptBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                swipeView.doSwipe(true);
            }
        });
    }
}
