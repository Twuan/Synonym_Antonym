package com.example.synonym_antonym;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "wordPairs.db";
    private static final String TABLE_NAME = "wordPairs";
    private static final String Column_ID = "id";
    private static final String Column_Word1 = "word1";
    private static final String Column_Word2 = "word2";
    SQLiteDatabase db;

    private static final String TABLE_CREATE = "create table " + TABLE_NAME + " (id integer primary key not null  , " +
            "word1 text not null, word2 text not null);";

    DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void insert(WordPair wordPair) {
        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        String query = "select * from wordPairs";
        Cursor cursor = db.rawQuery(query, null);
        int count = cursor.getCount();

        values.put(Column_ID, count);
        values.put(Column_Word1, wordPair.getWord1());
        values.put(Column_Word2, wordPair.getWord2());

        db.insert(TABLE_NAME, null, values);
    }

    public String searchWords(String word) {
        db = this.getReadableDatabase();
        String query = "select word1, word2 from " + TABLE_NAME;
        Cursor cursor = db.rawQuery(query, null);
        String a, b;
        b = "not found";

        if(cursor.moveToFirst()) {
            do {
                a = cursor.getString(0);

                if(a.equals(word)) {
                    b = cursor.getString(1);
                    break;
                }

                a = cursor.getString(1);

                if(a.equals(word)) {
                    b = cursor.getString(0);
                    break;
                }
            }
            while(cursor.moveToNext());
        }

        return b;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE);
        this.db = db;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String query = "DROP TABLE IF EXISTS " + TABLE_NAME;
        db.execSQL(query);
        this.onCreate(db);
    }
}
