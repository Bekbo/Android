package com.example.contants;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    Context context;
    Contact items[];

    public MyAdapter(Contact items[], Context context){
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.activity_contact_view, parent, false);
        return new MyViewHolder(view, context);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        MyViewHolder myViewHolder = holder;
        myViewHolder.txt_name.setText(items[position].name);
        myViewHolder.txt_work.setText(items[position].work);
        myViewHolder.setPosition(position);
    }

    @Override
    public int getItemCount() {
        return items.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView txt_name, txt_work;
        int position;

        public MyViewHolder(@NonNull View view, final Context context){
            super(view);
            txt_name = view.findViewById(R.id.contact_name);
            txt_work = view.findViewById(R.id.contact_work);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent view_contact = new Intent( context, ContactView.class);
                    view_contact.putExtra("pos", position);
                    context.startActivity(view_contact);
                }
            });
        }

        public void setPosition(int position) {
            this.position = position;
        }

    }
}
