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
import com.findcoffee.mapscoffee.MapsFika;
public class Fika extends AppCompatActivity {

    ViewFlipper viewFlipper;
    RatingBar ratingBar;
    Button btSubmit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fika);

        ratingBar = findViewById(R.id.ratingfika);
        btSubmit = findViewById(R.id.submitfika);

        btSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = String.valueOf(ratingBar.getRating());
                Toast.makeText(getApplication(),"Bintang "+s,Toast.LENGTH_SHORT).show();
            }
        });
        int images[] = {R.drawable.fika,R.drawable.fika1,R.drawable.fika2,R.drawable.fika3,
                R.drawable.fika4};
        viewFlipper = findViewById(R.id.temafika);
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
    public void lokasifika(View v){
        Intent i = new Intent (this, MapsFika.class);
        startActivity(i);
    }
    public void jenisfika(View v){
        Intent i = new Intent (this, jenisfika.class);
        startActivity(i);
    }
}