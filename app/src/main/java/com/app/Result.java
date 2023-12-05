package com.app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Result extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    ImageView resImg ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        TextView name = (TextView)findViewById(R.id.diseases);
        TextView cname = (TextView)findViewById(R.id. cname);
        TextView cause = (TextView)findViewById(R.id.cause);
        TextView control = (TextView)findViewById(R.id.control);
              resImg = (ImageView)findViewById(R.id.resImg);
        Intent intent = getIntent();
        String diseases = intent.getExtras().getString("diseases");
        Bundle extras = getIntent().getExtras();
        byte[] byteArray = extras.getByteArray("res");

        Bitmap bmp = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
        resImg.setImageBitmap(bmp);
        if(diseases.equals("BB")){
          name.setText("Bacterial Blight");
            cname.setText("(जिवानु अनिष्ट परिणम)");
            cause.setText("Bacterial blight starts out as angular, waxy and water-soaked leaf spot \n with a red to brown border on leaves, stems and bolls. The angular appearance is due to the restriction of the lesions.");
            control.setText("Organic Control\n" +
                    "\n" +
                    "Apply talc-based powder formulations containing the bacteria Pseudomonas fluorescens and Bacillus subtilis against the bacteria X. malvacearum. Use extracts of Azadirachta indica (neem extract). Apply growth regulators that prevent unrestrained growth to avoid infection with bacterial blight.\n" +
                    "\n" +
                    "✓ Chemical Control\n" +
                    "\n" +
                    "Always consider an integrated approach with preventive measures and biological treatments if available. Seed treatment with authorized antibiotics and seed dressing with copper oxychloride are very effective against the bacteria causing cotton bacterial blight.");

        }
        else if(diseases.equals("CV")){
            name.setText("Curl Virus");
            cname.setText("(फुलकिडा)");
            cause.setText("• Yellow spots on leaves.\n" +

                    ". Deep black powdery mold develops.\n" +

                    "• Leaf deformation with curling or cupping shape.\n" +

                    ". Stunted growth.\n" +

                    "• Small white to yellowish insects.\n");
            control.setText(
                  "Organic Control:\n"+
                    "Biological solutions will vary depending on the specific species of whitefly involved and the crop. Natural insecticides based on sugar-apple oil (Annona squamosa), pyrethrins, insecticidal soaps, Neem seed kernel extract (NSKE 5%), Neem oil (5ml/L water) are recommended. Pathogenic fungi include Beauveria bassiana, Isaria fumosorosea, Verticillium lecanii, and Paecilomyces fumosoroseus.\n" +
                     " Chemical Control\n" +
                    "A Select and apply ONLY ONE of the following products to your crops.\n" +
                    "Insecticide\n" +
                    "Fipronil 5.0% SC\n" +
                    "Found in Sungent (Aegis), Fitoor SC (Ichiban), Tag Ag...\n" +
                    "Insecticide\n" +
                    "Flonicamid 50.0% WG\n" +
                    "Found in Panama (Swal), Ulala (UPL)\n" +
                    "Insecticide\n" +
                    "Thiacloprid 21.7% SC\n" +
                    "Found in Alanto (Bayer), Splendour (Cheminova), Thio");

        }
        else if(diseases.equals("FW")){
            name.setText("Fusarium wilt");
            cname.setText("(अर्धा मार्गाल)");
            cause.setText("• Wilting of plant.\n" +
                    "• Yellowing of leaves.\n" +
                    "Inside of stem is stained brown");
            control.setText("Organic Control: \n" +
                    "\n" +
                    "Several biological control agents, including bacteria and nonpathogenic strains of F. oxysporum that compete with the pathogens, have been used to control Fusarium wilt in some crops. Trichoderma viride can also be used to treat the seeds (10g/kg seed). Some soils suppress the growth of Fusarium. Adjusting the soil pH to 6.5-7.0 and using nitrate rather than ammonium as nitrogen source can reduce the severity of the disease.\n" +
                    "\n" +
                    "Chemical Control:\n" +
                    "\n" +
                    "Always consider an integrated approach with preventive measures together with biological treatments if available. Apply soil-based fungicides on contaminated locations if no other measures are effective. Drenching the soil with copper oxychloride (3g/l) of water before sowing/ transplanting is also effective.");

        }
        else if(diseases.equals("healthy")){
            name.setText("Healthy");
          cname.setVisibility(View.INVISIBLE);
          cause.setText("none");
          control.setText("none");
        }



        //bottom nav code
        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setSelectedItemId(R.id.detect);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){


                    case R.id.detect:
                        startActivity(new Intent(getApplicationContext(),CaptureImage.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.feeds:
                        startActivity(new Intent(getApplicationContext(),Feeds.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.profile:
                        startActivity(new Intent(getApplicationContext(),Profile.class));
                        overridePendingTransition(0,0);
                        return true;
                }

                return false;
            }
        });


    }
}