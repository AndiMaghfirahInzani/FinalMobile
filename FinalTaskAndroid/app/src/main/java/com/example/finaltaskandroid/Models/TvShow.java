package com.example.finaltaskandroid.Models;

import com.google.gson.annotations.SerializedName;

public class TvShow {
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getTitle() {
        return name;
    }

    public void setTitle(String name) {
        this.name = name;
    }

    @SerializedName("poster_path")
    private String posterpath;


    @SerializedName("first_air_date")
    private String releaseDate;

    public String getPosterpath() {
        return posterpath;
    }

    public void setPosterpath(String posterpath) {
        this.posterpath = posterpath;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getReleaseDate() {
        return releaseDate;
    }
    public String getReleaseYear() {
        String[] releaseYear = releaseDate.split("-");
        return releaseYear[0];
    }
}
