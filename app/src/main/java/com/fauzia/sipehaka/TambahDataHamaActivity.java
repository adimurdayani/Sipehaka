package com.fauzia.sipehaka;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class TambahDataHamaActivity extends AppCompatActivity {

    private EditText editText1, editText2, editText3, editText4;
    private Button btnSimpan;

    protected Cursor cursor;
    DatabaseHamaHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_data_hama);

        helper = new DatabaseHamaHelper(this);

        editText1 = (EditText)findViewById(R.id.txIdhama);
        editText2 = (EditText)findViewById(R.id.txKodekhama);
        editText3 = (EditText)findViewById(R.id.txJudulhama);
        editText4 = (EditText)findViewById(R.id.txDeskripsihama);
        btnSimpan = (Button) findViewById(R.id.btn_simpanhama);

        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SQLiteDatabase db = helper.getWritableDatabase();

                db.execSQL("insert into hama(id, kode, judul, deskripsi) values('" +
                        editText1.getText().toString() + "','" +
                        editText2.getText().toString() + "','" +
                        editText3.getText().toString() + "','" +
                        editText4.getText().toString() + "')");

                Toast.makeText(getApplicationContext(), "Data berhasil disimpan", Toast.LENGTH_SHORT).show();
                KonsultasiActivity.ka.RefreshList();
                finish();

            }
        });
    }
}
