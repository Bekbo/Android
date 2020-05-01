package com.example.nbasimple;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import java.util.List;

public class SavedTeamsFragment extends Fragment {
    RecyclerView recyclerView;
    List<Team> teams;
    Context cntxt;
    AppDatabase db;
    public SavedTeamsFragment(){}
    public SavedTeamsFragment(Context context){
        this.cntxt = context;
        db = MyApplication.getInstance().getAppDatabase();
        teams = db.teamDao().getTeams();
        MainActivity main = (MainActivity)context;
        main.getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        main.getSupportActionBar().setDisplayShowHomeEnabled(false);
    }
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.saved_teams, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.saved_teams_recycler);
        TeamsAdapter teamsAdapter = new TeamsAdapter(cntxt, teams);
        StaggeredGridLayoutManager manager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(teamsAdapter);
    }

    @Override
    public void onResume() {
        super.onResume();
        MainActivity main = (MainActivity)cntxt;
        main.getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        main.getSupportActionBar().setDisplayShowHomeEnabled(false);
    }
}
