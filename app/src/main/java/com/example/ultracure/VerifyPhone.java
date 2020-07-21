package com.example.ultracure;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class VerifyPhone extends AppCompatActivity {

    EditText phonenoo;
    Button verifyphone;
    String str_phonenoo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verify_phone);

        verifyphone=findViewById(R.id.verifyphone);
        phonenoo=findViewById(R.id.phonenoo);

        verifyphone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                str_phonenoo=phonenoo.getText().toString();
                Intent intent=new Intent(getApplicationContext(), VerifyOTP.class);
                intent.putExtra("phoneNo", str_phonenoo);
                startActivity(intent);
            }
        });
    }
}
