package com.example.todoapp;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ToDoAdapter extends RecyclerView.Adapter<ToDoAdapter.MyViewHolder>{
    Context context;
    List<ToDo> toDos;
    private AdapterClick clicked;
    public ToDoAdapter(Context context, List<ToDo> toDos){
        this.context = context;
        this.toDos = toDos;
        clicked = (AdapterClick)context;
    }
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_view, parent, false);
        return new MyViewHolder(view, context);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        MyViewHolder myViewHolder = holder;
        myViewHolder.title.setText( toDos.get(position).id+"."+toDos.get(position).title);
        myViewHolder.status.setText(toDos.get(position).status);
        myViewHolder.category.setText(clicked.getCategoryName(toDos.get(position).cat_id));
        myViewHolder.id = toDos.get(position).id;
        myViewHolder.setPosition(position);
    }

    @Override
    public int getItemCount() {
        return toDos.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView title,status,category;
        long id;
        int position;

        public MyViewHolder(@NonNull View view, final Context context){
            super(view);
            title = view.findViewById(R.id.title);
            status = view.findViewById(R.id.status);
            category = view.findViewById(R.id.category);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    clicked.AdapterClicked(id);
                }
            });
        }

        public void setPosition(int position) {
            this.position = position;
        }

    }

    interface AdapterClick{
        void AdapterClicked(long pos);
        void deleteToDo(long pos);
        void updateToDo(long id, String title, String duration, String status, String desc, int cat);
        void addTodo(ToDo toDo);
        void changeToAdd();
        String getCategoryName(long id);
    }
}
