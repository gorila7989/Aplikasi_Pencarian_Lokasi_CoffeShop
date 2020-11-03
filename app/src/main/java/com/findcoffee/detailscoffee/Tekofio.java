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
import com.findcoffee.jeniscoffee.jenistekofio;
import com.findcoffee.mapscoffee.MapsFika;
import com.findcoffee.mapscoffee.MapsTekofio;

public class Tekofio extends AppCompatActivity {

    ViewFlipper viewFlipper;
    RatingBar ratingBar;
    Button btSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tekofio);

        ratingBar = findViewById(R.id.ratingtekofio);
        btSubmit = findViewById(R.id.submittekofio);

        btSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = String.valueOf(ratingBar.getRating());
                Toast.makeText(getApplication(),"Bintang "+s,Toast.LENGTH_SHORT).show();
            }
        });

        int images[] = {R.drawable.tekofio,R.drawable.tekofio1,R.drawable.tekofio2,R.drawable.tekofio3,
                R.drawable.tekofio4,R.drawable.tekofio5};

        viewFlipper = findViewById(R.id.tematekofio);

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
    public void lokasitekofio(View v){
        Intent i = new Intent (this, MapsTekofio.class);
        startActivity(i);
    }
    public void jenistekofio(View v){
        Intent i = new Intent (this, jenistekofio.class);
        startActivity(i);
    }
}