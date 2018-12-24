package com.example.android.inventoryapp.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.android.inventoryapp.data.InventoryContract.InventoryEntry;

public class InventoryDbHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "inventory.db";

    private static final int DATABASE_VERSION = 1;

    public InventoryDbHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String SQL_CREATE_INVENTORY_TABLE =  "CREATE TABLE " + InventoryEntry.TABLE_NAME + " ("
                + InventoryEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + InventoryEntry.COLUMN_ITEM_NAME + " TEXT NOT NULL, "
                + InventoryEntry.COLUMN_PRICE + " FLOAT, "
                + InventoryEntry.COLUMN_QUANTITY + " INTEGER, "
                + InventoryEntry.COLUMN_SUPPLIER_NAME + " TEXT, "
                + InventoryEntry.COLUMN_PHONE_NUMBER + " VARCHAR(15));";

        db.execSQL(SQL_CREATE_INVENTORY_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //Don't do anything here yet.
    }
}
