package com.example.socialmediaintegration.package_service;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.provider.Settings;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class MyService extends Service {
    private MediaPlayer player;
//int count=0;//we cannot perform long running task by using main UI thraed so we should have to create
    //new thread for creating long running background task.
   /* class MyThread implements Runnable{

        @Override
        public void run() {
            synchronized (this){
                while (count<10){
                    try{
                        wait(1000);
                    }catch(InterruptedException e){
                        e.printStackTrace();
                    }
                    Handler handler=new Handler(Looper.getMainLooper());
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(MyService.this,+count,Toast.LENGTH_SHORT).show();
                        }
                    });count++;
                }
            }
        }
    }*/
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
       /* Toast.makeText(this,"service Started", Toast.LENGTH_SHORT).show();
        Thread thread=new Thread(new MyThread());
        thread.start();*/

        //getting systems default ringtone
        player = MediaPlayer.create(this,
                Settings.System.DEFAULT_RINGTONE_URI);
        //setting loop play to true
        //this will make the ringtone continuously playing
        player.setLooping(true);

        //staring the player
        player.start();

        //we have some options for service
        //start sticky means service will be explicity started and stopped
        return START_STICKY;

    }

    @Override
    public void onCreate() {
        super.onCreate();
        Toast.makeText(this,"service Created", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        player.stop();
        Toast.makeText(this,"service Destroyed", Toast.LENGTH_SHORT).show();

    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {//It is a starter service so it return null
        return null;
    }
}
