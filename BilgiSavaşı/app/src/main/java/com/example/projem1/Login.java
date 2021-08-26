package com.example.projem1;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Login   extends AppCompatActivity {
    EditText user,pass;
    TextView kayıtol;
    Button giris;
    Context context=this;
    private FirebaseAuth mAuth;
    private FirebaseUser firebaseUser;
    private String userName;
    private String userPassword;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        user=(EditText)findViewById(R.id.etKullanici);
        pass =(EditText) findViewById(R.id.etSifre);
        giris = (Button) findViewById(R.id.btnGiris);
        kayıtol = (TextView) findViewById(R.id.txtKayıtol);

        mAuth = FirebaseAuth.getInstance();
        firebaseUser = mAuth.getCurrentUser(); // authenticated user

        if (firebaseUser !=null){

            Intent i = new Intent(Login.this,Profil.class);
            startActivity(i);
            finish();


        }
        
        giris.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userName = user.getText().toString();
                userPassword = pass.getText().toString();
                if (userName.isEmpty() || userPassword.isEmpty())
                {
                    Toast.makeText(context, "Lütfen Gerekli alanları doldurunuz.", Toast.LENGTH_SHORT).show();
                    
                    
                    
                    
                }
                else
                {
                    loginFunc();
                }

            }
        });

        kayıtol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this,Kayit_Ol.class);
                startActivity(intent);

            }
        });


    }

    private void loginFunc() {
        mAuth.signInWithEmailAndPassword(userName,userPassword).addOnCompleteListener(Login.this,
                new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){

                            Intent i = new Intent(Login.this,Profil.class);
                            startActivity(i);
                            finish();

                        }
                        else{
                            // hata
                            Toast.makeText(getApplicationContext(),task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                        }
                    }

                });




    }
}
