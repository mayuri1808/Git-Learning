package com.example.socialmediaintegration.package_service;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.socialmediaintegration.R;

public class Activity_Service5sec extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__service5sec);
    }

    public void start(View view) {
        Intent intent=new Intent(this,MyService5Sec.class);
        startService(intent);
    }

    public void stop(View view) {
        Intent intent=new Intent(this,MyService5Sec.class);
        stopService(intent);
    }
}
