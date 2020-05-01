package com.example.nbasimple;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.MenuItemCompat;
import androidx.fragment.app.FragmentManager;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.gson.GsonBuilder;
import java.util.List;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
public class MainActivity extends AppCompatActivity {
    List<Player> result_players;
    ResponsePlayers responsePlayers;
    List<Game> games;
    HttpLoggingInterceptor loggingInterceptor;
    OkHttpClient okHttpClient;
    Retrofit retrofit;
    APIService service;
    Thread th;
    ResponseGames responseGames;
    Toolbar toolbar;
    FragmentManager fragmentManager;
    BottomNavigationView bottomNavigationView;
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        th = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
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
//                    responseTeams = service.getTeams(1,10).execute().body();
                    responseGames = service.getGames(1,10).execute().body();
//                    responsePlayers = service.getPlayers(1,10).execute().body();
                } catch (Exception e){
                    Log.e("Error", e.getMessage());
                } finally {
                    Log.e("Process", "ended");
                }
            }
        });
        th.start();
        while(th.isAlive()){ }
        games = responseGames.data;
        context = this;
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.action_games:
                        toolbar.setTitle("NBA Games");
                        fragmentManager.popBackStack();
                        fragmentManager
                                .beginTransaction()
                                .replace(R.id.mainFrame, new GamesFragment(context, games))
                                .commit();
                        break;
                    case R.id.action_fav:
                        fragmentManager.popBackStack();
                        toolbar.setTitle("Saved Teams");
                        fragmentManager
                                .beginTransaction()
                                .replace(R.id.mainFrame, new SavedTeamsFragment(context))
                                .commit();
                        break;
                    case R.id.action_news:
                        toolbar.setTitle("NBA News");
                        fragmentManager.popBackStack();
                        fragmentManager
                                .beginTransaction()
                                .replace(R.id.mainFrame, new NewsFragment(context))
                                .commit();
                        break;
                }
                return false;
            }
        });

        fragmentManager = getSupportFragmentManager();
        fragmentManager
                .beginTransaction()
                .replace(R.id.mainFrame, new GamesFragment(this, games))
                .commit();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e("mainActiv", "OnRestart");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        MenuItem menuItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(menuItem);

        searchView.setQueryHint("Type to search players");
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Thread src = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try{
                            result_players = service.searchPlayers(1,100, query).execute().body().data;
//                            result_players = responsePlayers.data;
                        }catch (Exception e){
                            Log.e("Error", e.getMessage()+"");
                        }
                    }
                });
                src.start();
                while(src.isAlive()){}
                Log.e("Player", result_players + " " );
                fragmentManager
                        .beginTransaction()
                        .addToBackStack("games")
                        .replace(R.id.mainFrame, new PlayersFragment(context, result_players))
                        .commit();
                return false;
            }
            @Override
            public boolean onQueryTextChange(String newText) {

                return false;
            }
        });
        return true;
    }
}
