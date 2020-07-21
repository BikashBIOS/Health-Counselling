package com.example.ultracure.Doctor;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.ultracure.R;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;

import androidx.appcompat.app.AppCompatActivity;

public class DoctorDetails extends AppCompatActivity {
    TextView tvId, tvName, tvSpeciality, tvQualification, tvDesignation, tvInstitution, tvEmail, tvAccount, tvMobile, tvHours;
    int position;
    GoogleSignInClient mGoogleSignInClient;
    ImageView imagedoctor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_details);

        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();

        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);

        tvId=findViewById(R.id.txtregid);
        tvName=findViewById(R.id.txtname);
        tvSpeciality=findViewById(R.id.txtspeciality);
        tvQualification=findViewById(R.id.txtqualification);
        tvDesignation=findViewById(R.id.txtdesignation);
        tvInstitution=findViewById(R.id.txtinstitution);
        tvEmail=findViewById(R.id.txtemail);
        tvAccount=findViewById(R.id.txtaccount);
        tvMobile=findViewById(R.id.txtmobile);
        tvHours=findViewById(R.id.txthours);
        /*imagedoctor=findViewById(R.id.imagegoogledoctor);*/

        Intent intent =getIntent();
        position = intent.getExtras().getInt("position");

        /*GoogleSignInAccount acct = GoogleSignIn.getLastSignedInAccount(this);
        if (acct != null) {
            Uri doctorPhoto = acct.getPhotoUrl();
            Glide.with(this).load(String.valueOf(doctorPhoto)).into(imagedoctor);
        }*/


        tvId.setText("Regd.Id: "+DoctorsProfile.doctorArrayList.get(position).getRegid());
        tvName.setText("Name: "+DoctorsProfile.doctorArrayList.get(position).getName());
        tvSpeciality.setText("Speciality: "+DoctorsProfile.doctorArrayList.get(position).getSpeciality());
        tvQualification.setText("Qualification: "+DoctorsProfile.doctorArrayList.get(position).getQualification());
        tvDesignation.setText("Designation: "+DoctorsProfile.doctorArrayList.get(position).getDesignation());
        tvInstitution.setText("Institution: "+DoctorsProfile.doctorArrayList.get(position).getInstitution());
        tvEmail.setText("Email: "+DoctorsProfile.doctorArrayList.get(position).getEmail());
        tvMobile.setText("Mobile No: "+DoctorsProfile.doctorArrayList.get(position).getMobile());
        tvAccount.setText("Account No: "+DoctorsProfile.doctorArrayList.get(position).getAccount());
        tvHours.setText("Preferred Hours: "+DoctorsProfile.doctorArrayList.get(position).getHours());

    }
}
