package com.findcoffee;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Telephony;
import android.view.View;

import com.findcoffee.detailscoffee.Fika;
import com.findcoffee.detailscoffee.Greetings;
import com.findcoffee.detailscoffee.KopiBerkata;
import com.findcoffee.detailscoffee.Kopimumana;
import com.findcoffee.detailscoffee.Limkopi;
import com.findcoffee.detailscoffee.Parislyon;
import com.findcoffee.detailscoffee.Pkp;
import com.findcoffee.detailscoffee.Qahwa;
import com.findcoffee.detailscoffee.Tekofio;
import com.findcoffee.detailscoffee.Xy;

public class ListCoffe extends AppCompatActivity implements View.OnClickListener {

    CardView parislyon, limkopi, kopimumana,fika,greetings,kopiberkata,pkp,qahwa,tekofio,xy;
    private Object Intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_coffe);
        //defining cards
        parislyon = (CardView) findViewById(R.id.parislyon);
        limkopi = (CardView) findViewById(R.id.limkopi);
        kopimumana = (CardView) findViewById(R.id.kopimumana);
        fika = (CardView) findViewById(R.id.fika);
        greetings = (CardView) findViewById(R.id.greetings);

        pkp = (CardView) findViewById(R.id.pkp);
        kopiberkata = (CardView) findViewById(R.id.kopiberkata);
        qahwa = (CardView) findViewById(R.id.qahwa);
        tekofio = (CardView) findViewById(R.id.tekofio);
        xy = (CardView) findViewById(R.id.xy);

        //Add clicklistener to this cards
        parislyon.setOnClickListener(this);
        limkopi.setOnClickListener(this);
        kopimumana.setOnClickListener(this);
        fika.setOnClickListener(this);
        greetings.setOnClickListener(this);

        pkp.setOnClickListener(this);
        kopiberkata.setOnClickListener(this);
        qahwa.setOnClickListener(this);
        tekofio.setOnClickListener(this);
        xy.setOnClickListener(this);
    }
    @Override
    public void onClick(View v){
        android.content.Intent i;

        switch (v.getId()){
            case R.id.parislyon : i = new Intent(this, Parislyon.class);startActivity(i);break;
            case R.id.limkopi : i = new Intent(this, Limkopi.class);startActivity(i);break;
            case R.id.kopimumana : i = new Intent(this, Kopimumana.class);startActivity(i);break;
            case R.id.fika : i = new Intent(this, Fika.class);startActivity(i);break;
            case R.id.greetings : i = new Intent(this, Greetings.class);startActivity(i);break;

            case R.id.pkp : i = new Intent(this, Pkp.class);startActivity(i);break;
            case R.id.kopiberkata : i = new Intent(this, KopiBerkata.class);startActivity(i);break;
            case R.id.qahwa : i = new Intent(this, Qahwa.class);startActivity(i);break;
            case R.id.tekofio : i = new Intent(this, Tekofio.class);startActivity(i);break;
            case R.id.xy : i = new Intent(this, Xy.class);startActivity(i);break;
            default:break;
        }

    }
}
