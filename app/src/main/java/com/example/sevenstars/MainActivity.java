package com.example.sevenstars;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Spinner;
import android.widget.Toast;

import com.razorpay.Checkout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    CustomAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recycler1);

        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP){
            getWindow().setNavigationBarColor(getResources().getColor(R.color.black));
        }


        List<String> TrustName=new ArrayList<>();
        TrustName.add("Parvati Charitable Trust");
        TrustName.add("Saanthvana Seva");
        TrustName.add("The Association of People with disability");
        TrustName.add("Samarthanam Trust for the Disabled");
        TrustName.add("Vathsalya Charitable Trust");
        TrustName.add("Jeevana Jyothi Charitable Trust");
        TrustName.add("New Mighty Grace Charitable Trust");
        TrustName.add("Om Shakti Mahila Charitable Trust");
        TrustName.add("CARE SHELTER");
        TrustName.add("android");
        TrustName.add("REACHING HAND");



        customAdapter=new CustomAdapter(getData());

        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(customAdapter);


    }

    private ArrayList getData()
    {
    ArrayList<GetterSetter> gts=new ArrayList<>();


    GetterSetter gs1=new GetterSetter();
    gs1.setImage(R.drawable.charity);
    gs1.setName("Parvati Charitable Trust");
    gs1.setType("Retirement Home");
    gs1.setAddress("Ambedkar Street, HAL Old Airport Rd, Byatarayanapura");
    gts.add(gs1);

         gs1=new GetterSetter();
         gs1.setImage(R.drawable.charity4);
         gs1.setName("Saanthvana Seva");
         gs1.setType("Old Age Home");
         gs1.setAddress("#509 Samarpan. E A road. Ideal homes society Near Gopalan arcade mall, RR Nagar");
         gts.add(gs1);

        gs1=new GetterSetter();
        gs1.setImage(R.drawable.charity5);
        gs1.setName("The Association of People with disability");
        gs1.setType("Physically disabled");
        gs1.setAddress("6th Cross Road, Horamavu Agara Road, Off, Hutchins Rd, St Thomas Town, Lingarajapuram");
        gts.add(gs1);

        gs1=new GetterSetter();
        gs1.setImage(R.drawable.charity6);
        gs1.setName("Samarthanam Trust for the Disabled");
        gs1.setType("Physically disabled");
        gs1.setAddress("16th Main Road, 15th Cross Rd, Sector 4, HSR Layout");
        gts.add(gs1);

        gs1=new GetterSetter();
        gs1.setImage(R.drawable.charity7);
        gs1.setName("Vathsalya Charitable Trust");
        gs1.setType("Nutrition, Education");
        gs1.setAddress("717, 5th Cross Rd, HRBR Layout 1st Block, HRBR Layout, Kalyan Nagar");
        gts.add(gs1);

        gs1=new GetterSetter();
        gs1.setImage(R.drawable.charity8);
        gs1.setName("Jeevana Jyothi Charitable Trust");
        gs1.setType(" Educating");
        gs1.setAddress("No-28/1,10th cross, ashirwad colony, Bank Avenue, Horamavu Banaswadi");
        gts.add(gs1);

        gs1=new GetterSetter();
        gs1.setImage(R.drawable.charity1);
        gs1.setName("New Mighty Grace Charitable Trust");
        gs1.setType("Support to underprivileged children, Youth, Women & Disabled");
        gs1.setAddress("No.35, 244/1, Munivenkatappa Layout, Horamavu Main Rd, Kalkere");
        gts.add(gs1);

        gs1=new GetterSetter();
        gs1.setImage(R.drawable.charity1);
        gs1.setName("Om Shakti Mahila Charitable Trust");
        gs1.setType("Orphanage, Education and Day Care");
        gs1.setAddress("No. 21,sharadamma building, sampangi ramaiah layout K.G. halli");
        gts.add(gs1);

        gs1=new GetterSetter();
        gs1.setImage(R.drawable.charity9);
        gs1.setName("CARE SHELTER");
        gs1.setType("Old aged and disabled people");
        gs1.setAddress("39,19th Main, 38th Cross Rd, 5th Block, Prakruthi Layout");
        gts.add(gs1);

        gs1=new GetterSetter();
        gs1.setImage(R.drawable.charity1);
        gs1.setName("REACHING HAND");
        gs1.setType("education, health, and sustainable livelihood development");
        gs1.setAddress("1st Floor, 44, Nehru Rd, AravindNagar, Yadava Layout, St Thomas Town, Kacharakanahalli");
        gts.add(gs1);

        return gts;
    }
}