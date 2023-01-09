package com.example.android_app;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class contact4 extends AppCompatActivity {
    private Button bouton;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contact_layout4);
        Bundle extras=getIntent().getExtras();

        Toast.makeText(getApplicationContext(), "nom et prenom:" + extras.get("nom") + " " + extras.get("prenom"),Toast.LENGTH_LONG).show();
        Button boutonDemarrer = findViewById(R.id.button13);
        boutonDemarrer.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                envoyerEmail();
            }
        });
        bouton = findViewById(R.id.button12);
        bouton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse("tel:0612345674"));
                startActivity(callIntent);
            }
        });
    }
    protected void envoyerEmail(){
        Log.i("Send email", "");
        String[] TO = {"hamidelghazi@gmail.com"};
        String[] CC = {""};
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.setType("text/plain");
        emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
        emailIntent.putExtra(Intent.EXTRA_CC, CC);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Sujet du mail");
        emailIntent.putExtra(Intent.EXTRA_TEXT, "Contenu du mail");
        try {
            startActivity(Intent.createChooser(emailIntent, "Envoyer mail..."));
            finish();
            Log.i("Envoi du mail termine..", "");
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(contact4.this, "Pas de client mail installe", Toast.LENGTH_SHORT).show();
        }

    }


}


