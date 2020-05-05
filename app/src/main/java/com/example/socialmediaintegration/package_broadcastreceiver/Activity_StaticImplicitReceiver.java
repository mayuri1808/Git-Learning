package com.example.socialmediaintegration.package_broadcastreceiver;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.socialmediaintegration.R;

public class Activity_StaticImplicitReceiver extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__static_implicit_receiver);
    }

    public void sendBroadCast(View view) {
    }
}
