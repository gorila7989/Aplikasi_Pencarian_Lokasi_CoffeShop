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
import com.findcoffee.jeniscoffee.jenislimkopi;
import com.findcoffee.mapscoffee.MapsFika;
import com.findcoffee.mapscoffee.MapsLimkopi;

public class Limkopi extends AppCompatActivity {

    ViewFlipper viewFlipper;
    RatingBar ratingBar;
    Button btSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_limkopi);

        ratingBar = findViewById(R.id.ratinglimkopi);
        btSubmit = findViewById(R.id.submitlimkopi);

        btSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = String.valueOf(ratingBar.getRating());
                Toast.makeText(getApplication(),"Bintang "+s,Toast.LENGTH_SHORT).show();
            }
        });

        int images[] = {R.drawable.limkopi,R.drawable.limkopi1,R.drawable.limkopi2,R.drawable.limkopi3,
                R.drawable.limkopi4,R.drawable.limkopi5};

        viewFlipper = findViewById(R.id.temalimkopi);

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
    public void lokasilimkopi(View v){
        Intent i = new Intent (this, MapsLimkopi.class);
        startActivity(i);
    }
    public void jenislimkopi(View v){
        Intent i = new Intent (this, jenislimkopi.class);
        startActivity(i);
    }
}
