package com.findcoffee.detailscoffee;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.findcoffee.R;
import com.findcoffee.jeniscoffee.jenisparislyon;
import com.findcoffee.mapscoffee.MapsFika;
import com.findcoffee.mapscoffee.MapsParislyon;

public class Parislyon extends AppCompatActivity {

    ViewFlipper viewFlipper;
    RatingBar ratingBar;
    Button btSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parislyon);

        ratingBar = findViewById(R.id.ratingparislyon);
        btSubmit = findViewById(R.id.submitparislyon);

        btSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = String.valueOf(ratingBar.getRating());
                Toast.makeText(getApplication(),"Bintang "+s,Toast.LENGTH_SHORT).show();
            }
        });

        int images[] = {R.drawable.parislyon,R.drawable.parislyon1,R.drawable.parislyon2,R.drawable.parislyon3,
                        R.drawable.parislyon4,R.drawable.parislyon5,R.drawable.parislyon6};

        viewFlipper = findViewById(R.id.temaparislyon);

        for (int image : images){
            flipperImages(image);
        }
    }

    public void flipperImages (int image){
        ImageView imageView = new ImageView(this);
        imageView.setBackgroundResource(image);

        viewFlipper.addView(imageView);
        viewFlipper.setFlipInterval(3000); //3sec
        viewFlipper.setAutoStart(true);

        viewFlipper.setInAnimation(this, android.R.anim.slide_in_left);
        viewFlipper.setOutAnimation(this, android.R.anim.slide_out_right);
    }
    public void lokasiparislyon(View v){
        Intent i = new Intent (this, MapsParislyon.class);
        startActivity(i);
    }
    public void jenisparislyon(View v){
        Intent i = new Intent (this, jenisparislyon.class);
        startActivity(i);
    }
}