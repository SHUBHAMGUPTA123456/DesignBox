package com.example.designboxed.Quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.designboxed.R;
import com.example.designboxed.databinding.ActivityQuizFourBinding;

public class QuizFour extends AppCompatActivity {
    ActivityQuizFourBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityQuizFourBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        myTool();
    }
    private void myTool() {
        binding.toolBar.setNavigationIcon(R.drawable.icon_back_btn);
        binding.toolBar.setNavigationOnClickListener(v -> {
            onBackPressed();
            overridePendingTransition(R.anim.right_in,R.anim.right_out);
            finish();
        });
    }
}