package com.example.bloodline;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginForm extends AppCompatActivity implements View.OnClickListener {

    Button buttonRegister;
    Button loginButton;
    EditText EmailV, PasswordV;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_form);
        getSupportActionBar().setTitle("Login Form");

        mAuth = FirebaseAuth.getInstance();


        buttonRegister = findViewById(R.id.registerId);
        loginButton = findViewById(R.id.loginId);
        EmailV = findViewById(R.id.emailid);
        PasswordV = findViewById(R.id.passwordid);


        buttonRegister.setOnClickListener(this);
        loginButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        if (v.getId()==R.id.registerId)
        {
            Intent intent = new Intent(LoginForm.this, SignupForm.class);
            startActivity(intent);
        }

        if (v.getId()==R.id.loginId)
        {
            userLogin();
        }

    }

    private void userLogin() {

        String email = EmailV.getText().toString().trim();

        String password = PasswordV.getText().toString().trim();

        if (email.isEmpty())
        {
            EmailV.setError("Enter an Email address");
            EmailV.requestFocus();
            return;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches())
        {
            EmailV.setError("Enter a Valid Email address");
            EmailV.requestFocus();
            return;
        }

        if (password.isEmpty())
        {
            PasswordV.setError("Enter a password");
            PasswordV.requestFocus();
            return;
        }

        if (password.length()<6)
        {
            PasswordV.setError("Maximum length of password is 6");
            PasswordV.requestFocus();
            return;
        }


        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if (task.isSuccessful())
                {
                    Intent intent = new Intent(getApplicationContext(), MainPage.class);
                    startActivity(intent);

                } else {
                    Toast.makeText(getApplicationContext(), "Login Unsuccessful", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}




















