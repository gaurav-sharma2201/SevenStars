package com.example.sevenstars;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import com.razorpay.Checkout;
import com.razorpay.PaymentResultListener;

import org.json.JSONException;
import org.json.JSONObject;

public class Details extends AppCompatActivity implements PaymentResultListener {
    TextView Name,t6;
    Button donate;
    EditText INR;
    private static final String TAG=MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP){
            getWindow().setNavigationBarColor(getResources().getColor(R.color.black));
        }

//        Name=findViewById(R.id.Name);
//        t6=findViewById(R.id.type);
//        INR=findViewById(R.id.INR);
        donate=findViewById(R.id.donate);


        Checkout.preload(getApplicationContext());


//
//        Intent intent=getIntent();
//        String name=intent.getStringExtra("Name");
//        String type=intent.getStringExtra("Type");
//        Name.setText(name);
//        t6.setText(type);





        donate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                JMD("9");
            }
        });

    }

    private void JMD(String amount) {
        final Activity activity=this;

        Checkout checkout=new Checkout();
        checkout.setKeyID("rzp_test_Scbrij4dtAMGk4");
        checkout.setImage(R.drawable.image01);
        String pay=INR.getText().toString();
        int donation=Integer.parseInt(pay);
        int donation1=donation*100;
        String trust=Name.getText().toString();

        try {
            JSONObject options=new JSONObject();
            options.put("image",R.drawable.image01);
            options.put("name",trust);
            options.put("description","Reference no M9");
            options.put("currency","INR");
            options.put("amount",donation1);

            checkout.open(activity,options);

        } catch (JSONException e) {
            Log.e(TAG,"Error in starting RazorPay");
        }

    }

    @Override
    public void onPaymentSuccess(String s) {
        Toast.makeText(Details.this, "Thank you for Donating", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPaymentError(int i, String s) {

        Toast.makeText(Details.this, "Payment failed, try again", Toast.LENGTH_SHORT).show();

    }
}