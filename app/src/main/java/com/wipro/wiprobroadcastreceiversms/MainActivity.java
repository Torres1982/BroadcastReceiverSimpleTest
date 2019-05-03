package com.wipro.wiprobroadcastreceiversms;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button sendMessageButton;
    BroadcastReceiver broadcastReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sendMessageButton = findViewById(R.id.button_send_sms);

        sendMessageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                broadcastMessage();
            }
        });
    }

    // Send Registered Broadcast
    private void broadcastMessage() {
        Toast.makeText(this, "Broadcast Receiver SENT successfully!", Toast.LENGTH_SHORT).show();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.wipro.wiprobroadcastreceiversms.testbroadcast");
        broadcastReceiver = new MyTestReceiver();
        registerReceiver(broadcastReceiver, intentFilter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(broadcastReceiver);
    }
}
