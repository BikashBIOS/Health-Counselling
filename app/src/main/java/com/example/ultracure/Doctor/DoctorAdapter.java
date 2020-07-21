package com.example.ultracure.Doctor;

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

public class DoctorAdapter extends ArrayAdapter<Doctor> {

    Context context;
    List<Doctor> arrayListDoctor;
    public DoctorAdapter(@NonNull Context context, List<Doctor> arrayListDoctor) {

        super(context, R.layout.custom_list_item, arrayListDoctor);

        this.context=context;
        this.arrayListDoctor=arrayListDoctor;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_list_item, null, true);

        TextView tvId=view.findViewById(R.id.txt_id);
        TextView tvName=view.findViewById(R.id.txt_name);

        tvId.setText(arrayListDoctor.get(position).getRegid());
        tvName.setText(arrayListDoctor.get(position).getName());

        return view;
    }
}
