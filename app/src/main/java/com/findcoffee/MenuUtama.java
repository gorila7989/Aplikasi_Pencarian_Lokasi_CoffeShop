package com.findcoffee;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.app.AlertDialog;
import android.content.DialogInterface;

public class MenuUtama extends AppCompatActivity implements View.OnClickListener {
    CardView btncoffee, btnmaps, btnbantuan, btntentang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menuutama);

        //defining cards
        btncoffee = (CardView) findViewById(R.id.btncoffee);
        btnmaps = (CardView) findViewById(R.id.btnmaps);
        btnbantuan = (CardView) findViewById(R.id.btnbantuan);
        btntentang = (CardView) findViewById(R.id.btntentang);

        //Add clicklistener to this cards
        btncoffee.setOnClickListener(this);
        btnmaps.setOnClickListener(this);
        btnbantuan.setOnClickListener(this);
        btntentang.setOnClickListener(this);
    }

    public void onClick(View v) {
        android.content.Intent i;

        switch (v.getId()) {
            case R.id.btncoffee:
                i = new Intent(this, ListCoffe.class);
                startActivity(i);
                break;
            case R.id.btnmaps:
                i = new Intent(this, MapsActivity.class);
                startActivity(i);
                break;
            case R.id.btntentang:
                i = new Intent(this, tentang.class);
                startActivity(i);
                break;
            case R.id.btnbantuan:
                i = new Intent(this, Bantuan.class);
                startActivity(i);
                break;
            default:
                break;
        }
    }

    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setIcon(R.mipmap.icon)
                .setTitle(R.string.app_name)
                .setMessage("Kamu yakin ingin keluar?")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                })
                .show();
    }
}