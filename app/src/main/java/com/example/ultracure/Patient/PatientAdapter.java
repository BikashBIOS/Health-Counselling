package com.example.ultracure.Patient;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.example.ultracure.R;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class PatientAdapter extends ArrayAdapter<Patient> {
    Context context;
    List<Patient> arrayListPatient;

    public PatientAdapter(@NonNull Context context, List<Patient> arrayListPatient) {

        super(context, R.layout.custom_list_item, arrayListPatient);

        this.context=context;
        this.arrayListPatient=arrayListPatient;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_list_item, null, true);

        TextView ptvId=view.findViewById(R.id.txt_id);
        TextView ptvName=view.findViewById(R.id.txt_name);

        ptvId.setText(arrayListPatient.get(position).getPid());
        ptvName.setText(arrayListPatient.get(position).getPname());

        return view;
    }
}
