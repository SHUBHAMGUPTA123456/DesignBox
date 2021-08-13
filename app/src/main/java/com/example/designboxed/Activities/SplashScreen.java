package com.example.designboxed.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

import com.example.designboxed.Activities.Login;
import com.example.designboxed.R;
import com.example.designboxed.Utils.M;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_secreen);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (M.getUserToken(getApplicationContext()).equalsIgnoreCase("0")){
                    startActivity(new Intent(getApplicationContext(), Login.class));
                    finish();
                    return;
                }
                startActivity(new Intent(getApplicationContext(), Dashboard.class));
                finish();

            }
        },2000);
    }
}