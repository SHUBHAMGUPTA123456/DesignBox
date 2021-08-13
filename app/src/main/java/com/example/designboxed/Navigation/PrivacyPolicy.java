package com.example.designboxed.Navigation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.designboxed.R;
import com.example.designboxed.databinding.ActivityPrivacyPolicyBinding;

public class PrivacyPolicy extends AppCompatActivity {

    ActivityPrivacyPolicyBinding binding;
    String ttl = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPrivacyPolicyBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Intent intent = getIntent();
        ttl = intent.getStringExtra("key");
        binding.title.setText(ttl);
        binding.toolAbout.setNavigationIcon(R.drawable.ic_back_black);
        binding.toolAbout.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}