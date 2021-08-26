package com.example.projem1;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class AnaSayfa extends AppCompatActivity {


    Button btnteklimod,btnçoklumod,btnhakkında,btncıkıs;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.anasayfa);
        View viewBaslik = getLayoutInflater().inflate(R.layout.activity_actionbar, null);
        TextView KategoriTitle = viewBaslik.findViewById(R.id.KategoriTitle);
        KategoriTitle.setText("AnaSayfa");
        ActionBar.LayoutParams params = new ActionBar.LayoutParams(
                ActionBar.LayoutParams.WRAP_CONTENT,
                ActionBar.LayoutParams.MATCH_PARENT,
                Gravity.CENTER_HORIZONTAL);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(viewBaslik,params);//Layout içindeki xml dosyası.
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.anasayfa);//Drawable içine eklenen ikon.


        btnteklimod =(Button) findViewById(R.id.btnTekoyuncu);
        btnçoklumod =(Button) findViewById(R.id.btnçokoyuncu);
        btnhakkında =(Button) findViewById(R.id.btnHakkında);
        btncıkıs =(Button) findViewById(R.id.btnÇikis);


        btnteklimod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent teklimodintent = new Intent(AnaSayfa.this,Kategorisecimi.class);
                startActivity(teklimodintent);
            }
        });

        btncıkıs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });






    }
}
