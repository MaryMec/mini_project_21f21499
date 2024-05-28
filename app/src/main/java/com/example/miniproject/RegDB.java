package com.example.miniproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.security.PublicKey;

public class RegDB  extends SQLiteOpenHelper{

    public static final String Reg="UserReg.acc";
            public static final String User= "userDetails";
    public static final String fn = "FirstName";
    public static final String ln = "LastName";
    public static final String num ="PhoneNumber";
    public static final String mail = "Email";
    public static final String pass = "Password";
    public RegDB (Context context) {super(context,Reg,null,1);}

    @Override
    public void onCreate(SQLiteDatabase Rdb) {
        String query="CREATE TABLE "+ User+" ("+fn+" TEXT, " + ln+" TEXT ,"+ num+" TEXT PRIMARY KEY,"+ mail+" TEXT, " +pass+" TEXT)";
        Rdb.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase Rdb, int oldRdb, int newRdb) {
        Rdb.execSQL("DROP TABLE IF EXISTS " + User);
        onCreate(Rdb);
    }

    public boolean newUser (String FirstName,String LastName, String PhoneNumber, String Email, String Password){
        SQLiteDatabase Rdb=this.getReadableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(fn,FirstName);
        contentValues.put(ln,LastName);
        contentValues.put(num,PhoneNumber);
        contentValues.put(mail,Email);
        contentValues.put(pass,Password);

        long result = Rdb.insert(User, null ,contentValues);
        Rdb.close();
        if (result==-1)
            return false;
        else
            return true;


    }


    public String login(String email){
        SQLiteDatabase Rdb=this.getReadableDatabase();
        Cursor curs = Rdb.rawQuery("SELECT * FROM "+User+" WHERE "+mail+"='"+email+"'", null);
        curs.moveToFirst();
        String pass=curs.getString(4);
        Rdb.close();
        curs.close();
        return pass;
    }

    public Cursor ViewUsers(){
        SQLiteDatabase Rdb=this.getWritableDatabase();
        Cursor curs=Rdb.rawQuery("SELECT * FROM "+ User, null);
        return curs;

    }


}
