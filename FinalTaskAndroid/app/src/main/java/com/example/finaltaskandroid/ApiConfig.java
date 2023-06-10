package com.example.finaltaskandroid;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public class ApiConfig {
    public static final String apikey = "75acb31abf8c1a15c2491ae0f7f47900";

    public static String getApikey(){
        return apikey;
    }

    public static ApiService getApiService() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.themoviedb.org/3/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(ApiService.class);
    }
}
