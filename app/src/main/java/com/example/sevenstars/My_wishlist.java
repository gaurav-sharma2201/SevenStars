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
    TextView textView;
    String name_of_trust;

    ArrayList<Wishlist_getter_setter> course_getter_setterList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_wishlist);
        textView=findViewById(R.id.t1);

        recyclerView=findViewById(R.id.recycler1);

        Intent intent=getIntent();
        String name=intent.getStringExtra("new");
        textView.setText(name);

        name_of_trust=textView.getText().toString();

        course_getter_setterList=new ArrayList<>();

        recyclerViewAdapter=new RecyclerViewAdapter(getData());

        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(recyclerViewAdapter);




    }

    private ArrayList<Wishlist_getter_setter> getData() {
        ArrayList<Wishlist_getter_setter> list=new ArrayList<Wishlist_getter_setter>();
        Wishlist_getter_setter abc=new Wishlist_getter_setter();
        list.add(abc);
        return list;
    }
}