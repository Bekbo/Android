package com.example.nbasimple;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
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
import java.util.Random;

public class NewsAdapter  extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder>{
    Context context;
    List<News> news;
    int images[] = {R.drawable.news1,R.drawable.news2,R.drawable.news3, R.drawable.nba_logo};
    public NewsAdapter(){}
    public NewsAdapter(Context context, List<News> news){
        this.context = context;
        this.news = news;
    }

    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.news_adapter, parent, false);
        return new NewsViewHolder(view, context);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder holder, int position) {
        NewsViewHolder newsViewHolder = holder;
        newsViewHolder.layout.setAnimation(AnimationUtils.loadAnimation(context,R.anim.favourite_anim));
        newsViewHolder.title.setText(news.get(position).title);
        Random r = new Random();
        newsViewHolder.news_photo.setImageResource(images[r.nextInt(images.length)]);
        newsViewHolder.body.setText(news.get(position).timeAgo + " : " + news.get(position).content);
        newsViewHolder.author.setText("Updated : " + news.get(position).updated.substring(0,10) + " " + news.get(position).source + " Author :" + news.get(position).author);
        newsViewHolder.news_link_hasgtag.setText("#" + news.get(position).categories+" #" + news.get(position).team + " #" + news.get(position).url);
        newsViewHolder.news_link_hasgtag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW).setData(Uri.parse(news.get(position).url));
                context.startActivity(i);
            }
        });
        newsViewHolder.setPosition(position);
    }

    @Override
    public int getItemCount() {
        return news.size();
    }

    public class NewsViewHolder extends RecyclerView.ViewHolder{
        int position;
        TextView title, body, author, news_link_hasgtag;
        ImageView news_photo;
        LinearLayout layout;
        public NewsViewHolder(@NonNull View itemView, final Context context) {
            super(itemView);
            layout = itemView.findViewById(R.id.news_adapter_layout);
            news_photo = itemView.findViewById(R.id.news_photo);
            title = itemView.findViewById(R.id.news_title);
            body = itemView.findViewById(R.id.news_body);
            author = itemView.findViewById(R.id.news_author);
            news_link_hasgtag = itemView.findViewById(R.id.news_link_hasgtag);
        }

        public void setPosition(int position) {
            this.position = position;
        }
    }
}
