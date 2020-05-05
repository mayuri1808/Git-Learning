package com.example.socialmediaintegration.package_service;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.socialmediaintegration.R;

public class Activity_Service extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__service);
    }


    public void start(View view) {
        Intent intent=new Intent(Activity_Service.this,MyService.class);
        startService(intent);
    }

    public void stop(View view) {
        Intent intent=new Intent(Activity_Service.this,MyService.class);
        stopService(intent);
    }
}
