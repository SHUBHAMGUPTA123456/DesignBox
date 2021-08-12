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

        findViewById(R.id.img).setOnClickListener(v->{
            startActivity(new Intent(getApplicationContext(),Profile_Activity.class));
        });

        findViewById(R.id.home).setOnClickListener(v->{
            startActivity(new Intent(getApplicationContext(),EditProfile.class));
        });

        findViewById(R.id.noti).setOnClickListener(v->{
            startActivity(new Intent(getApplicationContext(),Notification_Activity.class));
        });
    }
}