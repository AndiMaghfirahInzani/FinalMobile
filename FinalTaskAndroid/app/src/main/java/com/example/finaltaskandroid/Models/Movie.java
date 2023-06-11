package com.example.finaltaskandroid.Models;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

public class Movie implements Parcelable {

    private int id;

    protected Movie(Parcel in) {
        id = in.readInt();
        title = in.readString();
        overview = in.readString();
        backdrop = in.readString();
        date = in.readString();
        voteAverage = in.readString();
        poster = in.readString();
    }

    public static final Creator<Movie> CREATOR = new Creator<Movie>() {
        @Override
        public Movie createFromParcel(Parcel in) {
            return new Movie(in);
        }

        @Override
        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };

    public void setId(int id) {
        this.id = id;
    }

    @SerializedName("title")
    private String title;
    public String getdate() {
        String[] releaseYear = date.split("-");
        return releaseYear[0];
    }

    public int getId() {
        return id;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public String getDate() {
        return date;
    }

    public void setDate() {
        this.date = date;
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

    @SerializedName("release_date")
    private String date;

    @SerializedName("vote_average")
    private String voteAverage;

    @SerializedName("poster_path")
    private String poster;

    public String getYear() {
        String[] relaseYear = date.split("-");
        return relaseYear[0];
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeString(title);
        parcel.writeString(overview);
        parcel.writeString(backdrop);
        parcel.writeString(date);
        parcel.writeString(voteAverage);
        parcel.writeString(poster);
    }
}
