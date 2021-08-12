package com.example.designboxed.Activities;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.designboxed.databinding.ActivityProfileBinding;

public class Profile_Activity extends AppCompatActivity {

    ActivityProfileBinding profileBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        profileBinding = ActivityProfileBinding.inflate(getLayoutInflater());
        setContentView(profileBinding.getRoot());

        profileBinding.pressBack.setOnClickListener(v -> {
            onBackPressed();
            finish();
        });
        profileBinding.editProfile.setOnClickListener(v -> {
            startActivity(new Intent(getApplicationContext(), EditProfile.class));
        });
    }
}