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
import com.findcoffee.jeniscoffee.jenispkp;
import com.findcoffee.mapscoffee.MapsFika;
import com.findcoffee.mapscoffee.MapsPkp;

public class Pkp extends AppCompatActivity {

    ViewFlipper viewFlipper;
    RatingBar ratingBar;
    Button btSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pkp);

        ratingBar = findViewById(R.id.ratingpkp);
        btSubmit = findViewById(R.id.submitpkp);

        btSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = String.valueOf(ratingBar.getRating());
                Toast.makeText(getApplication(),"Bintang "+s,Toast.LENGTH_SHORT).show();
            }
        });

        int images[] = {R.drawable.pkp,R.drawable.pkp1,R.drawable.pkp2,R.drawable.pkp3,
                R.drawable.pkp4,R.drawable.pkp5};

        viewFlipper = findViewById(R.id.temapkp);

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
    public void lokasipkp(View v){
        Intent i = new Intent (this, MapsPkp.class);
        startActivity(i);
    }
    public void jenispkp(View v){
        Intent i = new Intent (this, jenispkp.class);
        startActivity(i);
    }
}