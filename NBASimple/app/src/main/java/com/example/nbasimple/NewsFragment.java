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

import com.google.gson.GsonBuilder;

import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NewsFragment extends Fragment {
    Context context;
    RecyclerView news_recycler;
    HttpLoggingInterceptor loggingInterceptor;
    OkHttpClient okHttpClient;
    Retrofit retrofit;
    APIService service;
    Thread th;
    List<News> news;
    public NewsFragment(){}
    public NewsFragment(Context cntxt){
        this.context = cntxt;
        MainActivity main = (MainActivity)context;
        main.getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        main.getSupportActionBar().setDisplayShowHomeEnabled(false);
    }

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.news_list, container, false);
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
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
                            .baseUrl("https://api.sportsdata.io/v3/nba/scores/json/")
                            .addConverterFactory(GsonConverterFactory.create(new GsonBuilder().create()))
                            .client(okHttpClient)
                            .build();
                    service = retrofit.create(APIService.class);
//                    responseTeams = service.getTeams(1,10).execute().body();
                    news = service.getNews().execute().body();
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
        news_recycler = view.findViewById(R.id.news_recycler);
        NewsAdapter newsAdapter = new NewsAdapter(context, news);
        StaggeredGridLayoutManager manager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
        news_recycler.setLayoutManager(manager);
        news_recycler.setAdapter(newsAdapter);
        Log.e("News", news.size() + " items");
    }

}
