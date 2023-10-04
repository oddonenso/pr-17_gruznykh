package com.example.pr_17_gruznykh;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class MyDatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "myDB";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "mytable";

    // Define the column names
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_EMAIL = "email";

    public MyDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create the table with columns
        String createTableQuery = "CREATE TABLE " + TABLE_NAME + " ("
                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUMN_NAME + " TEXT, "
                + COLUMN_EMAIL + " TEXT)";
        db.execSQL(createTableQuery);
        Log.d("MyDatabaseHelper", "Table created: " + TABLE_NAME);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Handle database upgrade if needed
        // This method is called when the database version is increased
    }

    // Method to insert data into the database
    public long insertData(String name, String email) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, name);
        values.put(COLUMN_EMAIL, email);
        long rowID = db.insert(TABLE_NAME, null, values);
        db.close();
        return rowID;
    }

    // Method to retrieve all data from the database
    public Cursor getAllData() {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.query(TABLE_NAME, null, null, null, null, null, null);
    }

    // Method to delete all data from the database
    public int deleteAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        int deletedRowCount = db.delete(TABLE_NAME, null, null);
        db.close();
        return deletedRowCount;
    }
}