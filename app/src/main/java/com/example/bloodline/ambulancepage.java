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

public class ambulancepage extends AppCompatActivity {

    ListView listView;
    String mTitle[] = {"Salman Ambulance Service", "Pabna Popular", "Amir", "Zia","Syslhet Ambulance Service", "Ashraful Alam Akul", "SUST Ambulance service", "Dr.md. EnamulHaque", "RaiHan","Al amin Ambulance"};
    String mDescription[] = {"H-4,road-4,Dhanmondi, Dhaka",
    "Pabna popular hospital, Pabna",
     "Konabari trishal, Mymensingh",
    "uttara,Dhaka 01671059513",
     "Medical college road, Sylhet",
    "Kulaura, Moulivibazar, 01716159228",
    "SUST,Sylhet , 01911506698",
    "Kolabagan road birampur, Dinajpur",
    "Akhaura, Brahmanbaria",
    "Damrai,Savar,Nawabgonj, Dhaka"};

    int images[] = {R.drawable.ambulance,R.drawable.ambulance,R.drawable.ambulance,R.drawable.ambulance,R.drawable.ambulance,
            R.drawable.ambulance,R.drawable.ambulance,R.drawable.ambulance,R.drawable.ambulance,R.drawable.ambulance};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ambulancepage);

        listView = findViewById(R.id.ambulancelist);


        MyAdapter adapter = new MyAdapter(this, mTitle, mDescription, images);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position ==  0) {
                    Toast.makeText(ambulancepage.this, "Ambulance Called", Toast.LENGTH_SHORT).show();
                }
                if (position ==  0) {
                    Toast.makeText(ambulancepage.this, "Ambulance Called", Toast.LENGTH_SHORT).show();
                }
                if (position ==  0) {
                    Toast.makeText(ambulancepage.this, "Ambulance Called", Toast.LENGTH_SHORT).show();
                }
                if (position ==  0) {
                    Toast.makeText(ambulancepage.this, "Ambulance Called", Toast.LENGTH_SHORT).show();
                }
                if (position ==  0) {
                    Toast.makeText(ambulancepage.this, "Ambulance Called", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    class MyAdapter extends ArrayAdapter<String>{

        Context context;
        String rTitle[];
        String rDescription[];
        int rImage[];

        MyAdapter(Context c, String Title[], String Description[], int Img[]) {
            super(c, R.layout.ambulancerow, R.id.textview1, Title);
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

            View row = getLayoutInflater().inflate(R.layout.ambulancerow, parent, false);
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












