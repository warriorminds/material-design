package com.warriorminds.materialdesign;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private final long DRAWER_CLOSE_DELAY_MS = 300;
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;
    private NavigationView mNavigationView;
    private final Handler mDrawerActionHandler = new Handler();
    private FloatingActionButton mFab;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* Setup your toolbar */
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mNavigationView = (NavigationView) findViewById(R.id.nav_view);
        /* Setup your drawer toggle*/
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, toolbar, R.string.open, R.string.close);
        /* Add your toggle to be the drawer layout listener. */
        mDrawerLayout.setDrawerListener(mDrawerToggle);
        /* Set your NavigationItemSelectedListener to handle clicks to the menu. */
        mNavigationView.setNavigationItemSelectedListener(this);
        /* Don't forget the toggle syncState! */
        mDrawerToggle.syncState();

        /* Setup FAB */
        setupFab();

        /* Setup Recycler View */
        setupRecyclerView();
    }

    private void setupRecyclerView() {
        /* Get reference */
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        /* Set layout manager. */
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        /* Set your adapter. */
        recyclerView.setAdapter(new InfoAdapter(generateList()));
    }

    private ArrayList<Info> generateList(){
        ArrayList<Info> list = new ArrayList<>();
        for(int i = 0; i < 20; i ++){
            Info info = new Info();
            info.setName("This is the name #" + i);
            info.setDetails("Details for name #" + i);
            list.add(info);
        }
        return list;
    }
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onNavigationItemSelected(final MenuItem menuItem) {

        /* Close drawer and use a Handler to make something when the user clicks an item.
        *  Typically it will be open a new activity or change the fragment that is showing.
        * */
        mDrawerLayout.closeDrawers();
        mDrawerLayout.closeDrawer(GravityCompat.START);
        mDrawerActionHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if(menuItem.getItemId() == R.id.nav_cards){
                    startActivity(new Intent(MainActivity.this, CardsActivity.class));
                }
            }
        }, DRAWER_CLOSE_DELAY_MS);
        return false;
    }

    /* Setup floating action button */
    public void setupFab() {
        mFab = (FloatingActionButton) findViewById(R.id.fab);
        mFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }

        });
    }
}
