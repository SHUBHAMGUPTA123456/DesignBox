package com.example.designboxed.Adaptor;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.designboxed.Activities.Fragment.AllAssignedSurvay;
import com.example.designboxed.Activities.Fragment.CompletedSurvay;

public class ViewPagerAdapter extends FragmentPagerAdapter {
    Context mContext;
    int mTotalTabs;
    public ViewPagerAdapter(Context context , FragmentManager fragmentManager , int totalTabs) {
        super(fragmentManager);
        mContext = context;
        mTotalTabs = totalTabs;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        Log.d("asasas" , position + "");
        switch (position) {
            case 0:
                return new CompletedSurvay();
            case 1:
                return new AllAssignedSurvay();
            default:
                return null;

        }
    }

    @Override
    public int getCount() {
        return mTotalTabs;
    }
}
