package com.example.mail;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {
    EditText email, password;
    private String pref = "my_acc_info_pref";
    static SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        sharedPreferences = getSharedPreferences(pref, Context.MODE_PRIVATE);

        if(!sharedPreferences.getString("email", "No email.!").equals("No email.!")){
            Intent logged = new Intent(LoginActivity.this, MainActivity.class);
            logged.putExtra("emailLogged", sharedPreferences.getString("email", "No email.!"));
            startActivity(logged);
            finish();
        }
    }
    public void logIn(View v){
        Intent logged = new Intent(LoginActivity.this, MainActivity.class);
        if(sharedPreferences.getString("email", "No email.!").equals("No email.!")){
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("email", email.getText().toString());
            editor.putString("password", password.getText().toString());
            editor.apply();
            logged.putExtra("emailLogged", sharedPreferences.getString("email", "No email.!"));
            startActivity(logged);
            finish();
        }
    }
    public static void logouting(){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
    }

}
