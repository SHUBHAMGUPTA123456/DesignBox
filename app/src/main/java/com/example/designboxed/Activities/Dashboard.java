package com.example.designboxed.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.designboxed.Model.ModelAssignedSurvey;
import com.example.designboxed.databinding.ActivityDashboardBinding;

import java.util.ArrayList;
import java.util.List;

public class Dashboard extends AppCompatActivity {
ActivityDashboardBinding binding;
List<ModelAssignedSurvey> modelAssignedSurveys;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDashboardBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        recyclerPerform();
    }

    private void recyclerPerform() {
        modelAssignedSurveys = new ArrayList<>();
        binding.recAssignedSurvey.setHasFixedSize(true);
        binding.recAssignedSurvey.setNestedScrollingEnabled(false);
        binding.recAssignedSurvey.setLayoutManager(new LinearLayoutManager(getApplicationContext(), RecyclerView.HORIZONTAL,false));
        modelAssignedSurveys.add(new ModelAssignedSurvey("Admin"));
        modelAssignedSurveys.add(new ModelAssignedSurvey("User"));
        modelAssignedSurveys.add(new ModelAssignedSurvey("Admin"));
        AdapterAssignedSurvey adapterAssignedSurvey = new AdapterAssignedSurvey(getApplicationContext(),modelAssignedSurveys);
        binding.recAssignedSurvey.setAdapter(adapterAssignedSurvey);
    }
}