package com.app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Profile extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    FirebaseDatabase firebaseDatabase;
    private FirebaseAuth firebaseAuth;
    DatabaseReference databaseReference;
    TextView email , mono, name;
Button logOut;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        firebaseDatabase = FirebaseDatabase.getInstance();
        firebaseAuth = FirebaseAuth.getInstance();
        databaseReference = firebaseDatabase.getReference(firebaseAuth.getUid());
         email = (TextView)findViewById(R.id.pemail);
         mono = (TextView)findViewById(R.id.pmono);
         name = (TextView)findViewById(R.id.pname);
         logOut = (Button) findViewById(R.id.logout);
         getdata();
        //bottom nav code
        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setSelectedItemId(R.id.profile);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){


                    case R.id.detect:
                        startActivity(new Intent(getApplicationContext(),CaptureImage.class));
                        finish();
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.feeds:
                        startActivity(new Intent(getApplicationContext(),Feeds.class));
                        finish();
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.profile:
                        startActivity(new Intent(getApplicationContext(),Profile.class));
                        finish();
                        overridePendingTransition(0,0);
                        return true;
                }

                return false;
            }
        });  // bottom nav end

        logOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logout();
            }
        });
    }
    private void getdata() {


        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                System.out.println(snapshot.child("email").getValue().toString());
                System.out.println(snapshot.child("moNo").getValue().toString());
                System.out.println(snapshot.child("name").getValue().toString());
              email.setText(snapshot.child("email").getValue().toString());
              mono.setText(snapshot.child("moNo").getValue().toString());
               name.setText(snapshot.child("name").getValue().toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // calling on cancelled method when we receive
                // any error or we are not able to get the data.
                Toast.makeText(Profile.this, "Fail to get data.", Toast.LENGTH_SHORT).show();
            }
        });
    }

    //log out
    public void logout() {
        firebaseAuth = FirebaseAuth.getInstance();

        firebaseAuth.signOut();
        finish();
        startActivity(new Intent(Profile.this,longin.class));
        Toast.makeText(Profile.this, "Log Out Successfully", Toast.LENGTH_SHORT).show();

    }
}