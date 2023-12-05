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
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Register extends AppCompatActivity {
Button regButton ;
private EditText Email , Pass , Mono, Name;
private String email ,pass , mono, name;
    private FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        TextView signText = (TextView)findViewById(R.id.signtext);
        regButton = (Button)findViewById(R.id.btn);
        Email= (EditText)findViewById(R.id.regEmail);
       Pass= (EditText)findViewById(R.id.regPassword);
       Mono = (EditText)findViewById(R.id.mono);
       Name= (EditText)findViewById(R.id.name);
        firebaseAuth = FirebaseAuth.getInstance();

        signText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Register.this ,longin.class);
                startActivity(intent);
                finish();
            }
        });
        regButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                email = Email.getText().toString().trim();
                pass = Pass.getText().toString().trim();
                name = Name.getText().toString();
               mono = Mono.getText().toString();

                firebaseAuth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        System.out.println( task);
                        if(task.isSuccessful()) {
                            sendUserData();
                            Toast.makeText(Register.this, "Registration Succesfull", Toast.LENGTH_SHORT).show();
                            finish();
                            startActivity(new Intent(Register.this,longin.class));
                        }
                        else {
                            Toast.makeText(Register.this, "Registration Failed", Toast.LENGTH_SHORT).show();

                        }

                    }

                });

            }
        });
    }

    //send User Data

    private void sendUserData(){
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        DatabaseReference myRef = firebaseDatabase.getReference(firebaseAuth.getUid());


        User userProfile = new User( name,  email,  mono);
        myRef.setValue(userProfile);



    }


}