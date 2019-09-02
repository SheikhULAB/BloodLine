package com.example.bloodline;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;

public class SignupForm extends AppCompatActivity implements View.OnClickListener {

    TextView textView;
    EditText FullName, District, Area, Email, Password;
    Button Register;
    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_form);
        getSupportActionBar().setTitle("Signup Form");

        mAuth = FirebaseAuth.getInstance();

        textView = findViewById(R.id.signupskip);
        FullName = findViewById(R.id.fullnameid);
        District = findViewById(R.id.districtid);
        Area = findViewById(R.id.areaid);
        Email = findViewById(R.id.emailid);
        Password = findViewById(R.id.passwordid);
        Register = findViewById(R.id.registerFirebase);

        Register.setOnClickListener(this);
        textView.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {


         if (v.getId()==R.id.signupskip)
         {
             Intent intent = new Intent(SignupForm.this, MainPage.class);
             startActivity(intent);
         }
              if (v.getId()==R.id.registerFirebase)
              {
                  userRegister();
              }
    }




    private void userRegister() {

        String email = Email.getText().toString().trim();

        String password = Password.getText().toString().trim();

        if (email.isEmpty())
        {
            Email.setError("Enter an Email address");
            Email.requestFocus();
            return;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches())
        {
            Email.setError("Enter a Valid Email address");
            Email.requestFocus();
            return;
        }

        if (password.isEmpty())
        {
            Password.setError("Enter a password");
            Password.requestFocus();
            return;
        }

        if (password.length()<6)
        {
            Password.setError("Maximum length of password is 6");
            Password.requestFocus();
            return;
        }


        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    Toast.makeText(getApplicationContext(), "Registered Successfull", Toast.LENGTH_SHORT).show();

                } else {
                    if (task.getException() instanceof FirebaseAuthUserCollisionException){
                        Toast.makeText(getApplicationContext(), "User is already Registerd", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(getApplicationContext(), "Error : "+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });



    }
}





























