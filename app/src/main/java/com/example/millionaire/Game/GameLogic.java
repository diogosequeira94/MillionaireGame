package com.example.millionaire.Game;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.millionaire.TriviaPages.HomePage;
import com.example.millionaire.QuestionTypes.ImageQuestions;
import com.example.millionaire.QuestionTypes.Questions;
import com.example.millionaire.R;
import com.example.millionaire.Utils.WinnerPage;

import java.util.ArrayList;
import java.util.Random;

import io.github.erehmi.countdown.CountDownTask;
import io.github.erehmi.countdown.CountDownTimers;

public class GameLogic extends AppCompatActivity implements GameLogicInterface {

    private Button answer1, answer2, answer3, answer4;
    private TextView score, question, counter;
    private ImageView pictureQuestion, help, pictureWinning, image50, swap, publicHelp;

    private Questions mQuestions = new Questions();
    private ImageQuestions imageQuestions = new ImageQuestions();

    private String mAnswers;
    private String imageAnswers;

    private int mScore = 0;
    private int mQuestionsLenght = mQuestions.getmQestions().length;
    private int currentQuestion;
    private int timeshelped;

    private ArrayList<Integer> repeatedQuestions = new ArrayList<>();

    private final static int DELAY = 1000;
    private final int CD_INTERVAL = 1000;

    private MediaPlayer mediaPlayer = new MediaPlayer();
    private CountDownTask countDownTask = CountDownTask.create();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();
        initViews();

        //Music for the game
        playAudioWithDelay();

       /* //Creating BottomNavigationView
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(navListener); */


       //Start Game
        updateQuestion();

        //OnClick Listeners

