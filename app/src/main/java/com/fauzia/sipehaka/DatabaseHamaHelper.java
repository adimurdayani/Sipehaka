package com.fauzia.sipehaka;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class DatabaseHamaHelper extends SQLiteOpenHelper {

    private static final String NAMA_DATABASE = "dbhama.db";
    private static final int DATABASE_VERSION = 1;

    public DatabaseHamaHelper(@Nullable Context context) {
        super(context, NAMA_DATABASE, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String sql = "create table hama (id integer primary key, kode text null, judul text null, deskripsi text null);";
        Log.d("Data", "onCreate: "+sql);
        db.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
