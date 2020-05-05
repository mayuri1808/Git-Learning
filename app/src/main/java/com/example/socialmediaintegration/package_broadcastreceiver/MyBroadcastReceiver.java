package com.example.socialmediaintegration.package_broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.widget.Toast;

public class MyBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if(intent.ACTION_BOOT_COMPLETED.equals(intent.getAction())){
            Toast.makeText(context,"Boot Completed",Toast.LENGTH_SHORT).show();
        }else if(ConnectivityManager.CONNECTIVITY_ACTION.equals(intent.getAction())){
         Toast.makeText(context,"Connectivity Status changed",Toast.LENGTH_LONG).show();
   }}}

