package com.example.designboxed.Activities;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.designboxed.Adaptor.AdaptorNotification;
import com.example.designboxed.Models.ModelNotifications;
import com.example.designboxed.R;
import com.example.designboxed.databinding.ActivityNotificationBinding;

import java.util.ArrayList;

public class Notification_Activity extends AppCompatActivity {
    ActivityNotificationBinding notificationBinding;
    ArrayList<ModelNotifications> data = new ArrayList<>();
    AdaptorNotification adaptorNotification;
    ImageView backIcon;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        notificationBinding = ActivityNotificationBinding.inflate(getLayoutInflater());
        setContentView(notificationBinding.getRoot());
        backIcon = findViewById(R.id.backIcon);
        notificationBinding.recyclerData.setLayoutManager(new LinearLayoutManager(this));
        setData();
        backIcon.setOnClickListener(v->{
            onBackPressed();
            finish();
        });
    }
    private void setData() {
        data.add(new ModelNotifications("However, despite this expenditure, people in the U.S. have a lower life expectancy than people in other developed countries. "));
        data.add(new ModelNotifications("However, despite this expenditure, people in the U.S. have a lower life expectancy than people in other developed countries. "));
        data.add(new ModelNotifications("However, despite this expenditure, people in the U.S. have a lower life expectancy than people in other developed countries. "));
        adaptorNotification = new AdaptorNotification(getApplicationContext(), data);
        notificationBinding.recyclerData.setAdapter(adaptorNotification);
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}