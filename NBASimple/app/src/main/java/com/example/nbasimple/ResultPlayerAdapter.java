package com.example.nbasimple;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ResultPlayerAdapter extends RecyclerView.Adapter<ResultPlayerAdapter.ResultPlayerView>{
    Context context;
    List<Player> players;

    public ResultPlayerAdapter(){}
    public ResultPlayerAdapter(List<Player> players, Context context){
        this.context = context;
        this.players = players;
    }

    @NonNull
    @Override
    public ResultPlayerView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.players_result_adapter, parent, false);
        return new ResultPlayerAdapter.ResultPlayerView(view, context);
    }

    @Override
    public void onBindViewHolder(@NonNull ResultPlayerView holder, int position) {
        ResultPlayerView viewholder = holder;
        viewholder.players_result_adapter.setAnimation(AnimationUtils.loadAnimation(context,R.anim.recycler_anim));
        viewholder.fullname.setText(players.get(position).firstName + " " + players.get(position).lastName + " " + players.get(position).position);
        viewholder.team_abb.setText(players.get(position).team.abbreviation + " " + players.get(position).team.city);
        viewholder.result_player_info.setText("Plays on Division : " + players.get(position).team.division);
        viewholder.team_abb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity main = (MainActivity)context;
                main.fragmentManager
                        .beginTransaction()
                        .replace(R.id.mainFrame, new TeamDetailsFragment(players.get(position).team, context))
                        .addToBackStack("games")
                        .commitAllowingStateLoss();
            }
        });
        viewholder.setPosition(position);
    }

    @Override
    public int getItemCount() {
        return players.size();
    }

    public class ResultPlayerView extends RecyclerView.ViewHolder{
        int position;
        TextView fullname, team_abb, result_player_info;
        LinearLayout players_result_adapter;
        public ResultPlayerView(@NonNull View itemView, Context context) {
            super(itemView);
            players_result_adapter = itemView.findViewById(R.id.players_result_adapter);
            fullname = itemView.findViewById(R.id.result_player_fullname);
            team_abb = itemView.findViewById(R.id.result_player_team);
            result_player_info = itemView.findViewById(R.id.result_player_info);
        }
        public void setPosition(int position) {
            this.position = position;
        }
    }
}
