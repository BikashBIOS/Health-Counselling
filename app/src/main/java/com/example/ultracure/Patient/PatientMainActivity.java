package com.example.ultracure.Patient;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.ultracure.Doctor.DoctorsProfile;
import com.example.ultracure.R;
import com.example.ultracure.VideoChat;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class PatientMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.patientmenu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        /*if (item.getItemId()==R.id.patientProfile){
            startActivity(new Intent(PatientMainActivity.this, PatientsGoogle.class));
        }*/
        if (item.getItemId()==R.id.listDoctors){
            startActivity(new Intent(PatientMainActivity.this, DoctorsProfile.class));
        }
        return true;
    }
}
