package com.example.designboxed.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.designboxed.R;
import com.example.designboxed.databinding.ActivityLoginBinding;

public class Login extends AppCompatActivity {
    ActivityLoginBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        clickPerform();
    }

    private void clickPerform() {
        binding.goToForget.setOnClickListener(v -> {
            startActivity(new Intent(this, ForgetPassword.class));
            overridePendingTransition(R.anim.right_in,R.anim.right_out);
            finish();
        });
        binding.loginBtn.setOnClickListener(v -> {
            startActivity(new Intent(this, Dashboard.class));
            overridePendingTransition(R.anim.right_in,R.anim.right_out);
            finish();
        });
    }
}