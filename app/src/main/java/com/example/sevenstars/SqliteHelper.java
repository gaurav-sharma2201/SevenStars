package com.example.sevenstars;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class SqliteHelper extends SQLiteOpenHelper {

    static String DATABASE_NAME="WishListDataBase";

    public static final String TABLE_NAME="WishListTable";

    public static final String TABLE_COLUMN_ID="id";

    public static final String TABLE_COLUMN_TITLE="title";


    public SqliteHelper(@Nullable Context context){
        super(context,DATABASE_NAME,null,1);

    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE="CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " ( "+ TABLE_COLUMN_ID + " INTEGER PRIMARY KEY, "+TABLE_COLUMN_TITLE+" VARCHAR)";
        db.execSQL(CREATE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " +TABLE_NAME);
        onCreate(db);

    }
}
