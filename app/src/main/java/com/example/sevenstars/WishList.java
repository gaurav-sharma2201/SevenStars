package com.example.sevenstars;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class WishList extends AppCompatActivity {
    Button b1;
    EditText ed1;
    TextView t1;
    SQLiteDatabase sqLiteDatabase;
    String FirstHolder,SecondHolder,SqliteQueryBaseHolder;
    boolean CheckEditText;

    SqliteHelper sqliteHelper;
    SQLiteDatabase sqLiteDatabase2;
    Cursor cursor;
    CustomListAdapter listAdapter;
    ListView LISTVIEW;

    ArrayList<String> ID_ARRAY;
    ArrayList<String> TITLE_ARRAY;

    ArrayList<String> ListViewClickItemArray= new ArrayList<>();

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent=new Intent(WishList.this,MainActivity.class);
        startActivity(intent);
    }

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

            listAdapter=new CustomListAdapter(WishList.this,ID_ARRAY,TITLE_ARRAY);

            LISTVIEW.setAdapter(listAdapter);
            cursor.close();

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wish_list);
        ed1=findViewById(R.id.ed1);
        LISTVIEW=findViewById(R.id.listview);
        b1=findViewById(R.id.b1);
        t1=findViewById(R.id.t1);

        Intent intent=getIntent();
        String name=intent.getStringExtra("wish");
        t1.setText(name);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SqliteDatabaseBuild();

                SqliteTableBuild();

                CheckEditTextStatus();

                SqliteInsertData();

                EmptyEditTextAfterInsert();

                Intent intent1=new Intent(WishList.this,MainActivity.class);
                startActivity(intent1);

                Toast.makeText(WishList.this, "Wishlist Updated", Toast.LENGTH_SHORT).show();

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
                    Toast.makeText(WishList.this, "Please fill Name", Toast.LENGTH_SHORT).show();
                }
            }

            private void EmptyEditTextAfterInsert() {
                ed1.getText().clear();
                t1.setText("");
            }
        });

        ID_ARRAY=new ArrayList<String>();
        TITLE_ARRAY=new ArrayList<String>();
        sqliteHelper=new SqliteHelper(this);

        LISTVIEW.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(WishList.this, "Want to donate", Toast.LENGTH_SHORT).show();
            }
        });


    }

}