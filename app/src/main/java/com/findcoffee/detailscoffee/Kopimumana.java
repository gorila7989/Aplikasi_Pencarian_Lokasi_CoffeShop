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
import com.findcoffee.jeniscoffee.jeniskopimumana;
import com.findcoffee.mapscoffee.MapsFika;
import com.findcoffee.mapscoffee.MapsKopiberkata;
import com.findcoffee.mapscoffee.MapsKopimumana;

public class Kopimumana extends AppCompatActivity {

    ViewFlipper viewFlipper;
    RatingBar ratingBar;
    Button btSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kopimumana);

        ratingBar = findViewById(R.id.ratingkopimumana);
        btSubmit = findViewById(R.id.submitkopimumana);

        btSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = String.valueOf(ratingBar.getRating());
                Toast.makeText(getApplication(),"Bintang "+s,Toast.LENGTH_SHORT).show();
            }
        });

        int images[] = {R.drawable.kopimumana,R.drawable.kopimumana1,R.drawable.kopimumana2,R.drawable.kopimumana3,R.drawable.kopimumana4,R.drawable.kopimumana5};

        viewFlipper = findViewById(R.id.temakopimumana);

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
    public void lokasikopimumana(View v){
        Intent i = new Intent (this, MapsKopimumana.class);
        startActivity(i);
    }
    public void jeniskopimumana(View v){
        Intent i = new Intent (this, jeniskopimumana.class);
        startActivity(i);
    }
}