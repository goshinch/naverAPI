package com.example.naverapi.retrofit;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface NaverService {
    @GET("search/{type}")
    Call<Model> getData(
            @Header("X-Naver-Client-Id") String clientId,
            @Header("X-Naver-Client-Secret") String clientSecret,
            @Path("type") String type,
            @Query("query") String search
        );
}
