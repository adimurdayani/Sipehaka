package com.fauzia.sipehaka;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper db ;
    Button login;
    EditText username, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = new DatabaseHelper(this);

        username = (EditText)findViewById(R.id.username);
        password = (EditText)findViewById(R.id.password);
        login = (Button)findViewById(R.id.btn_login);

        //login
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strUsername = username.getText().toString();
                String strPassword = password.getText().toString();

                if (TextUtils.isEmpty(strUsername)){
                    username.setError("Username tidak boleh kosong!");
                    username.requestFocus();
                }else if (TextUtils.isEmpty(strPassword)){
                    password.setError("Password tidak boleh kosong!");
                }else{
                    Boolean masuk = db.cheklogin(strUsername,strPassword);
                    if (masuk == true){
                        Boolean updateSession = db.upgrateSession("ada", 1);
                        if (updateSession == true){
                            Toast.makeText(getApplicationContext(), "Login Sukses!.", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(MainActivity.this, AdminActivity.class);
                            startActivity(intent);
                            finish();
                        }
                    }else{
                        Toast.makeText(getApplicationContext(), "Login Gagal!.", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
    }

    public void link_registrasi(View view) {
        Intent intent = new Intent(MainActivity.this, RegistasiActivity.class);
        startActivity(intent);
    }
}
