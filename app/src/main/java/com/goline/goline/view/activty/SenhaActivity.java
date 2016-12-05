package com.goline.goline.view.activty;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.goline.goline.R;
import com.goline.goline.model.dao.SenhaREST;
import com.goline.goline.model.entity.Senha;

/**
 * Created by Vinicius on 05/12/2016.
 */

public class SenhaActivity extends AppCompatActivity {

    private ProgressDialog mProgressDialog;
    private SenhaREST senhaREST;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public class SenhaAsyncTask extends AsyncTask<Void, Void, Senha> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            mProgressDialog = ProgressDialog.show(SenhaActivity.this, "Aguarde...", "", false, false);
        }

        @Override
        protected Senha doInBackground(Void... params) {
            return senhaREST.getSenha(1L);
        }

        @Override
        protected void onPostExecute(Senha senha) {
            super.onPostExecute(senha);
            //mostrarConsultorios(senha);
            mProgressDialog.dismiss();
        }
    }
}
