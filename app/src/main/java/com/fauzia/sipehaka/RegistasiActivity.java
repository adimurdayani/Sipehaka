package com.fauzia.sipehaka;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegistasiActivity extends AppCompatActivity {

    DatabaseHelper db;
    Button register;
    EditText username, password, conf_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registasi);

        db = new DatabaseHelper(this);

        register = (Button)findViewById(R.id.btn_registrasi);
        username = (EditText)findViewById(R.id.tx_username);
        password = (EditText)findViewById(R.id.tx_password);
        conf_password = (EditText)findViewById(R.id.conf_password);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String rgusername = username.getText().toString();
                String rgpassword = password.getText().toString();
                String rgconfpassword = conf_password.getText().toString();

                if (rgpassword.equals(rgconfpassword)){
                    Boolean daftar = db.insertUser(rgusername,rgpassword);
                    if (daftar == true){
                        Toast.makeText(getApplicationContext(),"Registrasi sukses!.", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(RegistasiActivity.this, MainActivity.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(getApplicationContext(), "Registrasi gagal!", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(getApplicationContext(),"Password salah!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
