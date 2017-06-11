package com.example.kirchhoff.example;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.kirchhoff.example.ui.databinding.DataBindingActivity;
import com.example.kirchhoff.example.ui.drawer.simple.SimpleActivity;
import com.example.kirchhoff.example.ui.fab.FabAnimationActivity;
import com.example.kirchhoff.example.ui.recycler.diffutil.DiffUtilActivity;
import com.example.kirchhoff.example.ui.recycler.search.RecyclerSearchActivity;
import com.example.kirchhoff.example.ui.recycler.swipe.RecyclerCustomSwipeActivity;
import com.example.kirchhoff.example.ui.recycler.toolbar.RecyclerCollapsingToolbarActivity;
import com.example.kirchhoff.example.ui.tinder.TinderActivity;
import com.example.kirchhoff.example.ui.view.ViewActivity;
import com.example.kirchhoff.example.ui.viewpager.VPWithoutFragmentActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_main);

        findViewById(R.id.recyclerViewWithSearch).setOnClickListener(this);
        findViewById(R.id.dataBindingExample).setOnClickListener(this);
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
        else if (view.getId() == R.id.dataBindingExample)
            DataBindingActivity.startMe(this);
        else if (view.getId() == R.id.fabAnimationExample)
            FabAnimationActivity.startMe(this);
        else if (view.getId() == R.id.customRecyclerSwipe)
            RecyclerCustomSwipeActivity.startMe(this);
        else if (view.getId() == R.id.recyclerCollapsing)
            RecyclerCollapsingToolbarActivity.startMe(this);
        else if (view.getId() == R.id.vpWithoutFragment)
            VPWithoutFragmentActivity.startMe(this);
        else if (view.getId() == R.id.navigationDrawerDelegation)
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
}
