package com.example.socialmediaintegration.package_broadcastreceiver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.view.View;

import com.example.socialmediaintegration.R;

public class Activity_DynamicExplicitReceiver extends AppCompatActivity {
MyBroadcastReceiverDynamic myBroadcastReceiverDynamic=new MyBroadcastReceiverDynamic();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__dynamic_explicit_receiver);
        IntentFilter intentFilter=new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        intentFilter.addAction(Intent.ACTION_BOOT_COMPLETED);
        intentFilter.addAction(Intent.ACTION_TIME_TICK);
        registerReceiver(myBroadcastReceiverDynamic,intentFilter);


    }

    public void sendBroadCast(View view) {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(myBroadcastReceiverDynamic);
    }
}
