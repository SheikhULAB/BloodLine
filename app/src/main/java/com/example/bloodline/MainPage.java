package com.example.bloodline;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

public class MainPage extends AppCompatActivity implements View.OnClickListener {

    CardView searchId;
    CardView Postid;
    CardView Ambulanceid;
    CardView Bloodbankid;
    CardView Organizationid;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);

        searchId = findViewById(R.id.searchId);
        Postid = findViewById(R.id.postId);
        Ambulanceid = findViewById(R.id.ambulance);
        Bloodbankid = findViewById(R.id.bloodbankid);
        Organizationid = findViewById(R.id.organizationid);

        searchId.setOnClickListener(this);
        Postid.setOnClickListener(this);
        Ambulanceid.setOnClickListener(this);
        Bloodbankid.setOnClickListener(this);
        Organizationid.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if (v==searchId)
        {
            Intent intent = new Intent(MainPage.this, SearchPage.class);
            startActivity(intent);
        }

        if (v==Postid)
        {
            Intent intent = new Intent(MainPage.this, PostPage.class);
            startActivity(intent);
        }

        if (v==Ambulanceid)
        {
            Intent intent = new Intent(MainPage.this, ambulancepage.class);
            startActivity(intent);
        }

        if (v==Bloodbankid)
        {
            Intent intent = new Intent(MainPage.this, bloodbank.class);
            startActivity(intent);
        }

        if (v==Organizationid)
        {
            Intent intent = new Intent(MainPage.this, organization.class);
            startActivity(intent);
        }

    }
}































