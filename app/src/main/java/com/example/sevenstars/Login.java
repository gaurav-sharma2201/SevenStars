package com.example.sevenstars;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class Login extends AppCompatActivity {

    Button send_otp,login;
    GoogleSignInClient mGoogleSignInClient;
    static final int RC_SIGN_IN = 0;

    private FirebaseAuth mauth;
    EditText number,otp;
    private String verificationID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button button2 = (Button) findViewById(R.id.login1);
        mauth=FirebaseAuth.getInstance();

        number=findViewById(R.id.number);
        otp=findViewById(R.id.otp);
        send_otp=findViewById(R.id.send_otp);
        login=findViewById(R.id.login1);

        send_otp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(number.getText().toString())){
                    Toast.makeText(Login.this, "Please Enter valid phone no", Toast.LENGTH_SHORT).show();
                }
                else {
                    String phone="+91"+number.getText().toString();
                    sendVerificationCode(phone);
                }

            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(otp.getText().toString())){
                    Toast.makeText(Login.this, "Please enter OTP", Toast.LENGTH_SHORT).show();
                }
                else {
                    verifyCode(otp.getText().toString());

                }

            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Login.this,MainActivity.class);
                startActivity(intent);
            }
        });
        SignInButton signInButton = findViewById(R.id.google);
        Button New_Google=findViewById(R.id.google1);
        signInButton.setSize(SignInButton.SIZE_STANDARD);

        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();

        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);

        New_Google.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.google1:

                        signin();

                        break;
                }
            }
        });

    }

    private void sendVerificationCode(String phone) {
        PhoneAuthOptions authOptions=PhoneAuthOptions.newBuilder().setPhoneNumber(phone).setTimeout(60L, TimeUnit.SECONDS).setActivity(this).setCallbacks(mCallBack).build();
        PhoneAuthProvider.verifyPhoneNumber(authOptions);

    }
    private PhoneAuthProvider.OnVerificationStateChangedCallbacks

            mCallBack=new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

        @Override
        public void onCodeSent(String s,PhoneAuthProvider.ForceResendingToken forceResendingToken){

            super.onCodeSent(s,forceResendingToken);
            verificationID=s;

        }

        @Override
        public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {
            final String code=phoneAuthCredential.getSmsCode();

            if (code!=null){

                Toast.makeText(Login.this, "Code is " +code, Toast.LENGTH_SHORT).show();


                verifyCode(code);
                otp.setText(code);
            }

        }

        @Override
        public void onVerificationFailed(@NonNull FirebaseException e) {
            Toast.makeText(Login.this, e.getMessage(), Toast.LENGTH_SHORT).show();

        }
    };

    private void verifyCode(String code) {
        PhoneAuthCredential phoneAuthCredential=PhoneAuthProvider.getCredential(verificationID, code);

        signInWithCredential(phoneAuthCredential);
    }

    private void signInWithCredential(PhoneAuthCredential phoneAuthCredential) {
        mauth.signInWithCredential(phoneAuthCredential).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if (task.isSuccessful()){
                    Intent intent=new Intent(Login.this,MainActivity.class);
                    startActivity(intent);
                    finish();
                }
                else {
                    Toast.makeText(Login.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void signin() {
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, RC_SIGN_IN);

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


        if (requestCode == RC_SIGN_IN) {
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            handleSignInResult(task);
        }
    }

    private void handleSignInResult(Task<GoogleSignInAccount> completedTask) {
        try {
            GoogleSignInAccount account = completedTask.getResult(ApiException.class);

            Toast.makeText(Login.this, "Sign in successful", Toast.LENGTH_SHORT).show();
            Intent intent=new Intent(getApplicationContext(),MainActivity.class);
            startActivity(intent);

        } catch (ApiException e) {

            Log.w("Error", "signInResult:failed code=" + e.getStatusCode());

        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finishAffinity();
    }

    @Override
    protected void onStart() {
        super.onStart();

        GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(this);
        if (account!=null){
            Toast.makeText(Login.this, "User already Signed-in", Toast.LENGTH_SHORT).show();
            Intent intent=new Intent(getApplicationContext(),MainActivity.class);
            startActivity(intent);
        }
    }
}


