package com.example.databaseprogram;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.Date;

public class CDB extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION =1;
    private static final String DATABASE_NAME="contact";
    public CDB(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase arg0) {
        arg0.execSQL("Create table Contact(cno integer primary key autoincrement,fname text,sname text,dob date,phone num,place text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase arg0, int i, int i1) {
        arg0.execSQL("DROP TABLE IF EXISTS Contact");
        onCreate(arg0);

    }
    public void addContact(String fname, String sname, Date dob, int phone, String place) {
        try {
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues cv = new ContentValues();
            cv.put("fname", fname);
            cv.put("sname", sname);
            cv.put("dob", dob);
            cv.put("phone", phone);
            cv.put("place", place);
            db.insert("Contact", null, cv);
            db.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public String[] getOneContact(int cno)
    {
        String a[]=new String[2];
        try
        {
            SQLiteDatabase db=this.getReadableDatabase();
            Cursor cursor= db.query("Contact",new String[] { "cno", "fname","sname", "dob","phone","place"}, "cno" + "=?", new String[] { String.valueOf(cno)},null,null,null);
            if (cursor !=null && cursor.getCount()!=0)
            {
                cursor.moveToFirst();
                a[0]=cursor.getString(1);
                a[1]=cursor.getString(2);
                a[2]=cursor.getString(3);
                a[3]=cursor.getString(4);
                a[4]=cursor.getString(5);
                a[5]=cursor.getString(6);
            }
            else
            {
                a[0]="";
                a[1]="";
                a[2]="";
                a[3]="";
                a[4]="";
                a[5]="";
            }
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        return a;
    }
    public int deleteContact(int cno)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        return db.delete("Contact", "cno=?",new String[] { String.valueOf(cno)});
    }
    public void update(int cno ,String fname,String sname, Date dob, int phone, String place)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("fname",fname);
        values.put("sname",sname);
        values.put("dob",dob);
        values.put("phone",phone);
        values.put("place",place);

        db.update("Contact",values,"cno = ?",new String[]{String.valueOf(cno)});
        db.close();
    }
}


