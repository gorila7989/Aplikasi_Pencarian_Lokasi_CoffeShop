package com.findcoffee.jeniscoffee;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.findcoffee.R;

public class jenisxy extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jenisxy);
    }

    public void onDefaultToggleClick(View view) {
        Toast.makeText(this, "DefautToggle", Toast.LENGTH_SHORT).show();
    }

    public void onToggleFavClick(View view) {
        Toast.makeText(this, "Favorite", Toast.LENGTH_SHORT).show();
    }
}