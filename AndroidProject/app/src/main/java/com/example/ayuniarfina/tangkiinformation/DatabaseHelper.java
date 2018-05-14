package com.example.ayuniarfina.tangkiinformation;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "tangki.db";
    public static final String TABLE_NAME = "tangki_table";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "DATETIME";
    public static final String COL_3 = "KETINGGIAN";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, DATETIME INTEGER, KETINGGIAN INTEGER)");

        db.execSQL("insert into " + TABLE_NAME + "(DATETIME, KETINGGIAN) values (1,2)");
        db.execSQL("insert into " + TABLE_NAME + "(DATETIME, KETINGGIAN) values (2,4)");
        db.execSQL("insert into " + TABLE_NAME + "(DATETIME, KETINGGIAN) values (3,5)");
        db.execSQL("insert into " + TABLE_NAME + "(DATETIME, KETINGGIAN) values (4,7)");
//        db.execSQL("insert into " + TABLE_NAME + "(DATETIME, KETINGGIAN) values(8,4)");
    }

    public Cursor getListContents() {
        String selectQuery = "SELECT * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor result = db.rawQuery(selectQuery, null);
        result.moveToLast();
        return result;
    }
}
