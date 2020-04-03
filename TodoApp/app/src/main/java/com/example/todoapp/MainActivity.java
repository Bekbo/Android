package com.example.todoapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.List;

public class MainActivity extends AppCompatActivity implements ToDoAdapter.AdapterClick{
    AppDatabase db;
    FragmentManager fragmentManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager = getSupportFragmentManager();
        db = MyApplication.getInstance().getAppDatabase();
        fragmentManager
                .beginTransaction()
                .replace(R.id.ToDoListFragment, new ToDoListFragment(this,db.toDoDao().getAll()))
                .commit();
    }

    @Override
    public void AdapterClicked(long pos) {
        fragmentManager
                .beginTransaction()
                .replace(R.id.ToDoListFragment, new ToDoDetailFragment(db.toDoDao().getTodo(pos), this))
                .commit();
    }

    @Override
    public void deleteToDo(long id) {
        db.toDoDao().deleteToDo(id);
        fragmentManager
                .beginTransaction()
                .replace(R.id.ToDoListFragment, new ToDoListFragment(this, db.toDoDao().getAll()))
                .commit();
    }

    @Override
    public void updateToDo(long id, String title, String duration, String status, String desc, int cat) {
        db.toDoDao().updateToDo(id, title, duration, status, desc, cat);
        fragmentManager
                .beginTransaction()
                .replace(R.id.ToDoListFragment, new ToDoListFragment(this, db.toDoDao().getAll()))
                .commit();
    }

    @Override
    public void addTodo(ToDo toDo){
        Log.e("e", "Main");
        db.toDoDao().insertToDo(toDo);
        fragmentManager
                .beginTransaction()
                .replace(R.id.ToDoListFragment, new ToDoListFragment(this, db.toDoDao().getAll()))
                .commit();
    }

    @Override
    public void changeToAdd() {
        fragmentManager
                .beginTransaction()
                .replace(R.id.ToDoListFragment, new AddToDoFragment())
                .commit();
    }

    @Override
    public String getCategoryName(long id) {
        return db.categoryDao().getCategory(id).title;
    }
}
