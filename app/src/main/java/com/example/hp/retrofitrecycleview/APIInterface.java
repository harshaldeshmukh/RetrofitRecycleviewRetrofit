package com.example.hp.retrofitrecycleview;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface APIInterface {
    @GET("welfareschme.php")
    Call<JSONResponse> getJSON();

    @GET("ranks.php")
    Call<JSONResponse> getSrank();
}
