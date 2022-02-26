package com.example.sevenstars;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class Wishlist_Activity_sample extends AppCompatActivity {

    TextView t1;
    ListView LISTVIEW;

    SQLiteDatabase sqLiteDatabase;
    String FirstHolder,SqliteQueryBaseHolder;
    boolean CheckEditText;

    SqliteHelper sqliteHelper;
    SQLiteDatabase sqLiteDatabase2;
    Cursor cursor;
    CustomListAdapter listAdapter;

    ArrayList<String> ID_ARRAY;
    ArrayList<String> TITLE_ARRAY;


    ArrayList<String> ListViewClickItemArray= new ArrayList<>();

    @Override
    protected void onResume() {
        super.onResume();
        ShowSQLiteDBdata();
    }

    @SuppressLint("Range")
    private void ShowSQLiteDBdata() {

        sqLiteDatabase2=sqliteHelper.getWritableDatabase();

        cursor=sqLiteDatabase2.rawQuery("SELECT * FROM " +SqliteHelper.TABLE_NAME+ "",null);

        ID_ARRAY.clear();
        TITLE_ARRAY.clear();

        if (cursor.moveToFirst()){
            do {
                ID_ARRAY.add(cursor.getString(cursor.getColumnIndex(SqliteHelper.TABLE_COLUMN_ID)));

                ListViewClickItemArray.add(cursor.getString(cursor.getColumnIndex(SqliteHelper.TABLE_COLUMN_ID)));

                TITLE_ARRAY.add(cursor.getString(cursor.getColumnIndex(SqliteHelper.TABLE_COLUMN_TITLE)));


            }while (cursor.moveToNext());

            listAdapter=new CustomListAdapter(Wishlist_Activity_sample.this,ID_ARRAY,TITLE_ARRAY);

            listAdapter.notifyDataSetChanged();
          //  LISTVIEW.setBackgroundColor(this.getResources().getColor(R.color.white));
            LISTVIEW.setAdapter(listAdapter);
            cursor.close();

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wishlist_sample);

        t1 = findViewById(R.id.t1);
        LISTVIEW = findViewById(R.id.listview);

        Intent intent = getIntent();
        String name = intent.getStringExtra("add");

        t1.setText(name);



        ID_ARRAY=new ArrayList<String>();
        TITLE_ARRAY=new ArrayList<String>();

        sqliteHelper=new SqliteHelper(this);

        SqliteDatabaseBuild();

        SqliteTableBuild();

        CheckEditTextStatus();

        SqliteInsertData();

        EmptyEditTextAfterInsert();
    }

    private void SqliteDatabaseBuild() {
        sqLiteDatabase=openOrCreateDatabase("WishListDataBase", Context.MODE_PRIVATE,null);
    }

    private void SqliteTableBuild() {
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS " + "WishListTable(id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,title VARCHAR);");
    }

    private void CheckEditTextStatus() {

        FirstHolder=t1.getText().toString();

                if (TextUtils.isEmpty(FirstHolder)){
                    CheckEditText=false;
                }
                else {
                    CheckEditText=true;
                }

    }

    private void SqliteInsertData() {

        FirstHolder=t1.getText().toString();

                String FirstHolder2=FirstHolder.replace("'","''");


                if (CheckEditText==true){

                    SqliteQueryBaseHolder="INSERT INTO WishListTable(title) VALUES('"+FirstHolder2+"');";
                    sqLiteDatabase.execSQL(SqliteQueryBaseHolder);

                }else {

                }

    }

    private void EmptyEditTextAfterInsert() {
        t1.setText("");
    }
}