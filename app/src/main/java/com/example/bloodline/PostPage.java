package com.example.bloodline;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class PostPage extends AppCompatActivity {

    EditText bloodgrp, location, phone_num;
    Button postButton;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_page);

        databaseReference = FirebaseDatabase.getInstance().getReference("Receiver");

        bloodgrp = findViewById(R.id.editText1);
        location = findViewById(R.id.editText2);
        phone_num = findViewById(R.id.editText3);
        postButton = findViewById(R.id.postButton);

        postButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                savePost();
            }
        });

    }

    public void savePost()
    {
        String bloodGroup = bloodgrp.getText().toString().trim();
        String Location = location.getText().toString().trim();
        String Phone_Number = phone_num.getText().toString().trim();

        String key = databaseReference.push().getKey();

        Donor donor = new Donor(bloodGroup, Location, Phone_Number);

        databaseReference.child(key).setValue(donor);
        Toast.makeText(getApplicationContext(),"Post added successfully", Toast.LENGTH_SHORT).show();

        bloodgrp.setText("");
        location.setText("");
        phone_num.setText("");



    }
}
