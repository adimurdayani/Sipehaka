package com.fauzia.sipehaka;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.print.PrintAttributes;
import android.print.PrintDocumentAdapter;
import android.print.PrintManager;
import android.service.controls.actions.FloatAction;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.fauzia.sipehaka.Model.DataModel;
import com.fauzia.sipehaka.PDFprint.PDFUtils;
import com.fauzia.sipehaka.PDFprint.PdfDocumentAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class KonsultasiActivity extends AppCompatActivity {

    private ListView listView;
    private FloatingActionButton btnAdd;
    private ImageView imageView;

    protected Cursor cursor;
    DatabaseHamaHelper helper;
    String[] daftarlist;
    public static KonsultasiActivity ka;

    //    fungsi print data
    private static final String FILE_PRINT = "testing.pdf";
    private AlertDialog dialog;
    List<DataModel> dataModelList = new ArrayList<DataModel>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hama);

        listView = (ListView) findViewById(R.id.listData3);
        btnAdd = (FloatingActionButton) findViewById(R.id.btn_addhama);
        imageView = findViewById(R.id.imageHOme3);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(KonsultasiActivity.this, AdminActivity.class));
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(KonsultasiActivity.this, TambahDataHamaActivity.class));
            }
        });

        ka = this;
        helper = new DatabaseHamaHelper(this);
        RefreshList();

        dialog = new AlertDialog.Builder(this).setCancelable(false).setMessage("Please Wait").create();

//        addDataModel();

