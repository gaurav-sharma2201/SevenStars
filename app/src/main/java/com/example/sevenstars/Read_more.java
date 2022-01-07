package com.example.sevenstars;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Read_more extends AppCompatActivity {

    ImageView back,share;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_more);
        back=findViewById(R.id.back1);
        share=findViewById(R.id.share1);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Read_more.this,MainActivity.class);
                startActivity(intent);
            }
        });


    }
}