package com.example.sevenstars;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class Search extends AppCompatActivity {
    AutoCompleteTextView searchbox;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        searchbox=findViewById(R.id.SearchBox1);

        Window window = this.getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.setNavigationBarColor(this.getResources().getColor(R.color.black));


        List<String> TrustName = new ArrayList<>();
        TrustName.add("Parvathi Charitable Trust");
        TrustName.add("Saanthvana Seva");
        TrustName.add("The Association of People with disability");
        TrustName.add("Samarthanam Trust for the Disabled");
        TrustName.add("Vathsalya Charitable Trust");
        TrustName.add("Jeevana Jyothi Charitable Trust");
        TrustName.add("New Mighty Grace Charitable Trust");
        TrustName.add("Om Shakti Mahila Charitable Trust");
        TrustName.add("CARE SHELTER");
        TrustName.add("REACHING HAND");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.select_dialog_item, TrustName);
        searchbox.setThreshold(1);
        searchbox.setAdapter(arrayAdapter);

        searchbox.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String adapterView=parent.getItemAtPosition(position).toString();

                Toast.makeText(getApplicationContext(), adapterView, Toast.LENGTH_SHORT).show();

                FloatingActionButton button1=(FloatingActionButton) findViewById(R.id.search_button1);
                button1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        button(adapterView);
                    }
                });

            }

            private void button(String adapterView) {
                if (adapterView.matches("Parvathi Charitable Trust")){
                    String key="Chairman 1";
                    String address="Ambedkar Street, Byatarayanapura, Airport Road,Bangalore, Karnataka 560092";
                    Intent intent=new Intent(Search.this,Details.class);
                    intent.putExtra("Name",adapterView);
                    intent.putExtra("Chairman",key);
                    intent.putExtra("Address",address);
                    startActivity(intent);
                }else if (adapterView.matches("Saanthvana Seva")){
                    String key="Chairman 2";
                    String address="#509 Samarpan. E A road. Ideal homes society Near Gopalan arcade mall, RR Nagar";
                    Intent intent=new Intent(Search.this,Details.class);
                    intent.putExtra("Name",adapterView);
                    intent.putExtra("Chairman",key);
                    intent.putExtra("Address",address);
                    startActivity(intent);
                }else if (adapterView.matches("The Association of People with disability")){
                    String key="Chairman 3";
                    String address="6th Cross Road, Horamavu Agara Road, Off, Hutchins Rd, St Thomas Town, Lingarajapuram";
                    Intent intent=new Intent(Search.this,Details.class);
                    intent.putExtra("Name",adapterView);
                    intent.putExtra("Chairman",key);
                    intent.putExtra("Address",address);
                    startActivity(intent);
                }else if (adapterView.matches("Samarthanam Trust for the Disabled")){
                    String key="Chairman 4";
                    String address="16th Main Road, 15th Cross Rd, Sector 4, HSR Layout";
                    Intent intent=new Intent(Search.this,Details.class);
                    intent.putExtra("Name",adapterView);
                    intent.putExtra("Chairman",key);
                    intent.putExtra("Address",address);
                    startActivity(intent);
                }else if (adapterView.matches("Vathsalya Charitable Trust")){
                    String key="Chairman 5";
                    String address="717, 5th Cross Rd, HRBR Layout 1st Block, HRBR Layout, Kalyan Nagar";
                    Intent intent=new Intent(Search.this,Details.class);
                    intent.putExtra("Name",adapterView);
                    intent.putExtra("Chairman",key);
                    intent.putExtra("Address",address);
                    startActivity(intent);
                }else if (adapterView.matches("Jeevana Jyothi Charitable Trust")){
                    String key="Chairman 6";
                    String address="No-28/1,10th cross, ashirwad colony, Bank Avenue, Horamavu Banaswadi";
                    Intent intent=new Intent(Search.this,Details.class);
                    intent.putExtra("Name",adapterView);
                    intent.putExtra("Chairman",key);
                    intent.putExtra("Address",address);
                    startActivity(intent);
                }else if (adapterView.matches("New Mighty Grace Charitable Trust")){
                    String key="Chairman 7";
                    String address="No.35, 244/1, Munivenkatappa Layout, Horamavu Main Rd, Kalkere";
                    Intent intent=new Intent(Search.this,Details.class);
                    intent.putExtra("Name",adapterView);
                    intent.putExtra("Chairman",key);
                    intent.putExtra("Address",address);
                    startActivity(intent);
                }else if (adapterView.matches("Om Shakti Mahila Charitable Trust")){
                    String key="Chairman 7";
                    String address="No. 21,sharadamma building, sampangi ramaiah layout K.G. halli";
                    Intent intent=new Intent(Search.this,Details.class);
                    intent.putExtra("Name",adapterView);
                    intent.putExtra("Chairman",key);
                    intent.putExtra("Address",address);
                    startActivity(intent);
                }else if (adapterView.matches("CARE SHELTER")){
                    String key="Chairman 9";
                    String address="39,19th Main, 38th Cross Rd, 5th Block, Prakruthi Layout";
                    Intent intent=new Intent(Search.this,Details.class);
                    intent.putExtra("Name",adapterView);
                    intent.putExtra("Chairman",key);
                    intent.putExtra("Address",address);
                    startActivity(intent);
                }else if (adapterView.matches("REACHING HAND")){
                    String key="Chairman 10";
                    String address=" 1st Floor, 44, Nehru Rd, AravindNagar, Yadava Layout, St Thomas Town, Kacharakanahalli";
                    Intent intent=new Intent(Search.this,Details.class);
                    intent.putExtra("Name",adapterView);
                    intent.putExtra("Chairman",key);
                    intent.putExtra("Address",address);
                    startActivity(intent);
                }
            }
        });

    }
}