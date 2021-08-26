package com.example.projem1;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Kategorisecimi extends AppCompatActivity {
TextView txt1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        View viewBaslik = getLayoutInflater().inflate(R.layout.activity_actionbar, null);
        TextView KategoriTitle = viewBaslik.findViewById(R.id.KategoriTitle);
        KategoriTitle.setText("Kategori");
        ActionBar.LayoutParams params = new ActionBar.LayoutParams(
                ActionBar.LayoutParams.WRAP_CONTENT,
                ActionBar.LayoutParams.MATCH_PARENT,
                Gravity.CENTER_HORIZONTAL);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(viewBaslik,params);//Layout içindeki xml dosyası.
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.kategori);//Drawable içine eklenen ikon.





        Button Sporbuton = (Button) findViewById(R.id.Spor);
        Button Cografyabuton = (Button) findViewById(R.id.Cografya);
        Button Sanatbuton= (Button) findViewById(R.id.Sanat);
        Button Tarihbuton =(Button) findViewById(R.id.Tarih);
        Button Bilimbuton = (Button) findViewById(R.id.Bilim);
        Button Eglencebuton = (Button) findViewById(R.id.Eglence);


        Sporbuton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent Sporintent = new Intent(Kategorisecimi.this,Spor.class);
                Sporintent.putExtra("veri","id");
                startActivity(Sporintent);

            }

        });

        Cografyabuton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Cografyaintent = new Intent(Kategorisecimi.this,Cografya.class);
                Cografyaintent.putExtra("veri","id");
                startActivity(Cografyaintent);

            }
        });

        Sanatbuton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Sanatintent = new Intent(Kategorisecimi.this,Sanat.class);
                Sanatintent.putExtra("veri","id");
                startActivity(Sanatintent);

            }
        });

        Tarihbuton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Tarihintent = new Intent(Kategorisecimi.this,Tarih.class);
                Tarihintent.putExtra("veri","id");
                startActivity(Tarihintent);


            }
        });

        Bilimbuton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Bilimintent = new Intent(Kategorisecimi.this,Bilim.class);
                Bilimintent.putExtra("veri","id");
                startActivity(Bilimintent);
            }
        });

        Eglencebuton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent Eglenceintent = new Intent(Kategorisecimi.this,Eglence.class);
                Eglenceintent.putExtra("veri","id");
                startActivity(Eglenceintent);

            }
        });









    }
}
