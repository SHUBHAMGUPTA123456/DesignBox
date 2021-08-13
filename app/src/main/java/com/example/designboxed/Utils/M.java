package com.example.designboxed.Utils;


/**
 * Created by Woumtana Pingdiwindé Youssouf 03/2019
 * Tel: +226 63 86 22 46 - 73 35 41 41
 * Email: issoufwoumtana@gmail.com
 **/

import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.example.designboxed.R;


public class M {
    public static ProgressDialog pDialog;
    private static SharedPreferences mSharedPreferences;
    private static String pref_name = "Login";

    public static void showLoadingDialog(Context mContext) {
        pDialog = new ProgressDialog(mContext);
        pDialog.setMessage(mContext.getString(R.string.please_wait));
        pDialog.setIndeterminate(true);
        pDialog.setCancelable(false);
        pDialog.show();
    }

    public static void hideLoadingDialog() {
        if (pDialog.isShowing()) {
            pDialog.dismiss();
        }
    }

    public static void showToast(Context mContext, String message) {
        M.showToast(mContext, message);
    }

    public static void T(Context mContext, String Message) {
        M.showToast(mContext, Message);
    }

    public static void L(String Message) {
        Log.e("Vidoo", Message);
    }


    public static boolean seUserToken(String token, Context mContext) {
        mSharedPreferences = mContext.getSharedPreferences(pref_name, 0);
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putString("token", token);
        editor.apply();
        return editor.commit();
    }

    public static String getUserToken(Context mContext) {
        mSharedPreferences = mContext.getSharedPreferences(pref_name, 0);
        return mSharedPreferences.getString("token", "0");
    }

    public static boolean setSellerData(String seller_id, Context mContext) {
        mSharedPreferences = mContext.getSharedPreferences(pref_name, 0);
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putString("seller_id", seller_id);
        editor.apply();
        return editor.commit();
    }

    public static String getSellerData(Context mContext) {
        mSharedPreferences = mContext.getSharedPreferences(pref_name, 0);
        return mSharedPreferences.getString("seller_id", "null");
    }


    public static boolean setUsername(String username, Context mContext) {
        mSharedPreferences = mContext.getSharedPreferences(pref_name, 0);
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putString("username", username);
        return editor.commit();
    }

    public static String getUsername(Context mContext) {
        mSharedPreferences = mContext.getSharedPreferences(pref_name, 0);
        return mSharedPreferences.getString("username", null);
    }

}

