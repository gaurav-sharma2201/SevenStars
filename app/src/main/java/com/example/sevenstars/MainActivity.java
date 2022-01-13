package com.example.sevenstars;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.razorpay.Checkout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    CustomAdapter customAdapter;
    GoogleSignInClient mGoogleSignInClient;
    ImageButton signout;
    ImageView profileimage;
    TextView username,my_wishlist;

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finishAffinity();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recycler1);
        signout=findViewById(R.id.sign_out);
        profileimage=findViewById(R.id.profileimage);
        username=findViewById(R.id.username);
        my_wishlist=findViewById(R.id.my_wishlist);

        my_wishlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,WishList.class);
                startActivity(intent);
            }
        });


        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();

        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);

        GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(this);
        if (account != null) {
            String personName = account.getDisplayName();
            String personGivenName = account.getGivenName();
            String personFamilyName = account.getFamilyName();
            String personEmail = account.getEmail();
            String personId = account.getId();
            Uri personPhoto = account.getPhotoUrl();

            Glide.with(this).load(personPhoto).into(profileimage);
            username.setText(personName);
        }else {
            Intent intent=getIntent();
            String name=intent.getStringExtra("username");
            username.setText(name);
        }

        signout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.sign_out:
                        signout();
                }
            }
        });


        List<String> TrustName=new ArrayList<>();
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

        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(this, android.R.layout.select_dialog_item,TrustName);
        AutoCompleteTextView searchbox=findViewById(R.id.SearchBox);
        searchbox.setThreshold(1);
        searchbox.setAdapter(arrayAdapter);

        searchbox.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String adapterView=parent.getItemAtPosition(position).toString();

                Toast.makeText(getApplicationContext(), adapterView, Toast.LENGTH_SHORT).show();

                Button button=(Button) findViewById(R.id.select1);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        button(adapterView,getData());
                    }
                });

            }

            private void button(String adapterView, ArrayList data) {
                if (adapterView.matches("Parvathi Charitable Trust")){
                    String key="Chairman 1";
                    String address="Ambedkar Street, Byatarayanapura, Airport Road,Bangalore, Karnataka 560092";
                    Intent intent=new Intent(MainActivity.this,Details.class);
                    intent.putExtra("Name",adapterView);
                    intent.putExtra("Chairman",key);
                    intent.putExtra("Address",address);
                    startActivity(intent);
                }else if (adapterView.matches("Saanthvana Seva")){
                    String key="Chairman 2";
                    String address="#509 Samarpan. E A road. Ideal homes society Near Gopalan arcade mall, RR Nagar";
                    Intent intent=new Intent(MainActivity.this,Details.class);
                    intent.putExtra("Name",adapterView);
                    intent.putExtra("Chairman",key);
                    intent.putExtra("Address",address);
                    startActivity(intent);
                }else if (adapterView.matches("The Association of People with disability")){
                    String key="Chairman 3";
                    String address="6th Cross Road, Horamavu Agara Road, Off, Hutchins Rd, St Thomas Town, Lingarajapuram";
                    Intent intent=new Intent(MainActivity.this,Details.class);
                    intent.putExtra("Name",adapterView);
                    intent.putExtra("Chairman",key);
                    intent.putExtra("Address",address);
                    startActivity(intent);
                }else if (adapterView.matches("Samarthanam Trust for the Disabled")){
                    String key="Chairman 4";
                    String address="16th Main Road, 15th Cross Rd, Sector 4, HSR Layout";
                    Intent intent=new Intent(MainActivity.this,Details.class);
                    intent.putExtra("Name",adapterView);
                    intent.putExtra("Chairman",key);
                    intent.putExtra("Address",address);
                    startActivity(intent);
                }else if (adapterView.matches("Vathsalya Charitable Trust")){
                    String key="Chairman 5";
                    String address="717, 5th Cross Rd, HRBR Layout 1st Block, HRBR Layout, Kalyan Nagar";
                    Intent intent=new Intent(MainActivity.this,Details.class);
                    intent.putExtra("Name",adapterView);
                    intent.putExtra("Chairman",key);
                    intent.putExtra("Address",address);
                    startActivity(intent);
                }else if (adapterView.matches("Jeevana Jyothi Charitable Trust")){
                    String key="Chairman 6";
                    String address="No-28/1,10th cross, ashirwad colony, Bank Avenue, Horamavu Banaswadi";
                    Intent intent=new Intent(MainActivity.this,Details.class);
                    intent.putExtra("Name",adapterView);
                    intent.putExtra("Chairman",key);
                    intent.putExtra("Address",address);
                    startActivity(intent);
                }else if (adapterView.matches("New Mighty Grace Charitable Trust")){
                    String key="Chairman 7";
                    String address="No.35, 244/1, Munivenkatappa Layout, Horamavu Main Rd, Kalkere";
                    Intent intent=new Intent(MainActivity.this,Details.class);
                    intent.putExtra("Name",adapterView);
                    intent.putExtra("Chairman",key);
                    intent.putExtra("Address",address);
                    startActivity(intent);
                }else if (adapterView.matches("Om Shakti Mahila Charitable Trust")){
                    String key="Chairman 7";
                    String address="No. 21,sharadamma building, sampangi ramaiah layout K.G. halli";
                    Intent intent=new Intent(MainActivity.this,Details.class);
                    intent.putExtra("Name",adapterView);
                    intent.putExtra("Chairman",key);
                    intent.putExtra("Address",address);
                    startActivity(intent);
                }else if (adapterView.matches("CARE SHELTER")){
                    String key="Chairman 9";
                    String address="39,19th Main, 38th Cross Rd, 5th Block, Prakruthi Layout";
                    Intent intent=new Intent(MainActivity.this,Details.class);
                    intent.putExtra("Name",adapterView);
                    intent.putExtra("Chairman",key);
                    intent.putExtra("Address",address);
                    startActivity(intent);
                }else if (adapterView.matches("REACHING HAND")){
                    String key="Chairman 10";
                    String address=" 1st Floor, 44, Nehru Rd, AravindNagar, Yadava Layout, St Thomas Town, Kacharakanahalli";
                    Intent intent=new Intent(MainActivity.this,Details.class);
                    intent.putExtra("Name",adapterView);
                    intent.putExtra("Chairman",key);
                    intent.putExtra("Address",address);
                    startActivity(intent);
                }
//                data=new ArrayList();
//                Intent intent=new Intent(MainActivity.this,Details.class);
//                intent.putExtra("data",data);
//                startActivity(intent);
            }
        });

        searchbox.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });



        customAdapter=new CustomAdapter(getData());

        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(customAdapter);


    }

    private void signout() {
        mGoogleSignInClient.signOut()
                .addOnCompleteListener(this, new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        Toast.makeText(MainActivity.this, "User Signed out successfully", Toast.LENGTH_SHORT).show();

                        Intent intent=new Intent(MainActivity.this,Login.class);
                        startActivity(intent);

                    }
                });
    }

    private ArrayList getData()
    {
    ArrayList<GetterSetter> gts=new ArrayList<>();


    GetterSetter gs1=new GetterSetter();
    gs1.setImage(R.drawable.back1);
    gs1.setName("Parvathi Charitable Trust");
    gs1.setKey_People("Chairman 1");
    gs1.setType("Old Age Home\n" +
            "24/7 Nursing Care\n" +
            "Doctors Care\n" +
            "Food & Accommodation");
    gs1.setAddress("Ambedkar Street, Byatarayanapura, Airport Road\n" +
            "Bangalore, Karnataka 560092\n" +
            "India");
    gts.add(gs1);

         gs1=new GetterSetter();
         gs1.setImage(R.drawable.saanthvana);
         gs1.setKey_People("Chairman 2");
         gs1.setName("Saanthvana Seva");
         gs1.setType("OLD-AGE HOME\n" +
                 "NURSING CARE");
         gs1.setAddress("#509 Samarpan. E A road. Ideal homes society Near Gopalan arcade mall, RR Nagar");
         gts.add(gs1);

        gs1=new GetterSetter();
        gs1.setImage(R.drawable.apd);
        gs1.setKey_People("Chairman 3");
        gs1.setName("The Association of People with disability");
        gs1.setType("Physically disabled\n"+
                "Early Intervention\n"+
                "Inclusive Education\n"+
                "Livelihood Program");
        gs1.setKey_People("Chairman 3");
        gs1.setAddress("6th Cross Road, Horamavu Agara Road, Off, Hutchins Rd, St Thomas Town, Lingarajapuram");
        gts.add(gs1);

        gs1=new GetterSetter();
        gs1.setImage(R.drawable.samarthanam);
        gs1.setKey_People("Chairman 4");
        gs1.setName("Samarthanam Trust for the Disabled");
        gs1.setType("Education\n"+
                "Livelihood\n"+
                "Environment\n"+
                "Sports\n"+
                "Rehabilitation");
        gs1.setAddress("16th Main Road, 15th Cross Rd, Sector 4, HSR Layout");
        gts.add(gs1);

        gs1=new GetterSetter();
        gs1.setImage(R.drawable.vathsalya);
        gs1.setKey_People("Chairman 5");
        gs1.setName("Vathsalya Charitable Trust");
        gs1.setType("Nutrition\n"+ "Education\n"+"Child Labour\n"+"Girl Empowerment");
        gs1.setAddress("717, 5th Cross Rd, HRBR Layout 1st Block, HRBR Layout, Kalyan Nagar");
        gts.add(gs1);

        gs1=new GetterSetter();
        gs1.setImage(R.drawable.jeevana_jyothi);
        gs1.setKey_People("Chairman 6");
        gs1.setName("Jeevana Jyothi Charitable Trust");
        gs1.setType(" A home for the homeless\n" +
                " Food for the hungry\n" +
                " Clothes for the needy\n" +
                " Love for the abandoned & education for the under-provileged");
        gs1.setAddress("No-28/1,10th cross, ashirwad colony, Bank Avenue, Horamavu Banaswadi");
        gts.add(gs1);

        gs1=new GetterSetter();
        gs1.setImage(R.drawable.new_mighty);
        gs1.setKey_People("Chairman 7");
        gs1.setName("New Mighty Grace Charitable Trust");
        gs1.setType("Support to Underprivileged children\n" +
                "Youth Women & Disabled");
        gs1.setAddress("No.35, 244/1, Munivenkatappa Layout, Horamavu Main Rd, Kalkere");
        gts.add(gs1);

        gs1=new GetterSetter();
        gs1.setImage(R.drawable.om_shakthi);
        gs1.setKey_People("Chairman 8");
        gs1.setName("Om Shakti Mahila Charitable Trust");
        gs1.setType("Orphanage\n" +
                " Education and Day Care\n" +
                "Skill Development\n" +
                "Health\n" +
                "Disaster Relief\n" +
                "Child Malnutrition");
        gs1.setAddress("No. 21,sharadamma building, sampangi ramaiah layout K.G. halli");
        gts.add(gs1);

        gs1=new GetterSetter();
        gs1.setImage(R.drawable.care_shelter);
        gs1.setKey_People("Chairman 9");
        gs1.setName("CARE SHELTER");
        gs1.setType("Old aged\n" +
                "Disabled people");
        gs1.setAddress("39,19th Main, 38th Cross Rd, 5th Block, Prakruthi Layout");
        gts.add(gs1);

        gs1=new GetterSetter();
        gs1.setImage(R.drawable.charity1);
        gs1.setKey_People("Chairman 10");
        gs1.setName("REACHING HAND");
        gs1.setType("Education, Health, and sustainable Livelihood Development");
        gs1.setAddress("1st Floor, 44, Nehru Rd, AravindNagar, Yadava Layout, St Thomas Town, Kacharakanahalli");
        gts.add(gs1);

        return gts;
    }
}