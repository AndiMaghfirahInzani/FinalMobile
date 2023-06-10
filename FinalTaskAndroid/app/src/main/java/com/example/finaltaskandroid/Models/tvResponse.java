package com.example.finaltaskandroid.Models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class tvResponse {
    @SerializedName("results")
    private List<TvShow> tvShows;
    public List<TvShow> getTvShows(){return tvShows;}
}
