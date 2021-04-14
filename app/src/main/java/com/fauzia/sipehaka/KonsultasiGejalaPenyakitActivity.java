package com.fauzia.sipehaka;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.print.PrintAttributes;
import android.print.PrintDocumentAdapter;
import android.print.PrintManager;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
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

public class KonsultasiGejalaPenyakitActivity extends AppCompatActivity {

    private CheckBox
            checkBox1,
            checkBox2,
            checkBox3,
            checkBox4,
            checkBox5,
            checkBox6,
            checkBox7,
            checkBox8,
            checkBox9,
            checkBox10,
            checkBox11,
            checkBox12,
            checkBox13,
            checkBox14,
            checkBox15,
            checkBox16,
            checkBox17,
            checkBox18,
            checkBox19,
            checkBox20,
            checkBox21,
            checkBox22,
            checkBox23;

    private FloatingActionButton button1, button2;
    private TextView textView, textView2;
    Dialog dialog;
    private static final String FILE_PRINT = "hasil_diagnosa.pdf";
    private AlertDialog alertDialog;
    List<DataModel> dataModelList = new ArrayList<DataModel>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_konsultasi_gejala_penyakit);

        checkBox1 = (CheckBox) findViewById(R.id.checkboxpenyakit1);
        checkBox2 = (CheckBox) findViewById(R.id.checkboxpenyakit2);
        checkBox3 = (CheckBox) findViewById(R.id.checkboxpenyakit3);
        checkBox4 = (CheckBox) findViewById(R.id.checkboxpenyakit4);
        checkBox5 = (CheckBox) findViewById(R.id.checkboxpenyakit5);
        checkBox6 = (CheckBox) findViewById(R.id.checkboxpenyakit6);
        checkBox7 = (CheckBox) findViewById(R.id.checkboxpenyakit7);
        checkBox8 = (CheckBox) findViewById(R.id.checkboxpenyakit8);
        checkBox9 = (CheckBox) findViewById(R.id.checkboxpenyakit9);
        checkBox10 = (CheckBox) findViewById(R.id.checkboxpenyakit10);
        checkBox11 = (CheckBox) findViewById(R.id.checkboxpenyakit11);
        checkBox12 = (CheckBox) findViewById(R.id.checkboxpenyakit12);
        checkBox13 = (CheckBox) findViewById(R.id.checkboxpenyakit13);
        checkBox14 = (CheckBox) findViewById(R.id.checkboxpenyakit14);
        checkBox15 = (CheckBox) findViewById(R.id.checkboxpenyakit15);
        checkBox16 = (CheckBox) findViewById(R.id.checkboxpenyakit16);
        checkBox17 = (CheckBox) findViewById(R.id.checkboxpenyakit17);
        checkBox18 = (CheckBox) findViewById(R.id.checkboxpenyakit18);
        checkBox18 = (CheckBox) findViewById(R.id.checkboxpenyakit19);
        checkBox19 = (CheckBox) findViewById(R.id.checkboxpenyakit20);
        checkBox20 = (CheckBox) findViewById(R.id.checkboxpenyakit21);
        checkBox21 = (CheckBox) findViewById(R.id.checkboxpenyakit22);
        checkBox22 = (CheckBox) findViewById(R.id.checkboxpenyakit23);
        checkBox23 = (CheckBox) findViewById(R.id.checkboxpenyakit23);

        dialog = new Dialog(this);

        button1 = (FloatingActionButton) findViewById(R.id.btndiagnosapenyakit);
//        textView = (TextView)findViewById(R.id.hasildiagnosa);

