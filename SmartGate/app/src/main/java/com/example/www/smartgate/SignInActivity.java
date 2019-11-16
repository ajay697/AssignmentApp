package com.example.www.smartgate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.widget.Toolbar;

public class SignInActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private ImageButton mSignInButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("");

        mSignInButton = (ImageButton)findViewById(R.id.sign_in_button);
    }

    public void onSignInButtonClicked(View view){
        Intent profileIntent = new Intent(this,ProfileActivity.class);
        startActivity(profileIntent);
    }
}
