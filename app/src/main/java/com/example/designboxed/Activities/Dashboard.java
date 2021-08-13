package com.example.designboxed.Activities;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.designboxed.Model.ModelAssignedSurvey;
import com.example.designboxed.Navigation.NavigationActivity;
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

        binding.menuIcon.setOnClickListener(v -> {
            startActivity(new Intent(getApplicationContext(), NavigationActivity.class));
        });
        binding.notificationIcon.setOnClickListener(v -> {
            startActivity(new Intent(getApplicationContext(), Notification_Activity.class));
        });
    }
    private void recyclerPerform() {
        modelAssignedSurveys = new ArrayList<>();
        binding.recAssignedSurvey.setHasFixedSize(true);
        binding.recAssignedSurvey.setNestedScrollingEnabled(false);
        binding.recAssignedSurvey.setLayoutManager(new LinearLayoutManager(getApplicationContext(), RecyclerView.HORIZONTAL, false));
        modelAssignedSurveys.add(new ModelAssignedSurvey("Admin"));
        modelAssignedSurveys.add(new ModelAssignedSurvey("User"));
        modelAssignedSurveys.add(new ModelAssignedSurvey("Admin"));
        AdapterAssignedSurvey adapterAssignedSurvey = new AdapterAssignedSurvey(getApplicationContext(), modelAssignedSurveys);
        binding.recAssignedSurvey.setAdapter(adapterAssignedSurvey);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}