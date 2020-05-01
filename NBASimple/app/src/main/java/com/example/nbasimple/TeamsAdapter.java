package com.example.nbasimple;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class TeamsAdapter extends RecyclerView.Adapter<TeamsAdapter.TeamViewHolder>{
    Context context;
    List<Team> teams;
    public TeamsAdapter(){}
    public TeamsAdapter(Context context, List<Team> teams){
        this.context = context;
        this.teams = teams;
    }

    @NonNull
    @Override
    public TeamViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.saved_team_view, parent, false);
        return new TeamViewHolder(view, context);
    }

    @Override
    public void onBindViewHolder(@NonNull TeamViewHolder holder, int position) {
        TeamViewHolder teamViewHolder = holder;
        teamViewHolder.layout.setAnimation(AnimationUtils.loadAnimation(context,R.anim.favourite_anim));
        teamViewHolder.abbreviation.setText(teams.get(position).abbreviation);
        teamViewHolder.full_name.setText(teams.get(position).full_name);
        teamViewHolder.division.setText("Division : "+ teams.get(position).division);
        Picasso.get()
                .load("https://cdn4.iconfinder.com/data/icons/iconza-ios-tab-icons/60/01-heart-active-512.png")
                .centerCrop()
                .resize(100,100)
                .rotate(45)
                .into(teamViewHolder.liked);
        teamViewHolder.setPosition(position);
        teamViewHolder.liked.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppDatabase db = MyApplication.getInstance().getAppDatabase();
                db.teamDao().deleteTeam(teams.get(position).id);
                teams.remove(position);
                MainActivity main = (MainActivity)context;
                main.fragmentManager
                        .beginTransaction()
                        .replace(R.id.mainFrame, new SavedTeamsFragment(context))
                        .commitAllowingStateLoss();
            }
        });
        teamViewHolder.abbreviation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity main = (MainActivity)context;
                main.fragmentManager
                        .beginTransaction()
                        .replace(R.id.mainFrame, new TeamDetailsFragment(teams.get(position), context))
                        .addToBackStack("second")
                        .commit();
            }
        });
    }

    @Override
    public int getItemCount() {
        return teams.size();
    }

    public class TeamViewHolder extends RecyclerView.ViewHolder{
        int position;
        TextView abbreviation, full_name, division;
        ImageView liked;
        LinearLayout layout;
        public TeamViewHolder(@NonNull View itemView, final Context context) {
            super(itemView);
            layout = itemView.findViewById(R.id.saved_game_layout);
            abbreviation = itemView.findViewById(R.id.abbreviation);
            full_name = itemView.findViewById(R.id.saved_team_full_name);
            division = itemView.findViewById(R.id.saved_team_div);
            liked = itemView.findViewById(R.id.liked);
        }

        public void setPosition(int position) {
            this.position = position;
        }
    }
}
