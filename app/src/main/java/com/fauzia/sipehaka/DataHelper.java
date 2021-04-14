package com.fauzia.sipehaka;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class DataHelper extends SQLiteOpenHelper {

    private static final String NAMA_DATABASE = "dbkakao.db";
    private static final int DATABASE_VERSI = 1;

    public DataHelper(@Nullable Context context) {
        super(context, NAMA_DATABASE, null , DATABASE_VERSI);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String sql = "create table sistempakar (id integer primary key, kode text null, judul text null, deskripsi text null);";
        Log.d("Data","onCreate: "+sql);
        db.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
