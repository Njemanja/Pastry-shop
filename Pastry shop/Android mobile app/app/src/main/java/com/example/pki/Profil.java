package com.example.pki;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Profil extends AppCompatActivity {

    private static final String PREFS_NAME = "UserDetailsPreferences";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);
        displayUserDetails();
    }

    private void displayUserDetails() {
        SharedPreferences sharedPreferences = getSharedPreferences("UserDetailsPreferences", Context.MODE_PRIVATE);
        EditText korimeEditText = findViewById(R.id.korimeEditText);
        korimeEditText.setText(sharedPreferences.getString("username", ""));

        EditText imeEditText = findViewById(R.id.imeEditText);
        imeEditText.setText(sharedPreferences.getString("firstName", ""));

        EditText prezimeEditText = findViewById(R.id.prezimeEditText);
        prezimeEditText.setText(sharedPreferences.getString("lastName", ""));

        EditText emailEditText = findViewById(R.id.emailEditText);
        emailEditText.setText(sharedPreferences.getString("email", ""));

        EditText adresaEditText = findViewById(R.id.adresaEditText);
        adresaEditText.setText(sharedPreferences.getString("address", ""));

        EditText telefonEditText = findViewById(R.id.telefonEditText);
        telefonEditText.setText(sharedPreferences.getString("phoneNumber", ""));

        EditText lozinkaEditText = findViewById(R.id.lozinkaEditText);
        lozinkaEditText.setText(sharedPreferences.getString("password", ""));

        EditText lozinkaEditText1 = findViewById(R.id.lozinkaEditText1);
        lozinkaEditText1.setText(sharedPreferences.getString("password", ""));

    }
    public void saveUserData(View view) {
        EditText korisnickoImeEditText = findViewById(R.id.korimeEditText);
        EditText imeEditText = findViewById(R.id.imeEditText);
        EditText prezimeEditText = findViewById(R.id.prezimeEditText);
        EditText emailEditText = findViewById(R.id.emailEditText);
        EditText adresaEditText = findViewById(R.id.adresaEditText);
        EditText telefonEditText = findViewById(R.id.telefonEditText);
        EditText lozinkaEditText = findViewById(R.id.lozinkaEditText);
        EditText lozinkaEditText1 = findViewById(R.id.lozinkaEditText1);

        String korisnickoIme=korisnickoImeEditText.getText().toString();
        String ime = imeEditText.getText().toString();
        String prezime = prezimeEditText.getText().toString();
        String email = emailEditText.getText().toString();
        String adresa = adresaEditText.getText().toString();
        String telefon = telefonEditText.getText().toString();
        String lozinka = lozinkaEditText.getText().toString();
        String lozinka1 = lozinkaEditText1.getText().toString();

        if (korisnickoIme.isEmpty()|| ime.isEmpty() || prezime.isEmpty() || email.isEmpty() || adresa.isEmpty() || telefon.isEmpty() || lozinka.isEmpty() || lozinka1.isEmpty()) {
            Toast.makeText(this, "Molimo Vas da popunite sva polja.", Toast.LENGTH_SHORT).show();
            return;
        }

        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            Toast.makeText(this, "Unesite ispravan email.", Toast.LENGTH_SHORT).show();
            return;
        }

        if (!android.util.Patterns.PHONE.matcher(telefon).matches()) {
            Toast.makeText(this, "Unesite ispravan telefon.", Toast.LENGTH_SHORT).show();
            return;
        }

        if (!lozinka.equals(lozinka1)) {
            Toast.makeText(this, "Lozinke se ne podudaraju.", Toast.LENGTH_SHORT).show();
            return;
        }

        SharedPreferences.Editor editor = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE).edit();
        editor.putString("username", korisnickoIme);
        editor.putString("firstName", ime);
        editor.putString("lastName", prezime);
        editor.putString("email", email);
        editor.putString("address", adresa);
        editor.putString("phoneNumber", telefon);
        editor.putString("password", lozinka);
        editor.apply();

        Toast.makeText(this, "Podaci su uspešno sačuvani.", Toast.LENGTH_SHORT).show();
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


    public void odjava(View view) {
        Intent i= new Intent(this, MainActivity.class);
        startActivity(i);
        //finish();
    }

}