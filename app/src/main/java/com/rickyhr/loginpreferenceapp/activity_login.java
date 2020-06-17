package com.rickyhr.loginpreferenceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.rickyhr.loginpreferenceapp.database.SessionManager;
import com.rickyhr.loginpreferenceapp.database.databaseHelper;

public class activity_login extends AppCompatActivity {
    protected Cursor cursor;
    EditText user, pass;
    Button btnRegistrasi, btnLogin;
    databaseHelper dbhelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        dbhelper = new databaseHelper(this);
        user = findViewById(R.id.edtusername);
        pass = findViewById(R.id.edtpassword);

        btnLogin = findViewById(R.id.btLogin);
        btnRegistrasi = findViewById(R.id.btCreateAkun);

        SessionManager ses = new SessionManager(this.getApplicationContext());
        if (ses.isLoggedIn()) {
            goToActivity();
        }
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CekLogin();
            }
        });
        btnRegistrasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent daftar = new Intent(getBaseContext(), activity_register.class);
                startActivity(daftar);
            }
        });
    }

    private void CekLogin() {
        SessionManager sessionManager = new SessionManager(this.getApplicationContext());
        SQLiteDatabase db = dbhelper.getReadableDatabase();
        cursor = db.rawQuery("select * from tbl_user where username = " +
                "'" + user.getText().toString() + "' and password = '"
                + pass.getText().toString() + "'", null);
        cursor.moveToFirst();
        if (cursor.getCount() > 0) {
            sessionManager.createLogiSession(cursor.getString(2).toString(), cursor.getString(1).toString());
            Toast.makeText(getApplicationContext(), "Benar", Toast.LENGTH_SHORT).show();
            goToActivity();
        } else {
            Toast.makeText(getApplicationContext(), "Salah", Toast.LENGTH_SHORT).show();
        }
    }


    private void goToActivity() {
        Intent mInten = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(mInten);
    }
}