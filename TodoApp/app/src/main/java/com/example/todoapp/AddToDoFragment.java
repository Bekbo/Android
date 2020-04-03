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

public class AddToDoFragment extends Fragment {
    ToDoAdapter.AdapterClick clicked;
    EditText title, description, duration, status, category;
    Button add;
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        clicked = (ToDoAdapter.AdapterClick)context;
    }

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.add_todo_fragment_layout, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        title = view.findViewById(R.id.title);
        description = view.findViewById(R.id.description);
        duration = view.findViewById(R.id.duration);
        status = view.findViewById(R.id.status);
        category = view.findViewById(R.id.category);
        add = view.findViewById(R.id.add);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToDo todo = new ToDo();
                todo.title = title.getText().toString();
                todo.description = description.getText().toString();
                todo.duration = duration.getText().toString();
                todo.status = status.getText().toString();
                todo.cat_id = Integer.parseInt(category.getText().toString());
                clicked.addTodo(todo);
            }
        });
    }
}
