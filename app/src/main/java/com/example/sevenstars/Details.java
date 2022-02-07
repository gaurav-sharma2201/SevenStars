package com.example.sevenstars;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.razorpay.Checkout;
import com.razorpay.PaymentResultListener;

import org.json.JSONException;
import org.json.JSONObject;

public class Details extends AppCompatActivity implements PaymentResultListener {
    TextView Name, Key_people_names, Volunteers_names, Address;
    EditText INR1,donor;
    private static final String TAG = MainActivity.class.getSimpleName();
    private FirebaseFirestore db;
    String trust_name,Rupees;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        Checkout.preload(getApplicationContext());

        db=FirebaseFirestore.getInstance();


        Name = findViewById(R.id.Name);
        Key_people_names = findViewById(R.id.key_people_names);
        Volunteers_names = findViewById(R.id.volunteers_names);
        Address = findViewById(R.id.address_in_details);
        INR1= findViewById(R.id.INR001);
        donor=findViewById(R.id.donor);


        Button donate=(Button)findViewById(R.id.donate);

        Intent intent = getIntent();
        String name = intent.getStringExtra("Name");
        String chairman = intent.getStringExtra("Chairman");
        String address = intent.getStringExtra("Address");
        Name.setText(name);
        Key_people_names.setText(chairman);
        Address.setText(address);

        //For storing data in FireStore
        trust_name = name.toString();
        Rupees=INR1.getText().toString();
        //


        donate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String amount=INR1.getText().toString();
                String name=donor.getText().toString();
                String gray="#808080";
                int grayInt= Color.parseColor(gray);
                String white="#ffffff";
                int whiteInt=Color.parseColor(white);
                String green="#05E177";
                int greenInt=Color.parseColor(green);

                if (TextUtils.isEmpty(amount) || TextUtils.isEmpty(name)){

                    donate.setTextColor(whiteInt);
                    donate.setBackgroundColor(grayInt);
                    Toast.makeText(Details.this, "Please fill Name and Amount", Toast.LENGTH_SHORT).show();
                }else {
                    donate.setBackgroundColor(greenInt);
                    donate.setTextColor(whiteInt);
                    JMD("100");
                    Toast.makeText(getApplicationContext(), "Check name "+trust_name, Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    private void JMD(String amount) {

        final Activity activity = Details.this;

        Checkout checkout = new Checkout();
        checkout.setKeyID("rzp_test_Scbrij4dtAMGk4");
        checkout.setImage(R.drawable.pay_logo);
        String pay = INR1.getText().toString();
        int donation = Integer.parseInt(pay);
        int donation1 = donation * 100;
        String trust = Name.getText().toString();

        try {
            JSONObject options = new JSONObject();
            options.put("image", R.drawable.pay_logo);
            options.put("name", trust);
            options.put("description", "Reference no M9");
            options.put("currency", "INR");
            options.put("amount", donation1);

            checkout.open(activity, options);

        } catch (JSONException e) {
            Log.e(TAG, "Error in starting RazorPay");
        }

    }

    @Override
    public void onPaymentSuccess(String s) {
        Rupees=INR1.getText().toString();
        addDataToFirestore(trust_name,Rupees);

        Toast.makeText(Details.this, "Payment Successful", Toast.LENGTH_SHORT).show();
    }

    private void addDataToFirestore(String trust_name, String Rupees) {
        CollectionReference dbDonate= db.collection("Seven");
        Donate donate=new Donate(trust_name,Rupees);
        dbDonate.add(donate).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
            @Override
            public void onSuccess(DocumentReference documentReference) {
                Toast.makeText(Details.this, "Data Stored", Toast.LENGTH_LONG).show();

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(Details.this, "Data failed to store", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onPaymentError(int i, String s) {
        Toast.makeText(Details.this, "Payment Failed, try again", Toast.LENGTH_SHORT).show();

    }
}