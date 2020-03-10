package com.example.mail;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    EditText email, password;
    String emailText = "noreply@agendize.com", passwordText = "1";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);
        email = findViewById(R.id.email);
        email.setText(emailText);
        password = findViewById(R.id.password);
    }

    public void logIn(View v){
        Intent logged = new Intent(LoginActivity.this, MainActivity.class);
        logged.putExtra("email", emailText);
        startActivity(logged);
        if (email.getText().toString() == emailText){
            if (password.getText().toString() == passwordText){
                Intent logged1 = new Intent(LoginActivity.this, MainActivity.class);
                logged.putExtra("email", emailText);
                startActivity(logged1);
            }else{
                Toast.makeText(this,"Wrong password", Toast.LENGTH_LONG).show();
            }
        }else{
            Toast.makeText(this,"Wrong email", Toast.LENGTH_LONG).show();
        }
    }
}