//        Dexter.withContext(this)
//                .withPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)
//                .withListener(new PermissionListener() {
//                    @Override
//                    public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
//                        findViewById(R.id.imageViewPrint3)
//                                .setOnClickListener(new View.OnClickListener() {
//                                    @Override
//                                    public void onClick(View v) {
//                                        createPDFFile(new StringBuilder(getAppPath())
//                                                .append(FILE_PRINT).toString());
//                                    }
//                                });
//                    }
//
//                    @Override
//                    public void onPermissionDenied(PermissionDeniedResponse permissionDeniedResponse) {
//                        Toast.makeText(KonsultasiActivity.this, "" + permissionDeniedResponse.getPermissionName(), Toast.LENGTH_SHORT).show();
//                    }
//
//                    @Override
//                    public void onPermissionRationaleShouldBeShown(PermissionRequest permissionRequest, PermissionToken permissionToken) {
//
//                    }
//                }).check();
    }

    private void createPDFFile(String path) {

        if (new File(path).exists())
            new File(path).delete();

        try {
            final Document document = new Document();
//            Save
            PdfWriter.getInstance(document, new FileOutputStream(path));

//            open
            document.open();

//            sertting
            document.setPageSize(PageSize.A4);
            document.addCreationDate();
            document.addAuthor("Fausiah Wulandari Hafid");
            document.addCreator("Uci");

//            font setting
            BaseColor colorAccent = new BaseColor(0, 153, 204, 255);
            float fontSize = 27.0f;

//            custom font
            BaseFont fontName = BaseFont.createFont("assets/fonts/brandon_medium.otf", "UTF-8", BaseFont.EMBEDDED);

//            create title of document
            Font titleFont = new Font(fontName, 30.0f, Font.NORMAL, BaseColor.BLACK);
            PDFUtils.addNewItem(document, "Data Gejala Penyakit Kakao dan Gejala Hama Kakao", Element.ALIGN_CENTER, titleFont);

            Font textFont = new Font(fontName, fontSize, Font.NORMAL, colorAccent);
            PDFUtils.addNewItem(document, "Document By: ", Element.ALIGN_LEFT, titleFont);
            PDFUtils.addNewItem(document, "Fausiah Wulandari Hafid", Element.ALIGN_LEFT, titleFont);

            PDFUtils.addLineSeparator(document);

//            Add detail
            PDFUtils.addLineSpace(document);
            PDFUtils.addNewItem(document, "Data Gejala Penyakit Kakao dan Data Gejala Hama Kakao", Element.ALIGN_CENTER, titleFont);
            PDFUtils.addLineSeparator(document);

//            use rxjava
            io.reactivex.Observable.fromIterable(dataModelList)
                    .flatMap(model -> getBitmapFromUrl(this, model, document))
                    .subscribeOn(Schedulers.computation())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(model -> {

                        PDFUtils.addNewItemWithLeftAndRight(document, model.getKode(), model.getJudul(), textFont, textFont);

//                        PDFUtils.addLineSeparator(document);

//                        PDFUtils.addNewItem(document, model.getJudul(), Element.ALIGN_LEFT, textFont);
                        PDFUtils.addLineSeparator(document);


                    }, throwable -> {
                        dialog.dismiss();
                        Toast.makeText(this, "" + throwable.getMessage(), Toast.LENGTH_SHORT).show();
                    }, () -> {
                        document.close();
                        dialog.dismiss();
                        Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show();

                        printPDF();

                    });

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void printPDF() {

        PrintManager printManager = (PrintManager) getSystemService(Context.PRINT_SERVICE);

        try {
            PrintDocumentAdapter printDocumentAdapter = new PdfDocumentAdapter(this, new StringBuilder(getAppPath())
                    .append(FILE_PRINT).toString(), FILE_PRINT);
            printManager.print("Document", printDocumentAdapter, new PrintAttributes.Builder().build());
        } catch (Exception e) {
            Toast.makeText(this, "" + e.getMessage(), Toast.LENGTH_SHORT).show();
        }

    }

    private io.reactivex.Observable<DataModel> getBitmapFromUrl(Context context, DataModel model, Document document) {

        return Observable.fromCallable(() -> {
            return model;
        });
    }

    private String getAppPath() {
        File dir = new File(android.os.Environment.getExternalStorageDirectory()
                + File.separator
                + getResources().getString(R.string.app_name)
                + File.separator);

        if (!dir.exists())
            dir.mkdir();

        return dir.getPath() + File.separator;
    }

    private void addDataModel() {
        DataModel dataModel = new DataModel("GP1", " Bercak-bercak coklat");
        dataModelList.add(dataModel);

        dataModel = new DataModel("GP2", " Kulit batang agak belekuk");
        dataModelList.add(dataModel);

        dataModel = new DataModel("GP3", " Sering terdapat cairan");
        dataModelList.add(dataModel);

        dataModel = new DataModel("GP4", " Lapisan dalam berwarna merah");
        dataModelList.add(dataModel);

        dataModel = new DataModel("GP5", " Bintik-bintik coklat pada daun");
        dataModelList.add(dataModel);

        dataModel = new DataModel("GP6", " Ranting gundul berbentuk sapu");
        dataModelList.add(dataModel);

        dataModel = new DataModel("GP7", " Daun menguning dengan bercak");
        dataModelList.add(dataModel);

        dataModel = new DataModel("GH1", " Terdapat lubang masuk dan keluar larva");
        dataModelList.add(dataModel);

        dataModel = new DataModel("GH2", " Buah sulit di belah");
        dataModelList.add(dataModel);

        dataModel = new DataModel("GH3", " Tidak terdapat rongga udara pada buah");
        dataModelList.add(dataModel);

        dataModel = new DataModel("GH4", " Kulit buah berwarna kuning tidak merata");
        dataModelList.add(dataModel);

        dataModel = new DataModel("GH5", " Perkembangan buah tidak normal");
        dataModelList.add(dataModel);

        dataModel = new DataModel("GH6", " Bercak-bercak cekung warna coklat");
        dataModelList.add(dataModel);

        dataModel = new DataModel("GH7", " Mengakibatkan retak pada permukaan");
        dataModelList.add(dataModel);
    }

    public void RefreshList() {

        //fungsi menampilkan semua database

        SQLiteDatabase db = helper.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM hama", null);
        daftarlist = new String[cursor.getCount()];
        cursor.moveToFirst();

        for (int cc = 0; cc < cursor.getCount(); cc++) {
            cursor.moveToPosition(cc);
            daftarlist[cc] = cursor.getString(2).toString();
        }

//        end fungsi menampilkan semua database
        listView.setAdapter(new ArrayAdapter(this, android.R.layout.simple_list_item_1, daftarlist));
        listView.setSelected(true);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                final String selection = daftarlist[position];
                final CharSequence[] dialogitem = {"Lihat data", "Update data", "Hapus data"};
                AlertDialog.Builder builder = new AlertDialog.Builder(KonsultasiActivity.this);
                builder.setTitle("Pilihan");
                builder.setItems(dialogitem, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which) {
                            case 0:
                                Intent lihatData = new Intent(getApplicationContext(), LihatDataHamaActivity.class);
                                lihatData.putExtra("judul", selection);
                                startActivity(lihatData);
                                break;
                            case 1:
                                Intent lihatDataId = new Intent(getApplicationContext(), UpdateDataHamaActivity.class);
                                lihatDataId.putExtra("judul", selection);
                                startActivity(lihatDataId);
                                break;
                            case 2:
                                SQLiteDatabase db = helper.getWritableDatabase();
                                db.execSQL("delete from hama where judul = '" + selection + "'");
                                RefreshList();
                                break;
                        }
                    }
                });
                builder.create().show();
            }
        });
        ((ArrayAdapter) listView.getAdapter()).notifyDataSetInvalidated();

    }
}
