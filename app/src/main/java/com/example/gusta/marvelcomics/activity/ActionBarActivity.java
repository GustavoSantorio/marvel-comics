package com.example.gusta.marvelcomics.activity;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.gusta.marvelcomics.R;
import com.example.gusta.marvelcomics.fragment.BaseFragment;
import com.example.gusta.marvelcomics.fragment.ListFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gusta on 06/05/2017.
 */

public class ActionBarActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private static final long DRAWER_CLOSE_DELAY_MS = 350;

    private DrawerLayout mDrawerLayout;
    private Toolbar toolbar;
    private ActionBarDrawerToggle mDrawerToggle;
    private NavigationView navigationView;
    private final Handler mDrawerActionHandler = new Handler();

    private CharSequence mTitle;
    private List<BaseFragment> fragmentList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_action_bar);
        setToolbar();
        inflateComponents();
        setListeners();
        instantiateFragments();
        initDrawer();
    }

    private void setToolbar(){
        this.toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void inflateComponents(){
        this.mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        this.navigationView = (NavigationView) findViewById(R.id.navigation_view);
        this.mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
    }

    private void initDrawer(){
        this.mTitle = getResources().getString(R.string.app_name);
        setTitle(mTitle);
        navigate(fragmentList.get(0));
        navigationView.getMenu().getItem(0).setChecked(true);
    }
    private void setListeners(){
        this.navigationView.setNavigationItemSelectedListener(this);
        this.mDrawerLayout.setDrawerShadow(R.drawable.drawer_shadow, GravityCompat.START);
        this.mDrawerLayout.setDrawerListener(mDrawerToggle);
        this.mDrawerToggle.syncState();
    }

    private void instantiateFragments(){
        this.fragmentList = new ArrayList<>();
        this.fragmentList.add(new ListFragment());
    }

    @Override
    public void onBackPressed() {
        if (mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
            mDrawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    private void navigate(@NonNull Fragment fragment){
        FragmentManager frgManager = getFragmentManager();
        frgManager.beginTransaction().replace(R.id.content_frame, fragment).commit();
    }

    @Override
    public void setTitle(CharSequence title) {
        getSupportActionBar().setTitle(mTitle);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem menuItem) {
        Fragment fragment = null;
        switch (menuItem.getItemId()) {
            case R.id.home:
                fragment = fragmentList.get(0);
                this.mTitle = getResources().getString(R.string.app_name);
                break;
            default:
                break;
        }

        if(fragment != null) {
            menuItem.setChecked(true);
            navigate(fragment);
            setTitle(mTitle);
        }

        mDrawerActionHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                mDrawerLayout.closeDrawer(GravityCompat.START);
            }
        }, DRAWER_CLOSE_DELAY_MS);

        return true;
    }
}
