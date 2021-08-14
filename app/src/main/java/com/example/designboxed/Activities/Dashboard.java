package com.example.designboxed.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.designboxed.Model.ModelAssignedSurvey;
import com.example.designboxed.Navigation.NavigationActivity;
import com.example.designboxed.R;
import com.example.designboxed.Utils.UtilMethods;
import com.example.designboxed.databinding.ActivityDashboardBinding;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Dashboard extends AppCompatActivity {
    ActivityDashboardBinding binding;
    List<ModelAssignedSurvey> modelAssignedSurveys;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDashboardBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        recyclerPerform();
        clickPerform();
        getActiveSurveyApi();
    }
    private void getActiveSurveyApi() {
        UtilMethods.GetAssignment(getApplicationContext(), new UtilMethods.ApiCallBackTwoMethod() {
            @Override
            public void onSucess(Object object) {
                try {
                    Log.d("GetActiveSurveyApi", "onSuccess: "+object);
                    JSONObject jsonObject = new JSONObject(String.valueOf(object));
                    if (jsonObject.getString("is_team_leader").equalsIgnoreCase("true")) {
                        JSONArray jsonArray = jsonObject.getJSONArray("my_assignments");
                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject js = jsonArray.getJSONObject(i);
                            String id = js.getString("id");
                            String assigned_od = js.getString("assigned_od");
                            String total_voters_assigned = js.getString("total_voters_assigned");
                            String area = js.getString("area");
                            String block = js.getString("block");
                        }
                    }
                }catch (JSONException e){
                    e.printStackTrace();
                }
            }
            @Override
            public void onError(String errorMsg) {
                Log.d("GetActiveSurveyApi", "onError: "+errorMsg);
                Toast.makeText(Dashboard.this, errorMsg, Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void clickPerform() {
        binding.menuIcon.setOnClickListener(v -> {
            startActivity(new Intent(getApplicationContext(), NavigationActivity.class));
            overridePendingTransition(R.anim.right_in,R.anim.right_out);
        });
        binding.notificationIcon.setOnClickListener(v -> {
            startActivity(new Intent(getApplicationContext(), Notification_Activity.class));
            overridePendingTransition(R.anim.right_in,R.anim.right_out);
        });
        binding.viewAll.setOnClickListener(v -> {
            startActivity(new Intent(getApplicationContext(), AllSurvay.class));
            overridePendingTransition(R.anim.right_in,R.anim.right_out);
        });
        binding.profileSection.setOnClickListener(v -> {
            startActivity(new Intent(getApplicationContext(), Profile_Activity.class));
            overridePendingTransition(R.anim.right_in,R.anim.right_out);
        });
    }

    private void recyclerPerform() {
        modelAssignedSurveys = new ArrayList<>();
        binding.recAssignedSurvey.setHasFixedSize(true);
        binding.recAssignedSurvey.setNestedScrollingEnabled(false);
        binding.recAssignedSurvey.setLayoutManager(new LinearLayoutManager(getApplicationContext(), RecyclerView.HORIZONTAL, false));
        modelAssignedSurveys.add(new ModelAssignedSurvey("Admin",R.drawable.img_two_election));
        modelAssignedSurveys.add(new ModelAssignedSurvey("User",R.drawable.img_three));
        modelAssignedSurveys.add(new ModelAssignedSurvey("Admin",R.drawable.img_five));
        modelAssignedSurveys.add(new ModelAssignedSurvey("Admin",R.drawable.img_six));
        AdapterAssignedSurvey adapterAssignedSurvey = new AdapterAssignedSurvey(getApplicationContext(), modelAssignedSurveys);
        binding.recAssignedSurvey.setAdapter(adapterAssignedSurvey);
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Alert !");
        builder.setCancelable(false);
        builder.setMessage("Do you want to exit ?");
        builder.setIcon(R.drawable.ic_logout);
        builder.setPositiveButton("Yes", (dialog, which) -> {
            onBackPressed();
            finish();
        }).setNegativeButton("No", (dialog, which) -> dialog.dismiss());
        builder.show();
    }
}