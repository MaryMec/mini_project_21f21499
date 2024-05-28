package com.example.miniproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.Date;

public class EventDB extends SQLiteOpenHelper {
    public static final String EDB="Event.acc";
    public static final String Eve="EventsDetails";
    public static final String Eid="EventID";
    public static final String Ename="EventName";
    public static final String NumTick="NumberOfTickets";
    public static final String Price="totalPrice";
    public static  final String da="Date";
    public static final String Phone="Num";

    public EventDB (Context context){super(context,EDB, null,1);}

    @Override
    public void onCreate(SQLiteDatabase SDB) {
        String query="CREATE TABLE "+Eve+" ("+Eid+" INTEGER PRIMARY KEY AUTOINCREMENT, "+Ename+" TEXT, "+ NumTick+" TEXT, "+Price+" TEXT, "+Phone+" TEXT, "+da+" TEXT)";
    SDB.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase SDB, int Past, int New) {
        SDB.execSQL("DROP TABLE IF EXISTS "+Eve);
        onCreate(SDB);
    }
    public boolean AddEvent(String EventName, String NumberOfTickets, String totalPrice, String Num,String Date)
    {
        SQLiteDatabase SDB=this.getReadableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(Ename,EventName);
        contentValues.put(NumTick,NumberOfTickets);
        contentValues.put(Price,totalPrice);
        contentValues.put(Phone,Num);
        contentValues.put(da, Date);
        long result=SDB.insert(Eve,null , contentValues);
        SDB.close();
        if(result==-1)
        {
            return false;

        }
        else{
            return true;
        }
    }
    public Integer canceldata(String Eid){
        SQLiteDatabase SDB=this.getWritableDatabase();
        return SDB.delete(Eve,"EventID=?",new String[]{Eid});
    }
    public Cursor ShowBook(String n)
    {
        SQLiteDatabase SDB=this.getWritableDatabase();
        Cursor curs=SDB.rawQuery("SELECT * FROM "+Eve+" WHERE Num="+n,null);
        return curs;
    }
    public Cursor ViewBooking()
    {
        SQLiteDatabase EDB=this.getReadableDatabase();
        Cursor cursor=EDB.rawQuery("SELECT  * FROM "+Eve,null);
      return cursor;
    }
    public boolean ChangeBooking(String dat, String Evid ){
        SQLiteDatabase SDB= this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(da,dat);
        SDB.update(Eve, contentValues,"EventID=?",new String[]{Evid});
        return true;

    }
}
