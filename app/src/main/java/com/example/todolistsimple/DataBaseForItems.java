package com.example.todolistsimple;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DataBaseForItems extends SQLiteOpenHelper {

    public static final String TABLENAME = "TABLENAME";
    public static final String ITEM_NAME= "ITEM_NAME" ;
    public static final String ITEM_QUANTITY = "ITEM_QUANTITY";
    public static final String ID = "ID";

    public DataBaseForItems(@Nullable Context context) {
        super(context, TABLENAME, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableStatment = "CREATE TABLE " + TABLENAME + " ( " + ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + ITEM_NAME +" TEXT, " + ITEM_QUANTITY + " INTEGER )";


        db.execSQL(createTableStatment);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public boolean addOne (ItemsList itemslist ) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(ITEM_NAME, itemslist.getName());
        cv.put(ITEM_QUANTITY, itemslist.getQuantity());

        long insert = db.insert(TABLENAME,null , cv);
        if (insert ==-1) {
            return false;
        }
        else {
            return true ;
        }


    }
}
