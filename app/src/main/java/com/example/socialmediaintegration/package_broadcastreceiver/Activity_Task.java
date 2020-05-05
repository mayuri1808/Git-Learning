package com.example.socialmediaintegration.package_broadcastreceiver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.socialmediaintegration.R;

public class Activity_Task extends AppCompatActivity {
    int count = 0;
    TextView contOfButton;
    public static String BROADCAST_ACTION = "com.example.socialmediaintegration.package_broadcastreceiver.ActionSend";

    BroadcastReceiver receiver;

    MyReceiver myReceiver = new MyReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            super.onReceive(context, intent);
            if("com.example.socialmediaintegration.package_broadcastreceive.ActionSend".equals(intent.getAction())) {
                String intentExtra = intent.getStringExtra("com.example.socialmediaintegration.package_broadcastreceiver.ExtraData");
                contOfButton.setText("Broadcast Received"+intentExtra);
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__task);
        contOfButton=findViewById(R.id.countbuttonon);


    }

    public void actionClick(View view) {
        count++;
        contOfButton.setText(Integer.toString(count));

    }

    public void performAction(View view) {
        Intent broadcast = new Intent(BROADCAST_ACTION);
        broadcast.putExtra
                ("com.example.socialmediaintegration.package_broadcastreceiver.ExtraData","Hello from sender");
        broadcast.setAction(BROADCAST_ACTION);
        sendBroadcast(broadcast);
        startActivity(broadcast);




    }

    @Override
    protected void onStart() {
        super.onStart();
        IntentFilter intentFilter=new IntentFilter(BROADCAST_ACTION);
        registerReceiver(myReceiver,intentFilter);
    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(myReceiver);
    }
}
