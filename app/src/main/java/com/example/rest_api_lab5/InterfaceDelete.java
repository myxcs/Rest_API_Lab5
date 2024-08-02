package com.example.rest_api_lab5;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface InterfaceDelete {
    @FormUrlEncoded
    @POST("delete.php")
    Call<ServerResponseSanPham> deleteSanPham(
            @Field("MaSP") String MaSP);
}
