package com.example.todoapp;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ToDoDetailFragment extends Fragment {
    ToDo toDo;
    EditText title, description, status, category, duration;
    Button save, delete;
    ToDoAdapter.AdapterClick clicked;

    public ToDoDetailFragment(){}
    public ToDoDetailFragment(ToDo toDo, Context context){
        this.toDo = toDo;
        clicked = (ToDoAdapter.AdapterClick) context;
    }
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.todo_detail_fragment, container, false);
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        title = view.findViewById(R.id.title);
        description = view.findViewById(R.id.description);
        status = view.findViewById(R.id.status);
        category = view.findViewById(R.id.category);
        duration = view.findViewById(R.id.duration);

        title.setText(toDo.title); description.setText(toDo.description);
        status.setText(toDo.status); category.setText(toDo.cat_id+"");
        duration.setText(toDo.duration);
        save = view.findViewById(R.id.save);
        delete = view.findViewById(R.id.delete);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clicked = (ToDoAdapter.AdapterClick) v.getContext();
                clicked.updateToDo(toDo.id, title.getText().toString(), duration.getText().toString(), status.getText().toString()
                        , description.getText().toString(), Integer.parseInt(category.getText().toString()));
            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clicked = (ToDoAdapter.AdapterClick) v.getContext();
                clicked.deleteToDo(toDo.id);
            }
        });
    }
}
