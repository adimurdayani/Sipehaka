package com.fauzia.sipehaka;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class AdminActivity extends AppCompatActivity {

    DatabaseHelper db;
    Button logout;

    Animation animation, animation_dua, animation_tiga;

    FloatingActionButton fabTambahAdmin;

    TextView textView;

    ImageView logo_animasi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        db = new DatabaseHelper(this);

        logout = (Button)findViewById(R.id.btn_logout);
        fabTambahAdmin = findViewById(R.id.fab_tambahAdmin);
        textView = (TextView)findViewById(R.id.textSipehaka);

        animation = AnimationUtils.loadAnimation(this, R.anim.animasi);
        animation_dua = AnimationUtils.loadAnimation(this, R.anim.animasi_dua);
        animation_tiga = AnimationUtils.loadAnimation(this, R.anim.animasi_tiga);

        logo_animasi = (ImageView)findViewById(R.id.logo_sipehaka);

//        fungsi animasi
        logo_animasi.startAnimation(animation);
        textView.startAnimation(animation_dua);
        logout.startAnimation(animation_tiga);

        Boolean cheksession = db.cheksession("ada");
        if (cheksession == false){
            Intent intent = new Intent(AdminActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        }

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Boolean updateSession = db.upgrateSession("kosong", 1);
                if (updateSession == true){
                    Toast.makeText(getApplicationContext(), "Logout Sukses!.", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(AdminActivity.this,Main2Activity.class);
                    startActivity(intent);
                    finish();
                }
            }
        });

        fabTambahAdmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AdminActivity.this, RegistasiActivity.class));
            }
        });
    }

    public void btn_penyakit(View view) {
        startActivity(new Intent(AdminActivity.this,PenyakitActivity.class));
    }

    public void btn_hama(View view) {
        startActivity(new Intent(AdminActivity.this,KonsultasiActivity.class));
    }

    public void btn_kakao(View view) {
        startActivity(new Intent(AdminActivity.this,KelolaDataActivity.class));
    }

    public void btn_admin(View view) {
        startActivity(new Intent(AdminActivity.this,ProfileActivity.class));
    }
}
