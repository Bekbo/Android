package com.example.nbasimple;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.google.gson.GsonBuilder;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class TeamDetailsFragment extends Fragment {
    Context context;
    Team team;
    List<PlayersTeam> teamPlayers = new ArrayList<PlayersTeam>();
    RecyclerView players_recycler;
    TextView team_full_name, team_city, team_conference, team_division;
    PlayersAdapter adapter;
    ImageView liked_status;
    boolean favourite = false;

    public TeamDetailsFragment(Team team, Context context){
        this.team = team;
        this.context = context;
        this.teamPlayers = getPlayers(team.abbreviation);
    }

    public TeamDetailsFragment(int teamId, String teamAbr, Context context){
        this.team = getTeam(teamId);
        this.teamPlayers = getPlayers(teamAbr);
        this.context = context;
    }
    public void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        MainActivity main = (MainActivity)context;
        main.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        main.getSupportActionBar().setDisplayShowHomeEnabled(true);
        main.getSupportActionBar().setTitle("Team Details");
    }

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.team_details_fragment, container, false);
        liked_status = view.findViewById(R.id.like_status);
        team_full_name = view.findViewById(R.id.team_full_name);
        team_city = view.findViewById(R.id.team_city);
        AppDatabase db = MyApplication.getInstance().getAppDatabase();
        Picasso.get().load("https://cdn4.iconfinder.com/data/icons/ios-7-icons/50/like-512.png").rotate(45).into(liked_status);
        if(db.teamDao().getTeam(team.id)!=null){
            Picasso.get().load("https://cdn4.iconfinder.com/data/icons/iconza-ios-tab-icons/60/01-heart-active-512.png").rotate(45).into(liked_status);
            favourite = true;
        }
        liked_status.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("db", "clicked");
                if(favourite){
                    Log.e("Deleted", "true");
                    db.teamDao().deleteTeam(team.id);
                    Picasso.get().load("https://cdn4.iconfinder.com/data/icons/ios-7-icons/50/like-512.png").rotate(45).centerCrop().resize(50,50).into(liked_status);
                    favourite = false;
                }else{
                    Log.e("Added", "true");
                    db.teamDao().addTeam(team);
                    Picasso.get().load("https://cdn4.iconfinder.com/data/icons/iconza-ios-tab-icons/60/01-heart-active-512.png").rotate(45).centerCrop().resize(50,50).into(liked_status);
                    favourite = true;
                }
                Log.e("Size", MyApplication.getInstance().getAppDatabase().teamDao().getTeams().size()+"");
            }
        });
        team_conference = view.findViewById(R.id.team_conf);
        team_division = view.findViewById(R.id.team_division);
        team_full_name.setText(team.full_name);
        team_division.setText("Division : " + team.division);
        team_conference.setText("Conference : " + team.conference);
        team_city.setText("City : " + team.city);
        players_recycler = view.findViewById(R.id.team_players);
        StaggeredGridLayoutManager manager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
        adapter = new PlayersAdapter(teamPlayers, context);
        players_recycler.setLayoutManager(manager);
        players_recycler.setAdapter(adapter);
        return view;
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        Log.e("TeamDetailsFragment", "Destroy");
    }

    List<PlayersTeam> pls = new ArrayList<PlayersTeam>();

    public List<PlayersTeam> getPlayers(String team){
        Thread th;
        th = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    HttpLoggingInterceptor loggingInterceptor;
                    OkHttpClient okHttpClient;
                    Retrofit retrofit2;
                    APIService service2;
                    loggingInterceptor = new HttpLoggingInterceptor();
                    loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
                    okHttpClient = new OkHttpClient.Builder()
                            .addInterceptor(loggingInterceptor)
                            .connectTimeout(30, TimeUnit.SECONDS)
                            .build();
                    retrofit2 = new Retrofit.Builder()
                            .baseUrl("https://api.sportsdata.io/v3/nba/stats/json/")
                            .addConverterFactory(GsonConverterFactory.create(new GsonBuilder().create()))
                            .client(okHttpClient)
                            .build();
                    service2 = retrofit2.create(APIService.class);
                    pls = service2.getPlayerofTeam(team).execute().body();
                } catch (Exception e){
                    Log.e("Error", e.getMessage());
                } finally {
                    Log.e("Process", "ended");
                }
            }
        });
        th.start();
        while(th.isAlive()){ }
        return pls;
    }
    Team t;

    public Team getTeam(int teamId){
        Thread th = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    HttpLoggingInterceptor loggingInterceptor;
                    OkHttpClient okHttpClient;
                    Retrofit retrofit, retrofit2;
                    APIService service, service2;
                    Thread th;
                    loggingInterceptor = new HttpLoggingInterceptor();
                    loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
                    okHttpClient = new OkHttpClient.Builder()
                            .addInterceptor(loggingInterceptor)
                            .connectTimeout(30, TimeUnit.SECONDS)
                            .build();
                    retrofit = new Retrofit.Builder()
                            .baseUrl("https://free-nba.p.rapidapi.com/")
                            .addConverterFactory(GsonConverterFactory.create(new GsonBuilder().create()))
                            .client(okHttpClient)
                            .build();
                    service = retrofit.create(APIService.class);
                    t = service.getTeam(teamId, 1, 1).execute().body();
                }
                catch (Exception e){}
            }
        });
        th.start();
        while(th.isAlive()){ }
        return t;
    }
}
