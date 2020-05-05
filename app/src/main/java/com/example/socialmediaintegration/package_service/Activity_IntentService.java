package com.example.socialmediaintegration.package_service;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;

import com.example.socialmediaintegration.R;

public class Activity_IntentService extends AppCompatActivity {
private MediaPlayer player;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__intent_service);
    }

    public void start(View view) {
        Intent intent=new Intent(Activity_IntentService.this,MyIntentService.class);
       /* intent.setData(Uri.parse());
        getApplicationContext().startService(intent);*/
    }

    public void stop(View view) {
        Intent intent=new Intent(Activity_IntentService.this,MyIntentService.class);
        stopService(intent);
    }



}
