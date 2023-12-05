package com.app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class Feeds extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    private ArrayList<FeedModal> FeedModalArrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feeds);
        //bottom nav code
        RecyclerView recyclerView = findViewById(R.id.idRVFeed);
        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setSelectedItemId(R.id.feeds);
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

        // here we have created new array list and added data to it.
        FeedModalArrayList = new ArrayList<>();
        FeedModalArrayList.add(new FeedModal("PM Kisan Maan Dhan Yojana", "Under this scheme, a minimum fixed pension of Rs.3,000/- is provided to the small and marginal farmers, subject to certain exclusion criteria, on attaining the age of 60 years","12.9.2019"));
        FeedModalArrayList.add(new FeedModal("Credit facility for farmers", "Loan facility is available through a \n large network of Commercial Banks,\n Regional Rural Banks and \n Cooperative Credit Institutions in the\n country to fulfill the crop loan and term loan needs of the farmers","xxxxx"));
        FeedModalArrayList.add(new FeedModal("Pradhan Mantri Fasal Bima \n Yojana", "Insurance protection for food crops, oilseeds and annual horticultural/commercial crops notified by state government.","18th February 2016"));
        FeedModalArrayList.add(new FeedModal("PM Kisan Maan Dhan Yojana", "Under this scheme, a minimum fixed pension of Rs.3,000/- is provided to the small and marginal farmers, subject to certain exclusion criteria, on attaining the age of 60 years","12.9.2019"));
        FeedModalArrayList.add(new FeedModal("Credit facility for farmers", "Loan facility is available through a large network of Commercial Banks, Regional Rural Banks and Cooperative Credit Institutions in the country to fulfill the crop loan and term loan needs of the farmers","xxxxx"));
        FeedModalArrayList.add(new FeedModal("Pradhan Mantri Fasal Bima Yojana", "Insurance protection for food crops, oilseeds and annual horticultural/commercial crops notified by state government.","18th February 2016"));

        // we are initializing our adapter class and passing our arraylist to it.
        FeedAdaptor FeedAdapter = new FeedAdaptor(this, FeedModalArrayList);

        // below line is for setting a layout manager for our recycler view.
        // here we are creating vertical list so we will provide orientation as vertical
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        // in below two lines we are setting layoutmanager and adapter to our recycler view.
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(FeedAdapter);
    }
}