package com.example.sevenstars;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Read_more extends AppCompatActivity {

    ImageView back,share;
    TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_more);
        back=findViewById(R.id.back1);
        share=findViewById(R.id.share1);
        title=findViewById(R.id.title);

        Intent intent=getIntent();
        String read_name=intent.getStringExtra("read_name");
        title.setText(read_name);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Read_more.this,MainActivity.class);
                startActivity(intent);
            }
        });

        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String s_title=title.getText().toString();
                Intent intent1=new Intent(Intent.ACTION_SEND);
                intent1.putExtra(Intent.EXTRA_TEXT,"Sharing this with you \n" + s_title);
                intent1.setType("text/plain");
                startActivity(intent1.createChooser(intent1,"Send to"));
            }
        });

    }
}