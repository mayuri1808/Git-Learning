package com.example.socialmediaintegration.package_broadcast_task;

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

public class Activity_Sender extends AppCompatActivity {
    int count = 0;
    BroadcastReceiver mInnerBroadcastReceiver;

   //Activity_Receiver.MyInnerReceiver innerReceiver=new Activity_Receiver.MyInnerReceiver();
    TextView senderSide;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__sender);
        senderSide=findViewById(R.id.sender);

    }
    public void sendBroadcastt(View view) {
        Intent intent=new Intent("com.example.socialmediaintegration.ACTION_SEND");
        intent.putExtra("com.example.socialmediaintegration.EXTRA_DATA","Hello From Sender App : "+count);
        sendBroadcast(intent);
    }
    public void saveCount(View view) {
        count++;
        senderSide.setText(Integer.toString(count));
    }
    @Override
    protected void onStart() {
        super.onStart();
        IntentFilter intentFilter=new IntentFilter("com.example.socialmediaintegration.ACTION_SEND");
        registerReceiver(mInnerBroadcastReceiver,intentFilter);
    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(mInnerBroadcastReceiver);
    }
}
