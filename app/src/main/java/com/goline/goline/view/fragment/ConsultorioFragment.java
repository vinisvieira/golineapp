package com.goline.goline.view.fragment;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.goline.goline.R;
import com.goline.goline.model.dao.ConsultorioREST;
import com.goline.goline.model.entity.Consultorio;
import com.goline.goline.view.activty.SenhaActivity;
import com.goline.goline.view.adapter.ConsultoriosRecyclerView;

/**
 * Created by danilofernandocavalcanti on 01/12/16.
 */

public class ConsultorioFragment extends Fragment {

    private View mView;
    private ConsultorioREST consultorioREST;
    private ProgressDialog mProgressDialog;
    private RecyclerView mRecyclerView;
    private ConsultoriosRecyclerView mConsultoriosRecyclerView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        this.mView = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_consultorio, container, false);
        return this.mView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.mRecyclerView = (RecyclerView) this.mView.findViewById(R.id.recyclerViewConsultorios);
        consultorioREST = new ConsultorioREST();
        ConsultorioAsyncTask consultorioAsyncTask = new ConsultorioAsyncTask();
        consultorioAsyncTask.execute();
    }

    private void mostrarConsultorios(Consultorio[] consultorios) {
        this.mConsultoriosRecyclerView = new ConsultoriosRecyclerView(getActivity(), consultorios);

        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            this.mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        } else {
            this.mRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        }
        this.mRecyclerView.setAdapter(this.mConsultoriosRecyclerView);
    }

    public class ConsultorioAsyncTask extends AsyncTask<Void, Void, Consultorio[]> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            mProgressDialog = ProgressDialog.show(getActivity(), "Aguarde...", "", false, false);
        }

        @Override
            protected Consultorio[] doInBackground(Void... params) {
                return consultorioREST.getConsultorios();
        }

        @Override
        protected void onPostExecute(Consultorio[] consultorios) {
            super.onPostExecute(consultorios);
            mostrarConsultorios(consultorios);
            mProgressDialog.dismiss();
        }
    }

}
