package com.example.designboxed.Quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.designboxed.databinding.ActivitySurvayCompletedBinding;

public class SurvayCompleted extends AppCompatActivity {
    ActivitySurvayCompletedBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySurvayCompletedBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}