package com.example.socialmediaintegration.package_broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        if("com.example.socialmediaintegration.package_broadcastreceive.ActionSend".equals(intent.getAction())) {
            String extraData = intent.getStringExtra("com.example.socialmediaintegration.package_broadcastreceiver.ExtraData");
            Toast.makeText(context, "From Receiver" + extraData, Toast.LENGTH_LONG).show();
        }

    }
}
