package com.example.kirchhoff.example.ui.drawer.delegation;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.example.kirchhoff.example.R;
import com.example.kirchhoff.example.ui.drawer.BaseActivityDelegate;

import butterknife.BindView;

/**
 * @author Kirchhoff-
 */

public class NavigationDrawerDelegate extends BaseActivityDelegate<
        NavigationDrawerContract.NavigationDrawerView,
        NavigationDrawerPresenter> implements NavigationView.OnNavigationItemSelectedListener {

    @BindView(R.id.drawer_layout)
    protected DrawerLayout drawerLayout;
    @BindView(R.id.toolbar)
    protected Toolbar toolbar;
    @BindView(R.id.nav_view)
    protected NavigationView navigationView;


    @Override
    public void onCreate(NavigationDrawerPresenter presenter) {
        super.onCreate(presenter);
        configureDrawer();
    }

    private void configureDrawer() {
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                presenter.getView().getActivity(),
                drawerLayout,
                toolbar,
                R.string.drawer_open,
                R.string.drawer_close);
        presenter.getView().getActivity().getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_camera:
                presenter.getView().openCamera();
                break;
            case R.id.nav_gallery:

                break;
            case R.id.nav_slideshow:

                break;
            case R.id.nav_manage:

                break;
            case R.id.nav_share:

                break;
            case R.id.nav_send:
                presenter.onAction();
                break;
        }
        closeDrawer();
        return true;
    }

    public boolean closeDrawer() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
            return true;
        } else {
            return false;
        }
    }
}
