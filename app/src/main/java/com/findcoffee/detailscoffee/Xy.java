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
import com.findcoffee.jeniscoffee.jenisxy;
import com.findcoffee.mapscoffee.MapsFika;
import com.findcoffee.mapscoffee.MapsXy;

public class Xy extends AppCompatActivity {

    ViewFlipper viewFlipper;
    RatingBar ratingBar;
    Button btSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xy);

        ratingBar = findViewById(R.id.ratingxy);
        btSubmit = findViewById(R.id.submitxy);

        btSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = String.valueOf(ratingBar.getRating());
                Toast.makeText(getApplication(),"Bintang "+s,Toast.LENGTH_SHORT).show();
            }
        });

        int images[] = {R.drawable.xy,R.drawable.xy1,R.drawable.xy2,R.drawable.xy3,
                R.drawable.xy4};

        viewFlipper = findViewById(R.id.temaxy);

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
    public void lokasixy(View v){
        Intent i = new Intent (this, MapsXy.class);
        startActivity(i);
    }
    public void jenisxy(View v){
        Intent i = new Intent (this, jenisxy.class);
        startActivity(i);
    }
}