package com.example.millionaire.TriviaPages;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.millionaire.Game.GameLogic;
import com.example.millionaire.Game.GameModes;
import com.example.millionaire.R;
import com.example.millionaire.Utils.LoadingStartGame;

public class HomePage extends AppCompatActivity {

    private Button startButton;
    private Button practiceButton;
    private Button gameModes;
    private MediaPlayer mMediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        getSupportActionBar().hide();

        startButton = findViewById(R.id.buttonStart);
        practiceButton = findViewById(R.id.button2);
        gameModes = findViewById(R.id.gameModes);

        mMediaPlayer = new MediaPlayer();
        mMediaPlayer = MediaPlayer.create(this, R.raw.theme);
        mMediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        mMediaPlayer.setLooping(true);
        mMediaPlayer.start();

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mMediaPlayer.stop();
                MediaPlayer mediaPlayer2 = new MediaPlayer();
                mediaPlayer2 = MediaPlayer.create(getApplicationContext(), R.raw.play);
                mediaPlayer2.setAudioStreamType(AudioManager.STREAM_MUSIC);
                mediaPlayer2.start();

                startActivity(new Intent(getApplicationContext(), LoadingStartGame.class));

            }
        });

        practiceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Instructions.class));
            }
        });

        gameModes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mMediaPlayer.stop();
                startActivity(new Intent(getApplicationContext(), GameModes.class));
                finish();
            }
        });
    }




}
