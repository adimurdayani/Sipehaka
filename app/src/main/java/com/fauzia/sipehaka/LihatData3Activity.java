package com.fauzia.sipehaka;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class LihatData3Activity extends AppCompatActivity {

//    private ListView listView1, listView2;
//    protected Cursor cursor;
//
//    DatabaseHamaHelper helper;
//    String[] list1,list2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lihat_data3);

//        helper = new DatabaseHamaHelper(this);
//
//        listView1 = (ListView)findViewById(R.id.listview5);
//        listView2 = (ListView)findViewById(R.id.listview6);
//
//        SQLiteDatabase db = helper.getReadableDatabase();
//        cursor = db.rawQuery("SELECT * FROM hama", null);
//        list1 = new String[cursor.getCount()];
//        list2 = new String[cursor.getCount()];
//        cursor.moveToFirst();
//
//        for (int cc = 0; cc < cursor.getCount(); cc++){
//            cursor.moveToPosition(cc);
//            list1[cc] = cursor.getString(1).toString();
//            list2[cc] = cursor.getString(2).toString();
//        }
//        listView1.setAdapter(new ArrayAdapter(this,android.R.layout.simple_list_item_1, list1));
//        listView2.setAdapter(new ArrayAdapter(this,android.R.layout.simple_list_item_1, list2));
    }
}
