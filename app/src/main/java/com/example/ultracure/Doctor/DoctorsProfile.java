package com.example.ultracure.Doctor;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.ultracure.Patient.PatientMainActivity;
import com.example.ultracure.Patient.PatientsProfile;
import com.example.ultracure.R;
import com.example.ultracure.VideoChat;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class DoctorsProfile extends AppCompatActivity {

    ListView listView;
    DoctorAdapter doctorAdapter;
    Doctor doctor;
    public static ArrayList<Doctor> doctorArrayList=new ArrayList<>();
    String url="https://bikashmysql.000webhostapp.com/retrieveDoctor.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctors_profile);

        listView=findViewById(R.id.listview);
        doctorAdapter=new DoctorAdapter(this, doctorArrayList);
        listView.setAdapter(doctorAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, final int position, long id) {
                AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                ProgressDialog progressDialog = new ProgressDialog(view.getContext());

                CharSequence[] dialogItem = {"View Data","Video Call"/*,"Edit Data","Delete Data"*/};
                builder.setTitle(doctorArrayList.get(position).getName());
                builder.setItems(dialogItem, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {

                        switch (i){
                            case 0:
                                startActivity(new Intent(getApplicationContext(),DoctorDetails.class)
                                        .putExtra("position",position));
                                break;
                            case 1:
                                startActivity(new Intent(getApplicationContext(), VideoChat.class));
                                break;
                            /*case 1:
                                startActivity(new Intent(getApplicationContext(),DoctorEdit.class)
                                        .putExtra("position",position));
                                break;
                            case 2:
                                deleteData(doctorArrayList.get(position).getRegid());
                                break;*/
                        }
                    }
                });
                builder.create().show();
            }
        });
        retrieveData();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.doctor_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        /*if (item.getItemId()==R.id.patientProfile){
            startActivity(new Intent(PatientMainActivity.this, PatientsGoogle.class));
        }*/
        if (item.getItemId()==R.id.listPatients){
            startActivity(new Intent(DoctorsProfile.this, PatientsProfile.class));
        }
        return true;
    }

    public void deleteData(final String id){
        StringRequest request = new StringRequest(Request.Method.POST, "https://bikashmysql.000webhostapp.com/deleteDoctor.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        if(response.equalsIgnoreCase("Data Deleted")){
                            Toast.makeText(DoctorsProfile.this, "Data Deleted Successfully", Toast.LENGTH_SHORT).show();
                        }
                        else{
                            Toast.makeText(DoctorsProfile.this, "Data Not Deleted", Toast.LENGTH_SHORT).show();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(DoctorsProfile.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                Map<String,String> params = new HashMap<String,String>();
                params.put("regid", id);
                return params;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(request);

    }

    public void retrieveData(){

        StringRequest request = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        doctorArrayList.clear();
                        try{

                            JSONObject jsonObject = new JSONObject(response);
                            String success = jsonObject.getString("success");
                            JSONArray jsonArray = jsonObject.getJSONArray("DoctorsTable");

                            if(success.equals("1")){

                                for(int i=0;i<jsonArray.length();i++){

                                    JSONObject object = jsonArray.getJSONObject(i);

                                    String regid = object.getString("regid");
                                    String name = object.getString("name");
                                    String speciality = object.getString("speciality");
                                    String qualification = object.getString("qualification");
                                    String designation = object.getString("designation");
                                    String institution = object.getString("institution");
                                    String email = object.getString("email");
                                    String mobile = object.getString("mobile");
                                    String account = object.getString("account");
                                    String hours = object.getString("hours");

                                    doctor = new Doctor(regid,name,speciality,qualification,designation,institution, email,mobile,account,hours);
                                    doctorArrayList.add(doctor);
                                    doctorAdapter.notifyDataSetChanged();

                                }
                            }
                        }
                        catch (JSONException e){
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(DoctorsProfile.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(request);

    }
}
