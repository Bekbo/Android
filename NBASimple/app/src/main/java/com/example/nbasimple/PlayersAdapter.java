package com.example.nbasimple;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class PlayersAdapter extends RecyclerView.Adapter<PlayersAdapter.PlayerViewHolder>{
    Context context;
    List<PlayersTeam> playersTeam;
    GameAdapter.gameItemClickListener listener;

    public PlayersAdapter(List<PlayersTeam> playersTeam, Context context){
        this.playersTeam = playersTeam;
        this.context = context;
    }

    @NonNull
    @Override
    public PlayersAdapter.PlayerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_players, parent, false);
        return new PlayersAdapter.PlayerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PlayersAdapter.PlayerViewHolder holder, int position) {
        PlayersAdapter.PlayerViewHolder myViewHolder = holder;
        int pos = position;
        try{
            myViewHolder.player_full_name.setText(playersTeam.get(pos).firstName + " / " + playersTeam.get(pos).lastName);
            Picasso.get().load(playersTeam.get(pos).photoUrl)
                    .centerCrop()
                    .resize(100,100)
                    .into(myViewHolder.player_img);
            myViewHolder.player_position.setText("Position : " + playersTeam.get(pos).position + " " + playersTeam.get(pos).positionCategory);
            myViewHolder.player_injury_status.setText("Injury Status : " + playersTeam.get(pos).injuryStatus);
            myViewHolder.player_birth_date.setText(playersTeam.get(pos).birthDate.substring(0,10));
        }
        catch (Exception e){
        }
        myViewHolder.setPosition(position);
    }

    @Override
    public int getItemCount() {
        return playersTeam.size();
    }

    public class PlayerViewHolder extends RecyclerView.ViewHolder {
        int position;
        TextView player_full_name, player_position, player_injury_status, player_birth_date;
        ImageView player_img;
        public PlayerViewHolder(@NonNull View itemView) {
            super(itemView);
            player_full_name = itemView.findViewById(R.id.player_full_name);
            player_birth_date = itemView.findViewById(R.id.player_birth_date);
            player_img = itemView.findViewById(R.id.player_img);
            player_injury_status = itemView.findViewById(R.id.player_injury_status);
            player_position = itemView.findViewById(R.id.player_position);
        }

        public void setPosition(int position) {
            this.position = position;
        }
    }
}
