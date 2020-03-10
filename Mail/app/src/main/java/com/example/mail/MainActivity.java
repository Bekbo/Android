package com.example.mail;

import android.os.Bundle;
import androidx.fragment.app.FragmentManager;

public class MainActivity extends LoginActivity implements MyAdapter.AdapterClick{
    static FragmentManager fragmentManager;
    MailList mailList;
    MailView mailView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_act_land);

        mailList = new MailList();
        mailView = new MailView();
        fragmentManager = getSupportFragmentManager();

        fragmentManager
                .beginTransaction()
                .replace(R.id.mails, new MailList())
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
