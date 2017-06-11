package com.example.kirchhoff.example.ui.utils;

import android.content.Context;
import android.view.View;
import android.view.animation.AnimationUtils;

import com.example.kirchhoff.example.R;

/**
 * @author Kirchhoff-
 */

//TODO In kotlin may move this to Extensions file
public class SlideAnimationUtils {

    public static void slideInFromLeft(Context context, View view) {
        runSimpleAnimation(context, view, R.anim.slide_from_left);
    }


    public static void slideOutToLeft(Context context, View view) {
        runSimpleAnimation(context, view, R.anim.slide_to_left);
    }

    public static void slideInFromRight(Context context, View view) {
        runSimpleAnimation(context, view, R.anim.slide_from_right);
    }

    public static void slideOutToRight(Context context, View view) {
        runSimpleAnimation(context, view, R.anim.slide_to_right);
    }

    private static void runSimpleAnimation(Context context, View view, int animationId) {
        view.startAnimation(AnimationUtils.loadAnimation(
                context, animationId
        ));
    }
}
