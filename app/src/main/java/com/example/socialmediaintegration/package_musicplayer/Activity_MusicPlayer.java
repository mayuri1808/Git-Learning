package com.example.socialmediaintegration.package_musicplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings;
import android.view.View;
import android.widget.SeekBar;
import android.widget.Toast;

import com.example.socialmediaintegration.R;


public class Activity_MusicPlayer extends AppCompatActivity {
    SeekBar seekBar;
MediaPlayer mp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__music_player);
        mp=MediaPlayer.create(this,
                Settings.System.DEFAULT_RINGTONE_URI);
        seekBar=findViewById(R.id.seekbar);

    }

    public void play(View view) {

        mp.start();


    }

    public void pause(View view) {
        mp.pause();
    }
}
