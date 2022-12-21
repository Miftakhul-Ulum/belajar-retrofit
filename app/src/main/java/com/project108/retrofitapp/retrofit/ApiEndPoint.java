package com.project108.retrofitapp.retrofit;

import com.project108.retrofitapp.Model;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiEndPoint {

    @GET("data.php")
    Call<Model> getdata();
}
