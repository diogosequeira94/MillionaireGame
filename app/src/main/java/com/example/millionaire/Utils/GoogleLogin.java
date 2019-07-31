package com.example.millionaire.Utils;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.millionaire.R;
import com.example.millionaire.TriviaPages.HomePage;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.SignInButtonImpl;

public class GoogleLogin extends AppCompatActivity implements View.OnClickListener, GoogleApiClient.OnConnectionFailedListener {

    private LinearLayout profileSection;
    private Button signOut;
    private SignInButton signInButton;
    private TextView name, email, noLogin;
    private ImageView profilePic, logoImage;

    private GoogleApiClient googleApiClient;
    private static final int REQ_CODE = 9001;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_google_login);

        getSupportActionBar().hide();


        profileSection = (LinearLayout) findViewById(R.id.profilesection);
        signOut = findViewById(R.id.logout);
        signInButton = (SignInButton) findViewById(R.id.button_login);
        name = findViewById(R.id.name);
        noLogin = findViewById(R.id.continueButton);
        email = findViewById(R.id.email);
        profilePic = findViewById(R.id.prof_pic);
        logoImage = findViewById(R.id.logocenter);
        GoogleSignInOptions signInOptions = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();
        googleApiClient = new GoogleApiClient.Builder(this).enableAutoManage(this,this).addApi(Auth.GOOGLE_SIGN_IN_API, signInOptions).build();

        signInButton.setOnClickListener(this);
        signOut.setOnClickListener(this);
        noLogin.setOnClickListener(this);

        //When activity starts this is invisible
        profileSection.setVisibility(View.GONE);



    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){

            case R.id.button_login:
                signIn();
                break;

            case R.id.logout:
                signOut();
                break;

            case R.id.continueButton:
                startActivity( new Intent(getApplicationContext(), HomePage.class));
                finish();
        }
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }

    private void signIn(){

        Intent intent = Auth.GoogleSignInApi.getSignInIntent(googleApiClient);
        // When you use Activity for result you need to override OnActivityResult
        startActivityForResult(intent,REQ_CODE);
    }

    private void signOut(){

        Auth.GoogleSignInApi.signOut(googleApiClient).setResultCallback(new ResultCallback<Status>() {
            @Override
            public void onResult(@NonNull Status status) {
                updateUI(false);
            }
        });

    }

    private void handleResult(GoogleSignInResult result){

        if(result.isSuccess()){
            GoogleSignInAccount account = result.getSignInAccount();

            String name2 = account.getDisplayName();
            String email2 = account.getEmail();
            String image_url = account.getPhotoUrl().toString();

            name.setText(name2);
            email.setText(email2);
            Glide.with(this).load(image_url).into(profilePic);
            updateUI(true);
        } else {

            updateUI(false);
        }
    }

    private void updateUI(boolean isLogin){

        if(isLogin){

            profileSection.setVisibility(View.VISIBLE);
            signInButton.setVisibility(View.GONE);
            logoImage.setVisibility(View.GONE);
            noLogin.setVisibility(View.GONE);

        } else {

            profileSection.setVisibility(View.GONE);
            signInButton.setVisibility(View.VISIBLE);
            logoImage.setVisibility(View.VISIBLE);
            noLogin.setVisibility(View.VISIBLE);
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == REQ_CODE){

            GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            handleResult(result);

        }
    }
}
