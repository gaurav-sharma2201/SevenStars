package com.example.sevenstars;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private static final String BUNDLE_RECYCLER_LAYOUT = "classname.recycler.layout";

    RecyclerView recyclerView;
    CustomAdapter customAdapter;
    GoogleSignInClient mGoogleSignInClient;
    ImageView profileimage;
    BottomNavigationView bottomNavigationView;


    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Parcelable savedRecyclerLayoutState = savedInstanceState.getParcelable(BUNDLE_RECYCLER_LAYOUT);
        Objects.requireNonNull(recyclerView.getLayoutManager()).onRestoreInstanceState(savedRecyclerLayoutState);
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelable(BUNDLE_RECYCLER_LAYOUT, Objects.requireNonNull(recyclerView.getLayoutManager()).onSaveInstanceState());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recycler1);
        profileimage = findViewById(R.id.ProfileImage);
        bottomNavigationView = findViewById(R.id.bottomNavView);
        bottomNavigationView.setBackground(null);


            Window window = this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setNavigationBarColor(this.getResources().getColor(R.color.black));


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

            TextView star=(TextView)findViewById(R.id.star);
            star.setText(personName);

            TextView email=(TextView)findViewById(R.id.email);
            email.setText(personEmail);

            Glide.with(this).load(personPhoto).into(profileimage);

        } else {

        }

        customAdapter=new CustomAdapter(getData());

        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(customAdapter);


        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){
                    case R.id.home:

                        Toast.makeText(MainActivity.this, "Home screen", Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.account:

                        Intent intent=new Intent(MainActivity.this,account.class);
                        startActivity(intent);
                        break;

                    case R.id.search_btn:

                        Intent intent1=new Intent(MainActivity.this,Search.class);
                        startActivity(intent1);
                        break;

                    case R.id.my_list:

                        Intent intent2=new Intent(MainActivity.this,Wishlist_Activity_sample.class);
                        startActivity(intent2);
                        break;

                    case R.id.events:
                        Toast.makeText(MainActivity.this, "New events", Toast.LENGTH_SHORT).show();
                        break;

                }

                return false;
            }
        });

    }

      private ArrayList<GetterSetter> getData()

    {
    ArrayList<GetterSetter> gts=new ArrayList<>();


    GetterSetter gs1=new GetterSetter();
    gs1.setImage(R.drawable.im1);
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
         gs1.setImage(R.drawable.im2);
         gs1.setKey_People("Chairman 2");
         gs1.setName("Saanthvana Seva");
         gs1.setType("OLD-AGE HOME\n" +
                 "NURSING CARE");
         gs1.setAddress("#509 Samarpan. E A road. Ideal homes society Near Gopalan arcade mall, RR Nagar");
         gts.add(gs1);

        gs1=new GetterSetter();
        gs1.setImage(R.drawable.im3);
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
        gs1.setImage(R.drawable.im4);
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
        gs1.setImage(R.drawable.im5);
        gs1.setKey_People("Chairman 5");
        gs1.setName("Vathsalya Charitable Trust");
        gs1.setType("Nutrition\n"+ "Education\n"+"Child Labour\n"+"Girl Empowerment");
        gs1.setAddress("717, 5th Cross Rd, HRBR Layout 1st Block, HRBR Layout, Kalyan Nagar");
        gts.add(gs1);

        gs1=new GetterSetter();
        gs1.setImage(R.drawable.reaching);
        gs1.setKey_People("Chairman 6");
        gs1.setName("Jeevana Jyothi Charitable Trust");
        gs1.setType(" A home for the homeless\n" +
                " Food for the hungry\n" +
                " Clothes for the needy\n" +
                " Love for the abandoned & education for the under-provileged");
        gs1.setAddress("No-28/1,10th cross, ashirwad colony, Bank Avenue, Horamavu Banaswadi");
        gts.add(gs1);

        gs1=new GetterSetter();
        gs1.setImage(R.drawable.im7);
        gs1.setKey_People("Chairman 7");
        gs1.setName("New Mighty Grace Charitable Trust");
        gs1.setType("Support to Underprivileged children\n" +
                "Youth Women & Disabled");
        gs1.setAddress("No.35, 244/1, Munivenkatappa Layout, Horamavu Main Rd, Kalkere");
        gts.add(gs1);

        gs1=new GetterSetter();
        gs1.setImage(R.drawable.im8);
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
        gs1.setImage(R.drawable.im9);
        gs1.setKey_People("Chairman 9");
        gs1.setName("CARE SHELTER");
        gs1.setType("Old aged\n" +
                "Disabled people");
        gs1.setAddress("39,19th Main, 38th Cross Rd, 5th Block, Prakruthi Layout");
        gts.add(gs1);

        gs1=new GetterSetter();
        gs1.setImage(R.drawable.im10);
        gs1.setKey_People("Chairman 10");
        gs1.setName("REACHING HAND");
        gs1.setType("Education, Health, and sustainable Livelihood Development");
        gs1.setAddress("1st Floor, 44, Nehru Rd, AravindNagar, Yadava Layout, St Thomas Town, Kacharakanahalli");
        gts.add(gs1);

        return gts;
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();

            finishAffinity();
        }
}
