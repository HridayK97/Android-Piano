package com.example.hriday.virtualpiano;

import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class welcome extends AppCompatActivity {
    private ConstraintLayout welcomescreen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        welcomescreen=(ConstraintLayout)findViewById(R.id.welcomescreen);

    }
    public void gotopiano(View view){
        Intent gonext = new Intent(this,MainActivity.class);
        startActivity(gonext);
    }
}
