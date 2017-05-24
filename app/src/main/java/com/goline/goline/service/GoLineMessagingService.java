package com.goline.goline.service;

import android.content.Intent;

import com.goline.goline.util.NotificationUtil;
import com.goline.goline.view.activty.MainActivity;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import java.util.Map;

/**
 * Created by vinicius on 24/05/17.
 */

public class GoLineMessagingService extends FirebaseMessagingService{

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage){
        Map<String, String> data = remoteMessage.getData();

        Intent intent = new Intent(getBaseContext(), MainActivity.class);
        String title = "GoLine";
        String body = data.get("consultorio") + " - " + data.get("senha");

        NotificationUtil.create(getBaseContext(), intent, title, body, 1);
    }

}
