package com.example.mytube;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

public class PlayActivity extends AppCompatActivity {
    VideoView viewVideo;
    MediaController mediaController;
    int currentPos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
        viewVideo = findViewById(R.id.videoPlayer);
        mediaController = new MediaController(this);
        Intent intent = getIntent();
        String link = intent.getStringExtra("link");
        Toast.makeText(this, link, Toast.LENGTH_SHORT).show();
        viewVideo.setVideoURI(Uri.parse(link));

        viewVideo.setMediaController(mediaController);
        mediaController.setAnchorView(viewVideo);

        currentPos = 0;
    }
    @Override
    protected void onResume() {
        super.onResume();
        playVideo(currentPos);
    }

    @Override
    protected void onPause() {
        super.onPause();
        currentPos = viewVideo.getCurrentPosition();
        viewVideo.stopPlayback();


    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putInt("currentPos", currentPos);
        super.onSaveInstanceState(outState);

    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        currentPos = savedInstanceState.getInt("currentPos");
    }

    public void playVideo(int currentPos) {
        viewVideo.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                viewVideo.seekTo(currentPos);
                viewVideo.start();

            }
        });
    }




}