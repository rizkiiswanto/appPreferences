package com.rickyhr.loginpreferenceapp.database;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import com.rickyhr.loginpreferenceapp.MainActivity;

public class SessionManager {
    private SharedPreferences mShharedPreferences;
    private SharedPreferences.Editor mEditor;
    private Context mContext;

    int PRIVATE_MODE;
    private static final String PREF_NAME = "SharedPrefLogin";
    private static final String IS_LOGIN = "isLoggedin";
    public static final String KEY_USERNAME = "username";
    public static final String KEY_NAMA = "nama";

    public SessionManager(Context context){
        this.mContext = mContext;
        mShharedPreferences = this.mContext.getSharedPreferences(PREF_NAME,PRIVATE_MODE);
        mEditor = mShharedPreferences.edit();
    }

    public void createLogiSession(String username, String nama){
        mEditor.putBoolean(IS_LOGIN,true);
        mEditor.putString(KEY_USERNAME,username);
        mEditor.putString(KEY_NAMA, nama);
        mEditor.commit();
    }

    public boolean isLoggedIn(){
        return mShharedPreferences.getBoolean(IS_LOGIN,false);
    }
    public void checkIsLogin(){
        if(! isLoggedIn()){
            Intent i = new Intent(mContext, MainActivity.class);
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            mContext.startActivity(i);
        }
    }
    public void logoutUser(){
        mEditor.clear();
        mEditor.commit();
        Intent i = new Intent(mContext,MainActivity.class);
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        mContext.startActivity(i);
    }
    public String getNama(){
        return mShharedPreferences.getString("nama", null);
    }
}
