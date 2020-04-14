package com.example.jobdev;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class JobAdapter extends RecyclerView.Adapter<JobAdapter.MyViewHolder> {
    Context context;
    List<Job> jobs;
    int liked;
    public JobAdapter(Context context, List<Job> jobs, int liked) {
        this.context = context;
        this.jobs = jobs;
        this.liked = liked;
    }
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.job_view, parent, false);
        return new MyViewHolder(view, context);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        MyViewHolder myViewHolder = holder;
        myViewHolder.title.setText(jobs.get(position).getTitle());
        myViewHolder.type.setText(jobs.get(position).getType());
        myViewHolder.created_at.setText(jobs.get(position).getCreatedAt());
        AppDatabase db;
        db = MyApplication.getInstance().getAppDatabase();
        if (db.jobDao().getJob(jobs.get(position).getId())!= null){
            Picasso.get()
                    .load("https://cdn4.iconfinder.com/data/icons/iconza-ios-tab-icons/60/01-heart-active-512.png")
                    .centerCrop()
                    .resize(100,100)
                    .rotate(45)
                    .into(myViewHolder.like);
        }else {
            Picasso.get()
                    .load("https://cdn4.iconfinder.com/data/icons/ios-7-icons/50/like-512.png")
                    .rotate(45)
                    .centerCrop()
                    .resize(100,100)
                    .into(myViewHolder.like);
        }
        Picasso.get()
                .load(jobs.get(position).companyLogo)
                .into(myViewHolder.logo);
        myViewHolder.setPosition(position);
    }

    @Override
    public int getItemCount() {
        return jobs.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        int position;
        TextView title, type, created_at;
        ImageView like, logo;
        public MyViewHolder(@NonNull View view, final Context context){
            super(view);
            title = view.findViewById(R.id.title);
            type = view.findViewById(R.id.type);
            created_at = view.findViewById(R.id.createdat);
            like = view.findViewById(R.id.liked);
            logo = view.findViewById(R.id.logo);

            like.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AppDatabase db;
                    db = MyApplication.getInstance().getAppDatabase();
                    if (db.jobDao().getJob(jobs.get(position).id)!= null){
                        db.jobDao().deleteJob(jobs.get(position).id);
                        jobs = db.jobDao().getJobs();
                        Picasso.get()
                                .load("https://cdn4.iconfinder.com/data/icons/ios-7-icons/50/like-512.png")
                                .rotate(45)
                                .centerCrop()
                                .resize(100,100)
                                .into(like);
                    }else{
                        Picasso.get()
                                .load("https://cdn4.iconfinder.com/data/icons/iconza-ios-tab-icons/60/01-heart-active-512.png")
                                .centerCrop()
                                .resize(100,100)
                                .rotate(45)
                                .into(like);
                        db.jobDao().addJob(jobs.get(position));
                    }
                }
            });
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(context, JobViewFragment.class);
                    i.putExtra("job", jobs.get(position));
                    context.startActivity(i);
                }
            });
        }

        public void setPosition(int position) {
            this.position = position;
        }

    }
}
