package com.example.mail;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

public class MainActivity extends AppCompatActivity implements MyAdapter.AdapterClick{
    static FragmentManager fragmentManager;
    MailList mailList;
    MailView mailView;
    String email = " ";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_act_land);
        email = getIntent().getStringExtra("emailLogged");
        mailList = new MailList(email);
        mailView = new MailView();
        fragmentManager = getSupportFragmentManager();
        fragmentManager
                .beginTransaction()
                .replace(R.id.mails, mailList)
                .commit();
    }
    @Override
    public void AdapterClicked(Mail mail) {
        fragmentManager
                .beginTransaction()
                .replace(R.id.mail, new MailView(mail))
                .commit();
    }
}