        help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                helpDialog();
            }
        });

        image50.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                help50();
            }
        });

        swap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                swapQuestion();
            }
        });

        publicHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Need to implement this one", Toast.LENGTH_SHORT).show();
                publicHelp.setVisibility(View.INVISIBLE);
            }
        });

        answer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(answer1.getText() == mAnswers){

                    mScore++;
                    score.setText("Score: " + mScore);
                    updateQuestion();

                } else {
                    countDownTask.cancel();
                    gameOver();
                }
            }
        });

        answer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if(answer2.getText() == mAnswers){

                    mScore++;
                    score.setText("Score: " + mScore);
                    updateQuestion();
                } else {
                    countDownTask.cancel();
                    gameOver();
                }


            }
        });

        answer3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if(answer3.getText() == mAnswers){

                    mScore++;
                    score.setText("Score: " + mScore);
                    updateQuestion();
                } else {
                    countDownTask.cancel();
                    gameOver();
                }

            }
        });

        answer4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if(answer4.getText() == mAnswers){

                    mScore++;
                    score.setText("Score: " + mScore);
                    updateQuestion();

                } else {
                    countDownTask.cancel();
                    gameOver();
                }
            }
        });

    }


    @Override
    protected void onDestroy() {

        super.onDestroy();

        mediaPlayer.stop();
        mediaPlayer.reset();
        mediaPlayer.release();
        mediaPlayer = null;
    }

    private void initViews(){

        //Helps
        pictureQuestion = findViewById(R.id.pictureQuestion);
        image50 = findViewById(R.id.image50);
        help = findViewById(R.id.help);
        swap = findViewById(R.id.swap);
        publicHelp = findViewById(R.id.person);

        //Answers
        answer1 = findViewById(R.id.answer1);
        answer2 = findViewById(R.id.answer2);
        answer3 = findViewById(R.id.answer3);
        answer4 = findViewById(R.id.answer4);

        //Score and Middle Question
        score = findViewById(R.id.score);
        question = findViewById(R.id.question);

        //Down Counter
        counter = findViewById(R.id.counter);
    }
    @Override
    public void updateQuestion(){

        int num = (int) Math.floor(Math.random() * mQuestionsLenght);

        currentQuestion = num;

        long targetMillis = CountDownTask.elapsedRealtime() + 1000 * 20;

        countDownTask.until(counter, targetMillis, CD_INTERVAL, new CountDownTimers.OnCountDownListener() {
            @Override
            public void onTick(View view, long millisUntilFinished) {
                ((TextView)counter).setText(String.valueOf(millisUntilFinished / CD_INTERVAL));
            }

            @Override
            public void onFinish(View view) {
                gameOver();
            }
        });

      //  int questionType = (int) Math.floor(Math.random() * 10);

       // if(questionType > 4){

            if(repeatedQuestions.size() == mQuestionsLenght){
                winner();

            } else if (repeatedQuestions.contains(num)){


                System.out.println("The new number is: " + num);
                updateQuestion();


            } else {
                question.setText(mQuestions.getQuestion(num));
                answer1.setText(mQuestions.getChoice1(num));
                answer2.setText(mQuestions.getChoice2(num));
                answer3.setText(mQuestions.getChoice3(num));
                answer4.setText(mQuestions.getChoice4(num));

                mAnswers = mQuestions.getCorrectAnswer(num);

                if(!repeatedQuestions.contains(num)){
                    repeatedQuestions.add(num);
                }
            }

     /*   } else {

            int id = getResources().getIdentifier("res:drawable/image" + num, null, null);

            pictureQuestion.setImageResource(id);

            pictureQuestion.setVisibility(View.VISIBLE);
            answer1.setText(imageQuestions.getChoice1(num));
            answer2.setText(imageQuestions.getChoice2(num));
            answer3.setText(imageQuestions.getChoice3(num));
            answer4.setText(imageQuestions.getChoice4(num));

            imageAnswers = imageQuestions.getCorrectAnswer(num);


        }
*/
    }

    private void swapQuestion(){

            updateQuestion();
            repeatedQuestions.remove(repeatedQuestions.size() -2);
            swap.setVisibility(View.INVISIBLE);


    }

    private void help50(){

        //THIS IS A METHOD FOR 50-50

                Toast.makeText(getApplicationContext(), "Done", Toast.LENGTH_SHORT);

                if (timeshelped != 1){

                    Button[] answers = {answer1, answer2, answer3, answer4};

                    int answersChanged = 0;

                    while (answersChanged != 2){

                        int randomHelp = (int) Math.floor(Math.random() * answers.length);

                        if (!answers[randomHelp].getText().equals("")){
                            if(!answers[randomHelp].getText().equals(mAnswers)){
                                answers[randomHelp].setText("");
                                answersChanged++;

                            }
                        }

                    }

                    timeshelped++;
                    } else {

                    Toast.makeText(getApplicationContext(), "You have used this help! already!", Toast.LENGTH_SHORT).show();
                }
                    image50.setVisibility(View.INVISIBLE);

                }

    @Override
    public void gameOver(){

        mediaPlayer.stop();

        MediaPlayer mediaPlayer2 = new MediaPlayer();
        mediaPlayer2 = MediaPlayer.create(getApplicationContext(), R.raw.wrong);
        mediaPlayer2.setAudioStreamType(AudioManager.STREAM_MUSIC);
        mediaPlayer2.start();

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(GameLogic.this, R.style.AlertDialogStyle);
        alertDialogBuilder.setMessage("Game Over! Your score is: " + mScore + " points!")
                            .setCancelable(false)
                            .setPositiveButton("NEW GAME",
                                    new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialogInterface, int i) {
                                            startActivity(new Intent(getApplicationContext(), GameLogic.class));
                                            finish();
                                        }
                                    })

                            .setNegativeButton("EXIT",
                                    new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialogInterface, int i) {
                                            homePage();
                                            finish();
                                        }
                                    });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();


    }
    @Override
    public void winner(){

        countDownTask.cancel();

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(GameLogic.this,R.style.AlertDialogStyle);
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
                                homePage();
                                finish();
                            }
                        });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }


    @Override
    public void startAgain(){


        mScore = 0;
        score.setText("Score: " + mScore);


        for(int i = 0; i < repeatedQuestions.size(); i++){
            repeatedQuestions.remove(i);
        }
        updateQuestion();

    }

    @Override
    public void homePage(){
        countDownTask.cancel();
        startActivity(new Intent(getApplicationContext(), HomePage.class));
        finish();

    }

        public void playAudioWithDelay(){
        Handler handler = new Handler();
            handler.postDelayed(new Runnable(){
                @Override
                public void run() {

                    mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.questionsmusic);
                    mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
                    mediaPlayer.setLooping(true);
                    mediaPlayer.start();
                }
                //your code start with delay in one second after calling this method
            }, DELAY * 3);

        }



    private void helpDialog() {
        final String[] colors = {"Robin", "Audrey", "Rolo", "Christina"};

        AlertDialog.Builder builder2 = new AlertDialog.Builder(this);
        builder2.setTitle("You can choose one to help you!");
        builder2.setItems(colors, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch(which){
                    case 0:

                        int randomVoice = (int) Math.floor(Math.random() * 10);

                        if(randomVoice < 4){
                            mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.robinn);
                            mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
                            mediaPlayer.start();
                        } else if(randomVoice > 4 && randomVoice < 7){
                            mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.robin2);
                            mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
                            mediaPlayer.start();
                        } else{
                            mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.robin3);
                            mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
                            mediaPlayer.start();
                        }

                        break;
                    case 1:
                        Toast.makeText(getApplicationContext(), "Not done yet", Toast.LENGTH_SHORT).show();
                        break;
                    case 2:
                        Toast.makeText(getApplicationContext(), "Not done yet", Toast.LENGTH_SHORT).show();
                        break;
                    case 3:
                        Toast.makeText(getApplicationContext(), "Not done yet", Toast.LENGTH_SHORT).show();
                        break;




                }

            }
        });
        builder2.show();
    }

 /*   //Creating NavListener
    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                    switch (menuItem.getItemId()){
                        case R.id.nav_home:
                            Toast.makeText(getApplicationContext(), "Item 1", Toast.LENGTH_SHORT).show();
                            break;

                        case R.id.nav_file:
                            Toast.makeText(getApplicationContext(), "Item 1", Toast.LENGTH_SHORT).show();

                            break;
                        case R.id.nav_favourites:
                            Toast.makeText(getApplicationContext(), "Item 1", Toast.LENGTH_SHORT).show();


                            break;

                        case R.id.nav_settings:
                            Toast.makeText(getApplicationContext(), "Item 1", Toast.LENGTH_SHORT).show();


                            break;


                    }


                    return true;
                }

            }; */

    }


