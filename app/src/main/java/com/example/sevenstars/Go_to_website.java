package com.example.sevenstars;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Go_to_website extends AppCompatActivity {
    WebView wv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_go_to_website);
        wv1=findViewById(R.id.wv1);
        wv1.getSettings().getJavaScriptEnabled();
        wv1.setWebViewClient(new WebViewClient());


        wv1.loadUrl("https://www.amazon.com");
    }
}