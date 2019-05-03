package com.wipro.wiprobroadcastreceiversms;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyTestReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals("com.wipro.wiprobroadcastreceiversms.testbroadcast")) {
            String broadcastMessage = intent.getExtras().getString("Broadcast_Receiver_Test");
            Toast.makeText(context, "Broadcast RECEIVED successfully! " + broadcastMessage, Toast.LENGTH_SHORT).show();
        }
    }
}
