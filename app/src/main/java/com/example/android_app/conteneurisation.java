package com.example.android_app;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class conteneurisation extends AppCompatActivity {
    Button cours, contact;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cinquieme_activite);
        Bundle extras=getIntent().getExtras();
        Toast.makeText(getApplicationContext(), "matière et professeur:" + extras.get("matière") + " " + extras.get("professeur"),Toast.LENGTH_LONG).show();
        cours= (Button) findViewById(R.id.button11);
        contact= (Button) findViewById(R.id.button12);
        cours.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://m.inpt.ac.ma/course/view.php?id=1506"));
                startActivity(intent);
            }
        });
        contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(getBaseContext(), contact3.class);
                intent.putExtra("matière", "conteneurisation des applications");
                intent.putExtra("professeur", "Driss ALLAKI");
                startActivity(intent);
            }
        });
    }
}
