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
import com.findcoffee.jeniscoffee.jeniskopiberkata;
import com.findcoffee.mapscoffee.MapsFika;
import com.findcoffee.mapscoffee.MapsKopiberkata;

public class KopiBerkata extends AppCompatActivity {

    ViewFlipper viewFlipper;
    RatingBar ratingBar;
    Button btSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kopi_berkata);

        ratingBar = findViewById(R.id.ratingkopiberkata);
        btSubmit = findViewById(R.id.submitkopiberkata);

        btSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = String.valueOf(ratingBar.getRating());
                Toast.makeText(getApplication(),"Bintang "+s,Toast.LENGTH_SHORT).show();
            }
        });

        ratingBar = findViewById(R.id.ratinggreetings);
        btSubmit = findViewById(R.id.submitgreetings);

        int images[] = {R.drawable.kopiberkata,R.drawable.kopiberkata1,R.drawable.kopiberkata2,R.drawable.kopiberkata3,
                R.drawable.kopiberkata4,R.drawable.kopiberkata5};

        viewFlipper = findViewById(R.id.temakopiberkata);

        for (int image : images){
            flipperImages(image);
        }
    }
    public void flipperImages(int image) {
        ImageView imageView = new ImageView(this);
        imageView.setBackgroundResource(image);

        viewFlipper.addView(imageView);
        viewFlipper.setFlipInterval(3000); //3sec
        viewFlipper.setAutoStart(true);

        viewFlipper.setInAnimation(this, android.R.anim.slide_in_left);
        viewFlipper.setOutAnimation(this, android.R.anim.slide_out_right);
    }
    public void lokasikopiberkata(View v){
        Intent i = new Intent (this, MapsKopiberkata.class);
        startActivity(i);
    }
    public void jeniskopiberkata(View v){
        Intent i = new Intent (this, jeniskopiberkata.class);
        startActivity(i);
    }
}