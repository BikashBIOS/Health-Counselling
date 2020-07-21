package com.example.ultracure.Doctor;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.ultracure.Patient.Patient;
import com.example.ultracure.Patient.PatientAdapter;
import com.example.ultracure.Patient.PatientsProfile;
import com.example.ultracure.R;
import com.example.ultracure.VideoChat;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class DoctorMainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getActionBar().setTitle("DASHBOARD");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.doctor_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        /*if (item.getItemId()==R.id.doctorProfile){
            startActivity(new Intent(DoctorMainActivity.this, DoctorsGoogle.class));
        }*/
        if (item.getItemId()==R.id.listPatients){
            startActivity(new Intent(DoctorMainActivity.this, PatientsProfile.class));
        }
        return true;
    }
}
