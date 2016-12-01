package com.goline.goline.view.activty;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TableLayout;

import com.goline.goline.R;
import com.goline.goline.view.adapter.PagerAdapterActivityMain;

public class MainActivity extends AppCompatActivity {

    private TabLayout mTabLayout;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        this.mTabLayout = (TabLayout) findViewById(R.id.tabLayoutActivityMain);
        this.mViewPager = (ViewPager) findViewById(R.id.viewPagerActivityMain);

        this.mViewPager.setAdapter(new PagerAdapterActivityMain(getSupportFragmentManager(), getResources().getStringArray(R.array.titles_tab)));

        this.mTabLayout.setupWithViewPager(this.mViewPager);

    }

}
