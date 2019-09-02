package com.example.bloodline;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class bloodbank extends AppCompatActivity {


    ListView listView;
    String mTitle[] = {"Bangladesh Red Cresent Blood Bank",
            "Bangladesh Blood Bank and Transfusiion Center",
            "Thalassemia Blood Bank",
            "Mukti Blood Bank",
            "Badhan",
            "Quantum Lab",
            "Red Cresent Bhaban",
            "Bloodinfobd.com",
            "Islami Bank Hospital Mirpur"};

    String mDescription[] = {"Address: Aurangajeb rd, Dhaka",
            "Address: 12, 22 Babar rd, Dhaka",
            "Address: 30 Chamelibag 1st lane, Dhaka",
            "Address: Bir-uttam a.m shafiullah road, Dhaka1205",
            "Address: R C Mojumder Auditorium, TSC, Dhaka 1000",
            "Address: Shantinogar, Dhaka 1217",
            "Address: Motijheel Rd, Dhaka 1000",
            "Address: Shahjadpur bus stand ,Dhaka",
            "Address: Begum Rokeya Avenue, Dhaka 1216",
            };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bloodbank);



        listView = findViewById(R.id.bloodbanklist);


        MyAdapter adapter = new MyAdapter(this, mTitle, mDescription);
        listView.setAdapter(adapter);


    }

    class MyAdapter extends ArrayAdapter<String> {

        Context context;
        String rTitle[];
        String rDescription[];

        MyAdapter(Context c, String Title[], String Description[]) {
            super(c, R.layout.bloodbankrow, R.id.textview1, Title);
            this.context = c;
            this.rTitle = Title;
            this.rDescription = Description;



        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView,
                            @NonNull ViewGroup parent) {
            LayoutInflater inflater = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            View row = getLayoutInflater().inflate(R.layout.bloodbankrow, parent, false);

            TextView myTitle = row.findViewById(R.id.textview1);
            TextView myDescription = row.findViewById(R.id.textview2);

            myTitle.setText(rTitle[position]);
            myDescription.setText(rDescription[position]);



            return row;

        }
    }
}



