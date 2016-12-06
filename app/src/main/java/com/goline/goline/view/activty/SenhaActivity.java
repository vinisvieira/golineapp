package com.goline.goline.view.activty;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.goline.goline.R;
import com.goline.goline.model.dao.SenhaREST;
import com.goline.goline.model.entity.Senha;

/**
 * Created by Vinicius on 05/12/2016.
 */

public class SenhaActivity extends AppCompatActivity {

    private ProgressDialog mProgressDialog;
    private SenhaREST senhaREST;
    private Long idConsultorio;
    private String nomeConsultorio;
    private TextView consultorio;
    private TextView senhaChamada;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_senha);
        senhaREST = new SenhaREST();
        idConsultorio = getIntent().getLongExtra("senha", 0L);
        nomeConsultorio = getIntent().getStringExtra("nome");
        SenhaAsyncTask senhaAsyncTask = new SenhaAsyncTask();
        senhaAsyncTask.execute();
    }

    public class SenhaAsyncTask extends AsyncTask<Void, Void, Senha> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            mProgressDialog = ProgressDialog.show(SenhaActivity.this, "Aguarde...", "", false, false);
        }

        @Override
        protected Senha doInBackground(Void... params) {return senhaREST.getSenha(idConsultorio);
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
}
