package com.example.designboxed.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;

import com.example.designboxed.Adaptor.ViewPagerAdapter;
import com.example.designboxed.R;
import com.example.designboxed.databinding.ActivityAllSurvayBinding;
import com.google.android.material.tabs.TabLayout;

public class AllSurvay extends AppCompatActivity {
    ActivityAllSurvayBinding binding;
    TabLayout tabLayout;
    ViewPager viewPager;
    ViewPagerAdapter viewPagerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAllSurvayBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        tabLayout = binding.tabLay;
        viewPager = binding.viewPager;
        tabLayout.addTab(tabLayout.newTab().setText("All Assigned Survey"));
        tabLayout.addTab(tabLayout.newTab().setText("Completed Survey"));
        myTool();
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        viewPagerAdapter =new ViewPagerAdapter(this,getSupportFragmentManager(),tabLayout.getTabCount());
        viewPager.setAdapter(viewPagerAdapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener(){
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }
            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        clickPerform();
    }

    private void clickPerform() {
        binding.notificationIcon.setOnClickListener(v -> {
            startActivity(new Intent(getApplicationContext(), Notification_Activity.class));
            overridePendingTransition(R.anim.right_in,R.anim.right_out);
        });
    }

    private void myTool() {
        binding.toolBar.setNavigationIcon(R.drawable.icon_back_btn);
        binding.toolBar.setNavigationOnClickListener(v -> {
            onBackPressed();
            overridePendingTransition(R.anim.right_in,R.anim.right_out);
            finish();
        });
    }
}