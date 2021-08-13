package com.example.designboxed.Navigation;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.designboxed.Activities.AllSurvay;
import com.example.designboxed.Activities.Dashboard;
import com.example.designboxed.Activities.Notification_Activity;
import com.example.designboxed.Activities.Profile_Activity;
import com.example.designboxed.BuildConfig;
import com.example.designboxed.R;
import com.example.designboxed.databinding.ActivityNavigationBinding;

public class NavigationActivity extends AppCompatActivity {
    ActivityNavigationBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityNavigationBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.userProfile.setOnClickListener(v -> {
            startActivity(new Intent(getApplicationContext(), Profile_Activity.class));
        });
        binding.noti.setOnClickListener(v -> {
            startActivity(new Intent(getApplicationContext(), Notification_Activity.class));
        });
        binding.home.setOnClickListener(v -> {
            startActivity(new Intent(getApplicationContext(), Dashboard.class));
        });
        binding.allSurvay.setOnClickListener(v -> {
            startActivity(new Intent(getApplicationContext(), AllSurvay.class));
        });
        binding.termsnConditions.setOnClickListener(v -> {
            startActivity(new Intent(getApplicationContext(), PrivacyPolicy.class).putExtra("key","Terms of Use"));
        });
        binding.privcyPolicy.setOnClickListener(v -> {
            startActivity(new Intent(getApplicationContext(), PrivacyPolicy.class).putExtra("key","Privacy & Policy"));
        });
        binding.img.setOnClickListener(v -> {
            startActivity(new Intent(getApplicationContext(), Dashboard.class));
            overridePendingTransition(R.anim.right_in,R.anim.right_out);
        });
        binding.shareApp.setOnClickListener(v -> {
            try {
                Intent shareIntent = new Intent(Intent.ACTION_SEND);
                shareIntent.setType("text/plain");
                shareIntent.putExtra(Intent.EXTRA_SUBJECT, getResources().getString(R.string.app_name));
                String shareMessage = "\nLet me recommend you this application\n\n";
                shareMessage = shareMessage + "https://play.google.com/store/apps/details?id=" + BuildConfig.APPLICATION_ID + "\n\n";
                shareIntent.putExtra(Intent.EXTRA_TEXT, shareMessage);
                startActivity(Intent.createChooser(shareIntent, "choose one"));
            } catch (Exception e) {
                Toast.makeText(getApplicationContext(), "Something went wrong! "+e.toString(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}