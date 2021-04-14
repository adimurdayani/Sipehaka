package com.fauzia.sipehaka;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Objects;

public class InputActivity extends AppCompatActivity {

    Button simpan;
    EditText kode, judul, deskripsi, id;
    DataHelper dbHelper;
    protected Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);

        dbHelper = new DataHelper(this);

        simpan = (Button) findViewById(R.id.btn_simpan);
        id  = (EditText) findViewById(R.id.txId);
        kode  = (EditText) findViewById(R.id.txKode);
        judul  = (EditText) findViewById(R.id.txJudul);
        deskripsi  = (EditText) findViewById(R.id.txDeskripsi);

        simpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();

                db.execSQL("insert into sistempakar(id, kode, judul, deskripsi) values('" +
                        id.getText().toString() + "','" +
                        kode.getText().toString() + "','" +
                        judul.getText().toString() + "','" +
                        deskripsi.getText().toString() + "')");

                Toast.makeText(getApplicationContext(), "Berhasil", Toast.LENGTH_LONG).show();
                KelolaDataActivity.ma.RefreshList();
                finish();
            }
        });

    }

}
