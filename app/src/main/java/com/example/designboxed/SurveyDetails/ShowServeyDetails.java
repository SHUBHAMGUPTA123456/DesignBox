package com.example.designboxed.SurveyDetails;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.designboxed.Quiz.QuizOne;
import com.example.designboxed.R;
import com.example.designboxed.databinding.ActivityShowServeyDetailsBinding;

public class ShowServeyDetails extends AppCompatActivity {
    ActivityShowServeyDetailsBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityShowServeyDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        clickPerform();
    }

    private void clickPerform() {
        binding.startSurvey.setOnClickListener(v -> {
            startActivity(new Intent(this, QuizOne.class));
            overridePendingTransition(R.anim.right_in,R.anim.right_out);
        });
        binding.imBlack.setOnClickListener(v -> {
            onBackPressed();
            overridePendingTransition(R.anim.right_in,R.anim.right_out);
            finish();
        });
    }
}