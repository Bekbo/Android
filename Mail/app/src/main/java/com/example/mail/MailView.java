package com.example.mail;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


public class MailView extends Fragment {
    TextView title, body, user;
    Mail mail;
    int pos;

    public MailView(){
        this.pos = -1;
    }

    public MailView(Mail mail){
        this.mail = mail;
    }

    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
    }

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.selected_mail_view, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (pos != -1) {
            title = view.findViewById(R.id.title);
            body = view.findViewById(R.id.body);
            user = view.findViewById(R.id.user);
            title.setText(mail.title);
            body.setText(mail.body);
            user.setText(mail.from_user);
        }
    }
}