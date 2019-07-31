package com.example.millionaire.TriviaPages;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.Image;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.Toast;

import com.example.millionaire.Game.GameLogic;
import com.example.millionaire.Game.GameModes;
import com.example.millionaire.R;
import com.example.millionaire.Utils.LoadingStartGame;

public class HomePage extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {

    private Button startButton;
    private Button practiceButton;
    private Button gameModes;
    private MediaPlayer mMediaPlayer;
    private ImageView settings;
    private Menu menu;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        getSupportActionBar().hide();



        startButton = findViewById(R.id.buttonStart);
        practiceButton = findViewById(R.id.button2);
        gameModes = findViewById(R.id.gameModes);
        settings = findViewById(R.id.settings);

       // menu = findViewById(R.id.)

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



    public void showPopup(View view){
        Context wrapper = new ContextThemeWrapper(this, R.style.Popup);

        PopupMenu popupMenu = new PopupMenu(wrapper,view);
        popupMenu.setOnMenuItemClickListener(this);
        popupMenu.inflate(R.menu.settings_menu);
        popupMenu.show();
    }

    @Override
    public boolean onMenuItemClick(MenuItem menuItem) {

        switch (menuItem.getItemId()){
            case R.id.myProfile:
                Toast.makeText(this, "Shows Profile", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.settingsOption:
                Toast.makeText(this, "Shows Settings", Toast.LENGTH_SHORT).show();
                return true;

             default:
                 return false;
        }


    }
}
