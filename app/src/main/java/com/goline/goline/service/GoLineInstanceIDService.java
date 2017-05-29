package com.goline.goline.service;

import android.util.Log;

import com.goline.goline.model.entity.Notification;
import com.goline.goline.model.entity.Paciente;
import com.goline.goline.util.HttpHelper;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by vinicius on 24/05/17.
 */

public class GoLineInstanceIDService extends FirebaseInstanceIdService {

    HttpHelper httpHelper = new HttpHelper("http://192.168.23.47:8080/goline_2.0/api"); //("http://192.168.25.5:8080/goline_2.0/api");

    @Override
    public void onTokenRefresh() {
        String refreshedToken = FirebaseInstanceId.getInstance().getToken();
        Log.d("GoLine", "Refreshed token: " + refreshedToken);

        Notification notification = new Notification();

        notification.setTokenFMC(refreshedToken);

        Gson gson = new Gson();
        String body = gson.toJson(notification);
        Map<String, String> headers = new HashMap<String, String>();
        headers.put("Content-Type", "application/json;charset=utf-8");

        httpHelper.doPOST("notification",  headers, body);

    }

}
