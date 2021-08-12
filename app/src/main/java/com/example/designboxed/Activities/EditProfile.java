package com.example.designboxed.Activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.designboxed.databinding.ActivityEditProfileBinding;

public class EditProfile extends AppCompatActivity {

    ActivityEditProfileBinding editProfileBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        editProfileBinding = ActivityEditProfileBinding.inflate(getLayoutInflater());
        setContentView(editProfileBinding.getRoot());
        editProfileBinding.pressBack.setOnClickListener(v -> {
            onBackPressed();
            finish();
        });
    }
}