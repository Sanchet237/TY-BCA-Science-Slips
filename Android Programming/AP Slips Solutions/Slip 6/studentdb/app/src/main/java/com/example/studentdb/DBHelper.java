package com.example.studentdb;

import android.content.*;
import android.database.Cursor;
import android.database.sqlite.*;

public class DBHelper extends SQLiteOpenHelper {

    public DBHelper(Context context) {
        super(context, "StudentDB", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE Student(Sid INTEGER PRIMARY KEY AUTOINCREMENT, Sname TEXT, phno TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Student");
        onCreate(db);
    }

    public void insertData(String name, String phone) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put("Sname", name);
        cv.put("phno", phone);

        db.insert("Student", null, cv);
    }

    public String getAllData() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM Student", null);

        String data = "";

        while (c.moveToNext()) {
            data += "ID: " + c.getInt(0) +
                    "\nName: " + c.getString(1) +
                    "\nPhone: " + c.getString(2) +
                    "\n\n";
        }

        return data;
    }
}