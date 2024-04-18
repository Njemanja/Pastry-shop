package com.example.pki;


import android.content.Context;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.content.SharedPreferences;

public class Proizvod extends AppCompatActivity {
    private int prikazaniKomentari = 2;
    private Kolac[] kolaci;
    private TextView komentariTextView;
    private EditText noviKomentarEditText;

    private String[] komentari= new String[]{
        "Super slatkis.", "Jako ukusna poslastica. Sve preporuke.", "Bas lepo!", "Skupo!"
    };
    private void dodajItemUKorpu() {
        Item[] items;
        SharedPreferences sharedPreferences;
        sharedPreferences = getSharedPreferences("Counter", Context.MODE_PRIVATE);

        int itemCount = sharedPreferences.getInt("cnt", 0);
        items = new Item[itemCount];
        for (int i = 0; i < itemCount; i++) {
            String itemName = sharedPreferences.getString("itemName" + i, "");
            int itemQuantity = sharedPreferences.getInt("itemQuantity" + i, 0);
            items[i] = new Item(itemName, itemQuantity);
        }


        Item[] noviNiz = new Item[items.length + 1];
        String slika = getSharedPreferences("KolaciPreferences", Context.MODE_PRIVATE).getString("slika", "");
        noviNiz[0] = new Item(slika,1);


        for (int i = 1; i < noviNiz.length; i++) {
            noviNiz[i] = items[i - 1];
        }
        items=noviNiz;


        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("cnt", items.length);
        for (int i = 0; i < items.length; i++) {
            editor.putString("itemName" + i, items[i].getName());
            editor.putInt("itemQuantity" + i, items[i].getQuantity());
        }
        editor.apply();
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle("Obaveštenje");
        builder.setMessage("Uspesno ste dodali u korpu!");
        builder.create();
        builder.show();

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proizvod);

        kolaci = new Kolac[]{
                new Kolac("Mafini", 1500, "Najukusnija mafini sa cokoladom i vanilom ikada.", "Čokolada, brašno, šećer, vanila", "kolac1"),
                new Kolac("Mafini", 1500, "Najukusnija mafini sa cokoladom i vanilom ikada.", "Čokolada, brašno, šećer, vanila", "kolac1"),
                new Kolac("Krofne", 200, "Sveže krofne.", "Čokolada, brašno, šećer.", "kolac2"),
                new Kolac("Krofne", 200, "Sveže krofne.", "Čokolada, brašno, šećer.", "kolac2"),
                new Kolac("Mafini sa makom", 200, "Sveže mafine sa makom.", "Čokolada, brašno, šećer, mak", "slika6"),
                new Kolac("Mafini sa makom", 200, "Sveže mafine sa makom.", "Čokolada, brašno, šećer, mak", "slika6"),

        };

        ImageView korpaImageView = findViewById(R.id.heart);
        korpaImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Dodavanje itema u korpu
                dodajItemUKorpu();
            }
        });
        komentariTextView = findViewById(R.id.komentariTextView);

        prikaziInicijalneKomentare();

        // Dodajte ClickListener za prikazivanje dodatnih komentara
        findViewById(R.id.prikaziViseButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                prikaziDodatneKomentare();
            }
        });



        // Dodajte ClickListener za dugme "Pošalji"
        Button posaljiKomentarButton = findViewById(R.id.posaljiKomentarButton);
        posaljiKomentarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                posaljiNoviKomentar();
            }
        });

        // Retrieve data from SharedPreferences
        SharedPreferences sharedPreferences = getSharedPreferences("KolaciPreferences", Context.MODE_PRIVATE);
        String ime = sharedPreferences.getString("ime", "");
        float cena = sharedPreferences.getFloat("cena", 0.0f);
        String opis = sharedPreferences.getString("opis", "");
        String sastojci = sharedPreferences.getString("sastojci", "");
        String slika = sharedPreferences.getString("slika", "");

        TextView imeTextView = findViewById(R.id.imeTextView);
        TextView cenaTextView = findViewById(R.id.cenaTextView);
        TextView opisTextView = findViewById(R.id.opisTextView);
        TextView sastojciTextView = findViewById(R.id.sastojciTextView);
        ImageView slikaImageView = findViewById(R.id.slikaImageView); // Dodajte ImageView u XML


        imeTextView.setText(ime);
        cenaTextView.setText("Cena: " + cena);
        opisTextView.setText(opis);
        sastojciTextView.setText(sastojci);

        int resId = getResources().getIdentifier(slika, "drawable", getPackageName());
        slikaImageView.setImageResource(resId);

    }


    private void prikaziInicijalneKomentare() {
        StringBuilder komentariText = new StringBuilder("");
        for (int i = 0; i < Math.min(prikazaniKomentari, komentari.length); i++) {
            String komentar = komentari[i];
            if (i % 2 == 0) {
                komentariText.append(komentar).append(" \t- Ana 25.7.2023.").append("\n");
            } else {
                komentariText.append(komentar).append(" - Nikola 24.4.2022.").append("\n");
            }

        }
        komentariTextView.setText(komentariText.toString());
    }
    private void prikaziDodatneKomentare() {
        prikazaniKomentari += 2; // Dodajte još dva komentara
        prikaziInicijalneKomentare();
    }

    private void posaljiNoviKomentar() {
        noviKomentarEditText=findViewById(R.id.noviKomentarEditText);
        String s=noviKomentarEditText.getText().toString();
        StringBuilder komentariText = new StringBuilder("");
        komentariText.append(s);


        String[] noviNiz = new String[komentari.length + 1];
        noviNiz[0] = komentariText.toString();

        for (int i = 1; i < noviNiz.length; i++) {
            noviNiz[i] = komentari[i - 1];
        }
        komentari=noviNiz;

        prikaziInicijalneKomentare();
        noviKomentarEditText.setText("");
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

