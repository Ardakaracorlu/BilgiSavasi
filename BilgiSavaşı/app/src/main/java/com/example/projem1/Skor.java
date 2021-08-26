package com.example.projem1;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Skor extends AppCompatActivity {
    TextView tTotal,tDogru,tYanlıs,tSkor;
//    Button btnAnamenü,btnYenidenDene;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skor);

        View viewBaslik = getLayoutInflater().inflate(R.layout.activity_actionbar, null);
        TextView KategoriTitle = viewBaslik.findViewById(R.id.KategoriTitle);
        KategoriTitle.setText("Skor");
        ActionBar.LayoutParams params = new ActionBar.LayoutParams(
                ActionBar.LayoutParams.WRAP_CONTENT,
                ActionBar.LayoutParams.MATCH_PARENT,
                Gravity.CENTER_HORIZONTAL);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(viewBaslik,params);//Layout içindeki xml dosyası.
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



        tTotal = (TextView) findViewById(R.id.txtTotal);
        tDogru = (TextView) findViewById(R.id.txtDogru);
        tYanlıs = (TextView) findViewById(R.id.txtYanlis);
        tSkor = (TextView) findViewById(R.id.txtSkor);
//        btnAnamenü = (Button) findViewById(R.id.btnKategori);
    
//        btnYenidenDene = (Button) findViewById(R.id.btnYenidendene);


        Intent i = getIntent();
        String total = i.getStringExtra("total");
        String dogru = i.getStringExtra("dogru");
        String yanlıs = i.getStringExtra("yanlıs");
        String Skor = i.getStringExtra("Skor");


        tTotal.setText("Toplam Soru : "+total);
        tDogru.setText("Dogru : "+dogru);
        tYanlıs.setText("Yanlıs : "+yanlıs);
        tSkor.setText("Skor : "+Skor );


//        btnAnamenü.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent anamenü = new Intent(Skor.this,Kategorisecimi.class);
//                anamenü.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
//                startActivity(anamenü);
//                this.finish();
//
//            }
//
//            private void finish() {
//            }
//        });


//        btnYenidenDene.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent Yenidendene = new Intent(Skor.this,Spor.class);
//                startActivity(Yenidendene);
//
//            }
//        });




    }
    
    
       
}
