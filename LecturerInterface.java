package com.example.proctorbookproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LecturerInterface extends AppCompatActivity {
    private FirebaseAuth auth;
    private EditText email,password;
    private Button btnLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lecturer_interface);
        auth=FirebaseAuth.getInstance();
        email=findViewById(R.id.username);
        password=findViewById(R.id.password);
        btnLogin=findViewById(R.id.submit);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });

    }
    private void login()
    {
        String user=email.getText().toString().trim();
        String pass=password.getText().toString().trim();
        user=user+"@vrsec.ac.in";
        if(user.isEmpty())
        {
           email.setError("Username can't be empty");
        }
        if(pass.isEmpty())
        {
            password.setError("Password can't be empty");
        }
        else
        {
            auth.signInWithEmailAndPassword(user,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                   if(task.isSuccessful())
                   {
                       Toast.makeText(LecturerInterface.this,"Login Successful",Toast.LENGTH_SHORT).show();
                       startActivity(new Intent(LecturerInterface.this,studentinterface.class));

                   }
                   else
                   {
                       Toast.makeText(LecturerInterface.this,"Login Failed!",Toast.LENGTH_SHORT).show();
                   }
                }
            });
        }
    }
}