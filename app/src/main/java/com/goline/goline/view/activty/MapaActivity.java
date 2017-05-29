package com.goline.goline.view.activty;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.goline.goline.R;
import com.goline.goline.view.fragment.MapaFragment;

public class MapaActivity extends AppCompatActivity {

    private String rua;
    private String cidade;
    private String nome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapa);

        setupToolbar();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        rua = getIntent().getStringExtra("rua");
        cidade = getIntent().getStringExtra("cidade");
        nome = getIntent().getStringExtra("nome");

        getSupportActionBar().setTitle(nome);

        if(savedInstanceState==null){
            MapaFragment mapaFragment = new MapaFragment();
            mapaFragment.setArguments(getIntent().getExtras());
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_layout, mapaFragment).commit();
        }
    }

    protected void setupToolbar(){
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        if(toolbar != null){
            setSupportActionBar(toolbar);
        }
    }

}
