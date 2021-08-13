package com.example.designboxed.Quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.designboxed.Activities.Dashboard;
import com.example.designboxed.R;
import com.example.designboxed.databinding.ActivitySurvayCompletedBinding;

public class SurvayCompleted extends AppCompatActivity {
    ActivitySurvayCompletedBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySurvayCompletedBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        clickPerform();
    }

    private void clickPerform() {
        binding.goToHome.setOnClickListener(v -> {
            finishAffinity();
            startActivity(new Intent(this, Dashboard.class));
            overridePendingTransition(R.anim.right_in,R.anim.right_out);
        });
    }
}