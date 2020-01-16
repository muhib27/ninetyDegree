package com.muhib.ninetydegree;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.muhib.ninetydegree.fragment.DashboardFragment;
import com.muhib.ninetydegree.fragment.HomeFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Toolbar toolbar = findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

//        toolbar.setLogo(R.drawable.toolbar_icon);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.left_arrow);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        DashboardFragment dashboardFragment = new DashboardFragment();
        gotoFragment(dashboardFragment, "dashboardFragment");
    }
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    private void gotoFragment(Fragment fragment, String tag) {
        // load com.muhib.ninetydegree.fragment
       // com.muhib.ninetydegree.fragment.setArguments(bundle);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container, fragment, tag);
        // transaction.addToBackStack(null);
        transaction.commit();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
