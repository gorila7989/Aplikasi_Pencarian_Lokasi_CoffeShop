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
import com.findcoffee.jeniscoffee.jenisqahwa;
import com.findcoffee.mapscoffee.MapsFika;
import com.findcoffee.mapscoffee.MapsQahwa;

public class Qahwa extends AppCompatActivity {

    ViewFlipper viewFlipper;
    RatingBar ratingBar;
    Button btSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qahwa);

        ratingBar = findViewById(R.id.ratingqahwa);
        btSubmit = findViewById(R.id.submitqahwa);

        btSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = String.valueOf(ratingBar.getRating());
                Toast.makeText(getApplication(),"Bintang "+s,Toast.LENGTH_SHORT).show();
            }
        });

        int images[] = {R.drawable.qahwa,R.drawable.qahwa1,R.drawable.qahwa2,R.drawable.qahwa3,
                R.drawable.qahwa4,R.drawable.qahwa5};

        viewFlipper = findViewById(R.id.temaqahwa);

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
    public void lokasiqahwa(View v){
        Intent i = new Intent (this, MapsQahwa.class);
        startActivity(i);
    }
    public void jenisqahwa(View v){
        Intent i = new Intent (this, jenisqahwa.class);
        startActivity(i);
    }
}