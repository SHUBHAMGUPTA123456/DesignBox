package com.example.designboxed.Utils;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.util.Log;

import org.json.JSONException;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UtilMethods {
    public static String UPlat = "0.0";
    public static String UPlng = "0.0";
    private static void dialogOk(final Context context, final String message, final int flag) {
        try {
            new AlertDialog.Builder(context)
                    .setTitle("Alert ! ")
                    .setMessage(message)
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            // "OK" button was clicked
                            dialogInterface.dismiss();
                        }
                    })
                    .show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //    String Email_Pattern = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$";
    public static boolean isValidEmail(final String email) {
        Pattern pattern;
        Matcher matcher;
        String Email_Pattern = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$";
        pattern = Pattern.compile(Email_Pattern);
        matcher = pattern.matcher(email);
        return matcher.matches();
    }
    public static boolean isValidPhone(final String phone) {
        Pattern pattern;
        Matcher matcher;
        String regexPhone = "^[6-9][0-9]{9}$";
        pattern = Pattern.compile(regexPhone);
        matcher = pattern.matcher(phone);
        return matcher.matches();
    }
    public static boolean isValidPassword(final String password) {
        Pattern pattern;
        Matcher matcher;
        String regex = "^(?=.*[0-9])"
                + "(?=.*[a-z])(?=.*[A-Z])"
                + "(?=.*[@#$%^&+=])"
                + "(?=\\S+$).{8,20}$";
        pattern = Pattern.compile(regex);
        matcher = pattern.matcher(password);
        return matcher.matches();
    }
    public interface ApiCallBackTwoMethod {
        void onSucess(Object object) throws JSONException;
        void onError(String errorMsg);
    }
    public static void LoginSeeker(final Context context, String username, String password, final ApiCallBackTwoMethod apiCallBack) {
        if (new ConnectionDetector(context).isConnectingToInternet()) {
            RetrofitClient.getInstance();
            Call<ResponseBody> bodyCall = RetrofitClient.getDataServices().LoginUser(ApplicationConstant.AdminAuthKey,username,password);
            bodyCall.enqueue(new Callback<ResponseBody>() {
                @Override
                public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                    String s;
                    if (response.isSuccessful()) {
                        try {
                            s = response.body().string();
                            Log.d("TAG", "xfeffffe: " + s);
                            apiCallBack.onSucess(s);
                        } catch (IOException | JSONException e) {
                            e.printStackTrace();
                        }
                    } else {
                        dialogOk(context, "Error: " + response.message(), 1);
                        Log.d("ss", "onResponse: " + response.message());
                        apiCallBack.onError("No record found");
                    }
                }
                @Override
                public void onFailure(Call<ResponseBody> call, Throwable t) {
                    apiCallBack.onError("No record found " + t.getLocalizedMessage());
                    Log.d("TAG", "onFailure: " + t.getLocalizedMessage());
                }
            });
        } else {
            apiCallBack.onError("No Internet");
//          Toast.makeText(context, "No Internet", Toast.LENGTH_SHORT).show();
        }
    }
    // Get Assignment . . .
    public static void GetAssignment(final Context context, final ApiCallBackTwoMethod apiCallBack) {
        if (new ConnectionDetector(context).isConnectingToInternet()) {
            RetrofitClient.getInstance();
            Call<ResponseBody> bodyCall = RetrofitClient.getDataServices().GetAssignmentApi(ApplicationConstant.AdminAuthKey);
            bodyCall.enqueue(new Callback<ResponseBody>() {
                @Override
                public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                    String s;
                    if (response.isSuccessful()) {
                        try {
                            s = response.body().string();
                            Log.d("GetActiveSurvey", "onSuccess: " + s);
                            apiCallBack.onSucess(s);
                        } catch (IOException | JSONException e) {
                            e.printStackTrace();
                        }
                    } else {
                        dialogOk(context, "Error: " + response.errorBody().toString(), 1);
                        Log.d("GetActiveSurvey", "onResponse: " + response.message());
                        apiCallBack.onError("No record found");
                    }
                }
                @Override
                public void onFailure(Call<ResponseBody> call, Throwable t) {
                    apiCallBack.onError("No record found " + t.getLocalizedMessage());
                    Log.d("GetActiveSurvey", "onFailure: " + t.getLocalizedMessage());
                }
            });
        } else {
            apiCallBack.onError("No Internet");
//          Toast.makeText(context, "No Internet", Toast.LENGTH_SHORT).show();
        }
    }
    //Get User Data . . .
    public static void UserData(final Context context, final ApiCallBackTwoMethod apiCallBack) {
        if (new ConnectionDetector(context).isConnectingToInternet()) {
            RetrofitClient.getInstance();
            Call<ResponseBody> bodyCall = RetrofitClient.getDataServices().GetUserData(ApplicationConstant.AdminAuthKey);
            bodyCall.enqueue(new Callback<ResponseBody>() {
                @Override
                public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                    String s;
                    if (response.isSuccessful()) {
                        try {
                            s = response.body().string();
                            Log.d("GetUserData", "onSuccess: " + s);
                            apiCallBack.onSucess(s);
                        } catch (IOException | JSONException e) {
                            e.printStackTrace();
                        }
                    } else {
                        dialogOk(context, "Error: " + response.errorBody().toString(), 1);
                        Log.d("GetUserData", "onResponse: " + response.message());
                        apiCallBack.onError("No record found");
                    }
                }
                @Override
                public void onFailure(Call<ResponseBody> call, Throwable t) {
                    apiCallBack.onError("No record found " + t.getLocalizedMessage());
                    Log.d("GetUserData", "onFailure: " + t.getLocalizedMessage());
                }
            });
        } else {
            apiCallBack.onError("No Internet");
//          Toast.makeText(context, "No Internet", Toast.LENGTH_SHORT).show();
        }
    }
}