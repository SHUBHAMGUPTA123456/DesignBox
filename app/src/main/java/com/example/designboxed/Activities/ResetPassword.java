package com.example.designboxed.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.designboxed.databinding.ActivityResetPasswordBinding;

public class ResetPassword extends AppCompatActivity {
ActivityResetPasswordBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityResetPasswordBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}