package com.example.designboxed.Navigation;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.designboxed.Activities.Dashboard;
import com.example.designboxed.Activities.Notification_Activity;
import com.example.designboxed.Activities.Profile_Activity;
import com.example.designboxed.databinding.ActivityNavigationBinding;

public class NavigationActivity extends AppCompatActivity {
    ActivityNavigationBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityNavigationBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.userProfile.setOnClickListener(v -> {
            startActivity(new Intent(getApplicationContext(), Profile_Activity.class));
        });
        binding.noti.setOnClickListener(v -> {
            startActivity(new Intent(getApplicationContext(), Notification_Activity.class));
        });
        binding.home.setOnClickListener(v -> {
            startActivity(new Intent(getApplicationContext(), Dashboard.class));
        });

    }
}