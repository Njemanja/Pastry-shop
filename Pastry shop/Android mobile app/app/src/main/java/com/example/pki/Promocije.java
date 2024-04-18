package com.example.pki;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.Arrays;
import java.util.Comparator;

public class Promocije extends AppCompatActivity {

    private Kolac[] kolaci;
    private Kolac[] filteredKolaci;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_promocije);


        kolaci = new Kolac[]{
                new Kolac("", 150, "Mafini na 40% popusta!", "", "kolac1"),
                new Kolac("", 2200, "Uz jafa tortu, dobijate 50% popusta na sledeću porudžbinu!", "Čokolada, narandza, cokoladni fil, šećer, vanila", "torta2"),
                new Kolac("", 3200, "Uz svaki čokoladni tart, dobijate 3 voćna mafina gratis!", "", "kolac3"),
                new Kolac("", 2900, "Uz svaku čokoladnu tortu dobijate 3 mafina gratis!", "", "torta1"),
                new Kolac("", 1500, "Torta na 50% popusta!", "", "torta5"),
                new Kolac("", 420, "Uz svaki mafin, dobijate 1 gratis!", "", "kolac5"),


        };

        filteredKolaci = Arrays.copyOf(kolaci, kolaci.length);

        displayKolaci();

    }


    private void displayKolaci() {
        LinearLayout layout = findViewById(R.id.kolaciLayout);
        layout.removeAllViews();

        for (Kolac kolac : filteredKolaci) {
            ImageView imageView = new ImageView(this);
            int resId = getResources().getIdentifier(kolac.getSlikaHref(), "drawable", getPackageName());
            imageView.setImageResource(resId);
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    showKolacDialog(kolac);
                }
            });
            layout.addView(imageView);
        }
    }

    private void showKolacDialog(Kolac kolac) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(kolac.getIme())
                .setMessage(kolac.getOpis()+"\nCena: " + kolac.getCena() + " RSD")
                .setPositiveButton("Zatvori", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                }).show();
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
        //finish();
    }
    public void torte(View view) {
        Intent i= new Intent(this, Torte.class);
        startActivity(i);
        //finish();
    }
    public void kolaci(View view) {
        Intent i= new Intent(this, Kolaci.class);
        startActivity(i);
        //finish();
    }
    public void promocija(View view) {
        Intent i= new Intent(this, Promocije.class);
        startActivity(i);
        //finish();
    }
    public void korpa(View view) {
        Intent i= new Intent(this, Korpa.class);
        startActivity(i);
        //finish();
    }
    public void profil(View view) {
        Intent i= new Intent(this, Profil.class);
        startActivity(i);
        //finish();
    }
    public void odjava(View view) {
        Intent i= new Intent(this, MainActivity.class);
        startActivity(i);
        //finish();
    }
}