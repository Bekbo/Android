package com.example.contants;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    Contact contacts[] = Database.getContacts();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        MyAdapter myAdapter = new MyAdapter(contacts);
        recyclerView.setAdapter(myAdapter);
    }

    public void onSaveInstanceState(Bundle savedState){
        super.onSaveInstanceState(savedState);
        savedState.putInt("position", 2);
    }

    public void contactClick(View view){
    }
}
