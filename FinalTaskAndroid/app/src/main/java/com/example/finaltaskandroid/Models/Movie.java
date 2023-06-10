package com.example.finaltaskandroid.Models;

import com.google.gson.annotations.SerializedName;

public class Movie {
    private int id;
    private String title;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Movie() {
    }

    @SerializedName("release_date")
    private String date;
    @SerializedName("poster_path")
    private String posterpath;

    public String getDate() {
        return date;
    }

    public String getPosterpath() {
        return posterpath;
    }

    public String getYear() {
        String[] relaseYear = date.split("-");
        return relaseYear[0];
    }
}
