package com.example.android_app;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class DevOps extends AppCompatActivity {
    Button cours, contact;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.septieme_activite);
        Bundle extras=getIntent().getExtras();
        Toast.makeText(getApplicationContext(), "matière et professeur:" + extras.get("matière") + " " + extras.get("professeur"),Toast.LENGTH_LONG).show();
        cours= (Button) findViewById(R.id.button11);
        contact= (Button) findViewById(R.id.button12);
        cours.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://m.inpt.ac.ma/course/view.php?id=1671"));
                startActivity(intent);
            }
        });
        contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(getBaseContext(), contact5.class);
                intent.putExtra("matière", "DevOps");
                intent.putExtra("professeur", " Asmaâ RETBI");
                startActivity(intent);
            }
        });
    }
}
