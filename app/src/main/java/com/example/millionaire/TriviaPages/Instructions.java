package com.example.millionaire.TriviaPages;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.millionaire.R;

public class Instructions extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instructions);

        getSupportActionBar().hide();
    }
}
