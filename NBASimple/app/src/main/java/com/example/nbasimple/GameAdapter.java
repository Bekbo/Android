package com.example.nbasimple;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.OffsetDateTime;
import java.util.Date;
import java.util.List;

public class GameAdapter extends RecyclerView.Adapter<GameAdapter.GameViewHolder>{
    Context context;
    List<Game> games;
    Team home,away;
    gameItemClickListener listener;

    public GameAdapter(List<Game> games, Context context){
        this.games = games;
        this.context = context;
    }

    @NonNull
    @Override
    public GameViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_game, parent, false);
        return new GameViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GameViewHolder holder, int position) {
        GameViewHolder myViewHolder = holder;
        int pos = position;
        myViewHolder.layout.setAnimation(AnimationUtils.loadAnimation(context, R.anim.recycler_anim));
        myViewHolder.home_team.setText(games.get(pos).home_team.full_name);
        myViewHolder.away_team.setText(games.get(pos).away_team.full_name);
        myViewHolder.away_team_score.setText(games.get(pos).visitor_team_score + "");
        myViewHolder.home_team_score.setText(games.get(pos).home_team_score+"");
        if (Integer.parseInt(myViewHolder.home_team_score.getText().toString()) > Integer.parseInt(myViewHolder.away_team_score.getText().toString())){
            myViewHolder.home_team_score.setTextColor(Color.GREEN);
            myViewHolder.away_team_score.setTextColor(Color.RED);
        }else if (Integer.parseInt(myViewHolder.home_team_score.getText().toString()) < Integer.parseInt(myViewHolder.away_team_score.getText().toString())){
            myViewHolder.home_team_score.setTextColor(Color.RED);
            myViewHolder.away_team_score.setTextColor(Color.GREEN);
        }
        myViewHolder.status.setText(games.get(pos).status);
        myViewHolder.date.setText(games.get(pos).date.substring(0,10));
        myViewHolder.season.setText(games.get(pos).season + "");
        myViewHolder.home_team.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    MainActivity main = (MainActivity) context;
                    main.fragmentManager
                            .beginTransaction()
                            .replace(R.id.mainFrame,
                                    new TeamDetailsFragment(
                                            games.get(position).home_team.id,
                                            games.get(position).home_team.abbreviation,
                                            context))
                            .addToBackStack("second")
                            .commitAllowingStateLoss();
                }
            });
        myViewHolder.away_team.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity main = (MainActivity) context;
                main.fragmentManager
                        .beginTransaction()
                        .replace(R.id.mainFrame,
                                new TeamDetailsFragment(
                                        games.get(position).away_team.id,
                                        games.get(position).away_team.abbreviation,
                                        context))
                        .addToBackStack("second")
                        .commitAllowingStateLoss();
            }
        });
        myViewHolder.setPosition(position);
    }

    @Override
    public int getItemCount() {
        return games.size();
    }

    public class GameViewHolder extends RecyclerView.ViewHolder {
        TextView home_team, away_team, home_team_score, away_team_score, status, date, season;
        LinearLayout layout;
        int position;
        public GameViewHolder(@NonNull View itemView) {
            super(itemView);
            layout = itemView.findViewById(R.id.game_adapter_layout);
            home_team = itemView.findViewById(R.id.home_team);
            away_team = itemView.findViewById(R.id.away_team);
            home_team_score = itemView.findViewById(R.id.home_team_score);
            away_team_score = itemView.findViewById(R.id.away_team_score);
            status = itemView.findViewById(R.id.status);
            season = itemView.findViewById(R.id.season);
            date = itemView.findViewById(R.id.date);

        }

        public void setPosition(int position) {
            this.position = position;
        }
    }

    public interface gameItemClickListener {
        void teamDetailView(String team, int id);
    }
}
