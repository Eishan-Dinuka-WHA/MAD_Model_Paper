package com.example.modelpaper;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MediaplayerActivity extends AppCompatActivity {

    MediaPlayer mediaplayer;
    Button play, pause, stop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mediaplayer);
        play = findViewById(R.id.button);
        pause = findViewById(R.id.button2);
        stop = findViewById(R.id.button3);

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaplayer == null) {
                    mediaplayer = MediaPlayer.create(getApplicationContext(), R.raw.song);
                    mediaplayer.start();
                } else {
                    mediaplayer.start();
                }
            }
        });

        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaplayer != null) {
                    mediaplayer.pause();

                } else {


                }

            }
        });

        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaplayer.release();
                mediaplayer = null;
            }
        });

    }
}