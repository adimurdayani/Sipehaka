package com.fauzia.sipehaka;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.text.util.Linkify;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.AlertDialog;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.widget.Button;
import android.widget.TextView;

import java.util.regex.Pattern;

public class Main2Activity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;

    private Button button;

    TextView tvfacebook, tvinstagram, tvwhatsapp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_beranda, R.id.nav_konsultasi, R.id.nav_lihat_hasildiagnosa, R.id.nav_lihat_data,
                R.id.nav_bantuan, R.id.nav_bantuan_lihat, R.id.nav_tentang)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

//        button = findViewById(R.id.btn_detail);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main2, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    public void login(MenuItem item) {
        Intent intent = new Intent(Main2Activity.this, MainActivity.class);
        startActivity(intent);
    }

//tombol keluar aplikasi
    @Override
    public void onBackPressed() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(Main2Activity.this);
        builder.setMessage("Apakah anda yakin ingin keluar?");
        builder.setCancelable(true);
        builder.setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        builder.setPositiveButton("Ya", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    public void buttonData1(View view) {
        startActivity(new Intent(Main2Activity.this, LihatData1Activity.class));
    }

    public void buttonData2(View view) {
        startActivity(new Intent(Main2Activity.this, LihatData2Activity.class));
    }

    public void buttonData3(View view) {
        startActivity(new Intent(Main2Activity.this, LihatData3Activity.class));
    }

    public void btn_konsultasigejalapenyakit(View view) {
        startActivity(new Intent(Main2Activity.this,KonsultasiGejalaPenyakitActivity.class));
    }

    public void btn_konsultasigejalahama(View view) {
        startActivity(new Intent(Main2Activity.this,KonsultasiGejalaHamaActivity.class));
    }

    public void cardview_facebook(View view) {

        tvfacebook = findViewById(R.id.textview_facebook);
        Pattern pattern1 = Pattern.compile("[a-zA-Z]+&");
        tvfacebook.setText("Facebook&");
        Linkify.addLinks(tvfacebook, pattern1, "https://web.facebook.com/fauziahhafidm.hafidm/?_rdc=1&_rdr");
    }

    public void cardview_instagram(View view) {

        tvinstagram = findViewById(R.id.textview_instagram);
        Pattern pattern2 = Pattern.compile("[a-zA-Z]+&");
        tvinstagram.setText("Instagram&");
        Linkify.addLinks(tvinstagram, pattern2, "https://www.instagram.com/fauziahwulandari_h/?_rdc=1&_rdr");
    }

    public void cardview_whatsapp(View view) {

        tvwhatsapp = findViewById(R.id.textview_whatsapp);

        Pattern pattern3 = Pattern.compile("[a-zA-Z]+&");
        tvwhatsapp.setText("Whatsapp&");
        Linkify.addLinks(tvwhatsapp, pattern3,"https://api.whatsapp.com/send?phone=6282292360497");
    }

    public void btn_detail(View view) {
        startActivity(new Intent(Main2Activity.this, DetailBiodataActivity.class));
    }
}
