package com.example.projem1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Random;
import java.util.Timer;

public class Spor extends AppCompatActivity {
    Button b1,b2,b3,b4;
    TextView t1_soru,timertext;
    int total=0;
    int dogru=0;
    DatabaseReference reference;
    int yanlıs=0;
    int Skor=0;
    int number;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spor);
        View viewBaslik = getLayoutInflater().inflate(R.layout.activity_actionbar, null);
        TextView KategoriTitle = viewBaslik.findViewById(R.id.KategoriTitle);
        KategoriTitle.setText("Spor");
        ActionBar.LayoutParams params = new ActionBar.LayoutParams(
                ActionBar.LayoutParams.WRAP_CONTENT,
                ActionBar.LayoutParams.MATCH_PARENT,
                Gravity.CENTER_HORIZONTAL);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(viewBaslik,params);//Layout içindeki xml dosyası.
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.spor);//Drawable içine eklenen ikon.

        b1=(Button)findViewById(R.id.btnA);
        b2=(Button)findViewById(R.id.btnB);
        b3=(Button)findViewById(R.id.BtnC);
        b4=(Button)findViewById(R.id.BtnD);
        t1_soru=(TextView)findViewById(R.id.Txtsoru);
        timertext=(TextView)findViewById(R.id.Txttimer);
