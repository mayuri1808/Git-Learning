package com.example.socialmediaintegration.package_broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.widget.Toast;

public class MyBroadcastReceiverDynamic extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
         if(ConnectivityManager.CONNECTIVITY_ACTION.equals(intent.getAction())){
             boolean booleanExtra=intent.getBooleanExtra(ConnectivityManager.EXTRA_NO_CONNECTIVITY,false);
             if(!booleanExtra)
            Toast.makeText(context,"Connected",Toast.LENGTH_LONG).show();
             else {
                 Toast.makeText(context,"Disconnected",Toast.LENGTH_LONG).show();
             }
        }

        else if(intent.ACTION_BOOT_COMPLETED.equals(intent.getAction())){
            Toast.makeText(context,"Boot Completed",Toast.LENGTH_SHORT).show();
        }
        else if(Intent.ACTION_TIME_TICK.equals(intent.getAction())){
            Toast.makeText(context,"Time incremented",Toast.LENGTH_SHORT).show();
         }


    }
}
