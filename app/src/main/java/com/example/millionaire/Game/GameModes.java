package com.example.millionaire.Game;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.millionaire.R;
import com.example.millionaire.TriviaPages.HomePage;
import com.example.millionaire.Utils.LoadingPage;

public class GameModes extends AppCompatActivity {

   private Button button, button2;
   private ImageView arrow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_modes);

        getSupportActionBar().hide();

        button = findViewById(R.id.button);
        button2 = findViewById(R.id.button2);
        arrow = findViewById(R.id.arrow);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), LoadingPage.class));
                finish();
            }
        });

        arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), HomePage.class));
                finish();
            }
        });


    }
}
