package com.example.millionaire.Game;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.droidbyme.dialoglib.AnimUtils;
import com.droidbyme.dialoglib.DroidDialog;
import com.example.millionaire.QuestionTypes.ChallengerQuestions;
import com.example.millionaire.R;
import com.example.millionaire.TriviaPages.HomePage;
import com.example.millionaire.Utils.WinnerPage;
import java.util.ArrayList;

public class ChallengerQuestionsLogic extends AppCompatActivity implements View.OnClickListener {

    private ChallengerQuestions challengerQuestions = new ChallengerQuestions();
    private TextView textView;
    private Button an1, an2, an3, an4;
    private String rightAnswer;
    private MediaPlayer mediaPlayer = new MediaPlayer();
    private ArrayList<Integer> repeatedQuestions = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hard_questions_test);

        getSupportActionBar().hide();

        //Add the elements to the array.
        challengerQuestions.addElements();

        mediaPlayer = MediaPlayer.create(this, R.raw.challenger);
        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        mediaPlayer.setLooping(true);
        mediaPlayer.start();

        textView = findViewById(R.id.questionCenter);
        an1 = findViewById(R.id.ans1);
        an2 = findViewById(R.id.ans2);
        an3 = findViewById(R.id.ans3);
        an4 = findViewById(R.id.ans4);

        an1.setOnClickListener(this);
        an2.setOnClickListener(this);
        an3.setOnClickListener(this);
        an4.setOnClickListener(this);

        updateQuestion();
    }

    public void updateQuestion(){
        
        int randomNumber = (int) Math.floor(Math.random() * challengerQuestions.sizeOf());
        System.out.println(randomNumber);

        if(repeatedQuestions.size() == challengerQuestions.sizeOf()){
            winner();
        } else if(repeatedQuestions.contains(randomNumber)){
            updateQuestion();
        } else {
            textView.setText(challengerQuestions.getQuestion().get(randomNumber).getQuestionToask());
            an1.setText(challengerQuestions.getQuestion().get(randomNumber).getAnswer1());
            an2.setText(challengerQuestions.getQuestion().get(randomNumber).getAnswer2());
            an3.setText(challengerQuestions.getQuestion().get(randomNumber).getAnswer3());
            an4.setText(challengerQuestions.getQuestion().get(randomNumber).getAnswer4());
            rightAnswer = challengerQuestions.getQuestion().get(randomNumber).getRightAnswer();
            if(!repeatedQuestions.contains(randomNumber)){
                repeatedQuestions.add(randomNumber);
                }
            }
        }
    
    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.ans1:
                if(an1.getText() == rightAnswer){
                    updateQuestion();
                } else {
                    gameOver();
                }
                break;
            case R.id.ans2:
                if(an2.getText() == rightAnswer){
                    updateQuestion();
                } else {
                    gameOver();
                }
                break;
            case R.id.ans3:
                if(an3.getText() == rightAnswer){
                    updateQuestion();
                } else {
                    gameOver();
                }
                break;
            case R.id.ans4:
                if(an4.getText() == rightAnswer){
                    updateQuestion();
                } else {
                    gameOver();
                }
                break;
        }
    }


    private void gameOver(){
        
        mediaPlayer.stop();
        MediaPlayer mediaPlayer2 = new MediaPlayer();
        mediaPlayer2 = MediaPlayer.create(getApplicationContext(), R.raw.wrong);
        mediaPlayer2.setAudioStreamType(AudioManager.STREAM_MUSIC);
        mediaPlayer2.start();

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(ChallengerQuestionsLogic.this, R.style.AlertDialogStyle);
        alertDialogBuilder.setMessage("Game Over!")
                .setCancelable(false)
                .setPositiveButton("NEW GAME",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                startActivity(new Intent(getApplicationContext(), ChallengerQuestionsLogic.class));
                                finish();
                            }
                        })

                .setNegativeButton("EXIT",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                startActivity(new Intent(getApplicationContext(), HomePage.class));
                                finish();
                            }
                        });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mediaPlayer.stop();
        mediaPlayer.reset();
        mediaPlayer.release();
        mediaPlayer = null;
    }

    public void winner(){
        mediaPlayer.stop();
        MediaPlayer mediaPlayer2 = new MediaPlayer();
        mediaPlayer2 = MediaPlayer.create(getApplicationContext(), R.raw.yay);
        mediaPlayer2.setAudioStreamType(AudioManager.STREAM_MUSIC);
        mediaPlayer2.start();

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(ChallengerQuestionsLogic.this,R.style.AlertDialogStyle);
        alertDialogBuilder.setMessage("You won the game!")
                .setCancelable(false)
                .setPositiveButton("PRIZE",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                startActivity(new Intent(getApplicationContext(), WinnerPage.class));
                                finish();
                            }
                        })

                .setNegativeButton("NEW GAME",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                startAgain();
                                finish();
                            }
                        })


                .setNeutralButton("EXIT",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                startActivity(new Intent(getApplicationContext(),HomePage.class));
                                finish();
                            }
                        });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

    private void startAgain(){
        for(int i = 0; i < repeatedQuestions.size(); i++){
            repeatedQuestions.remove(i);
        }
        updateQuestion();
    }
}
