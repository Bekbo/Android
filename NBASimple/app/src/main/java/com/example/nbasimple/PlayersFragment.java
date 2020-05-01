package com.example.nbasimple;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import java.util.List;

public class PlayersFragment extends Fragment {
    List<Player> players;
    Context context;
    RecyclerView players_recycler;
    ResultPlayerAdapter adapter;

    public PlayersFragment(){}
    public PlayersFragment(Context context, List<Player> result){
        this.context = context;
        this.players = result;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MainActivity main = (MainActivity)context;
        main.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        main.getSupportActionBar().setDisplayShowHomeEnabled(true);
        main.getSupportActionBar().setTitle("Players");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.players_result, container, false);
        players_recycler = view.findViewById(R.id.team_players);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        StaggeredGridLayoutManager manager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
        adapter = new ResultPlayerAdapter(players, context);
        players_recycler.setLayoutManager(manager);
        players_recycler.setAdapter(adapter);
    }
}
