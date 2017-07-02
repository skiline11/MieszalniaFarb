/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.projekt1;

/**
 *
 * @author skiline11
 */
public class Pigment {
    private String nazwa, kolor_pocz, kolor_kon;
    private float wsp_toksycznosci, wplyw_na_jakosc;
    private boolean czy_mnoznik_toksycznosc = false, czy_mnoznik_jakosc = false;

    public Pigment(String nazwa, String kolor_pocz, String kolor_kon, char znak_toksycznosc, float wsp_toksycznosci, char znak_jakosc, float wplyw_na_jakosc) {
        
        this.nazwa = nazwa;
        this.kolor_pocz = kolor_pocz;
        this.kolor_kon = kolor_kon;
        
        this.czy_mnoznik_toksycznosc = false;
        this.wsp_toksycznosci = wsp_toksycznosci;
        if(znak_toksycznosc == '-') this.wsp_toksycznosci *= (-1);
        else if(znak_toksycznosc == 'x') this.czy_mnoznik_toksycznosc = true;
        
        this.czy_mnoznik_jakosc = false;
        this.wplyw_na_jakosc = wplyw_na_jakosc;
        if(znak_jakosc == '-') this.wplyw_na_jakosc *= (-1);
        else if(znak_jakosc == 'x') this.czy_mnoznik_jakosc = true;
    }
    
    public String getNazwa()
    {
        return this.nazwa;
    }
    
    public String getNazwaDoTabeli()
    {
        String wynik = "Nazwa(" + this.nazwa + "), Pocz(" + this.kolor_pocz + "), Kon(" + this.kolor_kon + "), toksycznosc(";
        if(this.czy_mnoznik_toksycznosc) wynik += "x";
        else if(this.wsp_toksycznosci > 0) wynik += '+';
        wynik += this.wsp_toksycznosci + "), jakosc(";
        if(this.czy_mnoznik_jakosc) wynik += "x";
        else if(this.wplyw_na_jakosc > 0) wynik += '+';
        wynik += this.wplyw_na_jakosc + ")";
        return wynik;
    }
    
    public String getKolor_Pocz() { return this.kolor_pocz; }
    public String getKolor_Kon() { return this.kolor_kon; }
    public float getWsp_toksycznosci() { return this.wsp_toksycznosci; }
    public float getWplyw_na_jakosc() { return this.wplyw_na_jakosc; }
    public boolean getCzy_mnoznik_toksycznosci() {return this.czy_mnoznik_toksycznosc; }
    public boolean getCzy_mnoznik_jakosc() { return this.czy_mnoznik_jakosc; }
}
