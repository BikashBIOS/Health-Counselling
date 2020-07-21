package com.example.ultracure;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.ultracure.Doctor.DoctorMainActivity;
import com.example.ultracure.Doctor.LoginActivity;
import com.example.ultracure.Doctor.RegistrationActivity;
import com.example.ultracure.Patient.LoginPatient;
import com.example.ultracure.Patient.RegistrationPatient;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Locale;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class ChoiceActivity extends AppCompatActivity {

    Button patient, doctor;
    TextView change_language;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choice);

        patient=findViewById(R.id.patientbtn);
        doctor=findViewById(R.id.doctorbtn);
        change_language=findViewById(R.id.txt_languageChange);
        mAuth=FirebaseAuth.getInstance();

        patient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(ChoiceActivity.this, LoginPatient.class);
                startActivity(intent);
            }
        });

        doctor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent dintent=new Intent(ChoiceActivity.this, LoginActivity.class);
                startActivity(dintent);
            }
        });

        change_language.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showLanguageDialog();
            }
        });
    }


    private void showLanguageDialog() {

        // final String[] laguage_item ={"english","ଓଡିଆ","তারা ছিল না"};

        final String [] laguage_item={"English","ଓଡିଆ"};
        AlertDialog.Builder builder=new AlertDialog.Builder(ChoiceActivity.this);
        builder.setTitle("Choose language");
        builder.setSingleChoiceItems(laguage_item, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                if (which==0)
                {
                    setLocal("en");
                    recreate();
                }
                else if (which==1)
                {
                    setLocal("or");
                    recreate();
                }
                dialog.dismiss();
            }
        });

        AlertDialog alertDialog=builder.create();
        alertDialog.show();
    }

    private void setLocal(String lan) {
        Locale locale=new Locale(lan);
        Locale.setDefault(locale);
        Configuration configuration= new Configuration();
        configuration.locale=locale;
        getBaseContext().getResources().updateConfiguration(configuration,getBaseContext().getResources().getDisplayMetrics());

        SharedPreferences.Editor editor=getSharedPreferences("Setting",MODE_PRIVATE).edit();
        editor.putString("My_lang",lan);
        editor.apply();
    }

    private void loadLocal()
    {
//        SharedPreferences preferences= getPreferences(MODE_PRIVATE);
//        String language=preferences.getString("My_lang","");
//        setLocal(language);

        String data=getApplicationContext().getSharedPreferences("Setting",MODE_PRIVATE).getString("My_lang","none");
        setLocal(data);
    }

}
