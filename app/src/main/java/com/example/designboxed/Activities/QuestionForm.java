package com.example.designboxed.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.designboxed.Quiz.SurvayCompleted;
import com.example.designboxed.R;
import com.example.designboxed.databinding.ActivityQuestionFormBinding;

public class QuestionForm extends AppCompatActivity {
ActivityQuestionFormBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityQuestionFormBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        clickPerform();
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
    private void clickPerform() {
        binding.btnSave.setOnClickListener(v -> {
            startActivity(new Intent(this, SurvayCompleted.class));
            overridePendingTransition(R.anim.right_in,R.anim.right_out);
        });
    }
}