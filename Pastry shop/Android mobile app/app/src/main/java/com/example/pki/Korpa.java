// Korpa.java
package com.example.pki;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Korpa extends AppCompatActivity {

    private Item[] items;
    private SharedPreferences sharedPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_korpa);
        loadItems();

        /*items = new Item[]{
                new Item("kolac1", 1),
                new Item("kolac2", 1)
        };*/

        LinearLayout korpaLayout = findViewById(R.id.korpaLayout);

        for (Item item : items) {
            LinearLayout itemLayout = new LinearLayout(this);
            itemLayout.setOrientation(LinearLayout.VERTICAL);
            itemLayout.setGravity(Gravity.CENTER_HORIZONTAL);

            ImageView imageView = new ImageView(this);
            int resID = getResources().getIdentifier(item.getName(), "drawable", getPackageName());
            imageView.setImageResource(resID);
            LinearLayout.LayoutParams imageParams = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            );
            imageParams.setMargins(10, 10, 10, 10);
            imageView.setLayoutParams(imageParams);

            LinearLayout buttonLayout = new LinearLayout(this);
            buttonLayout.setOrientation(LinearLayout.HORIZONTAL);
            buttonLayout.setGravity(Gravity.CENTER_HORIZONTAL);

            LinearLayout.LayoutParams buttonParams = new LinearLayout.LayoutParams(100, 100);

            ImageButton addButton = new ImageButton(this);
            addButton.setImageResource(R.drawable.plus);
            addButton.setScaleType(ImageView.ScaleType.FIT_CENTER);
            addButton.setLayoutParams(buttonParams);

            ImageButton deleteButton = new ImageButton(this);
            deleteButton.setImageResource(R.drawable.trash);
            deleteButton.setScaleType(ImageView.ScaleType.FIT_CENTER);
            deleteButton.setLayoutParams(buttonParams);

            ImageButton removeButton = new ImageButton(this);
            removeButton.setImageResource(R.drawable.minus);
            removeButton.setScaleType(ImageView.ScaleType.FIT_CENTER);
            removeButton.setLayoutParams(buttonParams);

            buttonLayout.addView(addButton);
            buttonLayout.addView(deleteButton);
            buttonLayout.addView(removeButton);

            TextView quantityTextView = new TextView(this);
            quantityTextView.setText(String.valueOf(item.getQuantity()));
            quantityTextView.setGravity(Gravity.CENTER);
            quantityTextView.setTextSize(20);

            itemLayout.addView(imageView);
            itemLayout.addView(buttonLayout);
            itemLayout.addView(quantityTextView);

            korpaLayout.addView(itemLayout);

            // Dodajte akcije nakon dodavanja elemenata u roditeljski layout
            addButton.setOnClickListener(v -> {
                item.inc();
                updateQuantityTextView(quantityTextView, item);
                saveItems();
            });

            deleteButton.setOnClickListener(v -> {
                korpaLayout.removeView(itemLayout);
                int indexToRemove = -1;
                for (int i = 0; i < items.length; i++) {
                    if (items[i].getName().equals(item.getName())) {
                        indexToRemove = i;
                        break;
                    }
                }

                if (indexToRemove != -1) {
                    Item[] newArray = new Item[items.length - 1];
                    System.arraycopy(items, 0, newArray, 0, indexToRemove);
                    System.arraycopy(items, indexToRemove + 1, newArray, indexToRemove, items.length - indexToRemove - 1);
                    items = newArray;

                }                 saveItems();
            });

            removeButton.setOnClickListener(v -> {
                if(item.getQuantity()>0){
                    item.dec();
                    updateQuantityTextView(quantityTextView, item);
                    saveItems();
                }

            });
        }
    }



    private void loadItems() {
        sharedPreferences = getSharedPreferences("Counter", Context.MODE_PRIVATE);

        int itemCount = sharedPreferences.getInt("cnt", 0);
        items = new Item[itemCount];
       for (int i = 0; i < itemCount; i++) {
            String itemName = sharedPreferences.getString("itemName" + i, "");
            int itemQuantity = sharedPreferences.getInt("itemQuantity" + i, 0);
            items[i] = new Item(itemName, itemQuantity);
        }
    }

    private void saveItems() {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("cnt", items.length);
        for (int i = 0; i < items.length; i++) {
            editor.putString("itemName" + i, items[i].getName());
            editor.putInt("itemQuantity" + i, items[i].getQuantity());
        }
        editor.apply();
    }
    public void poruci(View view) {
        LinearLayout korpaLayout = findViewById(R.id.korpaLayout);
        korpaLayout.removeAllViews();
        items = new Item[0];
        saveItems();
    }
    private void updateQuantityTextView(TextView quantityTextView, Item item) {
        quantityTextView.setText(String.valueOf(item.getQuantity()));
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
