package com.example.btl_android_studyapp.api;
import com.example.btl_android_studyapp.model.ThoiKhoaBieuResponse;
import com.example.btl_android_studyapp.model.UserModel;

import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.POST;
public interface ApiService {
    @FormUrlEncoded
    @POST("auth/login")
    Call<UserModel> login(
            @Field("username") String username,
            @Field("password") String password,
            @Field("grant_type") String grantType
    );

    @POST("sch/w-locdstkbtuanusertheohocky")
    Call<ThoiKhoaBieuResponse> getSchedule(@Body Map<String, Object> body, @Header("Authorization") String token);

    @POST("srm/w-locdsdiemsinhvien?hien_thi_mon_theo_hkdk=false")
    Call<Object> getAllPoint ( @Header("Authorization") String token);
}
