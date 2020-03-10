package com.example.mail;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{
    Context context;
    Mail mails[];
    private AdapterClick clicked;

    public MyAdapter(Context context, Mail[] mails){
        this.context = context;
        this.mails = mails;
        clicked = (AdapterClick)context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.mail_view, parent, false);
        return new MyViewHolder(view, context);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        MyViewHolder myViewHolder = holder;
        myViewHolder.user.setText(mails[position].from_user);
        myViewHolder.title.setText(mails[position].title);
        myViewHolder.setPosition(position);
    }

    @Override
    public int getItemCount() {
        return mails.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView user, title;
        int position;

        public MyViewHolder(@NonNull View view, final Context context){
            super(view);
            user = view.findViewById(R.id.user);
            title = view.findViewById(R.id.title);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    clicked.AdapterClicked(mails[position]);
                }
            });
        }

        public void setPosition(int position) {
            this.position = position;
        }

    }

    interface AdapterClick{
        void AdapterClicked(Mail mail);
    }
}
