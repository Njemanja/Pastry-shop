package com.example.pki;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void prijava(View view){
        EditText ime= findViewById(R.id.kor_ime);
        EditText lozinka= findViewById(R.id.lozinka);
        if(ime.getText().toString().equals("ana") && lozinka.getText().toString().equals("ana")){
            saveUserDetails("ana", "Ana", "Jankovic", "ana@etf.rs", "Majska 28", "0648756987", "ana");
            Intent i= new Intent(this, Index.class);
            startActivity(i);

        }else{
            AlertDialog.Builder builder=new AlertDialog.Builder(this);
            builder.setTitle("Obaveštenje");
            builder.setMessage("Podaci nisu uneti ili nisu ispravni!");
            builder.create();
            builder.show();
        }


    }
    private void saveUserDetails(String username, String firstName, String lastName, String email, String address, String phoneNumber, String password) {
        SharedPreferences sharedPreferences = getSharedPreferences("UserDetailsPreferences", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("username", username);
        editor.putString("firstName", firstName);
        editor.putString("lastName", lastName);
        editor.putString("email", email);
        editor.putString("address", address);
        editor.putString("phoneNumber", phoneNumber);
        editor.putString("password", password);
        editor.apply();
    }
}