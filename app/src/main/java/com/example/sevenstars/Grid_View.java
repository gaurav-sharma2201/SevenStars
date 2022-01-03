package com.example.sevenstars;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.GridView;

public class Grid_View extends AppCompatActivity {
    GridView g1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view);
        g1=findViewById(R.id.grid_view);
        g1.setAdapter(new GridAdapter(this));

    }
}