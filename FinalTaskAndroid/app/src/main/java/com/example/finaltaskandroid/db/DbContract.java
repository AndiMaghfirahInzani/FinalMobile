package com.example.finaltaskandroid.db;

import android.provider.BaseColumns;

public class DbContract {
    public static String TABLE_NAME = "Favorit";
    public static final class FavColumns implements BaseColumns {

        public static final String TMDB_ID = "tmdb_id";
        public static final String TITLE = "title";
        public static final String BACKDROP = "backDrop";
        public static final String POSTER = "poster";
        public static final String RELEASE_DATE = "releaseDate";
        public static final String RATE = "rating";
        public static final String OVERVIEW = "overview";
        public static final String ICON = "icon";
    }
}
