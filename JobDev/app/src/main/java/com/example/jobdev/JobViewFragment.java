package com.example.jobdev;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.ms.square.android.expandabletextview.ExpandableTextView;
import com.squareup.picasso.Picasso;


public class JobViewFragment extends AppCompatActivity {
    Toolbar toolbar;
    TextView companyName, createdAt, title, location, type, description, companyInfo;
    ImageView companyLogo;
    Job job;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent i = getIntent();
        job = i.getParcelableExtra("job");
        setContentView(R.layout.job_view_fragment);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        companyLogo = findViewById(R.id.logo);

        companyName = findViewById(R.id.companyName);
        createdAt = findViewById(R.id.createdat);
        title = findViewById(R.id.title);
        location = findViewById(R.id.location);
        type = findViewById(R.id.type);
        description = findViewById(R.id.description);
        companyInfo = findViewById(R.id.companyinfo);

        companyName.setText(job.getCompany());
        createdAt.setText(job.getCreatedAt());
        title.setText(job.getTitle());
        type.setText(job.getType());
        location.setText(job.getLocation());
        description.setText(job.getDescription());
        companyInfo.setText(job.getCompanyUrl());

        Picasso.get()
                .load(job.companyLogo)
                .into(companyLogo);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
//        MenuItem menuItem = menu.findItem(R.id.action_search);
//        SearchView searchView = (SearchView)menuItem.getActionView();
//        searchView.setQueryHint("Type to search by title");
        return true;
    }




}
