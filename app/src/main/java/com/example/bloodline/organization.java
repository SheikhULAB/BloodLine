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

public class organization extends AppCompatActivity {


    ListView listView;
    String mTitle[] = {"Swapnotthan", "Badhan,MBSTU UNIT", "UITS InVictus", "Blood Group Chittagong","Sylhet Ambulance service", "MD>SAMIUL HAQUE", "Hello Bangladesh social",
            "Save our women", "Blood donation cumilla","KIN"};
    String mDescription[] = {"Location: SUST,Sylhet",
            "Location: Mawlana Bhashani science and technology university, Tangail",
            "Location: Baridhara, varara, Dhaka",
            "Location: Halishahar,Chittagong",
            "Medical college road, sylhet",
            "Location: Newtown jessore, Jessore",
            "Location: Chandpur, Chandpur",
            "Location: Nikunjo-2, Khilkhet,Dhaka",
            "Location: whole city, Comilla",
            "Location: SUST, Sylhet"};

    int images[] = {R.drawable.organization,R.drawable.organization,R.drawable.organization,R.drawable.organization,R.drawable.organization,
            R.drawable.organization,R.drawable.organization,R.drawable.organization,R.drawable.organization,R.drawable.organization};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_organization);

        listView = findViewById(R.id.organizationlist);


        MyAdapter adapter = new MyAdapter(this, mTitle, mDescription, images);
        listView.setAdapter(adapter);


    }

    class MyAdapter extends ArrayAdapter<String> {

        Context context;
        String rTitle[];
        String rDescription[];
        int rImage[];

        MyAdapter(Context c, String Title[], String Description[], int Img[]) {
            super(c, R.layout.organizationrow, R.id.textview1, Title);
            this.context = c;
            this.rTitle = Title;
            this.rDescription = Description;
            this.rImage = Img;


        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView,
                            @NonNull ViewGroup parent) {
            LayoutInflater inflater = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            View row = getLayoutInflater().inflate(R.layout.organizationrow, parent, false);
            ImageView image = row.findViewById(R.id.image);
            TextView myTitle = row.findViewById(R.id.textview1);
            TextView myDescription = row.findViewById(R.id.textview2);

            image.setImageResource(rImage[position]);
            myTitle.setText(rTitle[position]);
            myDescription.setText(rDescription[position]);



            return row;

        }
    }
}
