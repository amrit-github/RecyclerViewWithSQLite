package com.example.amrit.recyclerviewwithdatabase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.example.amrit.recyclerviewwithdatabase.ModelContract.*;

public final class DataBaseHelperClass extends SQLiteOpenHelper{

    public static final String DATABASE_NAME = "recyclerView.db";
    public static final int DATABASE_VERSION = 1;

    public DataBaseHelperClass(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

         String SQL_CREATE_MODEL_LIST_TABLE = "CREATE TABLE " + ModelEntry.TABLE_NAME + "("
                 + ModelEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                 + ModelEntry.HELLO_COLUMN + " TEXT,"
                 + ModelEntry.NUMBER_COLUMN + " INTEGER);";

        db.execSQL(SQL_CREATE_MODEL_LIST_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        db.execSQL("DROP TABLE IF EXISTS " + ModelEntry.TABLE_NAME);
        onCreate(db);
    }
}
