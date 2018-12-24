package com.example.android.inventoryapp.data;

import android.content.ContentResolver;
import android.net.Uri;
import android.provider.BaseColumns;

public class InventoryContract {

    private InventoryContract(){}

    public static final String CONTENT_AUTHORITY = "com.example.android.inventoryapp";
    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);
    public static final String PATH_ITEMS = "items";

    public static final class InventoryEntry implements BaseColumns {

        public static final Uri CONTENT_URI = Uri.withAppendedPath(BASE_CONTENT_URI, PATH_ITEMS);

        /**
         * The MIME type of the {@link #CONTENT_URI} for a list of items.
         */
        public static final String CONTENT_LIST_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_ITEMS;

        /**
         * The MIME type of the {@link #CONTENT_URI} for a single item.
         */
        public static final String CONTENT_ITEM_TYPE =
                ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_ITEMS;


        public final static String TABLE_NAME = "items";
        public final static String _ID = BaseColumns._ID;

        public final static String COLUMN_ITEM_NAME = "product_name";
        public final static String COLUMN_PRICE = "price";
        public final static String COLUMN_QUANTITY = "quantity";
        public final static String COLUMN_SUPPLIER_NAME = "supplier_name";
        public final static String COLUMN_PHONE_NUMBER = "phone_number";
    }

}
