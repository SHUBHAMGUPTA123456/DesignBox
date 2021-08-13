package com.example.designboxed.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.designboxed.R;
import com.example.designboxed.Utils.M;
import com.example.designboxed.Utils.UtilMethods;
import com.example.designboxed.databinding.ActivityLoginBinding;

import org.json.JSONException;
import org.json.JSONObject;

public class Login extends AppCompatActivity {
    ActivityLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        clickPerform();
    }

    private void hitApi(String userName, String userPass) {
        UtilMethods.LoginSeeker(this, userName, userPass, new UtilMethods.ApiCallBackTwoMethod() {
            @Override
            public void onSucess(Object object) throws JSONException {
                Log.d("asdfghjkl", "onSucess: " + object);
                JSONObject jsonObject = new JSONObject(String.valueOf(object));
                if (!jsonObject.getBoolean("verified")) {
                    Toast.makeText(getApplicationContext(), "" + jsonObject.getString("msg"), Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "" + jsonObject.getString("msg"), Toast.LENGTH_SHORT).show();
                    M.seUserToken(jsonObject.getString("token"),Login.this);
                    startActivity(new Intent(getApplicationContext(), Dashboard.class));
                    overridePendingTransition(R.anim.right_in, R.anim.right_out);
                    finish();
                }
            }

            @Override
            public void onError(String errorMsg) {
                Log.d("asdfghjkl", "onError: " + errorMsg);
            }
        });
    }

    private void clickPerform() {
        binding.goToForget.setOnClickListener(v -> {
            startActivity(new Intent(this, ForgetPassword.class));
            overridePendingTransition(R.anim.right_in, R.anim.right_out);

        });
        binding.loginBtn.setOnClickListener(v -> {
            String userName=binding.userName.getText().toString().trim();
            String userPass=binding.password.getText().toString().trim();
            if (userName.isEmpty()){
                Toast.makeText(getApplicationContext(), "User name can't be empty!", Toast.LENGTH_SHORT).show();
                return;
            }
            if (userPass.isEmpty()){
                Toast.makeText(getApplicationContext(), "Password can't be empty!", Toast.LENGTH_SHORT).show();
                return;
            }
            hitApi(userName,userPass);

        });
    }
}