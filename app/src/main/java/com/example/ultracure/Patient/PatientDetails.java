package com.example.ultracure.Patient;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.ultracure.Doctor.DoctorsProfile;
import com.example.ultracure.R;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;

public class PatientDetails extends AppCompatActivity {

    TextView pId, pName, pEmail, pGender, pAge, pAddress, pTown, pDistrict, pPhone, pPincode;
    int position;
    GoogleSignInClient mGoogleSignInClient;
    ImageView imagepatient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_details);

        pId=findViewById(R.id.txtregidp);
        pName=findViewById(R.id.txtnamep);
        pAge=findViewById(R.id.txtagep);
        pGender=findViewById(R.id.txtgenderp);
        pAddress=findViewById(R.id.txtaddressp);
        pTown=findViewById(R.id.txttownp);
        pDistrict=findViewById(R.id.txtdistrictp);
        pPincode=findViewById(R.id.txtpincodep);
        pEmail=findViewById(R.id.txtemailp);
        pPhone=findViewById(R.id.txtphonep);


        Intent intent =getIntent();
        position = intent.getExtras().getInt("position");

        /*GoogleSignInAccount acct = GoogleSignIn.getLastSignedInAccount(this);
        if (acct != null) {
            Uri patientPhoto = acct.getPhotoUrl();
            Glide.with(this).load(String.valueOf(patientPhoto)).into(imagepatient);
        }*/


        pId.setText("Regd.Id: "+ PatientsProfile.patientArrayList.get(position).getPid());
        pName.setText("Name: "+PatientsProfile.patientArrayList.get(position).getPname());
        pEmail.setText("Email: "+PatientsProfile.patientArrayList.get(position).getPemail());
        pAge.setText("Age: "+PatientsProfile.patientArrayList.get(position).getPage());
        pGender.setText("Gender: "+PatientsProfile.patientArrayList.get(position).getPgender());
        pAddress.setText("Address: "+PatientsProfile.patientArrayList.get(position).getPaddress());
        pTown.setText("Town: "+PatientsProfile.patientArrayList.get(position).getPtown());
        pDistrict.setText("District: "+PatientsProfile.patientArrayList.get(position).getPdistrict());
        pPincode.setText("Pincode: "+PatientsProfile.patientArrayList.get(position).getPpincode());
        pPhone.setText("Phone No: "+PatientsProfile.patientArrayList.get(position).getPphone());
    }
}
