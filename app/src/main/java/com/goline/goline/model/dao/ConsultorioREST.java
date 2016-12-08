package com.goline.goline.model.dao;

import android.util.Log;

import com.goline.goline.model.entity.Consultorio;
import com.goline.goline.util.Constants;
import com.goline.goline.util.StringUtil;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by danilofernandocavalcanti on 01/12/16.
 */

public class ConsultorioREST {

    private static final int SECONDS = 1000;

    public Consultorio[] getConsultorios() {

        HttpURLConnection httpURLConnection = null;
        URL urlConnection;
        String serverResponseMessage = null;

        try {

            //urlConnection = new URL("http://192.168.25.5:8080/GoLine_1.0/ListarConsultorios");
            urlConnection = new URL("http://10.82.103.68:8080/GoLine_1.0/ListarConsultorios");
            //urlConnection = new URL("http://10.0.3.2:8080/GoLine_1.0/ListarConsultorios");

            httpURLConnection = (HttpURLConnection) urlConnection.openConnection();
            httpURLConnection.setReadTimeout(15 * SECONDS);
            httpURLConnection.setConnectTimeout(15 * SECONDS);
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setDoInput(true);
            httpURLConnection.setDoOutput(false);

            httpURLConnection.connect();

            serverResponseMessage = StringUtil.streamToString(httpURLConnection.getInputStream());

        } catch (IOException ioe) {
            Log.e(Constants.TAG, "getConsultorios -> " + ioe.getMessage());
        }

        return new Gson().fromJson(serverResponseMessage, Consultorio[].class);

    }

}
