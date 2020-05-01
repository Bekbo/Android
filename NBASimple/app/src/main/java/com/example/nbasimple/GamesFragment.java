package com.example.nbasimple;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class GamesFragment extends Fragment {
    public List<Game> games = new ArrayList<>();
    private Retrofit retrofit;
    static int page = 1;
    private APIService service;
    private HttpLoggingInterceptor loggingInterceptor;
    private OkHttpClient okHttpClient;
    RecyclerView recyclerView;
    GameAdapter adapter;
    GameAdapter.gameItemClickListener listener;
    Button next, prev;
    Context context;
    public GamesFragment(){}
    public GamesFragment(Context context, List<Game> games ){
        this.games = games;
        this.context = context;
        MainActivity main = (MainActivity)context;
        main.getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        main.getSupportActionBar().setDisplayShowHomeEnabled(false);
        main.getSupportActionBar().setTitle("NBA Games");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        Log.e("Games", "OnCreate");
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
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.games, container, false);
//        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("NBA Games");
//        setHasOptionsMenu(true);
        next = view.findViewById(R.id.next);
        int nextP = page+1, prevP = page - 1;
        next.setText("Next -> " + nextP );

        prev = view.findViewById(R.id.prev);
        prev.setText(prevP + " <- Previous");
        if (prevP == 0){
            prev.setVisibility(View.INVISIBLE);
        }

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Thread th = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try{
                            page = page + 1;
                            games = service.getGames(page, 10).execute().body().data;
                        }catch (Exception e){
                            Log.e("Error", e.getMessage());
                        }
                    }
                });
                th.start();
                while(th.isAlive()){}
                getFragmentManager()
                        .beginTransaction()
                        .replace(R.id.mainFrame, new GamesFragment(context, games))
                        .commit();

            }
        });
        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Thread th = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        if (page - 1 > 0) {
                            try {
                                page = page - 1;
                                games = service.getGames(page, 10).execute().body().data;
                            } catch (Exception e) {
                                Log.e("Error", e.getMessage());
                            }
                        }
                    }
                });
                th.start();
                while(th.isAlive()){}
                getFragmentManager()
                        .beginTransaction()
                        .replace(R.id.mainFrame, new GamesFragment(context, games))
                        .commit();
            }
        });
        recyclerView = view.findViewById(R.id.recyclerView);
        StaggeredGridLayoutManager manager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
        adapter = new GameAdapter(games, this.context);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(manager);
        return view;
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.e("Games", "OnResume");
        MainActivity main = (MainActivity)context;
        main.getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        main.getSupportActionBar().setDisplayShowHomeEnabled(false);
        main.getSupportActionBar().setTitle("NBA Games");
    }


    @Override
    public void onPause() {
        super.onPause();
        Log.e("Games", "onPause");

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e("Destroyed", "GamesFragment");
    }
}
