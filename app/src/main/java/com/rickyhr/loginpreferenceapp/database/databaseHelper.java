package com.rickyhr.loginpreferenceapp.database;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class databaseHelper extends SQLiteOpenHelper {
 private static final String DATAABASE_NAME ="biodata.db";
 private static final int DATABASE_VERSION = 1;

 public databaseHelper(Context context){
     super(context,DATAABASE_NAME,null,DATABASE_VERSION);
 }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "create table tbl_user (id integer primary key, nama text null, username text null, password text null);";
        Log.d("Data","onCreate : "+ sql);
        db.execSQL(sql);

        sql = "insert into tbl_user (nama,username,password) values ('Ricky Hariya','riki','1234')";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
