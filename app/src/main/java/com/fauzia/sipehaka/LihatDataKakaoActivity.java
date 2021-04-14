package com.fauzia.sipehaka;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.TextView;

public class LihatDataKakaoActivity extends AppCompatActivity {

    TextView textView1, textView2, textView3, textView4;
    DataHelper dbHelper;
    protected Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lihat_data_kakao);

        dbHelper = new DataHelper(this);

        textView1 = (TextView)findViewById(R.id.textidKakao);
        textView2 = (TextView)findViewById(R.id.textkode);
        textView3 = (TextView)findViewById(R.id.textJudul);
        textView4 = (TextView)findViewById(R.id.textsisiDeskripsi);

        SQLiteDatabase db = dbHelper.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM sistempakar WHERE judul = '" +
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
