package com.example.socialmediaintegration.package_broadcast_task;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.widget.TextView;

import com.example.socialmediaintegration.R;

public class Activity_Receiver extends AppCompatActivity {
   //MyInnerReceiver myReceiver=new MyInnerReceiver();
   TextView received;
    BroadcastReceiver mInnerBroadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {

            if ("com.example.socialmediaintegration.ACTION_SEND".equals(intent.getAction())) {
                String intentData = intent.getStringExtra("com.example.socialmediaintegration.EXTRA_DATA");
                received.setText("Inner Broadcast Receiver : " + intentData);
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__receiver);
        received = findViewById(R.id.receive);
       IntentFilter intentFilter = new IntentFilter("com.example.socialmediaintegration.ACTION_SEND");
        registerReceiver(mInnerBroadcastReceiver, intentFilter);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(mInnerBroadcastReceiver);

    }


   /* public static class MyInnerReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {

            if ("com.example.socialmediaintegration.ACTION_SEND".equals(intent.getAction())) {
                String intentData = intent.getStringExtra("com.example.socialmediaintegration.EXTRA_DATA");
                received.setText("Inner Broadcast Receiver : " + intentData);

            }

        }
    }*/
}
