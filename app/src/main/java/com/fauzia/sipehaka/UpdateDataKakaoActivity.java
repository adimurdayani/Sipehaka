package com.fauzia.sipehaka;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class UpdateDataKakaoActivity extends AppCompatActivity {

    Button btnUpdate;
    TextView textView1, textView2, textView3, textView4;
    DataHelper helper;
    protected Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_data_kakao);

        helper = new DataHelper(this);

        btnUpdate = (Button)findViewById(R.id.btn_update);
        textView1 = (TextView) findViewById(R.id.txId);
        textView2 = (TextView) findViewById(R.id.txKode);
        textView3 = (TextView) findViewById(R.id.txJudul);
        textView4 = (TextView) findViewById(R.id.txDeskripsi);

        SQLiteDatabase db = helper.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM sistempakar WHERE judul = '"+
                getIntent().getStringExtra("judul")+"' ", null);
        cursor.moveToFirst();

        if (cursor.getCount()>0){
            cursor.moveToPosition(0);
            textView1.setText(cursor.getString(0).toString());
            textView2.setText(cursor.getString(1).toString());
            textView3.setText(cursor.getString(2).toString());
            textView4.setText(cursor.getString(3).toString());
        }

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = helper.getWritableDatabase();
                db.execSQL("update sistempakar set kode='"+
                        textView2.getText().toString() +"', judul='" +
                        textView3.getText().toString()+"', deskripsi='"+
                        textView4.getText().toString() +"' where id='" +
                        textView1.getText().toString()+"'");

                Toast.makeText(getApplicationContext(), "Berhasil", Toast.LENGTH_LONG).show();
                KelolaDataActivity.ma.RefreshList();
                finish();

            }
        });
    }
}
