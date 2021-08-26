package com.example.projem1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Kayit_Ol extends AppCompatActivity {

    private EditText registerUserName;
    private EditText registerPassword;
    private Button buttonRegister;
    private FirebaseAuth mAuth;
    private String userName;
    private String userPassword;
    Context context= this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kayit__ol);

        registerUserName = (EditText) findViewById(R.id.ETKullaniciAdi);
        registerPassword = (EditText) findViewById(R.id.ETŞifre);
        buttonRegister = (Button) findViewById(R.id.BtnKayitOl);

        mAuth = FirebaseAuth.getInstance();


        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userName = registerUserName.getText().toString();
                userPassword = registerPassword.getText().toString();

                if (userName.isEmpty() || userPassword.isEmpty()) {
                    Toast.makeText(context, "Lütfen Gerekli Alanları Doldurunuz", Toast.LENGTH_SHORT).show();
                } else {

                    registerFunc();

                }


            }
        });
    }

            private void registerFunc() {

                mAuth.createUserWithEmailAndPassword(userName, userPassword)
                        .addOnCompleteListener(Kayit_Ol.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    Intent i = new Intent(Kayit_Ol.this, Profil.class);
                                    startActivity(i);
                                    finish();
                                } else {
                                    Toast.makeText(getApplicationContext(), task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                                }

                            }
                        });
            }
        }


