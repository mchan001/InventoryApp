package com.example.android.inventoryapp;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import com.example.android.inventoryapp.data.InventoryContract.InventoryEntry;

public class ItemCursorAdapter extends CursorAdapter {

    public ItemCursorAdapter(Context context, Cursor c){ super(context, c, 0);}

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView itemName = view.findViewById(R.id.name);
        TextView itemPrice = view.findViewById(R.id.summary);
        TextView itemId = view.findViewById(R.id.number);

        String number = cursor.getString(cursor.getColumnIndexOrThrow(InventoryEntry._ID));
        String body = cursor.getString(cursor.getColumnIndexOrThrow(InventoryEntry.COLUMN_ITEM_NAME));
        String summary = cursor.getString(cursor.getColumnIndexOrThrow(InventoryEntry.COLUMN_PRICE));
        if(summary.isEmpty()){
            summary = context.getString(R.string.price_unknown);
        }
        itemId.setText(number);
        itemName.setText(body);
        itemPrice.setText(summary);
    }
}
