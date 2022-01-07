package com.example.sevenstars;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class My_wishlist extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerViewAdapter recyclerViewAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_wishlist);

        recyclerView=findViewById(R.id.recycler1);

        Intent intent=getIntent();
        String name=intent.getStringExtra("new");

       // recyclerViewAdapter=new RecyclerViewAdapter();

        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(recyclerViewAdapter);


    }

//    private ArrayList<Wishlist_getter_setter> getData() {
//        ArrayList<Wishlist_getter_setter> list=new ArrayList<Wishlist_getter_setter>();
//        Wishlist_getter_setter abc=new Wishlist_getter_setter();
//        list.add(abc);
//        return list;
//    }
}