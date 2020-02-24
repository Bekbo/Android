package com.example.app1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btn_comfort, btn_finance, btn_edu, btn_profile, btn_health, btn_goal;

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

        btn_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Profile", Toast.LENGTH_SHORT).show();
            }
        });
        btn_health.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Health", Toast.LENGTH_SHORT).show();
            }
        });
        btn_comfort.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Comfort", Toast.LENGTH_SHORT).show();
            }
        });
        btn_edu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Edu", Toast.LENGTH_SHORT).show();
            }
        });
        btn_finance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Finance", Toast.LENGTH_SHORT).show();
            }
        });
        btn_goal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Goal", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
