package com.example.finaltaskandroid;

import com.example.finaltaskandroid.Models.MovieResponse;
import com.example.finaltaskandroid.Models.TvResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiService {

    @GET("movie/now_playing?")
    Call<MovieResponse> getMovie(@Query("api_key") String apikey);

    @GET("tv/airing_today?")
    Call<TvResponse> getTvshow(@Query("api_key") String apikey);
}
