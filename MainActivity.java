package com.example.proctorbookproject;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class MainActivity extends AppCompatActivity {
    private FirebaseAuth auth;
    private Button btnLogout,tbutton,pbutton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        auth = FirebaseAuth.getInstance();
        btnLogout = findViewById(R.id.btnlogin);
        tbutton=findViewById(R.id.button);
        pbutton=findViewById(R.id.button2);

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                login1();
            }
        });
        tbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login1();
            }
        });
        pbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                login1();
            }
        });
    }

    @Override
    public void onStart()

        {
            super.onStart();
            FirebaseUser currentuser=auth.getCurrentUser();
            if(currentuser==null)
            {
                startActivity(new Intent(MainActivity.this,LecturerInterface.class));

            }
        }
        public void login1() {
        startActivity(new Intent(MainActivity.this,LecturerInterface.class));
    }
}
