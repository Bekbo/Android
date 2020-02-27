package com.example.contants;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;


import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class ContactView extends MainActivity{
    Contact contact;
    TextView name, number, work;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_one_contact);
        name = findViewById(R.id.contact_name);
        number = findViewById(R.id.contact_number);
        work = findViewById(R.id.contact_work);
        Intent i = getIntent();

        contact = Database.getContact(i.getIntExtra("pos", 0));

        name.setText("Name : " + contact.name);
        number.setText("Phone Number : " + contact.number);
        work.setText("Work : " + contact.work);
    }

    public void call(View view){
        Intent callIntent = new Intent(Intent.ACTION_CALL);
        callIntent.setData(Uri.parse("tel:" + contact.number));
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE)
                != PackageManager.PERMISSION_GRANTED){
            Toast.makeText(this,"Please, Grant Permission", Toast.LENGTH_LONG).show();
            requestPermission();
        }else{
            startActivity(callIntent);
        }
    }

    private void requestPermission(){
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE}, 1);
    }
}
