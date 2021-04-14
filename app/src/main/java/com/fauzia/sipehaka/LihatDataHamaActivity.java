package com.fauzia.sipehaka;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.HeterogeneousExpandableList;
import android.widget.TextView;

public class LihatDataHamaActivity extends AppCompatActivity {

    private TextView textView1, textView2, textView3, textView4;
    protected Cursor cursor;
    DatabaseHamaHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lihat_data_hama);

        helper = new DatabaseHamaHelper(this);

        textView1 = (TextView)findViewById(R.id.textidhama1);
        textView2 = (TextView)findViewById(R.id.textkodehama1);
        textView3 = (TextView)findViewById(R.id.textJudulhama1);
        textView4 = (TextView)findViewById(R.id.textsisiDeskripsihama1);

        SQLiteDatabase db = helper.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM hama WHERE judul = '" +
                getIntent().getStringExtra("judul") + "'", null);
        cursor.moveToFirst();
        if(cursor.getCount()>0){
            cursor.moveToPosition(0);
            textView1.setText(cursor.getString(0).toString());
            textView2.setText(cursor.getString(1).toString());
            textView3.setText(cursor.getString(2).toString());
            textView4.setText(cursor.getString(3).toString());
        }
    }
}
