/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/* UWAGA -> DOPISAĆ CUSTOM BINDINGS - jest w tresci o tym */
package my.projekt1;

/**
 *
 * @author skiline11
 */
public class Farba {
    private String kolor;
    private float toksycznosc, jakosc;

    public Farba(String kolor, float toksycznosc, float jakosc) {
        this.kolor = kolor;
        this.toksycznosc = toksycznosc;
        this.jakosc = jakosc;
    }
    
    public String getKolor() { return this.kolor; }
    public float getToksycznosc() { return this.toksycznosc; }
    public float getJakosc() { return this.jakosc; }
    
    public void dodajPigment(Pigment pigment)
    {
        System.out.println("Jestem w funkcji dodajPigment");
        this.kolor = pigment.getKolor_Kon();
        if(pigment.getCzy_mnoznik_toksycznosci()) this.toksycznosc *= pigment.getWsp_toksycznosci();
        else this.toksycznosc += pigment.getWsp_toksycznosci();
        if(this.toksycznosc > 100) this.toksycznosc = 100;
        else if(this.toksycznosc < 0) this.toksycznosc = 0;
        
        if(pigment.getCzy_mnoznik_jakosc()) this.jakosc *= pigment.getWplyw_na_jakosc();
        else this.jakosc += pigment.getWplyw_na_jakosc();
        if(this.jakosc > 100) this.jakosc = 100;
        else if(this.jakosc < 0) this.jakosc = 0;
    }
}
