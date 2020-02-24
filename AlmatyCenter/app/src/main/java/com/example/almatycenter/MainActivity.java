package com.example.almatycenter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btn_comfort, btn_finance, btn_edu, btn_profile, btn_health, btn_goal, take_photo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_comfort = (Button)(findViewById(R.id.comfortButton));
        btn_finance = (Button)(findViewById(R.id.financeButton));
        btn_edu = (Button)(findViewById(R.id.educationButton));
        btn_profile = (Button)(findViewById(R.id.profileButton));
        btn_health = (Button)(findViewById(R.id.healthButton));
        btn_goal = (Button)(findViewById(R.id.goalButton));
        take_photo = (Button)(findViewById(R.id.takePhoto));

        btn_comfort.setOnClickListener(this);
        btn_goal.setOnClickListener(this);
        btn_health.setOnClickListener(this);
        btn_health.setOnClickListener(this);
        btn_edu.setOnClickListener(this);
        btn_profile.setOnClickListener(this);
        take_photo.setOnClickListener(this);

    }
    @Override
    public void onClick(View v) {
        if (v.getId()==btn_profile.getId()){
            Toast.makeText(MainActivity.this, "Profile", Toast.LENGTH_SHORT).show();
        }else if(v.getId()==btn_comfort.getId()){
            Toast.makeText(MainActivity.this, "Comfort", Toast.LENGTH_SHORT).show();
        }else if(v.getId()==btn_edu.getId()){
            Toast.makeText(MainActivity.this, "Education", Toast.LENGTH_SHORT).show();
        }else if(v.getId()==btn_health.getId()){
            Toast.makeText(MainActivity.this, "Health", Toast.LENGTH_SHORT).show();
        }else if(v.getId()==btn_finance.getId()){
            Toast.makeText(MainActivity.this, "Finance", Toast.LENGTH_SHORT).show();
        }else if(v.getId()==btn_goal.getId()){
            Toast.makeText(MainActivity.this, "Goal", Toast.LENGTH_SHORT).show();
        }else if(v.getId()==take_photo.getId()){
            take_photo.setText("Изменено !");
        }
    }
}