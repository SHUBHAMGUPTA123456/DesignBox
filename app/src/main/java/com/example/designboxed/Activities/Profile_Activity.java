package com.example.designboxed.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.designboxed.R;
import com.example.designboxed.databinding.ActivityProfileBinding;

public class Profile_Activity extends AppCompatActivity {

    ActivityProfileBinding profileBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        profileBinding=ActivityProfileBinding.inflate(getLayoutInflater());
        setContentView(profileBinding.getRoot());
    }
}