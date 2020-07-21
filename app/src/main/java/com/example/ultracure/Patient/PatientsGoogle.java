package com.example.ultracure.Patient;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.ultracure.Doctor.DoctorsGoogle;
import com.example.ultracure.Doctor.LoginActivity;
import com.example.ultracure.R;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class PatientsGoogle extends AppCompatActivity {

    ImageView imageViewP;
    TextView textNameP, textEmailP, textIdP;
    Button signoutP;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patients_google);

        /*GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();

        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);*/

        imageViewP=findViewById(R.id.imageViewP);
        textNameP=findViewById(R.id.textNameP);
        textEmailP=findViewById(R.id.textEmailP);
        textIdP=findViewById(R.id.textIdP);
        signoutP=findViewById(R.id.signoutP);

        signoutP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(PatientsGoogle.this, LoginPatient.class));
            }
        });

        GoogleSignInAccount acct = GoogleSignIn.getLastSignedInAccount(this);
        if (acct != null) {
            String personName = acct.getDisplayName();
            String personGivenName = acct.getGivenName();
            String personFamilyName = acct.getFamilyName();
            String personEmail = acct.getEmail();
            String personId = acct.getId();
            Uri patientPhoto = acct.getPhotoUrl();

            textNameP.setText(personName);
            textEmailP.setText(personEmail);
            textIdP.setText(personId);
            Glide.with(this).load(String.valueOf(patientPhoto)).into(imageViewP);
        }
    }

    /*private void signOut() {
        mGoogleSignInClient.signOut()
                .addOnCompleteListener(this, new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        Toast.makeText(PatientsGoogle.this, "Signed Out Successfully", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                });
    }*/
}
