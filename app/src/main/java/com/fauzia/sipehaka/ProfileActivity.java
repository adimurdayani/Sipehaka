package com.fauzia.sipehaka;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.text.util.Linkify;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.regex.Pattern;

public class ProfileActivity extends AppCompatActivity {

    Button button;
    TextView cardView1, cardView2, cardView3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        button = findViewById(R.id.btn_detailbio);
        cardView1 = findViewById(R.id.textview1);
        cardView2 = findViewById(R.id.textview2);
        cardView3 = findViewById(R.id.textview3);

        Pattern pattern1 = Pattern.compile("[a-zA-Z]+&");
        cardView1.setText("Facebook&");
        Linkify.addLinks(cardView1, pattern1, "https://web.facebook.com/fauziahhafidm.hafidm/?_rdc=1&_rdr");

        Pattern pattern2 = Pattern.compile("[a-zA-Z]+&");
        cardView2.setText("Instagram&");
        Linkify.addLinks(cardView2, pattern2, "https://www.instagram.com/fauziahwulandari_h/?_rdc=1&_rdr");

        Pattern pattern3 = Pattern.compile("[a-zA-Z]+&");
        cardView3.setText("Whatsapp&");
        Linkify.addLinks(cardView3, pattern3,"https://api.whatsapp.com/send?phone=6282292360497");

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ProfileActivity.this, DetailBiodataActivity.class));
            }
        });
    }
}
