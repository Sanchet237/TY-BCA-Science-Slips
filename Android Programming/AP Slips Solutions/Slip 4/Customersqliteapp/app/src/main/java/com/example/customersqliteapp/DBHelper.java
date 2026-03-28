package com.example.customersqliteapp;

import android.content.*;
import android.database.Cursor;
import android.database.sqlite.*;

public class DBHelper extends SQLiteOpenHelper {

    public DBHelper(Context context) {
        super(context, "CustomerDB", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE Customer(id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, address TEXT, phno TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Customer");
        onCreate(db);
    }

    public void insertData(String name, String address, String phno) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put("name", name);
        cv.put("address", address);
        cv.put("phno", phno);

        db.insert("Customer", null, cv);
    }

    public String getAllData() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM Customer", null);

        String data = "";

        while (c.moveToNext()) {
            data += "ID: " + c.getInt(0) +
                    "\nName: " + c.getString(1) +
                    "\nAddress: " + c.getString(2) +
                    "\nPhone: " + c.getString(3) +
                    "\n\n";
        }

        return data;
    }
}