//        Random random = new Random();
//        number = random.nextInt(5);

        updatesorular();
        reverseTimer(30,timertext);



    }

    private void updatesorular()
    {




          total++;
        if (total >4)
        {




            Intent i = new Intent(Spor.this,Skor.class);
            i.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
            i.putExtra("total",String.valueOf(total));
            i.putExtra("dogru",String.valueOf(dogru));
            i.putExtra("yanlıs",String.valueOf(yanlıs));
            i.putExtra("Skor",String.valueOf(Skor));
            startActivity(i);
            this.finish();


        }
        else
        {
            reference = FirebaseDatabase.getInstance().getReference().child("Sorular").child(String.valueOf(total));
            reference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                 final Model model = dataSnapshot.getValue(Model.class);

                 t1_soru.setText(model.getSorular());
                 b1.setText(model.getSecenek1());
                 b2.setText(model.getSecenek2());
                 b3.setText(model.getSecenek3());
                 b4.setText(model.getSecenek4());




                 b1.setOnClickListener(new View.OnClickListener() {
                     @Override
                     public void onClick(View v) {
                         if(b1.getText().toString().equals(model.getCevap()))

                         {
                             b1.setBackgroundColor(Color.GREEN);
                             Handler handler =new Handler();
                             handler.postDelayed(new Runnable() {
                                 @Override
                                 public void run() {

                                     dogru++;
                                     Skor=+100;
                                     b1.setBackgroundColor(Color.parseColor("#FFFFFF"));
                                     updatesorular();


                                 }
                             },1500);


                         }
                         else
                         {
                             yanlıs++;
                             b1.setBackgroundColor(Color.RED);

                             if (b2.getText().toString().equals(model.getCevap()))
                             {
                                   b2.setBackgroundColor(Color.GREEN);

                             }
                             else if (b3.getText().toString().equals(model.getCevap()))
                             {
                                 b3.setBackgroundColor(Color.GREEN);
                             }
                             else if (b4.getText().toString().equals(model.getCevap()))
                             {
                                 b4.setBackgroundColor(Color.GREEN);
                             }

                              Handler handler = new Handler();
                             handler.postDelayed(new Runnable() {
                                 @Override
                                 public void run() {
                                     b1.setBackgroundColor(Color.parseColor("#FFFFFF"));
                                     b2.setBackgroundColor(Color.parseColor("#FFFFFF"));
                                     b3.setBackgroundColor(Color.parseColor("#FFFFFF"));
                                     b4.setBackgroundColor(Color.parseColor("#FFFFFF"));
                                     updatesorular();

                                 }
                             },1500);

                         }

                     }
                 });


                 b2.setOnClickListener(new View.OnClickListener() {
                     @Override
                     public void onClick(View v) {

                         if(b2.getText().toString().equals(model.getCevap()))

                         {
                             b2.setBackgroundColor(Color.GREEN);
                             Handler handler =new Handler();
                             handler.postDelayed(new Runnable() {
                                 @Override
                                 public void run() {

                                     dogru++;
                                     Skor=Skor+100;
                                     b2.setBackgroundColor(Color.parseColor("#FFFFFF"));
                                     updatesorular();


                                 }
                             },1500);


                         }
                         else
                         {
                             yanlıs++;
                             b2.setBackgroundColor(Color.RED);

                             if (b1.getText().toString().equals(model.getCevap()))
                             {
                                 b1.setBackgroundColor(Color.GREEN);

                             }
                             else if (b3.getText().toString().equals(model.getCevap()))
                             {
                                 b3.setBackgroundColor(Color.GREEN);
                             }
                             else if (b4.getText().toString().equals(model.getCevap()))
                             {
                                 b4.setBackgroundColor(Color.GREEN);
                             }

                             Handler handler = new Handler();
                             handler.postDelayed(new Runnable() {
                                 @Override
                                 public void run() {
                                     b1.setBackgroundColor(Color.parseColor("#FFFFFF"));
                                     b2.setBackgroundColor(Color.parseColor("#FFFFFF"));
                                     b3.setBackgroundColor(Color.parseColor("#FFFFFF"));
                                     b4.setBackgroundColor(Color.parseColor("#FFFFFF"));
                                     updatesorular();

                                 }
                             },1500);

                         }

                     }




                 });


                 b3.setOnClickListener(new View.OnClickListener() {
                     @Override
                     public void onClick(View v) {


                         if(b3.getText().toString().equals(model.getCevap()))

                         {
                             b3.setBackgroundColor(Color.GREEN);
                             Handler handler =new Handler();
                             handler.postDelayed(new Runnable() {
                                 @Override
                                 public void run() {

                                     dogru++;
                                     Skor=Skor+100;
                                     b3.setBackgroundColor(Color.parseColor("#FFFFFF"));
                                     updatesorular();


                                 }
                             },1500);


                         }
                         else
                         {
                             yanlıs++;
                             b3.setBackgroundColor(Color.RED);

                             if (b1.getText().toString().equals(model.getCevap()))
                             {
                                 b1.setBackgroundColor(Color.GREEN);

                             }
                             else if (b2.getText().toString().equals(model.getCevap()))
                             {
                                 b2.setBackgroundColor(Color.GREEN);
                             }
                             else if (b4.getText().toString().equals(model.getCevap()))
                             {
                                 b4.setBackgroundColor(Color.GREEN);
                             }

                             Handler handler = new Handler();
                             handler.postDelayed(new Runnable() {
                                 @Override
                                 public void run() {
                                     b1.setBackgroundColor(Color.parseColor("#FFFFFF"));
                                     b2.setBackgroundColor(Color.parseColor("#FFFFFF"));
                                     b3.setBackgroundColor(Color.parseColor("#FFFFFF"));
                                     b4.setBackgroundColor(Color.parseColor("#FFFFFF"));
                                     updatesorular();

                                 }
                             },1500);

                         }

                     }
                 });

                 b4.setOnClickListener(new View.OnClickListener() {
                     @Override
                     public void onClick(View v) {
                         if(b4.getText().toString().equals(model.getCevap()))

                         {
                             b4.setBackgroundColor(Color.GREEN);
                             Handler handler =new Handler();
                             handler.postDelayed(new Runnable() {
                                 @Override
                                 public void run() {

                                     dogru++;
                                     Skor=Skor+100;
                                     b4.setBackgroundColor(Color.parseColor("#FFFFFF"));
                                     updatesorular();


                                 }
                             },1500);


                         }
                         else
                         {


                             yanlıs++;
                             b4.setBackgroundColor(Color.RED);

                             if (b1.getText().toString().equals(model.getCevap()))
                             {
                                 b1.setBackgroundColor(Color.GREEN);

                             }
                             else if (b2.getText().toString().equals(model.getCevap()))
                             {
                                 b2.setBackgroundColor(Color.GREEN);
                             }
                             else if (b3.getText().toString().equals(model.getCevap()))
                             {
                                 b3.setBackgroundColor(Color.GREEN);
                             }

                             Handler handler = new Handler();
                             handler.postDelayed(new Runnable() {
                                 @Override
                                 public void run() {
                                     b1.setBackgroundColor(Color.parseColor("#FFFFFF"));
                                     b2.setBackgroundColor(Color.parseColor("#FFFFFF"));
                                     b3.setBackgroundColor(Color.parseColor("#FFFFFF"));
                                     b4.setBackgroundColor(Color.parseColor("#FFFFFF"));
                                     updatesorular();

                                 }
                             },1500);

                         }


                     }
                 });



                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });


        }



    }
    public void  reverseTimer(int saniye, final TextView timertext)
    {


        new CountDownTimer(saniye * 1000+1000,1000)
        {


            @Override
            public void onTick(long millisUntilFinished) {
                int saniye = (int)(millisUntilFinished/1000);
                int dakika = saniye /60;
                saniye = saniye %60;
                timertext.setText(String.format("%02d",dakika)+":"+String.format("%02d",saniye));
            }

            @Override
            public void onFinish() {


                    timertext.setText("Süre Bitti");
                    Intent intent = new Intent(Spor.this,Skor.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                    intent.putExtra("total",String.valueOf(total));
                    intent.putExtra("dogru",String.valueOf(dogru));
                    intent.putExtra("yanlıs",String.valueOf(yanlıs));
                    intent.putExtra("Skor",String.valueOf(Skor));
                    startActivity(intent);


            }
        }.start();


    }







}



