package com.example.bloodline;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class SearchPage extends AppCompatActivity {

    private ListView listView;
    DatabaseReference databaseReference;
    private List<Donor> donorList;
    private CustomAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_page);

        databaseReference = FirebaseDatabase.getInstance().getReference("Receiver");
        donorList = new ArrayList<>();

        customAdapter = new CustomAdapter(SearchPage.this, donorList);

        listView = findViewById(R.id.listviewId);
    }


    protected void onStart(){

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                donorList.clear();
                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren())
                {
                    Donor donor = dataSnapshot1.getValue(Donor.class);
                    donorList.add(donor);
                }

                listView.setAdapter(customAdapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        super.onStart();
    }


}




















