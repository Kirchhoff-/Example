package com.example.kirchhoff.example;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.kirchhoff.example.ui.recycler.diffutil.ex1.DiffUtilActivity;
import com.example.kirchhoff.example.ui.recycler.diffutil.ex2.ThingDiffUtilActivity;
import com.example.kirchhoff.example.ui.recycler.swipe.RecyclerCustomSwipeActivity;
import com.example.likebutton.LikeButtonActivity;
import com.example.recyclercollapsing.RecyclerCollapsingToolbarActivity;
import com.kirchhoff.coordinatebehavior.CoordinatorBehaviorActivity;
import com.kirchhoff.countdownlabel.CountdownLabelActivity;
import com.kirchhoff.curvedbottombar.CurvedBottomBarActivity;
import com.kirchhoff.fabanimation.FabAnimationActivity;
import com.kirchhoff.fastrecyclerview.FastRecyclerViewActivity;
import com.kirchhoff.recyclermvp.MvpRecyclerViewActivity;
import com.kirchhoff.recyclersearch.RecyclerSearchActivity;
import com.kirchhoff.simpletransition.SimpleTransitionActivity;
import com.kirchhoff.viewpagerwithoutfragment.VPWithoutFragmentActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_main);

        findViewById(R.id.recyclerViewWithSearch).setOnClickListener(this);
        findViewById(R.id.fabAnimationExample).setOnClickListener(this);
        findViewById(R.id.customRecyclerSwipe).setOnClickListener(this);
        findViewById(R.id.recyclerCollapsing).setOnClickListener(this);
        findViewById(R.id.vpWithoutFragment).setOnClickListener(this);
        findViewById(R.id.diffUtil).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.recyclerViewWithSearch) {
            Intent intent = new Intent(this, RecyclerSearchActivity.class);
            startActivity(intent);
        } else if (view.getId() == R.id.fabAnimationExample) {
            Intent intent = new Intent(this, FabAnimationActivity.class);
            startActivity(intent);
        } else if (view.getId() == R.id.customRecyclerSwipe)
            RecyclerCustomSwipeActivity.startMe(this);
        else if (view.getId() == R.id.recyclerCollapsing) {
            Intent intent = new Intent(this, RecyclerCollapsingToolbarActivity.class);
            startActivity(intent);
        } else if (view.getId() == R.id.vpWithoutFragment) {
            Intent intent = new Intent(this, VPWithoutFragmentActivity.class);
            startActivity(intent);
        } else if (view.getId() == R.id.diffUtil) {
            Intent difIntent = new Intent(this, DiffUtilActivity.class);
            this.startActivity(difIntent);
        }
    }

    public void onLikeButtonClick(View view) {
        Intent intent = new Intent(this, LikeButtonActivity.class);
        this.startActivity(intent);
    }

    public void onCountDownLabel(View view) {
        Intent intent = new Intent(this, CountdownLabelActivity.class);
        this.startActivity(intent);
    }

    public void simpleTransition(View view) {
        Intent intent = new Intent(this, SimpleTransitionActivity.class);
        startActivity(intent);
    }

    public void customCoordinateLayoutBehavior(View view) {
        Intent intent = new Intent(this, CoordinatorBehaviorActivity.class);
        startActivity(intent);
    }

    public void mvpRecycler(View view) {
        Intent intent = new Intent(this, MvpRecyclerViewActivity.class);
        startActivity(intent);
    }

    public void diffUtilExample2(View view) {
        Intent intent = new Intent(this, ThingDiffUtilActivity.class);
        startActivity(intent);
    }

    public void fastRecyclerViewExample(View view) {
        Intent intent = new Intent(this, FastRecyclerViewActivity.class);
        startActivity(intent);
    }

    public void curvedBottomBarExample(View view) {
        Intent intent = new Intent(this, CurvedBottomBarActivity.class);
        startActivity(intent);
    }
}
