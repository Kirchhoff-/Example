package com.example.kirchhoff.example.ui.tinder;

import android.content.Context;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.kirchhoff.example.R;
import com.mindorks.placeholderview.SwipePlaceHolderView;
import com.mindorks.placeholderview.annotations.Layout;
import com.mindorks.placeholderview.annotations.Resolve;
import com.mindorks.placeholderview.annotations.View;
import com.mindorks.placeholderview.annotations.swipe.SwipeCancelState;
import com.mindorks.placeholderview.annotations.swipe.SwipeIn;
import com.mindorks.placeholderview.annotations.swipe.SwipeInState;
import com.mindorks.placeholderview.annotations.swipe.SwipeOut;
import com.mindorks.placeholderview.annotations.swipe.SwipeOutState;

/**
 * @author Kirchhoff-
 */

@Layout(R.layout.r_tinder_card)
public class TinderCard {

    private final static String TAG = "TinderCard";

    @View(R.id.profileImageView)
    private ImageView profileImageView;

    @View(R.id.nameAgeTxt)
    private TextView nameAgeTxt;

    @View(R.id.locationNameTxt)
    private TextView locationNameTxt;

    private Profile profile;
    private Context context;
    private SwipePlaceHolderView swipeView;

    public TinderCard(Context context, Profile profile, SwipePlaceHolderView swipeView) {
        this.context = context;
        this.profile = profile;
        this.swipeView = swipeView;
    }

    @Resolve
    private void onResolved() {
        Glide.with(context).load(profile.getImageUrl()).into(profileImageView);
        nameAgeTxt.setText(profile.getName() + ", " + profile.getAge());
        locationNameTxt.setText(profile.getLocation());
    }

    @SwipeOut
    private void onSwipedOut() {
        Log.d(TAG, "onSwipedOut");
        swipeView.addView(this);
    }

    @SwipeCancelState
    private void onSwipeCancelState() {
        Log.d(TAG, "onSwipeCancelState");
    }

    @SwipeIn
    private void onSwipeIn() {
        Log.d(TAG, "onSwipedIn");
    }

    @SwipeInState
    private void onSwipeInState() {
        Log.d(TAG, "onSwipeInState");
    }

    @SwipeOutState
    private void onSwipeOutState() {
        Log.d(TAG, "onSwipeOutState");
    }
}