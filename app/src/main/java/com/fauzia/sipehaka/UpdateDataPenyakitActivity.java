package com.fauzia.sipehaka;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateDataPenyakitActivity extends AppCompatActivity {

    private EditText editText1, editText2, editText3, editText4;
    private Button btnUpdate;

    protected Cursor cursor;
    DatabasePenyakitHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_data_penyakit);

        helper = new DatabasePenyakitHelper(this);

        editText1 = (EditText)findViewById(R.id.txIdpenyakit1);
        editText2 = (EditText)findViewById(R.id.txKodepenyakit1);
        editText3 = (EditText)findViewById(R.id.txJudulpenyakit1);
        editText4 = (EditText)findViewById(R.id.txDeskripsipenyakit1);
        btnUpdate = (Button)findViewById(R.id.btn_updatepenyakit1);

        SQLiteDatabase db = helper.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM penyakit WHERE judul = '"+
                getIntent().getStringExtra("judul")+"' ", null);
        cursor.moveToFirst();

        if (cursor.getCount()>0){
            cursor.moveToPosition(0);
            editText1.setText(cursor.getString(0).toString());
            editText2.setText(cursor.getString(1).toString());
            editText3.setText(cursor.getString(2).toString());
            editText4.setText(cursor.getString(3).toString());
        }


        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = helper.getWritableDatabase();

                db.execSQL("update penyakit set kode='"+
                        editText2.getText().toString() +"', judul='" +
                        editText3.getText().toString()+"', deskripsi='"+
                        editText4.getText().toString() +"' where id='" +
                        editText1.getText().toString()+"'");

                Toast.makeText(getApplicationContext(),"Data berhasil diupdate", Toast.LENGTH_SHORT).show();
                PenyakitActivity.pa.RefreshList();
                finish();
            }
        });
    }
}
