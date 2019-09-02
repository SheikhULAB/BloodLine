package com.example.bloodline;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class CustomAdapter extends ArrayAdapter<Donor> {

    private Activity context;
    private List<Donor> donorList;

    public CustomAdapter(Context context, List<Donor> donorList) {
        super(context, R.layout.searchlayout, donorList);
        this.context = (Activity) context;
        this.donorList = donorList;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater layoutInflater = context.getLayoutInflater();
        View view = layoutInflater.inflate(R.layout.searchlayout,null,true);
        Donor donor = donorList.get(position);

        TextView t1 = view.findViewById(R.id.bgid);
        TextView t2 = view.findViewById(R.id.lid);
        TextView t3 = view.findViewById(R.id.phid);

        t1.setText("Blood Group : "+donor.getBloodgroup());
        t2.setText("Location : "+donor.getLocation());
        t2.setText("Phone Number : "+donor.getPhonenumber());


        return view;
    }
}
