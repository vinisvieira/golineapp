package com.goline.goline.view.activty;

import android.content.Intent;
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
import android.widget.Toast;

import com.goline.goline.LoginActivity;
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

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        // Os Id's que estou verificando no Switch-case foram definidos por mim para cada item do menu_action_bar2.xml
        int id = item.getItemId();
        Intent intent;
        switch(id){
            case R.id.login:
                intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
                break;
            case R.id.cadastrar:
                intent = new Intent(MainActivity.this, CadastroUsuarioActivity.class);
                startActivity(intent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    // Esse método da Activity infla o menu definido no XML ( menu_action_bar2.xml ) na ActionBar dessa Activity
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

}
