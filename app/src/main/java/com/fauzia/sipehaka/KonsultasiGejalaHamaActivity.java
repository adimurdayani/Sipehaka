package com.fauzia.sipehaka;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
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

public class KonsultasiGejalaHamaActivity extends AppCompatActivity {

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
            checkBox15;

    private FloatingActionButton button1;
    Dialog dialog;
    private TextView textView, textView2;

    private static final String FILE_PRINT = "hasil_diagnosa.pdf";
    private AlertDialog alertDialog;
    List<DataModel> dataModelList = new ArrayList<DataModel>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_konsultasi_gejala_hama);

        checkBox1 = findViewById(R.id.checkboxhama1);
        checkBox2 = findViewById(R.id.checkboxhama2);
        checkBox3 = findViewById(R.id.checkboxhama3);
        checkBox4 = findViewById(R.id.checkboxhama4);
        checkBox5 = findViewById(R.id.checkboxhama5);
        checkBox6 = findViewById(R.id.checkboxhama6);
        checkBox7 = findViewById(R.id.checkboxhama7);
        checkBox8 = findViewById(R.id.checkboxhama8);
        checkBox9 = findViewById(R.id.checkboxhama9);
        checkBox10 = findViewById(R.id.checkboxhama10);
        checkBox11 = findViewById(R.id.checkboxhama11);
        checkBox12 = findViewById(R.id.checkboxhama12);
        checkBox13 = findViewById(R.id.checkboxhama13);
        checkBox14 = findViewById(R.id.checkboxhama14);
        checkBox15 = findViewById(R.id.checkboxhama15);

        dialog = new Dialog(this);

        button1 = findViewById(R.id.btndiagnosahama);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (checkBox1.isChecked() && checkBox2.isChecked() && checkBox3.isChecked()) {
                    openDialog1();
                } else if (checkBox1.isChecked()) {
                    openDialog1();
                } else if (checkBox2.isChecked()) {
                    openDialog1();
                } else if (checkBox3.isChecked()) {
                    openDialog1();
                } else if (checkBox4.isChecked() && checkBox5.isChecked() && checkBox6.isChecked() && checkBox7.isChecked()) {
                    openDialog2();
                } else if (checkBox4.isChecked()) {
                    openDialog2();
                } else if (checkBox5.isChecked()) {
                    openDialog2();
                } else if (checkBox6.isChecked()) {
                    openDialog2();
                } else if (checkBox7.isChecked()) {
                    openDialog2();
                } else if (checkBox8.isChecked() && checkBox9.isChecked() && checkBox10.isChecked() && checkBox11.isChecked()) {
                    openDialog3();
                } else if (checkBox8.isChecked()) {
                    openDialog3();
                } else if (checkBox9.isChecked()) {
                    openDialog3();
                } else if (checkBox10.isChecked()) {
                    openDialog3();
                } else if (checkBox11.isChecked()) {
                    openDialog3();
                } else if (checkBox12.isChecked() && checkBox13.isChecked()) {
                    openDialog4();
                } else if (checkBox12.isChecked()) {
                    openDialog4();
                } else if (checkBox13.isChecked()) {
                    openDialog4();
                } else if (checkBox14.isChecked() && checkBox15.isChecked()) {
                    openDialog5();
                } else if (checkBox15.isChecked()) {
                    openDialog5();
                } else if (checkBox14.isChecked()) {
                    openDialog5();
                } else {
                    Toast.makeText(KonsultasiGejalaHamaActivity.this, "Anda belum pilih salah satu diagnosa", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void openDialog1() {

        dialog.setContentView(R.layout.dialog_hasildiagnosahama1);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        textView = dialog.findViewById(R.id.hasildiagnosa);
        textView2 = dialog.findViewById(R.id.caramenecegah);

        String hasildiagnosapenyakit = "";
        String deskripsi = "";

        if (checkBox1.isChecked()) {
            hasildiagnosapenyakit += "Kepik Penghisap Buah";
            deskripsi += "Serangan hama: Serangan terjadi pada buah muda. Pada buah tua tidak terlalu merugikan";
        } else if (checkBox2.isChecked()) {
            hasildiagnosapenyakit += "Kepik Penghisap Buah";
            deskripsi += "Serangan hama: Serangan terjadi pada buah muda. Pada buah tua tidak terlalu merugikan";
        } else if (checkBox3.isChecked()) {
            hasildiagnosapenyakit += "Kepik Penghisap Buah";
            deskripsi += "Serangan hama: Serangan terjadi pada buah muda. Pada buah tua tidak terlalu merugikan";
        } else if (checkBox1.isChecked() && checkBox2.isChecked() && checkBox3.isChecked()) {
            hasildiagnosapenyakit += "Kepik Penghisap Buah";
            deskripsi += "Serangan hama: Serangan terjadi pada buah muda. Pada buah tua tidak terlalu merugikan";
        } else {
            hasildiagnosapenyakit += "Penyakit tidak ditemukan";
            deskripsi += "Deskripsi tidak ditemukan";
        }

        textView.setText("" + hasildiagnosapenyakit);
        textView2.setText("" + deskripsi);

        ImageView imageView = dialog.findViewById(R.id.close);
        ImageView imageViewprint = dialog.findViewById(R.id.print1);
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
                        Toast.makeText(KonsultasiGejalaHamaActivity.this, "" + permissionDeniedResponse.getPermissionName(), Toast.LENGTH_SHORT).show();
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
            PDFUtils.addNewItem(document, "Hasil diagnosa hama tanaman kakao", Element.ALIGN_CENTER, titleFont);
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
        DataModel dataModel = new DataModel("Kepik penghisap Buah = ", " \nSerangan hama: serangan terjadi pada buah muda. Pada buah tua tidak terlalu merugikan");
        dataModelList.add(dataModel);
    }

    private void openDialog2() {
        dialog.setContentView(R.layout.dialog_hasildiagnosahama2);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        textView = dialog.findViewById(R.id.hasildiagnosa);
        textView2 = dialog.findViewById(R.id.caramenecegah);

        String hasildiagnosapenyakit = "";
        String deskripsi = "";

        if (checkBox4.isChecked()) {
            hasildiagnosapenyakit += "Penggerek Buah Kakao";
            deskripsi += "Menyerang buah muda dengan diameter 3 cm sampai dengan 8 cm.\n" +
                    "Ulatnya merusak dengan menggerek\n" +
                    "Ulatnya memakan kulit, daging buah dan saluran ke biji";
        } else if (checkBox5.isChecked()) {
            hasildiagnosapenyakit += "Penggerek Buah Kakao";
            deskripsi += "Menyerang buah muda dengan diameter 3 cm sampai dengan 8 cm.\n" +
                    "Ulatnya merusak dengan menggerek\n" +
                    "Ulatnya memakan kulit, daging buah dan saluran ke biji";
        } else if (checkBox6.isChecked()) {
            hasildiagnosapenyakit += "Penggerek Buah Kakao";
            deskripsi += "Menyerang buah muda dengan diameter 3 cm sampai dengan 8 cm.\n" +
                    "Ulatnya merusak dengan menggerek\n" +
                    "Ulatnya memakan kulit, daging buah dan saluran ke biji";
        } else if (checkBox7.isChecked()) {
            hasildiagnosapenyakit += "Penggerek Buah Kakao";
            deskripsi += "Menyerang buah muda dengan diameter 3 cm sampai dengan 8 cm.\n" +
                    "Ulatnya merusak dengan menggerek\n" +
                    "Ulatnya memakan kulit, daging buah dan saluran ke biji";
        } else if (checkBox4.isChecked() && checkBox5.isChecked() && checkBox6.isChecked() && checkBox7.isChecked()) {
            hasildiagnosapenyakit += "Penggerek Buah Kakao";
            deskripsi += "Menyerang buah muda dengan diameter 3 cm sampai dengan 8 cm.\n" +
                    "Ulatnya merusak dengan menggerek\n" +
                    "Ulatnya memakan kulit, daging buah dan saluran ke biji";
        }

        textView.setText("" + hasildiagnosapenyakit);
        textView2.setText("" + deskripsi);

        ImageView imageView = dialog.findViewById(R.id.close);
        Button btnOk = dialog.findViewById(R.id.Oke);
        ImageView imageViewprint = dialog.findViewById(R.id.print2);

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
        addDataModel2();
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
                        Toast.makeText(KonsultasiGejalaHamaActivity.this, "" + permissionDeniedResponse.getPermissionName(), Toast.LENGTH_SHORT).show();
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
            PDFUtils.addNewItem(document, "Hasil diagnosa hama tanaman kakao", Element.ALIGN_CENTER, titleFont);
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
        DataModel dataModel = new DataModel("Penggerek Buah Kakao = ", " \nMenyerang buah muda dengan diameter 3 cm sampai dengan 8 cm." +
                "Ulatnya merusak dengan menggerek" +
                "Ulatnya memakan kulit, daging buah dan saluran ke biji");
        dataModelList.add(dataModel);
    }

    private void openDialog3() {
        dialog.setContentView(R.layout.dialog_hasildiagnosahama3);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        textView = dialog.findViewById(R.id.hasildiagnosa);
        textView2 = dialog.findViewById(R.id.caramenecegah);

        String hasildiagnosapenyakit = "";
        String deskripsi = "";

        if (checkBox8.isChecked()) {
            hasildiagnosapenyakit += "Ulat Api";
            deskripsi += "Menyerang daun kakao dengan memakan daging daun.\n" +
                    "Setelah ulat besar, akan memakan seluruh jaringan daun";
        } else if (checkBox9.isChecked()) {
            hasildiagnosapenyakit += "Ulat Api";
            deskripsi += "Menyerang daun kakao dengan memakan daging daun.\n" +
                    "Setelah ulat besar, akan memakan seluruh jaringan daun";
        } else if (checkBox10.isChecked()) {
            hasildiagnosapenyakit += "Ulat Api";
            deskripsi += "Menyerang daun kakao dengan memakan daging daun.\n" +
                    "Setelah ulat besar, akan memakan seluruh jaringan daun";
        } else if (checkBox11.isChecked()) {
            hasildiagnosapenyakit += "Ulat Api";
            deskripsi += "Menyerang daun kakao dengan memakan daging daun.\n" +
                    "Setelah ulat besar, akan memakan seluruh jaringan daun";
        } else if (checkBox8.isChecked() && checkBox9.isChecked() && checkBox10.isChecked() && checkBox11.isChecked()) {
            hasildiagnosapenyakit += "Ulat Api";
            deskripsi += "Menyerang daun kakao dengan memakan daging daun.\n" +
                    "Setelah ulat besar, akan memakan seluruh jaringan daun";
        }

        textView.setText("" + hasildiagnosapenyakit);
        textView2.setText("" + deskripsi);

        ImageView imageView = dialog.findViewById(R.id.close);
        Button btnOk = dialog.findViewById(R.id.Oke);
        ImageView imageViewprint = dialog.findViewById(R.id.print3);

        imageViewprint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

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
        addDataModel3();
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
                        Toast.makeText(KonsultasiGejalaHamaActivity.this, "" + permissionDeniedResponse.getPermissionName(), Toast.LENGTH_SHORT).show();
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
            PDFUtils.addNewItem(document, "Hasil diagnosa hama tanaman kakao", Element.ALIGN_CENTER, titleFont);
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
        DataModel dataModel = new DataModel("Ulat Api = ", " \nMenyerang daun kakao dengan memakan daging daun." +
                "Setelah ulat besar, akan memakan seluruh jaringan daun");
        dataModelList.add(dataModel);
    }

    private void openDialog4() {

        dialog.setContentView(R.layout.dialog_hasildiagnosahama4);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        textView = dialog.findViewById(R.id.hasildiagnosa);
        textView2 = dialog.findViewById(R.id.caramenecegah);

        String hasildiagnosapenyakit = "";
        String deskripsi = "";

        if (checkBox12.isChecked()) {
            hasildiagnosapenyakit += "Ulat Kilan";
            deskripsi += "Ulat kilan menyerang daun, bunga, dan pentil kakao";
        } else if (checkBox12.isChecked() && checkBox13.isChecked()) {
            hasildiagnosapenyakit += "Ulat Kilan";
            deskripsi += "Ulat kilan menyerang daun, bunga, dan pentil kakao";
        }
        textView.setText("" + hasildiagnosapenyakit);
        textView2.setText("" + deskripsi);

        ImageView imageView = dialog.findViewById(R.id.close);
        Button btnOk = dialog.findViewById(R.id.Oke);
        ImageView imageViewprint = dialog.findViewById(R.id.print4);

        imageViewprint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

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
        addDataModel4();
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
                        Toast.makeText(KonsultasiGejalaHamaActivity.this, "" + permissionDeniedResponse.getPermissionName(), Toast.LENGTH_SHORT).show();
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
            PDFUtils.addNewItem(document, "Hasil diagnosa hama tanaman kakao", Element.ALIGN_CENTER, titleFont);
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
        DataModel dataModel = new DataModel("Ulat Kilan = ", " \nUlat kilan menyerang daun, bunga, dan pentil kakao");
        dataModelList.add(dataModel);
    }

    private void openDialog5() {
        dialog.setContentView(R.layout.dialog_hasildiagnosahama5);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        textView = dialog.findViewById(R.id.hasildiagnosa);
        textView2 = dialog.findViewById(R.id.caramenecegah);

        String hasildiagnosapenyakit = "";
        String deskripsi = "";

        if (checkBox14.isChecked()) {
            hasildiagnosapenyakit += "Penggerek Batang";
            deskripsi += "Merusak bagian batang atau cabang\n" +
                    "Menggerek menuju empelur (Xilem) batang/ cabang\n" +
                    "Gerekan membelok keatas dan menyerang tanaman muda";
        } else if (checkBox15.isChecked()) {
            hasildiagnosapenyakit += "Penggerek Batang";
            deskripsi += "Merusak bagian batang atau cabang\n" +
                    "Menggerek menuju empelur (Xilem) batang/ cabang\n" +
                    "Gerekan membelok keatas dan menyerang tanaman muda";
        } else if (checkBox14.isChecked() && checkBox15.isChecked()) {
            hasildiagnosapenyakit += "Penggerek Batang";
            deskripsi += "Merusak bagian batang atau cabang\n" +
                    "Menggerek menuju empelur (Xilem) batang/ cabang\n" +
                    "Gerekan membelok keatas dan menyerang tanaman muda";
        }

        textView.setText("" + hasildiagnosapenyakit);
        textView2.setText("" + deskripsi);

        ImageView imageView = dialog.findViewById(R.id.close);
        Button btnOk = dialog.findViewById(R.id.Oke);
        ImageView imageViewprint = dialog.findViewById(R.id.print5);

        imageViewprint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

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
        addDataModel5();
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
                        Toast.makeText(KonsultasiGejalaHamaActivity.this, "" + permissionDeniedResponse.getPermissionName(), Toast.LENGTH_SHORT).show();
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
            PDFUtils.addNewItem(document, "Hasil diagnosa hama tanaman kakao", Element.ALIGN_CENTER, titleFont);
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
        DataModel dataModel = new DataModel("Penggerek Batang = ", " \nMerusak bagian batang atau cabang Menggerek menuju empelur (Xilem) batang / cabang Gerekan membelok keatas dan menyerang tanaman muda");
        dataModelList.add(dataModel);
    }

    public void onCheckdiKlik(View view) {

        boolean checked = ((CheckBox) view).isChecked();
        String string = "";

        switch (view.getId()) {
            case R.id.checkboxhama1:
                string = checked ? "Diseleksi" : "Tidak diseleksi";
                break;
            case R.id.checkboxhama2:
                string = checked ? "Diseleksi" : "Tidak diseleksi";
                break;
            case R.id.checkboxhama3:
                string = checked ? "Diseleksi" : "Tidak diseleksi";
                break;
            case R.id.checkboxhama4:
                string = checked ? "Diseleksi" : "Tidak diseleksi";
                break;
            case R.id.checkboxhama5:
                string = checked ? "Diseleksi" : "Tidak diseleksi";
                break;
            case R.id.checkboxhama6:
                string = checked ? "Diseleksi" : "Tidak diseleksi";
                break;
            case R.id.checkboxhama7:
                string = checked ? "Diseleksi" : "Tidak diseleksi";
                break;
            case R.id.checkboxhama8:
                string = checked ? "Diseleksi" : "Tidak diseleksi";
                break;
            case R.id.checkboxhama9:
                string = checked ? "Diseleksi" : "Tidak diseleksi";
                break;
            case R.id.checkboxhama10:
                string = checked ? "Diseleksi" : "Tidak diseleksi";
                break;
            case R.id.checkboxhama11:
                string = checked ? "Diseleksi" : "Tidak diseleksi";
                break;
            case R.id.checkboxhama12:
                string = checked ? "Diseleksi" : "Tidak diseleksi";
                break;
            case R.id.checkboxhama13:
                string = checked ? "Diseleksi" : "Tidak diseleksi";
                break;
            case R.id.checkboxhama14:
                string = checked ? "Diseleksi" : "Tidak diseleksi";
                break;
            case R.id.checkboxhama15:
                string = checked ? "Diseleksi" : "Tidak diseleksi";
                break;
        }

        Toast.makeText(getApplicationContext(), string, Toast.LENGTH_SHORT).show();

    }

}
