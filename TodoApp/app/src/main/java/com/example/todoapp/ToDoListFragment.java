package com.example.todoapp;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import java.util.List;

public class ToDoListFragment extends Fragment {
    RecyclerView recyclerView;
    List<ToDo> toDoList;
    Button changeToAdd;
    ToDoAdapter.AdapterClick clicked;
    Context cntxt;
    public ToDoListFragment(){}
    public ToDoListFragment(Context context, List<ToDo> toDos){
        this.cntxt = context;
        this.toDoList = toDos;
    }
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
    }

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.todo_list_fragm_layout, container, false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.todolistRecycler);
        ToDoAdapter toDoAdapter = new ToDoAdapter(view.getContext(), toDoList);
        StaggeredGridLayoutManager manager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(toDoAdapter);

        clicked = (ToDoAdapter.AdapterClick) cntxt;
        changeToAdd = view.findViewById(R.id.addTodo);
        changeToAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clicked.changeToAdd();
            }
        });
    }
}
