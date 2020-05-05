package com.example.socialmediaintegration.package_broadcast_task;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        //It receive data which is send by intent from another activity
        if ("com.example.socialmediaintegration.ACTION_SEND".equals(intent.getAction())) {
            String extraData = intent.getStringExtra("com.example.socialmediaintegration.EXTRA_DATA");
            Toast.makeText(context, "From Receiver" + extraData, Toast.LENGTH_LONG).show();
        }
    }
}