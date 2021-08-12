package com.example.designboxed.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.designboxed.R;
import com.example.designboxed.databinding.ActivityEditProfileBinding;

public class EditProfile extends AppCompatActivity {

    ActivityEditProfileBinding editProfileBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        editProfileBinding=ActivityEditProfileBinding.inflate(getLayoutInflater());
        setContentView(editProfileBinding.getRoot());
    }
}