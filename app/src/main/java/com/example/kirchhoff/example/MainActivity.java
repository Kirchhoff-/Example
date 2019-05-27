package com.example.kirchhoff.example;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.kirchhoff.example.ui.animation.SimpleTransitionActivity;
import com.example.kirchhoff.example.ui.drawer.simple.SimpleActivity;
import com.example.kirchhoff.example.ui.other.CoordinatorBehaviorActivity;
import com.example.kirchhoff.example.ui.other.CountdownLabelActivity;
import com.example.kirchhoff.example.ui.other.CustomActionBarActivity;
import com.example.kirchhoff.example.ui.recycler.diffutil.ex1.DiffUtilActivity;
import com.example.kirchhoff.example.ui.recycler.diffutil.ex2.ThingDiffUtilActivity;
import com.example.kirchhoff.example.ui.recycler.multi.MultiRowRecyclerActivity;
import com.example.kirchhoff.example.ui.recycler.search.RecyclerSearchActivity;
import com.example.kirchhoff.example.ui.recycler.swipe.RecyclerCustomSwipeActivity;
import com.example.kirchhoff.example.ui.recycler.testable.TestableRecyclerViewActivity;
import com.example.kirchhoff.example.ui.recycler.toolbar.RecyclerCollapsingToolbarActivity;
import com.example.kirchhoff.example.ui.tinder.TinderActivity;
import com.example.kirchhoff.example.ui.view.ViewActivity;
import com.kirchhoff.curvedbottombar.CurvedBottomBarActivity;
import com.kirchhoff.fabanimation.FabAnimationActivity;
import com.kirchhoff.fastrecyclerview.FastRecyclerViewActivity;
import com.kirchhoff.keyboardwatcher.KeyboardWatcherActivity;
import com.kirchhoff.recyclermvp.MvpRecyclerViewActivity;
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
        findViewById(R.id.navigationDrawerDelegation).setOnClickListener(this);
        findViewById(R.id.diffUtil).setOnClickListener(this);
        findViewById(R.id.tinderExample).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.recyclerViewWithSearch)
            RecyclerSearchActivity.startMe(this);
        else if (view.getId() == R.id.fabAnimationExample) {
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
        } else if (view.getId() == R.id.navigationDrawerDelegation)
            SimpleActivity.startMe(this);
        else if (view.getId() == R.id.diffUtil) {
            Intent difIntent = new Intent(this, DiffUtilActivity.class);
            this.startActivity(difIntent);
        } else if (view.getId() == R.id.tinderExample) {
            TinderActivity.startMe(this);
        }
    }

    public void onViewClick(View view) {
        ViewActivity.start(this);
    }

    public void onCountDownLabel(View view) {
        Intent intent = new Intent(this, CountdownLabelActivity.class);
        this.startActivity(intent);
    }

    public void customActionBar(View view) {
        Intent difIntent = new Intent(this, CustomActionBarActivity.class);
        this.startActivity(difIntent);
    }

    public void simpleTransition(View view) {
        SimpleTransitionActivity.start(this);
    }

    public void customCoordinateLayoutBehavior(View view) {
        CoordinatorBehaviorActivity.start(this);
    }

    public void multiRowRecycler(View view) {
        MultiRowRecyclerActivity.start(this);
    }

    public void mvpRecycler(View view) {
        Intent intent = new Intent(this, MvpRecyclerViewActivity.class);
        startActivity(intent);
    }

    public void diffUtilExample2(View view) {
        ThingDiffUtilActivity.start(this);
    }

    public void keyboardWatcherExample(View view) {
        Intent intent = new Intent(this, KeyboardWatcherActivity.class);
        startActivity(intent);
    }

    public void fastRecyclerViewExample(View view) {
        Intent intent = new Intent(this, FastRecyclerViewActivity.class);
        startActivity(intent);
    }

    public void testableRecyclerViewExample(View view) {
		Intent intent = new Intent(this, TestableRecyclerViewActivity.class);
		startActivity(intent);
    }

    public void curvedBottomBarExample(View view) {
        Intent intent = new Intent(this, CurvedBottomBarActivity.class);
        startActivity(intent);
    }
}
