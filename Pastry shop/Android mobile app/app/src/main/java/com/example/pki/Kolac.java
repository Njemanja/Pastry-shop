package com.example.pki;

public class Kolac {
    private String ime;
    private double cena;
    private String opis;
    private String sastojci;
    private String slikaHref;

    public Kolac(String ime, double cena, String opis, String sastojci, String slikaHref) {
        this.ime = ime;
        this.cena = cena;
        this.opis = opis;
        this.sastojci = sastojci;
        this.slikaHref = slikaHref;
    }

    // Dodajte getter metode po potrebi
    public String getIme() {
        return ime;
    }

    public float getCena() {
        return (float)cena;
    }

    public String getOpis() {
        return opis;
    }

    public String getSastojci() {
        return sastojci;
    }

    public String getSlikaHref() {
        return slikaHref;
    }
}
