package com.goline.goline.view.activty;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.facebook.login.LoginManager;
import com.goline.goline.R;
import com.goline.goline.util.AlertUtil;
import com.goline.goline.view.adapter.PagerAdapterActivityMain;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;

    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        firebaseAuth = FirebaseAuth.getInstance();

        user = firebaseAuth.getCurrentUser();

        this.mTabLayout = (TabLayout) findViewById(R.id.tabLayoutActivityMain);
        this.mViewPager = (ViewPager) findViewById(R.id.viewPagerActivityMain);

        this.mViewPager.setAdapter(new PagerAdapterActivityMain(getSupportFragmentManager(), getResources().getStringArray(R.array.titles_tab)));
        this.mTabLayout.setupWithViewPager(this.mViewPager);
        this.mViewPager.setCurrentItem(1);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        // Os Id's que estou verificando no Switch-case foram definidos por mim para cada item do menu_action_bar2.xml
        Intent intent;
            switch (item.getItemId()) {
                case R.id.login:
                    intent = new Intent(MainActivity.this, LoginActivity.class);
                    startActivity(intent);
                    break;
                case R.id.cadastrar:
                    intent = new Intent(MainActivity.this, CadastroUsuarioActivity.class);
                    startActivity(intent);
                    break;
                case R.id.action_logout:
                    LoginManager.getInstance().logOut();
                    firebaseAuth.signOut();
                    AlertUtil.toast(getBaseContext(), "Deslogado...");
                    intent = new Intent(MainActivity.this, MainActivity.class);
                    startActivity(intent);
                    break;
        }
        return super.onOptionsItemSelected(item);
    }

    // Esse método da Activity infla o menu definido no XML ( menu_action_bar2.xml ) na ActionBar dessa Activity
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        if (user == null) {
            getMenuInflater().inflate(R.menu.menu_main, menu);
            return true;
        }else{
            getMenuInflater().inflate(R.menu.menu_login, menu);
            return true;
        }

    }

}
