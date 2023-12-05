package com.app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class longin extends AppCompatActivity {
    private FirebaseAuth mAuth;
    EditText email,pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_longin);
         email= (EditText) findViewById(R.id.email);
         pass = (EditText) findViewById(R.id.password);
        TextView reg = (TextView) findViewById(R.id.regtext);
        Button btn = findViewById(R.id.btn);
        mAuth = FirebaseAuth.getInstance();
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validate())
                    loginUserAccount();
                else {
                    Toast.makeText(longin.this, "Please Enter the detail", Toast.LENGTH_SHORT).show();
                }
            }
        });

        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(longin.this, Register.class);
                startActivity(intent);
                finish();
            }
        });
    }
    //validate
    private Boolean validate(){
        Boolean result = false;
        String pass1;
        String email1;


        pass1 = pass.getText().toString();
        email1 = email.getText().toString();


        if(pass1.isEmpty()  || email1.isEmpty() ){
            Toast.makeText(this, "Please enter all the details", Toast.LENGTH_SHORT).show();
        }else{
            result = true;
        }

        return result;
    }
    //login user
    private void loginUserAccount()
    {
        // Take the value of two edit texts in Strings
        String email1, password;
        email1 = email.getText().toString();
        password = pass.getText().toString();

        mAuth.signInWithEmailAndPassword(email1,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(getApplicationContext(), "Login successful!!", Toast.LENGTH_LONG).show();
                    Intent intent
                            = new Intent(longin.this,CaptureImage.class);
                    startActivity(intent);
                    finish();
                }
                else {

                    // sign-in failed
                    Toast.makeText(getApplicationContext(), "Login failed!!", Toast.LENGTH_LONG).show();


                }

            }
        });
    }

}
