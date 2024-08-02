package com.example.rest_api_lab5;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface InterfaceSelect {
   @GET("select.php")
    Call<ServerResponseSelect> selectSanPham();
}
