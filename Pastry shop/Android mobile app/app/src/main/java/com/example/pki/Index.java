package com.example.pki;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Index extends AppCompatActivity {

    private Handler handler = new Handler();
    private Runnable runnable;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);
        final ImageView imageView1 = findViewById(R.id.imageViewPromocija1);
        final ImageView imageView2 = findViewById(R.id.imageViewPromocija2);
        final ImageView imageView3 = findViewById(R.id.imageViewPromocija3);
        final TextView textView1 = findViewById(R.id.textViewPromocija1);
        final TextView textView2 = findViewById(R.id.textViewPromocija2);
        final TextView textView3 = findViewById(R.id.textViewPromocija3);
        String[] images = {"kolac1", "torta2", "kolac3", "torta1", "torta5", "kolac5"};
        String[] text = {"Mafini na 40% popusta!", "Uz jafa tortu, dobijate 50% popusta na sledeću porudžbinu!", "Uz svaki čokoladni tart, dobijate 3 voćna mafina gratis!", "Uz svaku čokoladnu tortu dobijate 3 mafina gratis!", "Torta na 50% popusta!", "Uz svaki mafin, dobijate 1 gratis!"};

        runnable = new Runnable() {
            int currentImageIndex = 0;

            @Override
            public void run() {
                switch (currentImageIndex) {
                    case 0:
                        imageView1.setImageResource(getResources().getIdentifier(images[0], "drawable", getPackageName()));
                        imageView2.setImageResource(getResources().getIdentifier(images[1], "drawable", getPackageName()));
                        imageView3.setImageResource(getResources().getIdentifier(images[2], "drawable", getPackageName()));

                        textView1.setText(text[0]);
                        textView2.setText(text[1]);
                        textView3.setText(text[2]);

                        currentImageIndex=1;
                        break;
                    case 1:

                        imageView1.setImageResource(getResources().getIdentifier(images[3], "drawable", getPackageName()));
                        imageView2.setImageResource(getResources().getIdentifier(images[4], "drawable", getPackageName()));
                        imageView3.setImageResource(getResources().getIdentifier(images[5], "drawable", getPackageName()));

                        textView1.setText(text[3]);
                        textView2.setText(text[4]);
                        textView3.setText(text[5]);
                        currentImageIndex=0;
                        break;
                }

                handler.postDelayed(this, 5000);
            }
        };

        handler.post(runnable);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }





    public void obavestenja(View view) {

        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle("Obaveštenja");
        builder.setMessage("* Prihvacena je narudzbina za cokoladnu tortu.\n* Odbijena je narudzbina za vocnu tortu.");
        builder.create();
        builder.show();
    }
    public void index(View view) {
        Intent i= new Intent(this, Index.class);
        startActivity(i);
        finish();
    }
    public void torte(View view) {
        Intent i= new Intent(this, Torte.class);
        startActivity(i);
        finish();
    }
    public void kolaci(View view) {
        Intent i= new Intent(this, Kolaci.class);
        startActivity(i);
        finish();
    }
    public void promocija(View view) {
        Intent i= new Intent(this, Promocije.class);
        startActivity(i);
        finish();
    }
    public void korpa(View view) {
        Intent i= new Intent(this, Korpa.class);
        startActivity(i);
        finish();
    }
    public void profil(View view) {
        Intent i= new Intent(this, Profil.class);
        startActivity(i);
        finish();
    }
    public void odjava(View view) {
        Intent i= new Intent(this, MainActivity.class);
        startActivity(i);
        finish();
    }

}