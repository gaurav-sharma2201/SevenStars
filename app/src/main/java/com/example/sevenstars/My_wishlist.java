package com.example.sevenstars;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class My_wishlist extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerViewAdapter recyclerViewAdapter;
    private List<List_Data> list_data;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_wishlist);

        Intent intent=getIntent();
        String name=intent.getStringExtra("new");

        recyclerView=findViewById(R.id.recycler1);
        GridLayoutManager gridLayoutManager=new GridLayoutManager(this,2);
        list_data=new ArrayList<>();




    }

}