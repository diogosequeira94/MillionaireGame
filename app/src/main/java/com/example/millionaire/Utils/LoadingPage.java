package com.example.millionaire.Utils;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import com.example.millionaire.Game.ChallengerQuestionsLogic;
import com.example.millionaire.R;

public class LoadingPage extends AppCompatActivity {

    private ProgressBar progressBar;
    private ObjectAnimator progressAnimator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading_page);

        getSupportActionBar().hide();


        init();
        progressAnimator.start();
        progressAnimator.setDuration(3500);

        progressAnimator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                System.out.println("Done");
                super.onAnimationEnd(animation);
                progressBar.setVisibility(View.GONE);
                startActivity();
            }
        });

    }

    private void init(){

        progressBar = findViewById(R.id.progressBar);
        progressAnimator = ObjectAnimator.ofInt(progressBar, "progress",0,100);
    }

    private void startActivity(){
        startActivity(new Intent(getApplicationContext(), ChallengerQuestionsLogic.class));
    }
}
