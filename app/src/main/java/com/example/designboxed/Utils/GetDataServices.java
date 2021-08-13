package com.example.designboxed.Utils;


import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface GetDataServices {

    /*http://designbox.aaratechnologies.in:8686/api/login*/
    @POST("login")
    @FormUrlEncoded
    Call<ResponseBody> LoginUser(
            @Header("Authorization") String adminKey,
            @Field("username") String username,
            @Field("password") String password
    );


}
