package com.example.contants;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {


    Contact items[];

    public MyAdapter(Contact items[]){
        this.items = items;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.my_row,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.txt.setText(items[position].name);
    }

    @Override
    public int getItemCount() {
        return items.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView txt;

        public MyViewHolder(View view){
            super(view);
            txt = (TextView)view.findViewById(R.id.user_name);
        }

    }
}
