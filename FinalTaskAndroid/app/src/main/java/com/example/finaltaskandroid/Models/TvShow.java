package com.example.finaltaskandroid.Models;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

public class TvShow implements Parcelable {
    @SerializedName("name")
    private String name;
    private int id;

    protected TvShow(Parcel in) {
        name = in.readString();
        id = in.readInt();
        overview = in.readString();
        backdrop = in.readString();
        airdate = in.readString();
        voteAverage = in.readString();
        poster = in.readString();
    }

    public static final Creator<TvShow> CREATOR = new Creator<TvShow>() {
        @Override
        public TvShow createFromParcel(Parcel in) {
            return new TvShow(in);
        }

        @Override
        public TvShow[] newArray(int size) {
            return new TvShow[size];
        }
    };

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getBackdrop() {
        return backdrop;
    }

    public void setBackdrop(String backdrop) {
        this.backdrop = backdrop;
    }

    public String getAirdate() {
        return airdate;
    }
    public int getId() {
        return id;
    }

    public void setAirdate(String airdate) {
        this.airdate = airdate;
    }

    public String getVoteAverage() {
        return voteAverage;
    }

    public void setVoteAverage(String voteAverage) {
        this.voteAverage = voteAverage;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    @SerializedName("overview")
    private String overview;

    @SerializedName("backdrop_path")
    private String backdrop;

    @SerializedName("first_air_date")
    private String airdate;

    @SerializedName("vote_average")
    private String voteAverage;

    @SerializedName("poster_path")
    private String poster;
    public String getReleaseYear() {
        String[] releaseYear = airdate.split("-");
        return releaseYear[0];
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeInt(id);
        parcel.writeString(overview);
        parcel.writeString(backdrop);
        parcel.writeString(airdate);
        parcel.writeString(voteAverage);
        parcel.writeString(poster);
    }
}
