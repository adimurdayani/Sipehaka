package com.fauzia.sipehaka;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class LihatDataPenyakitActivity extends AppCompatActivity {

    private TextView textView1, textView2, textView3, textView4;
    private ImageView imageView;

    protected Cursor cursor;
    DatabasePenyakitHelper helper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lihat_data_penyakit);

        helper = new DatabasePenyakitHelper(this);

        textView1 = (TextView)findViewById(R.id.textidopenyakit);
        textView2 = (TextView)findViewById(R.id.textkodepenyakit);
        textView3 = (TextView)findViewById(R.id.textJudulpenyakit);
        textView4 = (TextView)findViewById(R.id.textsisipenyakit);

        SQLiteDatabase db = helper.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM penyakit WHERE judul = '" +
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
