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
import com.findcoffee.jeniscoffee.jenisfika;
import com.findcoffee.jeniscoffee.jenisgreetings;
import com.findcoffee.mapscoffee.MapsFika;
import com.findcoffee.mapscoffee.MapsGreetings;

public class Greetings extends AppCompatActivity {

    ViewFlipper viewFlipper;
    RatingBar ratingBar;
    Button btSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_greetings);

        ratingBar = findViewById(R.id.ratinggreetings);
        btSubmit = findViewById(R.id.submitgreetings);

        btSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = String.valueOf(ratingBar.getRating());
                Toast.makeText(getApplication(),"Bintang "+s,Toast.LENGTH_SHORT).show();
            }
        });

        int images[] = {R.drawable.greetings,R.drawable.greetings1,R.drawable.greetings2,R.drawable.greetings3,
                R.drawable.greetings4,R.drawable.greetings5};

        viewFlipper = findViewById(R.id.temagreetings);

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
    public void lokasigreetings(View v){
        Intent i = new Intent (this, MapsGreetings.class);
        startActivity(i);
    }
    public void jenisgreetings(View v){
        Intent i = new Intent (this, jenisgreetings.class);
        startActivity(i);
    }
}