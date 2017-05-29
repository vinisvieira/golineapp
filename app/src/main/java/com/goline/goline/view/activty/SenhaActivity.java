package com.goline.goline.view.activty;


import android.Manifest;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.goline.goline.R;
import com.goline.goline.model.dao.SenhaREST;
import com.goline.goline.model.entity.Senha;
import com.goline.goline.util.PermissionUtil;

/**
 * Created by Vinicius on 05/12/2016.
 */

public class SenhaActivity extends AppCompatActivity implements View.OnClickListener {

    private ProgressDialog mProgressDialog;
    private SenhaREST senhaREST;
    private Long idConsultorio;
    private String nomeConsultorio;
    private String rua;
    private String cidade;
    private TextView consultorio;
    private TextView senhaChamada;
    private ImageButton buttonMapa;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_senha);

        ActionBar actionBar = getSupportActionBar();

        // Método que ativa o botão Up Navigation
        actionBar.setDisplayHomeAsUpEnabled(true);

        senhaREST = new SenhaREST();
        idConsultorio = getIntent().getLongExtra("senha", 0L);
        nomeConsultorio = getIntent().getStringExtra("nome");
        SenhaAsyncTask senhaAsyncTask = new SenhaAsyncTask();
        senhaAsyncTask.execute();

        buttonMapa = (ImageButton) findViewById(R.id.button_mapa);

        buttonMapa.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        rua = getIntent().getStringExtra("rua");
        cidade = getIntent().getStringExtra("cidade");

        String[] permissions = new String[]{Manifest.permission.ACCESS_COARSE_LOCATION,
                                            Manifest.permission.ACCESS_FINE_LOCATION};

        if(PermissionUtil.validate(this, 0, permissions)){

            Intent intent = new Intent(this, MapaActivity.class);

            intent.putExtra("rua", rua);
            intent.putExtra("cidade", cidade);
            intent.putExtra("nome", nomeConsultorio);
            startActivity(intent);

        }

    }

    public class SenhaAsyncTask extends AsyncTask<Void, Void, Senha> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            mProgressDialog = ProgressDialog.show(SenhaActivity.this, "Aguarde...", "", false, false);
        }

        @Override
        protected Senha doInBackground(Void... params) {
            return senhaREST.getSenha(idConsultorio);
        }

        @Override
        protected void onPostExecute(Senha senha) {
            super.onPostExecute(senha);

            String chamada = String.valueOf(senha.getValorChamada());

            consultorio = (TextView) findViewById(R.id.text_view_consultorio);
            consultorio.setText(nomeConsultorio);
            senhaChamada = (TextView) findViewById(R.id.text_view_senha);
            senhaChamada.setText(chamada);
            mProgressDialog.dismiss();
        }
    }

    // Esse método da Activity é chamado sempre que um botão da ActionBar é clicado
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        // Estou verificando pelo Id do botão clicado se corresponde ao botão Up Navigation
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
