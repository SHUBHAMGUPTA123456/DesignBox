package com.example.designboxed.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.example.designboxed.Utils.UtilMethods;
import com.example.designboxed.databinding.ActivityProfileBinding;

import org.json.JSONException;
import org.json.JSONObject;

public class Profile_Activity extends AppCompatActivity {

    ActivityProfileBinding profileBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        profileBinding = ActivityProfileBinding.inflate(getLayoutInflater());
        setContentView(profileBinding.getRoot());
        clickPerform();
        getProfileDtaaApi();
    }

    private void getProfileDtaaApi() {
        UtilMethods.UserData(getApplicationContext(), new UtilMethods.ApiCallBackTwoMethod() {
            @Override
            public void onSucess(Object object) throws JSONException {
                try {
                    Log.d("GetUserDataApi", "onSucess: "+object);
                    JSONObject jsonObject = new JSONObject(String.valueOf(object));
                    String first_name = jsonObject.getString("first_name");
                    String last_name = jsonObject.getString("last_name");
                    profileBinding.txtName.setText(first_name+" "+last_name);
                    String email = jsonObject.getString("email");
                    profileBinding.txtEmail.setText(email);
                    String username = jsonObject.getString("username");
                    String is_active = jsonObject.getString("is_active");
                }catch (JSONException e){
                    e.printStackTrace();
                }
            }

            @Override
            public void onError(String errorMsg) {

            }
        });
    }

    private void clickPerform() {
        profileBinding.pressBack.setOnClickListener(v -> {
            onBackPressed();
            finish();
        });
        profileBinding.editProfile.setOnClickListener(v -> {
            startActivity(new Intent(getApplicationContext(), EditProfile.class));
        });
    }
}