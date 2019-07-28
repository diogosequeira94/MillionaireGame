package com.example.millionaire.Utils;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.millionaire.TriviaPages.HomePage;
import com.example.millionaire.R;

public class WinnerPage extends AppCompatActivity {

    private ImageView winner;
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_winner_page);

        getSupportActionBar().hide();

        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.troll);
        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        mediaPlayer.start();

        winner = findViewById(R.id.finger);

        winner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.stop();
                startActivity(new Intent(getApplicationContext(), HomePage.class));
                finish();
            }
        });
    }
}
