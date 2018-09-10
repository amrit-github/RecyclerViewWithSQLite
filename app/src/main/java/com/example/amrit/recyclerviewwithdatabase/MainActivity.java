package com.example.amrit.recyclerviewwithdatabase;

import android.Manifest;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.strictmode.SqliteObjectLeakedViolation;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private static final String hello = "Hello From ";
    private SQLiteDatabase mDatabase;
    private MyAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DataBaseHelperClass dataBaseHelperClass = new DataBaseHelperClass(this);
        mDatabase = dataBaseHelperClass.getWritableDatabase();
        insertInstanceValues();

        mRecyclerView = findViewById(R.id.myRecyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new MyAdapter(this,getAllData());
        mRecyclerView.setAdapter(mAdapter);
    }

    public void insertInstanceValues() {
        for(int i = 1; i < 20; i++){

            String column_1 = hello + " " + String.valueOf(i);
            int column_2 = i*i;
            ContentValues contentValues = new ContentValues();
            contentValues.put(ModelContract.ModelEntry.HELLO_COLUMN,column_1);
            contentValues.put(ModelContract.ModelEntry.NUMBER_COLUMN,column_2);

            mDatabase.insert(ModelContract.ModelEntry.TABLE_NAME,null,contentValues);
        }
    }

    public Cursor getAllData(){

        SQLiteDatabase myDb = new DataBaseHelperClass(this).getReadableDatabase();
        return myDb.rawQuery("SELECT * FROM " + ModelContract.ModelEntry.TABLE_NAME,null);
    }
}
