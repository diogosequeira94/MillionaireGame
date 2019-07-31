package com.example.millionaire.Utils;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.millionaire.R;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;

public class GoogleLogin extends AppCompatActivity implements View.OnClickListener, GoogleApiClient.OnConnectionFailedListener {

    private LinearLayout profileSection;
    private Button signOut;
    private SignInButton signInButton;
    private TextView name, email;
    private ImageView profilePic;

    private GoogleApiClient googleApiClient;
    private static final int REQ_CODE = 9001;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_google_login);


        profileSection = (LinearLayout) findViewById(R.id.profilesection);
        signOut = findViewById(R.id.logout);
        signInButton = (SignInButton) findViewById(R.id.button_login);
        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        profilePic = findViewById(R.id.prof_pic);

        signInButton.setOnClickListener(this);
        signOut.setOnClickListener(this);

        //When activity starts this is invisible
        profileSection.setVisibility(View.GONE);



    }

    @Override
    public void onClick(View view) {

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }
}
