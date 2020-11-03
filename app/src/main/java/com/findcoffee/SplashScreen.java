package com.findcoffee;

import android.os.Bundle;
import android.content.Intent;
import android.app.Activity;

public class SplashScreen extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        SplashScreen();}

    public void SplashScreen(){
        new Thread(){
            public void run(){
                try{Thread.sleep(5000);}
                catch (Exception e){}
                Intent i = new Intent (SplashScreen.this, MenuUtama.class);
                SplashScreen.this.finish();
                startActivity(i);
            }
        }.start();
    }
}