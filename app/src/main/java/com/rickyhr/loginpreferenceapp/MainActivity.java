package com.rickyhr.loginpreferenceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.rickyhr.loginpreferenceapp.database.SessionManager;

public class MainActivity extends AppCompatActivity {
TextView nama;
Button btnLogot;
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nama = findViewById(R.id.tvNama);
        btnLogot = findViewById(R.id.buttonlogot);

        final SessionManager sm = new SessionManager(getApplicationContext());
        nama.setText("Selamat Datang, " + sm.getNama());
        btnLogot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sm.logoutUser();
                Intent i = new Intent(getApplicationContext(), activity_login.class);
                startActivity(i);
            }
        });
    }
}
