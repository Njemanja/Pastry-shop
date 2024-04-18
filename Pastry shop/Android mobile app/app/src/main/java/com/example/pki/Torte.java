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

public class Torte extends AppCompatActivity {

    private Kolac[] kolaci;
    private Kolac[] filteredKolaci;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kolaci);

        kolaci = new Kolac[]{
                new Kolac("Torta sa čokoladom", 2500, "Najukusnija torta sa čokoladom i kinder buenom.", "čokolada, vanila fil, pavlaka za kuvanje, šećer, vanila, kinder čokolada", "torta1"),
                new Kolac("Jafa torta", 2500, "Najlepša jafa torta ikada.", "jafa keks, vanila fil, pavlaka za kuvanje, šećer, vanila, narandža", "torta2"),
                new Kolac("Dečija torta", 3500, "Dečija jednorog torta.", "keks, vanila fil, cokolaca, čokoladni fil, šećer", "torta3"),
                new Kolac("Voćna torta", 2000, "Najsvežija voćna torta u Beogradu.", "borovnoica,jagoda, vanila, narandza, čokolada, vanila fil, šećer", "torta4"),
                new Kolac("Nugat torta", 2700, "Čokoladna rapsodija ukusa sa fokusom na nugat.", "čokolada, kinder bueno, mars čokolada, bela čokolada, čokoladni fil, šećer", "torta5"),
                new Kolac("Šarena torta", 3100, "Šarena torta sa žele bombonama.", "žeče bombone, limun,fil od narandže, šećer, vanila", "torta6"),

        };

        filteredKolaci = Arrays.copyOf(kolaci, kolaci.length);

        displayKolaci();

        Button sortNiyaButton = findViewById(R.id.niza);
        Button sortVisaButton = findViewById(R.id.visa);

        sortNiyaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Arrays.sort(filteredKolaci, new Comparator<Kolac>() {
                    @Override
                    public int compare(Kolac o1, Kolac o2) {
                        return Float.compare(o1.getCena(), o2.getCena());
                    }
                });
                displayKolaci();
            }
        });

        sortVisaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Arrays.sort(filteredKolaci, new Comparator<Kolac>() {
                    @Override
                    public int compare(Kolac o1, Kolac o2) {
                        return Float.compare(o2.getCena(), o1.getCena());
                    }
                });
                displayKolaci();
            }
        });

        EditText kolacText = findViewById(R.id.kolacText);
        kolacText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                searchKolaci(charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });
    }

    private void searchKolaci(String searchText) {
        if (searchText.isEmpty()) {
            filteredKolaci = Arrays.copyOf(kolaci, kolaci.length);
        } else {
            int count = 0;
            for (Kolac kolac : kolaci) {
                if (kolac.getIme().toLowerCase().contains(searchText.toLowerCase())) {
                    count++;
                }
            }

            filteredKolaci = new Kolac[count];
            int index = 0;
            for (Kolac kolac : kolaci) {
                if (kolac.getIme().toLowerCase().contains(searchText.toLowerCase())) {
                    filteredKolaci[index++] = kolac;
                }
            }
        }
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
                .setMessage("Cena: " + kolac.getCena() + " RSD\nOpis: " + kolac.getOpis() + "\nSastojci: " + kolac.getSastojci())
                .setPositiveButton("Zatvori", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .setNeutralButton("Prikaži više", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        saveKolacToLocalStorage(kolac);
                        dialog.dismiss();
                        proizvod();
                    }
                })
                .show();
    }

    private void saveKolacToLocalStorage(Kolac kolac) {
        SharedPreferences sharedPreferences = getSharedPreferences("KolaciPreferences", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("ime", kolac.getIme());
        editor.putString("slika", kolac.getSlikaHref());
        editor.putFloat("cena", kolac.getCena());
        editor.putString("opis", kolac.getOpis());
        editor.putString("sastojci", kolac.getSastojci());
        editor.putString("kljuc", kolac.getIme());
        editor.apply();
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
    public void proizvod() {
        Intent i= new Intent(this, Proizvod.class);
        startActivity(i);
        //finish();
    }
}