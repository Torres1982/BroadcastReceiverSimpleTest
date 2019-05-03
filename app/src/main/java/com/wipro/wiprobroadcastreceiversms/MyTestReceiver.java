package com.wipro.wiprobroadcastreceiversms;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyTestReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

//        if (intent.getAction().equals("com.wipro.wiprobroadcastreceiversms.testbroadcast")) {
            Toast.makeText(context, "Broadcast Receiver RECEIVED successfully!", Toast.LENGTH_SHORT).show();
//        }
    }
}
