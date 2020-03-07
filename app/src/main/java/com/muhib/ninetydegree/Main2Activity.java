package com.muhib.ninetydegree;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;
import com.muhib.ninetydegree.fragment.AboutUsFragment;
import com.muhib.ninetydegree.fragment.ContactUsFragment;
import com.muhib.ninetydegree.fragment.DashboardFragment;
import com.muhib.ninetydegree.fragment.PrivacyPolicyFragment;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.widget.ImageView;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {

    private AppBarConfiguration mAppBarConfiguration;
    DrawerLayout drawer;
    NavigationView navigationView;
    public TextView tvHomeToolbarText;
    public ImageView ivHomeMenuBarId1;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawer = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);


        ivHomeMenuBarId1 = toolbar.findViewById(R.id.ivHomeMenuBarId1);
        tvHomeToolbarText = toolbar.findViewById(R.id.tvHomeToolbarText);
        ivHomeMenuBarId1.setOnClickListener(this);

        navigationView.setItemIconTintList(null);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
//        mAppBarConfiguration = new AppBarConfiguration.Builder(
//                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow,
//                R.id.nav_tools, R.id.nav_share, R.id.nav_send)
//                .setDrawerLayout(drawer)
//                .build();
//        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
//        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
//        NavigationUI.setupWithNavController(navigationView, navController);


        DashboardFragment dashboardFragment = new DashboardFragment();
        gotoHomeFragment(dashboardFragment, "DashboardFragment");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main2, menu);
        return true;
    }

//    @Override
//    public boolean onSupportNavigateUp() {
//        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
//        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
//                || super.onSupportNavigateUp();
//    }

    private void gotoHomeFragment(Fragment fragment, String tag) {
        // load com.muhib.ninetydegree.fragment
        // com.muhib.ninetydegree.fragment.setArguments(bundle);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container, fragment, tag);
        // transaction.addToBackStack(null);
        transaction.commit();
    }

    private void gotoFragment(Fragment fragment, String tag) {
        // load com.muhib.ninetydegree.fragment
        // com.muhib.ninetydegree.fragment.setArguments(bundle);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container, fragment, tag);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    Fragment fragment;

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.aboutUs:
                backClear();
                fragment = new AboutUsFragment();
                gotoFragment(fragment, "AboutUsFragment");
                drawer.closeDrawer(GravityCompat.START);
                break;
            case R.id.contactUs:
                backClear();
                fragment = new ContactUsFragment();
                gotoFragment(fragment, "ContactUsFragment");
                drawer.closeDrawer(GravityCompat.START);
                break;
            case R.id.privacyPolicy:
                backClear();
                fragment = new PrivacyPolicyFragment();
                gotoFragment(fragment, "PrivacyPolicyFragment");
                drawer.closeDrawer(GravityCompat.START);
                break;
        }
        return false;
    }

    private void backClear() {
        int backStack = getSupportFragmentManager().getBackStackEntryCount();

        while (backStack > 0) {
            getSupportFragmentManager().popBackStack();
            backStack--;
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ivHomeMenuBarId1:

                DashboardFragment dashboardFragment = (DashboardFragment) getSupportFragmentManager().findFragmentByTag("DashboardFragment");
                if (dashboardFragment != null && !dashboardFragment.isVisible()) {
                    getSupportFragmentManager().popBackStack();
                    //Toast.makeText(getApplicationContext(), "ff", Toast.LENGTH_SHORT).show();
                } else {

                    drawer.openDrawer(GravityCompat.START);
                }
                break;
        }
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {

            super.onBackPressed();
        }
    }
}
