package com.example.finaltaskandroid.db;

import android.content.ContentValues;
import android.database.Cursor;

import com.example.finaltaskandroid.Models.Favorite;

import java.util.ArrayList;

public class MapHelper {
    public static ArrayList<Favorite> mapCursorToArrayList(Cursor notesCursor) {
        ArrayList<Favorite> notesList = new ArrayList<>();

        while (notesCursor.moveToNext()) {
            int id = notesCursor.getInt(notesCursor.getColumnIndexOrThrow(DbContract.FavColumns._ID));
            String title = notesCursor.getString(notesCursor.getColumnIndexOrThrow(DbContract.FavColumns.TITLE));
            String backdropPath = notesCursor.getString(notesCursor.getColumnIndexOrThrow(DbContract.FavColumns.BACKDROP));
            int tmdbId = notesCursor.getInt(notesCursor.getColumnIndexOrThrow(DbContract.FavColumns.TMDB_ID));
            int isMovie = notesCursor.getInt(notesCursor.getColumnIndexOrThrow(DbContract.FavColumns.ICON));
            String overview = notesCursor.getString(notesCursor.getColumnIndexOrThrow(DbContract.FavColumns.OVERVIEW));
            String poster = notesCursor.getString(notesCursor.getColumnIndexOrThrow(DbContract.FavColumns.POSTER));
            String releaseDate = notesCursor.getString(notesCursor.getColumnIndexOrThrow(DbContract.FavColumns.RELEASE_DATE));
            String voteAverage = notesCursor.getString(notesCursor.getColumnIndexOrThrow(DbContract.FavColumns.RATE));

            notesList.add(new Favorite(tmdbId, title, overview, voteAverage, backdropPath, isMovie==1?true:false, releaseDate, poster));
        }
        return notesList;
    }

        public static ContentValues favToContentValues(Favorite favorite){
            ContentValues values = new ContentValues();
            values.put(DbContract.FavColumns.TMDB_ID, favorite.getTmdbId());
            values.put(DbContract.FavColumns.TITLE, favorite.getTitle());
            values.put(DbContract.FavColumns.OVERVIEW, favorite.getOverview());
            values.put( DbContract.FavColumns.RATE, favorite.getVoteAverage());
            values.put(DbContract.FavColumns.BACKDROP, favorite.getBannerUrl());
            values.put(DbContract.FavColumns.ICON, favorite.isMovie() ? 1 : 0);
            values.put(DbContract.FavColumns.RELEASE_DATE, favorite.getDate());
            values.put(DbContract.FavColumns.POSTER, favorite.getPosterpath());


            return values;
        }
}
