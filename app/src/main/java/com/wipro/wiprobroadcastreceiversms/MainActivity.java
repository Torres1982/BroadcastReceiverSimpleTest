package com.wipro.wiprobroadcastreceiversms;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button sendMessageButton;
    BroadcastReceiver broadcastReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sendMessageButton = findViewById(R.id.button_send_broadcast);

        sendMessageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                broadcastMessage();
            }
        });
    }

    // Register Broadcast Receiver
    private void broadcastMessage() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.wipro.wiprobroadcastreceiversms.testbroadcast");
        broadcastReceiver = new MyTestReceiver();
        registerReceiver(broadcastReceiver, intentFilter);

        Toast.makeText(this, "Broadcast Receiver REGISTERED successfully!", Toast.LENGTH_SHORT).show();
        sendBroadcast();
    }

    // Send Broadcast
    private void sendBroadcast() {
        Intent intent = new Intent();
        intent.addFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES);
        intent.setAction("com.wipro.wiprobroadcastreceiversms.testbroadcast");
        sendBroadcast(intent);

        Toast.makeText(this, "Broadcast Receiver SENT successfully!", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(broadcastReceiver);
    }
}
