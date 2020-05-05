package com.example.socialmediaintegration.package_broadcastreceiver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;

import com.example.socialmediaintegration.R;

public class Activity_Task2 extends AppCompatActivity {
     MyReceiver mReceiver=new MyReceiver();
    public static String BROADCAST_ACTION =  "com.example.socialmediaintegration.package_broadcastreceive.ActionSend";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__task2);
        IntentFilter eventFilter = new IntentFilter();
        eventFilter.addAction(BROADCAST_ACTION);
        registerReceiver(mReceiver, eventFilter);
    }

    @Override
    protected void onDestroy() {
        unregisterReceiver(mReceiver);
        super.onDestroy();
    }




}
