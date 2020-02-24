package com.example.contants;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ContactView extends AppCompatActivity {
    Contact contact;
    TextView name, number, work;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_view);
        name = findViewById(R.id.contact_name);
        number = findViewById(R.id.contact_number);
        work = findViewById(R.id.contact_work);
    }

    public void onRestoreInstanceState(Bundle savedState){
        super.onRestoreInstanceState(savedState);
        contact = Database.getContact(savedState.getInt("position"));
        name.setText(contact.name);
        number.setText(contact.number);
        work.setText(contact.work);
    }
}
