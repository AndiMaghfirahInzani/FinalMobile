package com.example.finaltaskandroid.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class FavHelper {
    private static final String DATABASE_TABLE = DbContract.TABLE_NAME;

    private static dbHelper databaseHelper;
    private static SQLiteDatabase database;
    private static volatile FavHelper INSTANCE;

    public static FavHelper getInstance(Context context) {
        if (INSTANCE == null) {
            synchronized (SQLiteOpenHelper.class) {
                if (INSTANCE == null) {
                    INSTANCE = new FavHelper(context);
                }
            }
        }

        return INSTANCE;
    }

    private FavHelper(Context context) {
        databaseHelper = new dbHelper(context);
    }

    // Open database
    public void open() throws SQLException {
        database = databaseHelper.getWritableDatabase();
    }

    // Close database
    public void close() {
        databaseHelper.close();
        if (database.isOpen()) database.close();
    }

    // Create data
    public long create(ContentValues values) {
        return database.insert(DATABASE_TABLE, null, values);
    }
    public Cursor readAll() {
        return database.query(
                DATABASE_TABLE,
                null,
                null,
                null,
                null,
                null,
                DbContract.FavColumns._ID + " ASC"
        );
    }
//    public int update(String id, ContentValues values) {
//        return database.update(
//                DATABASE_TABLE,
//                values,
//                DbContract.FavColumns._ID + " = ?",
//                new String[]{id}
//        );
//    }

    public int delete(int id) {
        return database.delete(
                DATABASE_TABLE,
                DbContract.FavColumns._ID + " = " + id,
                null
        );
    }

    public boolean isFavorite(int tmdbId){
        String query = "SELECT * FROM " + DATABASE_TABLE + " WHERE " + DbContract.FavColumns.TMDB_ID + " = ?";
        String[] selectionArgs = {String.valueOf(tmdbId)};
        Cursor cursor = database.rawQuery(query, selectionArgs);
        System.out.println(cursor.getCount());
        boolean exists = (cursor.getCount() > 0);
        cursor.close();
        return exists;
    }
}
