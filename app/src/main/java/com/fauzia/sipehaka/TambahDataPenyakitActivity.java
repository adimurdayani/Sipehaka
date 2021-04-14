package com.fauzia.sipehaka;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class TambahDataPenyakitActivity extends AppCompatActivity {

    private EditText editText1, editText2, editText3, editText4;
    private Button btnAdd;

    protected Cursor cursor;
    DatabasePenyakitHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_data_penyakit);

        helper = new DatabasePenyakitHelper(this);

        editText1 = (EditText)findViewById(R.id.txIdpenyakit);
        editText2 = (EditText)findViewById(R.id.txKodekpenyakit);
        editText3 = (EditText)findViewById(R.id.txJudulpenyakit);
        editText4 = (EditText)findViewById(R.id.txDeskripsipenyakit);
        btnAdd = (Button) findViewById(R.id.btn_simpanpenyakit);


        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = helper.getWritableDatabase();

                db.execSQL("insert into penyakit(id, kode, judul, deskripsi) values('" +
                        editText1.getText().toString() + "','" +
                        editText2.getText().toString() + "','" +
                        editText3.getText().toString() + "','" +
                        editText4.getText().toString() + "')");

                Toast.makeText(getApplicationContext(), "Berhasil", Toast.LENGTH_LONG).show();
                PenyakitActivity.pa.RefreshList();
                finish();
            }
        });
    }
}