//        textView.setText("");

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBox1.isChecked() && checkBox2.isChecked()) {
                    openDialog1();
                } else if (checkBox1.isChecked()) {
                    openDialog1();
                } else if (checkBox2.isChecked()) {
                    openDialog1();
                } else if (checkBox3.isChecked() && checkBox4.isChecked() && checkBox5.isChecked()) {
                    openDialog2();
                } else if (checkBox3.isChecked()) {
                    openDialog2();
                } else if (checkBox4.isChecked()) {
                    openDialog2();
                } else if (checkBox5.isChecked()) {
                    openDialog2();
                } else if (checkBox6.isChecked() && checkBox7.isChecked() && checkBox8.isChecked()) {
                    openDialog3();
                } else if (checkBox6.isChecked()) {
                    openDialog3();
                } else if (checkBox7.isChecked()) {
                    openDialog3();
                } else if (checkBox8.isChecked()) {
                    openDialog3();
                } else if (checkBox9.isChecked() && checkBox10.isChecked() && checkBox11.isChecked() && checkBox12.isChecked() && checkBox13.isChecked()) {
                    openDialog4();
                } else if (checkBox9.isChecked()) {
                    openDialog4();
                } else if (checkBox10.isChecked()) {
                    openDialog4();
                } else if (checkBox11.isChecked()) {
                    openDialog4();
                } else if (checkBox12.isChecked()) {
                    openDialog4();
                } else if (checkBox13.isChecked()) {
                    openDialog4();
                } else if (checkBox14.isChecked() && checkBox15.isChecked() && checkBox16.isChecked() && checkBox17.isChecked() && checkBox18.isChecked()) {
                    openDialog5();
                } else if (checkBox14.isChecked()) {
                    openDialog5();
                } else if (checkBox15.isChecked()) {
                    openDialog5();
                } else if (checkBox16.isChecked()) {
                    openDialog5();
                } else if (checkBox17.isChecked()) {
                    openDialog5();
                } else if (checkBox18.isChecked()) {
                    openDialog5();
                } else if (checkBox19.isChecked() && checkBox20.isChecked() && checkBox21.isChecked()) {
                    openDialog6();
                } else if (checkBox19.isChecked()) {
                    openDialog6();
                } else if (checkBox20.isChecked()) {
                    openDialog6();
                } else if (checkBox21.isChecked()) {
                    openDialog6();
                } else if (checkBox22.isChecked() && checkBox23.isChecked()) {
                    openDialog7();
                } else if (checkBox22.isChecked()) {
                    openDialog7();
                } else if (checkBox23.isChecked()) {
                    openDialog7();
                } else {
                    Toast.makeText(KonsultasiGejalaPenyakitActivity.this, "Anda belum pilih salah satu diagnosa", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void openDialog1() {

        dialog.setContentView(R.layout.hasil_diagnosapenyakit1);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        textView = dialog.findViewById(R.id.hasildiagnosa);
        textView2 = dialog.findViewById(R.id.caramenecegah);

        String hasildiagnosapenyakit = "";
        String deskripsi = "";

        if (checkBox1.isChecked()) {
            hasildiagnosapenyakit += "Penyakit busuk buah";
            deskripsi += "Solusi: melakukan anitassi kebun yaitu memetik semua buah busuk kemudian dibenamkan kedalam tanah kedalam 30cm, kultur teknis yaitu dengan pengaturan pohon pelindung dan pangkasan tanaman kakao sehingga kelembapan di dalam kebun turun, bahan kimiawi yaitu penyemprotan buah-buah sehiat secara preventif dengan fungisida berbahan aktif tembaga konsentrasi formulasi 0,3% selang waktu 2 minggu.";
        } else if (checkBox2.isChecked()) {
            hasildiagnosapenyakit += "Penyakit busuk buah";
            deskripsi += "Solusi: melakukan anitassi kebun yaitu memetik semua buah busuk kemudian dibenamkan kedalam tanah kedalam 30cm, kultur teknis yaitu dengan pengaturan pohon pelindung dan pangkasan tanaman kakao sehingga kelembapan di dalam kebun turun, bahan kimiawi yaitu penyemprotan buah-buah sehiat secara preventif dengan fungisida berbahan aktif tembaga konsentrasi formulasi 0,3% selang waktu 2 minggu.";
        } else if (checkBox1.isChecked() && checkBox2.isChecked()) {
            hasildiagnosapenyakit += "Penyakit busuk buah";
            deskripsi += "Solusi: melakukan anitassi kebun yaitu memetik semua buah busuk kemudian dibenamkan kedalam tanah kedalam 30cm, kultur teknis yaitu dengan pengaturan pohon pelindung dan pangkasan tanaman kakao sehingga kelembapan di dalam kebun turun, bahan kimiawi yaitu penyemprotan buah-buah sehiat secara preventif dengan fungisida berbahan aktif tembaga konsentrasi formulasi 0,3% selang waktu 2 minggu.";
        } else {
            hasildiagnosapenyakit += "Penyakit tidak diketahui";
            deskripsi += "Solusi tidak di ketahui";
        }

        textView.setText("" + hasildiagnosapenyakit);
        textView2.setText("" + deskripsi);

        ImageView imageView = dialog.findViewById(R.id.close);
        ImageView imageViewprint = dialog.findViewById(R.id.printpenyakit1);
        Button btnOk = dialog.findViewById(R.id.Oke);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                Toast.makeText(getApplicationContext(), "Keluar", Toast.LENGTH_SHORT).show();
            }
        });

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                Toast.makeText(getApplicationContext(), "Keluar", Toast.LENGTH_SHORT).show();
            }
        });
        alertDialog = new AlertDialog.Builder(this).setCancelable(false).setMessage("Please Wait").create();
        addDataModel1();
        Dexter.withContext(this)
                .withPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)
                .withListener(new PermissionListener() {
                    @Override
                    public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                        imageViewprint.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                createPDFFile1(new StringBuilder(getAppPath1())
                                        .append(FILE_PRINT).toString());
                            }
                        });
                    }

                    @Override
                    public void onPermissionDenied(PermissionDeniedResponse permissionDeniedResponse) {
                        Toast.makeText(KonsultasiGejalaPenyakitActivity.this, "" + permissionDeniedResponse.getPermissionName(), Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onPermissionRationaleShouldBeShown(PermissionRequest permissionRequest, PermissionToken permissionToken) {

                    }
                }).check();
        dialog.show();

    }

    private void createPDFFile1(String path) {

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
            PDFUtils.addNewItem(document, "Hasil Diagnosa", Element.ALIGN_CENTER, titleFont);

            Font textFont = new Font(fontName, fontSize, Font.NORMAL, colorAccent);
            PDFUtils.addNewItem(document, "Document By: ", Element.ALIGN_LEFT, titleFont);
            PDFUtils.addNewItem(document, "Fausiah Wulandari Hafid", Element.ALIGN_LEFT, titleFont);

            PDFUtils.addLineSeparator(document);

//            Add detail
            PDFUtils.addLineSpace(document);
            PDFUtils.addNewItem(document, "Hasil diagnosa penyakit tanaman kakao", Element.ALIGN_CENTER, titleFont);
            PDFUtils.addLineSeparator(document);

//            use rxjava
            io.reactivex.Observable.fromIterable(dataModelList)
                    .flatMap(model -> getBitmapFromUrl1(this, model, document))
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

                        printPDF1();

                    });

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void printPDF1() {

        PrintManager printManager = (PrintManager) getSystemService(Context.PRINT_SERVICE);

        try {
            PrintDocumentAdapter printDocumentAdapter = new PdfDocumentAdapter(this, new StringBuilder(getAppPath1())
                    .append(FILE_PRINT).toString(), FILE_PRINT);
            printManager.print("Document", printDocumentAdapter, new PrintAttributes.Builder().build());
        } catch (Exception e) {
            Toast.makeText(this, "" + e.getMessage(), Toast.LENGTH_SHORT).show();
        }

    }

    private io.reactivex.Observable<DataModel> getBitmapFromUrl1(Context context, DataModel model, Document document) {

        return Observable.fromCallable(() -> {
            return model;
        });
    }

    private String getAppPath1() {
        File dir = new File(android.os.Environment.getExternalStorageDirectory()
                + File.separator
                + getResources().getString(R.string.app_name)
                + File.separator);

        if (!dir.exists())
            dir.mkdir();

        return dir.getPath() + File.separator;
    }

    private void addDataModel1() {
        DataModel dataModel = new DataModel("Penyakit busuk buah = ", " \nSolusi: melakukan anitassi kebun yaitu memetik semua buah busuk kemudian dibenamkan kedalam tanah kedalam 30cm, kultur teknis yaitu dengan pengaturan pohon pelindung dan pangkasan tanaman kakao sehingga kelembapan di dalam kebun turun, bahan kimiawi yaitu penyemprotan buah-buah sehiat secara preventif dengan fungisida berbahan aktif tembaga konsentrasi formulasi 0,3% selang waktu 2 minggu.");
        dataModelList.add(dataModel);
    }

    private void openDialog2() {
        dialog.setContentView(R.layout.hasil_diagnosapenyakit2);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        textView = dialog.findViewById(R.id.hasildiagnosa);
        textView2 = dialog.findViewById(R.id.caramenecegah);

        String hasildiagnosapenyakit = "";
        String deskripsi = "";

        if (checkBox3.isChecked()) {
            hasildiagnosapenyakit += "Penyakit kangker batang";
            deskripsi += "Solusi: pengendalliannya adalah kulit batang yang membusuk dikupas sampai batas kulit yang sehat, luka kupasan selanjutnya dioles dengan fungisida tembaga konstrasi 5% formulasi, apabila serangan pada kulit batang sudah hampir melingkar maka tanaman harus dipotong atau dibungkar.";
        } else if (checkBox4.isChecked()) {
            hasildiagnosapenyakit += "Penyakit kangker batang";
            deskripsi += "Solusi: pengendalliannya adalah kulit batang yang membusuk dikupas sampai batas kulit yang sehat, luka kupasan selanjutnya dioles dengan fungisida tembaga konstrasi 5% formulasi, apabila serangan pada kulit batang sudah hampir melingkar maka tanaman harus dipotong atau dibungkar.";
        } else if (checkBox5.isChecked()) {
            hasildiagnosapenyakit += "Penyakit kangker batang";
            deskripsi += "Solusi: pengendalliannya adalah kulit batang yang membusuk dikupas sampai batas kulit yang sehat, luka kupasan selanjutnya dioles dengan fungisida tembaga konstrasi 5% formulasi, apabila serangan pada kulit batang sudah hampir melingkar maka tanaman harus dipotong atau dibungkar.";
        } else if (checkBox3.isChecked() && checkBox4.isChecked()) {
            hasildiagnosapenyakit += "Penyakit kangker batang";
            deskripsi += "Solusi: pengendalliannya adalah kulit batang yang membusuk dikupas sampai batas kulit yang sehat, luka kupasan selanjutnya dioles dengan fungisida tembaga konstrasi 5% formulasi, apabila serangan pada kulit batang sudah hampir melingkar maka tanaman harus dipotong atau dibungkar.";
        } else if (checkBox3.isChecked() && checkBox4.isChecked() && checkBox5.isChecked()) {
            hasildiagnosapenyakit += "Penyakit kangker batang";
            deskripsi += "Solusi: pengendalliannya adalah kulit batang yang membusuk dikupas sampai batas kulit yang sehat, luka kupasan selanjutnya dioles dengan fungisida tembaga konstrasi 5% formulasi, apabila serangan pada kulit batang sudah hampir melingkar maka tanaman harus dipotong atau dibungkar.";
        }
        textView.setText("" + hasildiagnosapenyakit);
        textView2.setText("" + deskripsi);

        ImageView imageView = dialog.findViewById(R.id.close);
        ImageView imageViewprint = dialog.findViewById(R.id.printpenyakit2);
        Button btnOk = dialog.findViewById(R.id.Oke);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                Toast.makeText(getApplicationContext(), "Keluar", Toast.LENGTH_SHORT).show();
            }
        });

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                Toast.makeText(getApplicationContext(), "Keluar", Toast.LENGTH_SHORT).show();
            }
        });

        alertDialog = new AlertDialog.Builder(this).setCancelable(false).setMessage("Please Wait").create();
        addDataModel1();
        Dexter.withContext(this)
                .withPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)
                .withListener(new PermissionListener() {
                    @Override
                    public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                        imageViewprint.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                createPDFFile2(new StringBuilder(getAppPath2())
                                        .append(FILE_PRINT).toString());
                            }
                        });
                    }

                    @Override
                    public void onPermissionDenied(PermissionDeniedResponse permissionDeniedResponse) {
                        Toast.makeText(KonsultasiGejalaPenyakitActivity.this, "" + permissionDeniedResponse.getPermissionName(), Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onPermissionRationaleShouldBeShown(PermissionRequest permissionRequest, PermissionToken permissionToken) {

                    }
                }).check();

        dialog.show();
    }

    private void createPDFFile2(String path) {

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
            PDFUtils.addNewItem(document, "Hasil Diagnosa", Element.ALIGN_CENTER, titleFont);

            Font textFont = new Font(fontName, fontSize, Font.NORMAL, colorAccent);
            PDFUtils.addNewItem(document, "Document By: ", Element.ALIGN_LEFT, titleFont);
            PDFUtils.addNewItem(document, "Fausiah Wulandari Hafid", Element.ALIGN_LEFT, titleFont);

            PDFUtils.addLineSeparator(document);

//            Add detail
            PDFUtils.addLineSpace(document);
            PDFUtils.addNewItem(document, "Hasil diagnosa penyakit tanaman kakao", Element.ALIGN_CENTER, titleFont);
            PDFUtils.addLineSeparator(document);

//            use rxjava
            io.reactivex.Observable.fromIterable(dataModelList)
                    .flatMap(model -> getBitmapFromUrl2(this, model, document))
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

                        printPDF2();

                    });

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void printPDF2() {

        PrintManager printManager = (PrintManager) getSystemService(Context.PRINT_SERVICE);

        try {
            PrintDocumentAdapter printDocumentAdapter = new PdfDocumentAdapter(this, new StringBuilder(getAppPath2())
                    .append(FILE_PRINT).toString(), FILE_PRINT);
            printManager.print("Document", printDocumentAdapter, new PrintAttributes.Builder().build());
        } catch (Exception e) {
            Toast.makeText(this, "" + e.getMessage(), Toast.LENGTH_SHORT).show();
        }

    }

    private io.reactivex.Observable<DataModel> getBitmapFromUrl2(Context context, DataModel model, Document document) {

        return Observable.fromCallable(() -> {
            return model;
        });
    }

    private String getAppPath2() {
        File dir = new File(android.os.Environment.getExternalStorageDirectory()
                + File.separator
                + getResources().getString(R.string.app_name)
                + File.separator);

        if (!dir.exists())
            dir.mkdir();

        return dir.getPath() + File.separator;
    }

    private void addDataModel2() {
        DataModel dataModel = new DataModel("Penyakit kangker batang = ", " \nSolusi: pengendalliannya adalah kulit batang yang membusuk dikupas sampai batas kulit yang sehat, luka kupasan selanjutnya dioles dengan fungisida tembaga konstrasi 5% formulasi, apabila serangan pada kulit batang sudah hampir melingkar maka tanaman harus dipotong atau dibungkar.");
        dataModelList.add(dataModel);
    }

    private void openDialog3() {
        dialog.setContentView(R.layout.hasil_diagnosapenyakit3);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        textView = dialog.findViewById(R.id.hasildiagnosa);
        textView2 = dialog.findViewById(R.id.caramenecegah);

        String hasildiagnosapenyakit = "";
        String deskripsi = "";

        if (checkBox6.isChecked()) {
            hasildiagnosapenyakit += "Penyakit antraknose colletori";
            deskripsi += "Solusi: Pengendalian adalah perbaikan kondisi tanaman yaitu dengan pemupukan ekstra, perbaikan kondisi lingkungan yaitu dengan memberikan pohon penaung secukupnya, sanitasi yaitu menghilangkan rangting-ranting yang telah kering dan merampas buah busuk, penyemprotan fungisida yaitu untuk melindungi flush yang tumbuh dengan fungisida berbahan aktif mankozeb 0,5% formulasi atau prokloras 0,1% formulasi, eradikasi yaitu membongkar tanaman yang terserang berat.";
        } else if (checkBox7.isChecked()) {
            hasildiagnosapenyakit += "Penyakit antraknose colletori";
            deskripsi += "Solusi: Pengendalian adalah perbaikan kondisi tanaman yaitu dengan pemupukan ekstra, perbaikan kondisi lingkungan yaitu dengan memberikan pohon penaung secukupnya, sanitasi yaitu menghilangkan rangting-ranting yang telah kering dan merampas buah busuk, penyemprotan fungisida yaitu untuk melindungi flush yang tumbuh dengan fungisida berbahan aktif mankozeb 0,5% formulasi atau prokloras 0,1% formulasi, eradikasi yaitu membongkar tanaman yang terserang berat.";
        } else if (checkBox8.isChecked()) {
            hasildiagnosapenyakit += "Penyakit antraknose colletori";
            deskripsi += "Solusi: Pengendalian adalah perbaikan kondisi tanaman yaitu dengan pemupukan ekstra, perbaikan kondisi lingkungan yaitu dengan memberikan pohon penaung secukupnya, sanitasi yaitu menghilangkan rangting-ranting yang telah kering dan merampas buah busuk, penyemprotan fungisida yaitu untuk melindungi flush yang tumbuh dengan fungisida berbahan aktif mankozeb 0,5% formulasi atau prokloras 0,1% formulasi, eradikasi yaitu membongkar tanaman yang terserang berat.";
        } else if (checkBox6.isChecked() && checkBox7.isChecked()) {
            hasildiagnosapenyakit += "Penyakit antraknose colletori";
            deskripsi += "Solusi: Pengendalian adalah perbaikan kondisi tanaman yaitu dengan pemupukan ekstra, perbaikan kondisi lingkungan yaitu dengan memberikan pohon penaung secukupnya, sanitasi yaitu menghilangkan rangting-ranting yang telah kering dan merampas buah busuk, penyemprotan fungisida yaitu untuk melindungi flush yang tumbuh dengan fungisida berbahan aktif mankozeb 0,5% formulasi atau prokloras 0,1% formulasi, eradikasi yaitu membongkar tanaman yang terserang berat.";
        } else if (checkBox6.isChecked() && checkBox7.isChecked() && checkBox8.isChecked()) {
            hasildiagnosapenyakit += "Penyakit antraknose colletori";
            deskripsi += "Solusi: Pengendalian adalah perbaikan kondisi tanaman yaitu dengan pemupukan ekstra, perbaikan kondisi lingkungan yaitu dengan memberikan pohon penaung secukupnya, sanitasi yaitu menghilangkan rangting-ranting yang telah kering dan merampas buah busuk, penyemprotan fungisida yaitu untuk melindungi flush yang tumbuh dengan fungisida berbahan aktif mankozeb 0,5% formulasi atau prokloras 0,1% formulasi, eradikasi yaitu membongkar tanaman yang terserang berat.";
        }
        textView.setText("" + hasildiagnosapenyakit);
        textView2.setText("" + deskripsi);

        ImageView imageView = dialog.findViewById(R.id.close);
        ImageView imageViewprint = dialog.findViewById(R.id.printpenyakit3);
        Button btnOk = dialog.findViewById(R.id.Oke);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                Toast.makeText(getApplicationContext(), "Keluar", Toast.LENGTH_SHORT).show();
            }
        });

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                Toast.makeText(getApplicationContext(), "Keluar", Toast.LENGTH_SHORT).show();
            }
        });
        alertDialog = new AlertDialog.Builder(this).setCancelable(false).setMessage("Please Wait").create();
        addDataModel1();
        Dexter.withContext(this)
                .withPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)
                .withListener(new PermissionListener() {
                    @Override
                    public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                        imageViewprint.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                createPDFFile3(new StringBuilder(getAppPath3())
                                        .append(FILE_PRINT).toString());
                            }
                        });
                    }

                    @Override
                    public void onPermissionDenied(PermissionDeniedResponse permissionDeniedResponse) {
                        Toast.makeText(KonsultasiGejalaPenyakitActivity.this, "" + permissionDeniedResponse.getPermissionName(), Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onPermissionRationaleShouldBeShown(PermissionRequest permissionRequest, PermissionToken permissionToken) {

                    }
                }).check();

        dialog.show();
    }

    private void createPDFFile3(String path) {

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
            PDFUtils.addNewItem(document, "Hasil Diagnosa", Element.ALIGN_CENTER, titleFont);

            Font textFont = new Font(fontName, fontSize, Font.NORMAL, colorAccent);
            PDFUtils.addNewItem(document, "Document By: ", Element.ALIGN_LEFT, titleFont);
            PDFUtils.addNewItem(document, "Fausiah Wulandari Hafid", Element.ALIGN_LEFT, titleFont);

            PDFUtils.addLineSeparator(document);

//            Add detail
            PDFUtils.addLineSpace(document);
            PDFUtils.addNewItem(document, "Hasil diagnosa penyakit tanaman kakao", Element.ALIGN_CENTER, titleFont);
            PDFUtils.addLineSeparator(document);

//            use rxjava
            io.reactivex.Observable.fromIterable(dataModelList)
                    .flatMap(model -> getBitmapFromUrl3(this, model, document))
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

                        printPDF3();

                    });

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void printPDF3() {

        PrintManager printManager = (PrintManager) getSystemService(Context.PRINT_SERVICE);

        try {
            PrintDocumentAdapter printDocumentAdapter = new PdfDocumentAdapter(this, new StringBuilder(getAppPath3())
                    .append(FILE_PRINT).toString(), FILE_PRINT);
            printManager.print("Document", printDocumentAdapter, new PrintAttributes.Builder().build());
        } catch (Exception e) {
            Toast.makeText(this, "" + e.getMessage(), Toast.LENGTH_SHORT).show();
        }

    }

    private io.reactivex.Observable<DataModel> getBitmapFromUrl3(Context context, DataModel model, Document document) {

        return Observable.fromCallable(() -> {
            return model;
        });
    }

    private String getAppPath3() {
        File dir = new File(android.os.Environment.getExternalStorageDirectory()
                + File.separator
                + getResources().getString(R.string.app_name)
                + File.separator);

        if (!dir.exists())
            dir.mkdir();

        return dir.getPath() + File.separator;
    }

    private void addDataModel3() {
        DataModel dataModel = new DataModel("Penyakit antraknose colletori = ", " \nSolusi: Pengendalian adalah perbaikan kondisi tanaman yaitu dengan pemupukan ekstra, perbaikan kondisi lingkungan yaitu dengan memberikan pohon penaung secukupnya, sanitasi yaitu menghilangkan rangting-ranting yang telah kering dan merampas buah busuk, penyemprotan fungisida yaitu untuk melindungi flush yang tumbuh dengan fungisida berbahan aktif mankozeb 0,5% formulasi atau prokloras 0,1% formulasi, eradikasi yaitu membongkar tanaman yang terserang berat.");
        dataModelList.add(dataModel);
    }

    private void openDialog4() {
        dialog.setContentView(R.layout.hasil_diagnosapenyakit4);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        textView = dialog.findViewById(R.id.hasildiagnosa);
        textView2 = dialog.findViewById(R.id.caramenecegah);

        String hasildiagnosapenyakit = "";
        String deskripsi = "";

        if (checkBox9.isChecked()) {
            hasildiagnosapenyakit += "Penyakit Vascular Streak Dieback";
            deskripsi += "Solusi: Pengendalianya adalah perbaikan kondisi tanaman yaitu dengan pemupukan ekstra, perbaikan kondisi lingkungan yaitu dengan memberikan pohon penaung secukupnya, sanitasi yaitu menghilangkan ranting-ranting yang telah kering dan merampas buahbuah busuk,penyemprotan fungisida yaitu untuk melindungi flush yang tumbuh dengan fungisida berbahan aktif mankozeb 0,5% formulasi atau prokloras 0,1% formulasi,eradikasi yaitu membongkar tanaman yang terserang berat.";
        } else if (checkBox10.isChecked()) {
            hasildiagnosapenyakit += "Penyakit Vascular Streak Dieback";
            deskripsi += "Solusi: Pengendalianya adalah perbaikan kondisi tanaman yaitu dengan pemupukan ekstra, perbaikan kondisi lingkungan yaitu dengan memberikan pohon penaung secukupnya, sanitasi yaitu menghilangkan ranting-ranting yang telah kering dan merampas buahbuah busuk,penyemprotan fungisida yaitu untuk melindungi flush yang tumbuh dengan fungisida berbahan aktif mankozeb 0,5% formulasi atau prokloras 0,1% formulasi,eradikasi yaitu membongkar tanaman yang terserang berat.";
        } else if (checkBox11.isChecked()) {
            hasildiagnosapenyakit += "Penyakit Vascular Streak Dieback";
            deskripsi += "Solusi: Pengendalianya adalah perbaikan kondisi tanaman yaitu dengan pemupukan ekstra, perbaikan kondisi lingkungan yaitu dengan memberikan pohon penaung secukupnya, sanitasi yaitu menghilangkan ranting-ranting yang telah kering dan merampas buahbuah busuk,penyemprotan fungisida yaitu untuk melindungi flush yang tumbuh dengan fungisida berbahan aktif mankozeb 0,5% formulasi atau prokloras 0,1% formulasi,eradikasi yaitu membongkar tanaman yang terserang berat.";
        } else if (checkBox12.isChecked()) {
            hasildiagnosapenyakit += "Penyakit Vascular Streak Dieback";
            deskripsi += "Solusi: Pengendalianya adalah perbaikan kondisi tanaman yaitu dengan pemupukan ekstra, perbaikan kondisi lingkungan yaitu dengan memberikan pohon penaung secukupnya, sanitasi yaitu menghilangkan ranting-ranting yang telah kering dan merampas buahbuah busuk,penyemprotan fungisida yaitu untuk melindungi flush yang tumbuh dengan fungisida berbahan aktif mankozeb 0,5% formulasi atau prokloras 0,1% formulasi,eradikasi yaitu membongkar tanaman yang terserang berat.";
        } else if (checkBox13.isChecked()) {
            hasildiagnosapenyakit += "Penyakit Vascular Streak Dieback";
            deskripsi += "Solusi: Pengendalianya adalah perbaikan kondisi tanaman yaitu dengan pemupukan ekstra, perbaikan kondisi lingkungan yaitu dengan memberikan pohon penaung secukupnya, sanitasi yaitu menghilangkan ranting-ranting yang telah kering dan merampas buahbuah busuk,penyemprotan fungisida yaitu untuk melindungi flush yang tumbuh dengan fungisida berbahan aktif mankozeb 0,5% formulasi atau prokloras 0,1% formulasi,eradikasi yaitu membongkar tanaman yang terserang berat.";
        } else if (checkBox9.isChecked() && checkBox10.isChecked()) {
            hasildiagnosapenyakit += "Penyakit Vascular Streak Dieback";
            deskripsi += "Solusi: Pengendalianya adalah perbaikan kondisi tanaman yaitu dengan pemupukan ekstra, perbaikan kondisi lingkungan yaitu dengan memberikan pohon penaung secukupnya, sanitasi yaitu menghilangkan ranting-ranting yang telah kering dan merampas buahbuah busuk,penyemprotan fungisida yaitu untuk melindungi flush yang tumbuh dengan fungisida berbahan aktif mankozeb 0,5% formulasi atau prokloras 0,1% formulasi,eradikasi yaitu membongkar tanaman yang terserang berat.";
        } else if (checkBox9.isChecked() && checkBox10.isChecked() && checkBox11.isChecked()) {
            hasildiagnosapenyakit += "Penyakit Vascular Streak Dieback";
            deskripsi += "Solusi: Pengendalianya adalah perbaikan kondisi tanaman yaitu dengan pemupukan ekstra, perbaikan kondisi lingkungan yaitu dengan memberikan pohon penaung secukupnya, sanitasi yaitu menghilangkan ranting-ranting yang telah kering dan merampas buahbuah busuk,penyemprotan fungisida yaitu untuk melindungi flush yang tumbuh dengan fungisida berbahan aktif mankozeb 0,5% formulasi atau prokloras 0,1% formulasi,eradikasi yaitu membongkar tanaman yang terserang berat.";
        } else if (checkBox9.isChecked() && checkBox10.isChecked() && checkBox11.isChecked() && checkBox12.isChecked()) {
            hasildiagnosapenyakit += "Penyakit Vascular Streak Dieback";
            deskripsi += "Solusi: Pengendalianya adalah perbaikan kondisi tanaman yaitu dengan pemupukan ekstra, perbaikan kondisi lingkungan yaitu dengan memberikan pohon penaung secukupnya, sanitasi yaitu menghilangkan ranting-ranting yang telah kering dan merampas buahbuah busuk,penyemprotan fungisida yaitu untuk melindungi flush yang tumbuh dengan fungisida berbahan aktif mankozeb 0,5% formulasi atau prokloras 0,1% formulasi,eradikasi yaitu membongkar tanaman yang terserang berat.";
        } else if (checkBox9.isChecked() && checkBox10.isChecked() && checkBox11.isChecked() && checkBox12.isChecked() && checkBox13.isChecked()) {
            hasildiagnosapenyakit += "Penyakit Vascular Streak Dieback";
            deskripsi += "Solusi: Pengendalianya adalah perbaikan kondisi tanaman yaitu dengan pemupukan ekstra, perbaikan kondisi lingkungan yaitu dengan memberikan pohon penaung secukupnya, sanitasi yaitu menghilangkan ranting-ranting yang telah kering dan merampas buahbuah busuk,penyemprotan fungisida yaitu untuk melindungi flush yang tumbuh dengan fungisida berbahan aktif mankozeb 0,5% formulasi atau prokloras 0,1% formulasi,eradikasi yaitu membongkar tanaman yang terserang berat.";
        }

        textView.setText("" + hasildiagnosapenyakit);
        textView2.setText("" + deskripsi);

        ImageView imageView = dialog.findViewById(R.id.close);
        ImageView imageViewprint = dialog.findViewById(R.id.printpenyakit4);
        Button btnOk = dialog.findViewById(R.id.Oke);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                Toast.makeText(getApplicationContext(), "Keluar", Toast.LENGTH_SHORT).show();
            }
        });

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                Toast.makeText(getApplicationContext(), "Keluar", Toast.LENGTH_SHORT).show();
            }
        });
        alertDialog = new AlertDialog.Builder(this).setCancelable(false).setMessage("Please Wait").create();
        addDataModel1();
        Dexter.withContext(this)
                .withPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)
                .withListener(new PermissionListener() {
                    @Override
                    public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                        imageViewprint.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                createPDFFile4(new StringBuilder(getAppPath4())
                                        .append(FILE_PRINT).toString());
                            }
                        });
                    }

                    @Override
                    public void onPermissionDenied(PermissionDeniedResponse permissionDeniedResponse) {
                        Toast.makeText(KonsultasiGejalaPenyakitActivity.this, "" + permissionDeniedResponse.getPermissionName(), Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onPermissionRationaleShouldBeShown(PermissionRequest permissionRequest, PermissionToken permissionToken) {

                    }
                }).check();
        dialog.show();
    }

    private void createPDFFile4(String path) {

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
            PDFUtils.addNewItem(document, "Hasil Diagnosa", Element.ALIGN_CENTER, titleFont);

            Font textFont = new Font(fontName, fontSize, Font.NORMAL, colorAccent);
            PDFUtils.addNewItem(document, "Document By: ", Element.ALIGN_LEFT, titleFont);
            PDFUtils.addNewItem(document, "Fausiah Wulandari Hafid", Element.ALIGN_LEFT, titleFont);

            PDFUtils.addLineSeparator(document);

//            Add detail
            PDFUtils.addLineSpace(document);
            PDFUtils.addNewItem(document, "Hasil diagnosa penyakit tanaman kakao", Element.ALIGN_CENTER, titleFont);
            PDFUtils.addLineSeparator(document);

//            use rxjava
            io.reactivex.Observable.fromIterable(dataModelList)
                    .flatMap(model -> getBitmapFromUrl4(this, model, document))
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

                        printPDF4();

                    });

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void printPDF4() {

        PrintManager printManager = (PrintManager) getSystemService(Context.PRINT_SERVICE);

        try {
            PrintDocumentAdapter printDocumentAdapter = new PdfDocumentAdapter(this, new StringBuilder(getAppPath4())
                    .append(FILE_PRINT).toString(), FILE_PRINT);
            printManager.print("Document", printDocumentAdapter, new PrintAttributes.Builder().build());
        } catch (Exception e) {
            Toast.makeText(this, "" + e.getMessage(), Toast.LENGTH_SHORT).show();
        }

    }

    private io.reactivex.Observable<DataModel> getBitmapFromUrl4(Context context, DataModel model, Document document) {

        return Observable.fromCallable(() -> {
            return model;
        });
    }

    private String getAppPath4() {
        File dir = new File(android.os.Environment.getExternalStorageDirectory()
                + File.separator
                + getResources().getString(R.string.app_name)
                + File.separator);

        if (!dir.exists())
            dir.mkdir();

        return dir.getPath() + File.separator;
    }

    private void addDataModel4() {
        DataModel dataModel = new DataModel("Penyakit Vascular Streak Dieback = ", " \nSolusi: Pengendalianya adalah perbaikan kondisi tanaman yaitu dengan pemupukan ekstra, perbaikan kondisi lingkungan yaitu dengan memberikan pohon penaung secukupnya, sanitasi yaitu menghilangkan ranting-ranting yang telah kering dan merampas buahbuah busuk,penyemprotan fungisida yaitu untuk melindungi flush yang tumbuh dengan fungisida berbahan aktif mankozeb 0,5% formulasi atau prokloras 0,1% formulasi,eradikasi yaitu membongkar tanaman yang terserang berat.");
        dataModelList.add(dataModel);
    }

    private void openDialog5() {
        dialog.setContentView(R.layout.hasil_diagnosapenyakit5);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        textView = dialog.findViewById(R.id.hasildiagnosa);
        textView2 = dialog.findViewById(R.id.caramenecegah);

        String hasildiagnosapenyakit = "";
        String deskripsi = "";

        if (checkBox14.isChecked()) {
            hasildiagnosapenyakit += "Penyakit Jamur Upas";
            deskripsi += "Solusi keempat : Pengendalianya adalah pangkasan sanitasi yaitu memotong ranting sakit sampai pada batas gejala garis coklat pada xilem ditambah 30-50 cm dibawahnya, eradikasi yaitu pembongkaran tanaman yang terserang berat.";
        } else if (checkBox15.isChecked()) {
            hasildiagnosapenyakit += "Penyakit Jamur Upas";
            deskripsi += "Solusi keempat : Pengendalianya adalah pangkasan sanitasi yaitu memotong ranting sakit sampai pada batas gejala garis coklat pada xilem ditambah 30-50 cm dibawahnya, eradikasi yaitu pembongkaran tanaman yang terserang berat.";
        } else if (checkBox16.isChecked()) {
            hasildiagnosapenyakit += "Penyakit Jamur Upas";
            deskripsi += "Solusi keempat : Pengendalianya adalah pangkasan sanitasi yaitu memotong ranting sakit sampai pada batas gejala garis coklat pada xilem ditambah 30-50 cm dibawahnya, eradikasi yaitu pembongkaran tanaman yang terserang berat.";
        } else if (checkBox17.isChecked()) {
            hasildiagnosapenyakit += "Penyakit Jamur Upas";
            deskripsi += "Solusi keempat : Pengendalianya adalah pangkasan sanitasi yaitu memotong ranting sakit sampai pada batas gejala garis coklat pada xilem ditambah 30-50 cm dibawahnya, eradikasi yaitu pembongkaran tanaman yang terserang berat.";
        } else if (checkBox18.isChecked()) {
            hasildiagnosapenyakit += "Penyakit Jamur Upas";
            deskripsi += "Solusi keempat : Pengendalianya adalah pangkasan sanitasi yaitu memotong ranting sakit sampai pada batas gejala garis coklat pada xilem ditambah 30-50 cm dibawahnya, eradikasi yaitu pembongkaran tanaman yang terserang berat.";
        } else if (checkBox14.isChecked() && checkBox15.isChecked()) {
            hasildiagnosapenyakit += "Penyakit Jamur Upas";
            deskripsi += "Solusi: Pengendalianya adalah pangkasan sanitasi yaitu memotong ranting sakit sampai pada batas gejala garis coklat pada xilem ditambah 30-50 cm dibawahnya, eradikasi yaitu pembongkaran tanaman yang terserang berat.";
        } else if (checkBox14.isChecked() && checkBox15.isChecked() && checkBox16.isChecked()) {
            hasildiagnosapenyakit += "Penyakit Jamur Upas";
            deskripsi += "Solusi: Pengendalianya adalah pangkasan sanitasi yaitu memotong ranting sakit sampai pada batas gejala garis coklat pada xilem ditambah 30-50 cm dibawahnya, eradikasi yaitu pembongkaran tanaman yang terserang berat.";
        } else if (checkBox14.isChecked() && checkBox15.isChecked() && checkBox16.isChecked() && checkBox17.isChecked()) {
            hasildiagnosapenyakit += "Penyakit Jamur Upas";
            deskripsi += "Solusi: Pengendalianya adalah pangkasan sanitasi yaitu memotong ranting sakit sampai pada batas gejala garis coklat pada xilem ditambah 30-50 cm dibawahnya, eradikasi yaitu pembongkaran tanaman yang terserang berat.";
        } else if (checkBox14.isChecked() && checkBox15.isChecked() && checkBox16.isChecked() && checkBox17.isChecked() && checkBox18.isChecked()) {
            hasildiagnosapenyakit += "Penyakit Jamur Upas";
            deskripsi += "Solusi: Pengendalianya adalah pangkasan sanitasi yaitu memotong ranting sakit sampai pada batas gejala garis coklat pada xilem ditambah 30-50 cm dibawahnya, eradikasi yaitu pembongkaran tanaman yang terserang berat.";
        }

        textView.setText("" + hasildiagnosapenyakit);
        textView2.setText("" + deskripsi);

        ImageView imageView = dialog.findViewById(R.id.close);
        ImageView imageViewprint = dialog.findViewById(R.id.printpenyakit5);
        Button btnOk = dialog.findViewById(R.id.Oke);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                Toast.makeText(getApplicationContext(), "Keluar", Toast.LENGTH_SHORT).show();
            }
        });

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                Toast.makeText(getApplicationContext(), "Keluar", Toast.LENGTH_SHORT).show();
            }
        });
        alertDialog = new AlertDialog.Builder(this).setCancelable(false).setMessage("Please Wait").create();
        addDataModel1();
        Dexter.withContext(this)
                .withPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)
                .withListener(new PermissionListener() {
                    @Override
                    public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                        imageViewprint.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                createPDFFile5(new StringBuilder(getAppPath5())
                                        .append(FILE_PRINT).toString());
                            }
                        });
                    }

                    @Override
                    public void onPermissionDenied(PermissionDeniedResponse permissionDeniedResponse) {
                        Toast.makeText(KonsultasiGejalaPenyakitActivity.this, "" + permissionDeniedResponse.getPermissionName(), Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onPermissionRationaleShouldBeShown(PermissionRequest permissionRequest, PermissionToken permissionToken) {

                    }
                }).check();
        dialog.show();
    }

    private void createPDFFile5(String path) {

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
            PDFUtils.addNewItem(document, "Hasil Diagnosa", Element.ALIGN_CENTER, titleFont);

            Font textFont = new Font(fontName, fontSize, Font.NORMAL, colorAccent);
            PDFUtils.addNewItem(document, "Document By: ", Element.ALIGN_LEFT, titleFont);
            PDFUtils.addNewItem(document, "Fausiah Wulandari Hafid", Element.ALIGN_LEFT, titleFont);

            PDFUtils.addLineSeparator(document);

//            Add detail
            PDFUtils.addLineSpace(document);
            PDFUtils.addNewItem(document, "Hasil diagnosa penyakit tanaman kakao", Element.ALIGN_CENTER, titleFont);
            PDFUtils.addLineSeparator(document);

//            use rxjava
            io.reactivex.Observable.fromIterable(dataModelList)
                    .flatMap(model -> getBitmapFromUrl5(this, model, document))
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

                        printPDF5();

                    });

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void printPDF5() {

        PrintManager printManager = (PrintManager) getSystemService(Context.PRINT_SERVICE);

        try {
            PrintDocumentAdapter printDocumentAdapter = new PdfDocumentAdapter(this, new StringBuilder(getAppPath5())
                    .append(FILE_PRINT).toString(), FILE_PRINT);
            printManager.print("Document", printDocumentAdapter, new PrintAttributes.Builder().build());
        } catch (Exception e) {
            Toast.makeText(this, "" + e.getMessage(), Toast.LENGTH_SHORT).show();
        }

    }

    private io.reactivex.Observable<DataModel> getBitmapFromUrl5(Context context, DataModel model, Document document) {

        return Observable.fromCallable(() -> {
            return model;
        });
    }

    private String getAppPath5() {
        File dir = new File(android.os.Environment.getExternalStorageDirectory()
                + File.separator
                + getResources().getString(R.string.app_name)
                + File.separator);

        if (!dir.exists())
            dir.mkdir();

        return dir.getPath() + File.separator;
    }

    private void addDataModel5() {
        DataModel dataModel = new DataModel("Penyakit Jamur Upas = ", " \nSolusi: Pengendalianya adalah pangkasan sanitasi yaitu memotong ranting sakit sampai pada batas gejala garis coklat pada xilem ditambah 30-50 cm dibawahnya, eradikasi yaitu pembongkaran tanaman yang terserang berat.");
        dataModelList.add(dataModel);
    }

    private void openDialog6() {
        dialog.setContentView(R.layout.hasil_diagnosapenyakit6);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        textView = dialog.findViewById(R.id.hasildiagnosa);
        textView2 = dialog.findViewById(R.id.caramenecegah);

        String hasildiagnosapenyakit = "";
        String deskripsi = "";

        if (checkBox19.isChecked()) {
            hasildiagnosapenyakit += "Penyakit Akar";
            deskripsi += "Solusi: Pengendalianya adalah tanaman yang telah mati harus dibongkar berikut akarakarnya sampai bersih pada lubang bongkaran diberi belerang sebanyak kurang lebih 600 g setiap lubang, lubang tersebut tidak ditanami selama paling tidak satu tahun, untuk pencegah penyebaran ke tanaman lain perlu dibuat parit isolasi sedalam 80 cm dengan lebar 30 cm pada daerah satu baris di luar tanaman yang mati, tanaman di sekitar tanaman mati diperiksa akar tunggangnya, pada serangan awal tampak adanya miselium atau rhizomorf pada permukaan akar atau leher akar, miselium tersebut dibersihkan dengan sikat kemudian dioles dengan fungisida khusus jamur akar misalnya tridemorf PCNS.";
        } else if (checkBox20.isChecked()) {
            hasildiagnosapenyakit += "Penyakit Akar";
            deskripsi += "Solusi: Pengendalianya adalah tanaman yang telah mati harus dibongkar berikut akarakarnya sampai bersih pada lubang bongkaran diberi belerang sebanyak kurang lebih 600 g setiap lubang, lubang tersebut tidak ditanami selama paling tidak satu tahun, untuk pencegah penyebaran ke tanaman lain perlu dibuat parit isolasi sedalam 80 cm dengan lebar 30 cm pada daerah satu baris di luar tanaman yang mati, tanaman di sekitar tanaman mati diperiksa akar tunggangnya, pada serangan awal tampak adanya miselium atau rhizomorf pada permukaan akar atau leher akar, miselium tersebut dibersihkan dengan sikat kemudian dioles dengan fungisida khusus jamur akar misalnya tridemorf PCNS.";
        } else if (checkBox21.isChecked()) {
            hasildiagnosapenyakit += "Penyakit Akar";
            deskripsi += "Solusi: Pengendalianya adalah tanaman yang telah mati harus dibongkar berikut akarakarnya sampai bersih pada lubang bongkaran diberi belerang sebanyak kurang lebih 600 g setiap lubang, lubang tersebut tidak ditanami selama paling tidak satu tahun, untuk pencegah penyebaran ke tanaman lain perlu dibuat parit isolasi sedalam 80 cm dengan lebar 30 cm pada daerah satu baris di luar tanaman yang mati, tanaman di sekitar tanaman mati diperiksa akar tunggangnya, pada serangan awal tampak adanya miselium atau rhizomorf pada permukaan akar atau leher akar, miselium tersebut dibersihkan dengan sikat kemudian dioles dengan fungisida khusus jamur akar misalnya tridemorf PCNS.";
        } else if (checkBox19.isChecked() && checkBox20.isChecked()) {
            hasildiagnosapenyakit += "Penyakit Akar";
            deskripsi += "Solusi: Pengendalianya adalah tanaman yang telah mati harus dibongkar berikut akarakarnya sampai bersih pada lubang bongkaran diberi belerang sebanyak kurang lebih 600 g setiap lubang, lubang tersebut tidak ditanami selama paling tidak satu tahun, untuk pencegah penyebaran ke tanaman lain perlu dibuat parit isolasi sedalam 80 cm dengan lebar 30 cm pada daerah satu baris di luar tanaman yang mati, tanaman di sekitar tanaman mati diperiksa akar tunggangnya, pada serangan awal tampak adanya miselium atau rhizomorf pada permukaan akar atau leher akar, miselium tersebut dibersihkan dengan sikat kemudian dioles dengan fungisida khusus jamur akar misalnya tridemorf PCNS.";
        } else if (checkBox19.isChecked() && checkBox20.isChecked() && checkBox21.isChecked()) {
            hasildiagnosapenyakit += "Penyakit Akar";
            deskripsi += "Solusi: Pengendalianya adalah tanaman yang telah mati harus dibongkar berikut akarakarnya sampai bersih pada lubang bongkaran diberi belerang sebanyak kurang lebih 600 g setiap lubang, lubang tersebut tidak ditanami selama paling tidak satu tahun, untuk pencegah penyebaran ke tanaman lain perlu dibuat parit isolasi sedalam 80 cm dengan lebar 30 cm pada daerah satu baris di luar tanaman yang mati, tanaman di sekitar tanaman mati diperiksa akar tunggangnya, pada serangan awal tampak adanya miselium atau rhizomorf pada permukaan akar atau leher akar, miselium tersebut dibersihkan dengan sikat kemudian dioles dengan fungisida khusus jamur akar misalnya tridemorf PCNS.";
        }
        textView.setText("" + hasildiagnosapenyakit);
        textView2.setText("" + deskripsi);

        ImageView imageView = dialog.findViewById(R.id.close);
        ImageView imageViewprint = dialog.findViewById(R.id.printpenyakit6);
        Button btnOk = dialog.findViewById(R.id.Oke);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                Toast.makeText(getApplicationContext(), "Keluar", Toast.LENGTH_SHORT).show();
            }
        });

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                Toast.makeText(getApplicationContext(), "Keluar", Toast.LENGTH_SHORT).show();
            }
        });
        alertDialog = new AlertDialog.Builder(this).setCancelable(false).setMessage("Please Wait").create();
        addDataModel1();
        Dexter.withContext(this)
                .withPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)
                .withListener(new PermissionListener() {
                    @Override
                    public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                        imageViewprint.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                createPDFFile16(new StringBuilder(getAppPath6())
                                        .append(FILE_PRINT).toString());
                            }
                        });
                    }

                    @Override
                    public void onPermissionDenied(PermissionDeniedResponse permissionDeniedResponse) {
                        Toast.makeText(KonsultasiGejalaPenyakitActivity.this, "" + permissionDeniedResponse.getPermissionName(), Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onPermissionRationaleShouldBeShown(PermissionRequest permissionRequest, PermissionToken permissionToken) {

                    }
                }).check();
        dialog.show();
    }

    private void createPDFFile16(String path) {

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
            PDFUtils.addNewItem(document, "Hasil Diagnosa", Element.ALIGN_CENTER, titleFont);

            Font textFont = new Font(fontName, fontSize, Font.NORMAL, colorAccent);
            PDFUtils.addNewItem(document, "Document By: ", Element.ALIGN_LEFT, titleFont);
            PDFUtils.addNewItem(document, "Fausiah Wulandari Hafid", Element.ALIGN_LEFT, titleFont);

            PDFUtils.addLineSeparator(document);

//            Add detail
            PDFUtils.addLineSpace(document);
            PDFUtils.addNewItem(document, "Hasil diagnosa penyakit tanaman kakao", Element.ALIGN_CENTER, titleFont);
            PDFUtils.addLineSeparator(document);

//            use rxjava
            io.reactivex.Observable.fromIterable(dataModelList)
                    .flatMap(model -> getBitmapFromUrl6(this, model, document))
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

                        printPDF6();

                    });

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void printPDF6() {

        PrintManager printManager = (PrintManager) getSystemService(Context.PRINT_SERVICE);

        try {
            PrintDocumentAdapter printDocumentAdapter = new PdfDocumentAdapter(this, new StringBuilder(getAppPath6())
                    .append(FILE_PRINT).toString(), FILE_PRINT);
            printManager.print("Document", printDocumentAdapter, new PrintAttributes.Builder().build());
        } catch (Exception e) {
            Toast.makeText(this, "" + e.getMessage(), Toast.LENGTH_SHORT).show();
        }

    }

    private io.reactivex.Observable<DataModel> getBitmapFromUrl6(Context context, DataModel model, Document document) {

        return Observable.fromCallable(() -> {
            return model;
        });
    }

    private String getAppPath6() {
        File dir = new File(android.os.Environment.getExternalStorageDirectory()
                + File.separator
                + getResources().getString(R.string.app_name)
                + File.separator);

        if (!dir.exists())
            dir.mkdir();

        return dir.getPath() + File.separator;
    }

    private void addDataModel6() {
        DataModel dataModel = new DataModel("Penyakit Akar = ", " \nSolusi: Pengendalianya adalah tanaman yang telah mati harus dibongkar berikut akarakarnya sampai bersih pada lubang bongkaran diberi belerang sebanyak kurang lebih 600 g setiap lubang, lubang tersebut tidak ditanami selama paling tidak satu tahun, untuk pencegah penyebaran ke tanaman lain perlu dibuat parit isolasi sedalam 80 cm dengan lebar 30 cm pada daerah satu baris di luar tanaman yang mati, tanaman di sekitar tanaman mati diperiksa akar tunggangnya, pada serangan awal tampak adanya miselium atau rhizomorf pada permukaan akar atau leher akar, miselium tersebut dibersihkan dengan sikat kemudian dioles dengan fungisida khusus jamur akar misalnya tridemorf PCNS.");
        dataModelList.add(dataModel);
    }

    private void openDialog7() {
        dialog.setContentView(R.layout.hasil_diagnosapenyakit7);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        textView = dialog.findViewById(R.id.hasildiagnosa);
        textView2 = dialog.findViewById(R.id.caramenecegah);

        String hasildiagnosapenyakit = "";
        String deskripsi = "";

        if (checkBox22.isChecked()) {
            hasildiagnosapenyakit += "Penyakit kelayuan pentil";
            deskripsi += "Solusi: Pengendalianya adalah dengan memberikan pemupukan yang tepat dan tidak melakukan pangkasan berat serta pembukaan penaung dratis yang dapat memacu pertunasan intensif";
        } else if (checkBox23.isChecked()) {
            hasildiagnosapenyakit += "Penyakit kelayuan pentil";
            deskripsi += "Solusi: Pengendalianya adalah dengan memberikan pemupukan yang tepat dan tidak melakukan pangkasan berat serta pembukaan penaung dratis yang dapat memacu pertunasan intensif";
        } else if (checkBox22.isChecked() && checkBox23.isChecked()) {
            hasildiagnosapenyakit += "Penyakit kelayuan pentil";
            deskripsi += "Solusi: Pengendalianya adalah dengan memberikan pemupukan yang tepat dan tidak melakukan pangkasan berat serta pembukaan penaung dratis yang dapat memacu pertunasan intensif";
        }
        textView.setText("" + hasildiagnosapenyakit);
        textView2.setText("" + deskripsi);

        ImageView imageView = dialog.findViewById(R.id.close);
        ImageView imageViewprint = dialog.findViewById(R.id.printpenyakit7);
        Button btnOk = dialog.findViewById(R.id.Oke);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                Toast.makeText(getApplicationContext(), "Keluar", Toast.LENGTH_SHORT).show();
            }
        });

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                Toast.makeText(getApplicationContext(), "Keluar", Toast.LENGTH_SHORT).show();
            }
        });
        alertDialog = new AlertDialog.Builder(this).setCancelable(false).setMessage("Please Wait").create();
        addDataModel1();
        Dexter.withContext(this)
                .withPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)
                .withListener(new PermissionListener() {
                    @Override
                    public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                        imageViewprint.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                createPDFFile7(new StringBuilder(getAppPath7())
                                        .append(FILE_PRINT).toString());
                            }
                        });
                    }

                    @Override
                    public void onPermissionDenied(PermissionDeniedResponse permissionDeniedResponse) {
                        Toast.makeText(KonsultasiGejalaPenyakitActivity.this, "" + permissionDeniedResponse.getPermissionName(), Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onPermissionRationaleShouldBeShown(PermissionRequest permissionRequest, PermissionToken permissionToken) {

                    }
                }).check();
        dialog.show();
    }

    private void createPDFFile7(String path) {

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
            PDFUtils.addNewItem(document, "Hasil Diagnosa", Element.ALIGN_CENTER, titleFont);

            Font textFont = new Font(fontName, fontSize, Font.NORMAL, colorAccent);
            PDFUtils.addNewItem(document, "Document By: ", Element.ALIGN_LEFT, titleFont);
            PDFUtils.addNewItem(document, "Fausiah Wulandari Hafid", Element.ALIGN_LEFT, titleFont);

            PDFUtils.addLineSeparator(document);

//            Add detail
            PDFUtils.addLineSpace(document);
            PDFUtils.addNewItem(document, "Hasil diagnosa penyakit tanaman kakao", Element.ALIGN_CENTER, titleFont);
            PDFUtils.addLineSeparator(document);

//            use rxjava
            io.reactivex.Observable.fromIterable(dataModelList)
                    .flatMap(model -> getBitmapFromUrl7(this, model, document))
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

                        printPDF7();

                    });

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void printPDF7() {

        PrintManager printManager = (PrintManager) getSystemService(Context.PRINT_SERVICE);

        try {
            PrintDocumentAdapter printDocumentAdapter = new PdfDocumentAdapter(this, new StringBuilder(getAppPath7())
                    .append(FILE_PRINT).toString(), FILE_PRINT);
            printManager.print("Document", printDocumentAdapter, new PrintAttributes.Builder().build());
        } catch (Exception e) {
            Toast.makeText(this, "" + e.getMessage(), Toast.LENGTH_SHORT).show();
        }

    }

    private io.reactivex.Observable<DataModel> getBitmapFromUrl7(Context context, DataModel model, Document document) {

        return Observable.fromCallable(() -> {
            return model;
        });
    }

    private String getAppPath7() {
        File dir = new File(android.os.Environment.getExternalStorageDirectory()
                + File.separator
                + getResources().getString(R.string.app_name)
                + File.separator);

        if (!dir.exists())
            dir.mkdir();

        return dir.getPath() + File.separator;
    }

    private void addDataModel7() {
        DataModel dataModel = new DataModel("Penyakit kelayuan pentil = ", " \nSolusi: Pengendalianya adalah dengan memberikan pemupukan yang tepat dan tidak melakukan pangkasan berat serta pembukaan penaung dratis yang dapat memacu pertunasan intensif");
        dataModelList.add(dataModel);
    }

    public void onCheckdiKlik(View view) {
        boolean checked = ((CheckBox) view).isChecked();
        String string = "";

        switch (view.getId()) {
            case R.id.checkboxpenyakit1:
                string = checked ? "Diseleksi" : "Tidak diseleksi";
                break;
            case R.id.checkboxpenyakit2:
                string = checked ? "Diseleksi" : "Tidak diseleksi";
                break;
            case R.id.checkboxpenyakit3:
                string = checked ? "Diseleksi" : "Tidak diseleksi";
                break;
            case R.id.checkboxpenyakit4:
                string = checked ? "Diseleksi" : "Tidak diseleksi";
                break;
            case R.id.checkboxpenyakit5:
                string = checked ? "Diseleksi" : "Tidak diseleksi";
                break;
            case R.id.checkboxpenyakit6:
                string = checked ? "Diseleksi" : "Tidak diseleksi";
                break;
            case R.id.checkboxpenyakit7:
                string = checked ? "Diseleksi" : "Tidak diseleksi";
                break;
            case R.id.checkboxpenyakit8:
                string = checked ? "Diseleksi" : "Tidak diseleksi";
                break;
            case R.id.checkboxpenyakit9:
                string = checked ? "Diseleksi" : "Tidak diseleksi";
                break;
            case R.id.checkboxpenyakit10:
                string = checked ? "Diseleksi" : "Tidak diseleksi";
                break;
            case R.id.checkboxpenyakit11:
                string = checked ? "Diseleksi" : "Tidak diseleksi";
                break;
            case R.id.checkboxpenyakit12:
                string = checked ? "Diseleksi" : "Tidak diseleksi";
                break;
            case R.id.checkboxpenyakit13:
                string = checked ? "Diseleksi" : "Tidak diseleksi";
                break;
            case R.id.checkboxpenyakit14:
                string = checked ? "Diseleksi" : "Tidak diseleksi";
                break;
            case R.id.checkboxpenyakit15:
                string = checked ? "Diseleksi" : "Tidak diseleksi";
                break;
            case R.id.checkboxpenyakit16:
                string = checked ? "Diseleksi" : "Tidak diseleksi";
                break;
            case R.id.checkboxpenyakit17:
                string = checked ? "Diseleksi" : "Tidak diseleksi";
                break;
            case R.id.checkboxpenyakit18:
                string = checked ? "Diseleksi" : "Tidak diseleksi";
                break;
            case R.id.checkboxpenyakit19:
                string = checked ? "Diseleksi" : "Tidak diseleksi";
                break;
            case R.id.checkboxpenyakit20:
                string = checked ? "Diseleksi" : "Tidak diseleksi";
                break;
            case R.id.checkboxpenyakit21:
                string = checked ? "Diseleksi" : "Tidak diseleksi";
                break;
            case R.id.checkboxpenyakit22:
                string = checked ? "Diseleksi" : "Tidak diseleksi";
                break;
            case R.id.checkboxpenyakit23:
                string = checked ? "Diseleksi" : "Tidak diseleksi";
                break;
        }

        Toast.makeText(getApplicationContext(), string, Toast.LENGTH_SHORT).show();
    }
}
