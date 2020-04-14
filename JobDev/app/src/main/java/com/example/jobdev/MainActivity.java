package com.example.jobdev;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.core.view.MenuItemCompat;
import androidx.fragment.app.FragmentManager;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    Context main;
    FragmentManager fragmentManager;
    Toolbar toolbar;
    List<Job> jobs;
    HttpLoggingInterceptor loggingInterceptor;
    OkHttpClient okHttpClient;
    Retrofit retrofit;
    APIService service;
    Thread th;
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
                            .baseUrl("https://jobs.github.com/")
                            .addConverterFactory(GsonConverterFactory.create(new GsonBuilder().create()))
                            .client(okHttpClient)
                            .build();
                    service = retrofit.create(APIService.class);
//                    jobs = service.getJobByTitle("Frontend Developer-Corporate Systems").execute().body();
//                    Log.e("Size", jobs.size()+"");
                    jobs = service.getJobs().execute().body();
//                    jobs.add(service.getJobById("ad3ad504-dcb8-4ae4-88bc-bd6867e3a2f2").execute().body());
//                    jobs.add(service.getJobById("60a1853a-f79d-4078-b079-f8cef48df405").execute().body());
                } catch (Exception e){
                    Log.e("E", e.getMessage()+ " asdasdasdas");
                } finally {
                    Log.e("A", "ended");
                }
            }
        });
        th.start();
        while(th.isAlive()){ Log.e("Load", "ing");}
        fragmentManager = getSupportFragmentManager();
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        main = this;
        fragmentManager
                .beginTransaction()
                .replace(R.id.mainFrame, new JobsFragment(this, jobs))
                .commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        MenuItem menuItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(menuItem);

        searchView.setQueryHint("Type to search by title");
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }
            @Override
            public boolean onQueryTextChange(String newText) {
                Log.e("Search", newText);
                List<Job> result = new ArrayList<Job>();
                for (Job job : jobs){
                    if (job.title.contains(newText))
                        result.add(job);
                }
                fragmentManager
                        .beginTransaction()
                        .replace(R.id.mainFrame, new JobsFragment(main, result))
                        .commit();
                return false;
            }
        });
        return true;
    }

    //    @Override
//    public boolean onOptionsItemSelected(MenuItem item){
//        int id = item.getItemId();
//
//        if(id == R.id.search){
//            Toast.makeText(this, "Search", Toast.LENGTH_LONG);
//        }else if (id == R.id.filter){
//            Toast.makeText(this, "Filter", Toast.LENGTH_LONG);
//        }else{
//            Toast.makeText(this, "Something", Toast.LENGTH_LONG);
//        }
//        return true;
//    }

    public void openLiked(View view) {
        fragmentManager
                .beginTransaction()
                .replace(R.id.mainFrame, new LikedFragment(this))
                .commit();
    }

    public void openJobs(View view){
        fragmentManager
                .beginTransaction()
                .replace(R.id.mainFrame, new JobsFragment(this, jobs))
                .commit();
    }

}
