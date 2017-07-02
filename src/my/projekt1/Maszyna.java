/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.projekt1;

import java.util.List;

/**
 *
 * @author skiline11
 */
public interface Maszyna {
    public void ustawFarby();
    public void ustawPigmenty();
    
    public String[] getTablicaNazwPigmentow();
    public String[] getTablicaNazwFarb();
    public Farba getFarba(int numer);
    public List<Farba> getListaFarb();
    public Pigment getPigment(int numer);
    public List<Pigment> getListaPigmentow();
    
    public void dodajLosowaFarbe();
    public void dodajFarbe(Farba f);
    public void usunFarbe(int numer);
    
    public void dodajLosowyPigment();
    public void dodajPigment(Pigment p);
    public void usunPigment(int numer);
}
