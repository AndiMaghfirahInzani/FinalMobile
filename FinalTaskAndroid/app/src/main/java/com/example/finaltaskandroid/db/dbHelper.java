package com.example.finaltaskandroid.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class dbHelper extends SQLiteOpenHelper {
    private static String DATABASE_NAME = "Fav.db";
    private static final int DATABASE_VERSION = 1;



    public dbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
//        sqLiteDatabase.execSQL(SQL_CREATE_TABLE_FAVORITE);
        String query = String.format(
                "CREATE TABLE %s"
                        + " (%s INTEGER PRIMARY KEY AUTOINCREMENT,"
                        + " %s TEXT NOT NULL,"
                        + " %s TEXT NOT NULL,"
                        + " %s TEXT NOT NULL,"
                        + " %s TEXT NOT NULL,"
                        + " %s TEXT NOT NULL,"
                        + " %s TEXT NOT NULL,"
                        + " %s TEXT NOT NULL,"
                        + "%s INTEGER)",
                DbContract.TABLE_NAME,
                DbContract.FavColumns._ID,
                DbContract.FavColumns.TMDB_ID,
                DbContract.FavColumns.TITLE,
                DbContract.FavColumns.BACKDROP,
                DbContract.FavColumns.POSTER,
                DbContract.FavColumns.RELEASE_DATE,
                DbContract.FavColumns.OVERVIEW,
                DbContract.FavColumns.ICON,
                DbContract.FavColumns.RATE
        );
        sqLiteDatabase.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String query = "DROP TABLE IF EXISTS " + DbContract.TABLE_NAME;
        sqLiteDatabase.execSQL(query);
        onCreate(sqLiteDatabase);
    }
}
