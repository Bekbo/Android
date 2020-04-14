package com.example.jobdev;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import java.util.List;

public class LikedFragment extends Fragment {
    RecyclerView recyclerView;
    List<Job> jobs;
    Context cntxt;
    AppDatabase db;
    public LikedFragment(){}
    public LikedFragment(Context context){
        this.cntxt = context;
    }
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
    }

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.jobs_fragment, container, false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        db = MyApplication.getInstance().getAppDatabase();
        jobs = db.jobDao().getJobs();
        recyclerView = view.findViewById(R.id.jobsrecycler);
        JobAdapter jobAdapter = new JobAdapter(view.getContext(), jobs, 1);
        StaggeredGridLayoutManager manager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(jobAdapter);
    }
}
