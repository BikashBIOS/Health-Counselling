package com.example.ultracure.Patient;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

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
import com.example.ultracure.Doctor.Doctor;
import com.example.ultracure.Doctor.DoctorAdapter;
import com.example.ultracure.Doctor.DoctorDetails;
import com.example.ultracure.Doctor.DoctorEdit;
import com.example.ultracure.Doctor.DoctorMainActivity;
import com.example.ultracure.Doctor.DoctorsProfile;
import com.example.ultracure.R;
import com.example.ultracure.VideoChat;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PatientsProfile extends AppCompatActivity {

    ListView plistView;
    PatientAdapter patientAdapter;
    Patient patient;
    public static ArrayList<Patient> patientArrayList=new ArrayList<>();
    String url="https://bikashmysql.000webhostapp.com/retrievePatient.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patients_profile);

        plistView=findViewById(R.id.plistview);
        patientAdapter=new PatientAdapter(this, patientArrayList);
        plistView.setAdapter(patientAdapter);

        plistView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, final int position, long id) {
                AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                ProgressDialog progressDialog = new ProgressDialog(view.getContext());

                CharSequence[] dialogItem = {"View Data","Video Call"/*,"Edit Data","Delete Data"*/};
                builder.setTitle(patientArrayList.get(position).getPname());
                builder.setItems(dialogItem, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {

                        switch (i){
                            case 0:
                                startActivity(new Intent(getApplicationContext(),PatientDetails.class)
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
                                deleteData(patientArrayList.get(position).getPid());
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
        getMenuInflater().inflate(R.menu.patientmenu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        /*if (item.getItemId()==R.id.doctorProfile){
            startActivity(new Intent(DoctorMainActivity.this, DoctorsGoogle.class));
        }*/
        if (item.getItemId()==R.id.listDoctors){
            startActivity(new Intent(PatientsProfile.this, DoctorsProfile.class));
        }
        return true;
    }

    public void deleteData(final String id){
        StringRequest request = new StringRequest(Request.Method.POST, "https://bikashmysql.000webhostapp.com/deletePatient.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        if(response.equalsIgnoreCase("Data Deleted")){
                            Toast.makeText(PatientsProfile.this, "Data Deleted Successfully", Toast.LENGTH_SHORT).show();
                        }
                        else{
                            Toast.makeText(PatientsProfile.this, "Data Not Deleted", Toast.LENGTH_SHORT).show();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(PatientsProfile.this, error.getMessage(), Toast.LENGTH_SHORT).show();
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

                        patientArrayList.clear();
                        try{

                            JSONObject jsonObject = new JSONObject(response);
                            String success = jsonObject.getString("successs");
                            JSONArray jsonArray = jsonObject.getJSONArray("PatientsTable");

                            if(success.equals("2")){

                                for(int i=0;i<jsonArray.length();i++){

                                    JSONObject object = jsonArray.getJSONObject(i);

                                    String pid = object.getString("regid");
                                    String pname = object.getString("name");
                                    String pemail = object.getString("email");
                                    String page = object.getString("age");
                                    String pgender = object.getString("gender");
                                    String paddress = object.getString("address");
                                    String ptown = object.getString("town");
                                    String pdistrict = object.getString("district");
                                    String ppincode = object.getString("pincode");
                                    String pphone = object.getString("phone");

                                    patient = new Patient(pid,pname, pemail,page, pgender, paddress,ptown,pdistrict,ppincode,pphone);
                                    patientArrayList.add(patient);
                                    patientAdapter.notifyDataSetChanged();

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
                Toast.makeText(PatientsProfile.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(request);

    }
}
