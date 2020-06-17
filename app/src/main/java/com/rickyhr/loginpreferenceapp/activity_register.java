package com.rickyhr.loginpreferenceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.rickyhr.loginpreferenceapp.database.databaseHelper;

public class activity_register extends AppCompatActivity {
EditText nama,username,password;
Button buat, kembali;
databaseHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        nama = findViewById(R.id.edtnama);
        username = findViewById(R.id.edtextUsername);
        password = findViewById(R.id.edtextPassword);
        dbHelper = new databaseHelper(this);

        buat = findViewById(R.id.btCreateAkun);
        kembali = findViewById(R.id.btkembali);

        buat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                db.execSQL("insert into tbl_user (nama,username,password) values"
                + "('" +nama.getText().toString() +"','"+username.getText().toString()+"','"
                + "'"+password.getText().toString()+"')");
                Toast.makeText(getApplicationContext(),"Anda sudah terdftar", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
        kembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
