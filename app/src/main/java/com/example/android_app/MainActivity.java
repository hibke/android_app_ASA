package com.example.android_app;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button inpt, moodle, mobile, linux, DevOps, conteneurisation, bigdata, API;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(this, "Activite est creee", Toast.LENGTH_SHORT).show();
        Log.i("onCreate():", "Activite est creee");
        inpt= (Button) findViewById(R.id.button3);
        moodle= (Button) findViewById(R.id.button4);
        mobile= (Button) findViewById(R.id.button5);
        linux= (Button) findViewById(R.id.button10);
        conteneurisation= (Button) findViewById(R.id.button6);
        DevOps= (Button) findViewById(R.id.button7);
        API= (Button) findViewById(R.id.button8);
        bigdata= (Button) findViewById(R.id.button9);
        inpt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://www.inpt.ac.ma"));
                startActivity(intent);
            }
        });
        moodle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://m.inpt.ac.ma/login/index.php"));
                startActivity(intent);
            }
        });
        mobile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(getBaseContext(), mobile.class);
                intent.putExtra("matière", "développement des applications mobiles");
                intent.putExtra("professeur", "Yann Ben MAISSA");
                startActivity(intent);
            }
        });
        linux.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(getBaseContext(), linux.class);
                intent.putExtra("matière", "Administration système");
                intent.putExtra("professeur", " Abdelkabir ROUAGUBI\n");
                startActivity(intent);
            }
        });
        API.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(getBaseContext(), API.class);
                intent.putExtra("matière", "API Design");
                intent.putExtra("professeur", "Hicham BAIDOURI");
                startActivity(intent);
            }
        });
        conteneurisation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(getBaseContext(), conteneurisation.class);
                intent.putExtra("matière", "conteneurisation des applications");
                intent.putExtra("professeur", "Driss ALLAKI");
                startActivity(intent);
            }
        });
        bigdata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(getBaseContext(), bigdata.class);
                intent.putExtra("matière", "big data et NoSQL");
                intent.putExtra("professeur", "Hamid EL GHAZI");
                startActivity(intent);
            }
        });
        DevOps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(getBaseContext(), DevOps.class);
                intent.putExtra("matière", "DevOps");
                intent.putExtra("professeur", "Asmaâ RETBI");
                startActivity(intent);
            }
        });


    }
    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "Activite est demarree", Toast.LENGTH_SHORT).show();
        Log.i("onStart():", "Activite est demarree");
    }
    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(this, "Activite est redemarree", Toast.LENGTH_SHORT).show();
        Log.i("onRestart():", "Activite est redemarree");
    }
    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "Activite est reprise", Toast.LENGTH_SHORT).show();
        Log.i("onResume():", "Activite est demarree");
    }
    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this, "Activite est en pause", Toast.LENGTH_SHORT).show();
        Log.i("onPause():", "Activite est en pause");
    }
    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this, "Activite est stoppee", Toast.LENGTH_SHORT).show();
        Log.i("onStop():", "Activite est stoppee");
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "Activite est detruite", Toast.LENGTH_SHORT).show();
        Log.i("onDestroy():", "Activity destroyed");
    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    public void sendNotification(View view) {
        NotificationChannel mChannel;
        int importance = NotificationManager.IMPORTANCE_DEFAULT;

        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this, "default");
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.rockstargames.com/gta-v"));
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        String CHANNEL_ID = "channel_1";
        mBuilder.setContentIntent(pendingIntent);
        mBuilder.setSmallIcon(R.drawable.ic_launcher_foreground);
        mBuilder.setContentTitle("ASEDS Student App");
        mBuilder.setContentText("ASA vous facitice la vie en tant que étudiant aseds");
        mChannel = new NotificationChannel(CHANNEL_ID, this.getString(R.string.app_name), importance);
        mChannel.setDescription("notification");

        NotificationManager mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        mNotificationManager.createNotificationChannel(mChannel);
        mBuilder.setChannelId(CHANNEL_ID);
        mNotificationManager.notify(001, mBuilder.build());
    }


}