/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.projekt1;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author skiline11
 */
public class MojaMaszyna implements Maszyna
{
    private File def_farb;
    private File def_pigmentow;
    
    private List<Farba> lista_farb; 
    private List<String> lista_nazw_farb;
    private List<Pigment> lista_pigmentow;
    private List<String> lista_nazw_pigmentow;
    private List<String> lista_nazw_pigmentow_do_tabeli;
    
    Random rand = new Random();
    
    public void ustawFarby()
    {   
        try {
            List<String> linijki_pliku = Files.readAllLines(def_farb.toPath(), Charset.defaultCharset());
            for(String linijka : linijki_pliku)
            {
                String[] slowa = linijka.split(" ");
                if(slowa.length != 3) throw new IllegalArgumentException("Brak 3 argumentow w pewnej linijce w pliku def_farb");
                float toksycznosc = Integer.valueOf(slowa[1]);
                float jakosc = Integer.valueOf(slowa[2]);
                if(Character.isLetter(slowa[0].charAt(0)) == false)
                {
                    throw new IllegalArgumentException("Nazwa pewnej farby w pliku def_farb nie zaczyna sie od litery");
                }
                for(char c : slowa[0].toCharArray())
                {
                    if(Character.isLetter(c) == false && Character.isDigit(c) == false && c != '-')
                    {
                        throw new IllegalArgumentException("Nazwa pewnej farby zawiera niedozwolony znak");
                    }
                }
                if(toksycznosc < 0 || toksycznosc > 100 || jakosc < 0 || jakosc > 100)
                {
                    throw new IllegalArgumentException("Nie poprawne wartosci toksycznosci lub jakosci w pliku def_farb");
                }
                Farba farba = new Farba(slowa[0], toksycznosc, jakosc);
                lista_farb.add(farba);
                if(lista_nazw_farb.contains(farba.getKolor()))
                {
                    throw new IllegalArgumentException("Nazwy farb w pliku def_farb nie są unikalne");
                }
                lista_nazw_farb.add(farba.getKolor());
            }
        } catch (IOException ex) {
            Logger.getLogger(MaszynaDoProdukcjiFarb.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Brak pliku def_farb");
            JOptionPane.showMessageDialog(null, "Brak pliku def_farb");
            System.exit(0);
        } catch(NumberFormatException e)
        {
            System.err.println("Wczytywanie farb zakonczone niepowodzeniem. Sprawdz definicje farb");
            JOptionPane.showMessageDialog(null, "Wczytywanie farb zakonczone niepowodzeniem. Sprawdz definicje farb");
            System.exit(0);
        } catch(IllegalArgumentException e)
        {
            System.err.println(e.getMessage());
            JOptionPane.showMessageDialog(null, e);
            System.exit(0);
        }
    }
    
    public void ustawPigmenty()
    {
        try {
            List<String> linijki_pliku = Files.readAllLines(def_pigmentow.toPath(), Charset.defaultCharset());
            for(String linijka : linijki_pliku)
            {
                String[] tab = linijka.split(" ");
                if(tab.length != 7) throw new IllegalArgumentException("Brak 7 argumentow w pewnej linijce pliku def_pigmentow");
                String nazwa_pigmentu = tab[0];
                String kolor_pocz = tab[1];
                String kolor_kon = tab[2];
                char znak_toks = tab[3].charAt(0);
                float toks = Float.valueOf(tab[4]);
                char znak_jakosci = tab[5].charAt(0);
                float jakosc = Float.valueOf(tab[6]);
                
                for(char c : tab[0].toCharArray())
                {
                    if(Character.isLetter(c) == false && Character.isDigit(c) == false)
                    {
                        throw new IllegalArgumentException("Nazwa pewnego pigmentu zawiera niedozwolony znak");
                    }
                }
                
                Pigment pigment = new Pigment(nazwa_pigmentu, kolor_pocz, kolor_kon, znak_toks, toks, znak_jakosci, jakosc);
                if(znak_toks != '+' && znak_toks != '-' && znak_toks != 'x') throw new NumberFormatException();
                if(znak_jakosci != '+' && znak_jakosci != '-' && znak_jakosci != 'x') throw new NumberFormatException();
                if(toks < 0 || toks > 100 || jakosc < 0 || jakosc > 100) throw new NumberFormatException();
                
                lista_pigmentow.add(pigment);
                if(lista_nazw_farb.contains(pigment.getNazwa())) throw new IllegalArgumentException("Nazwy pigmentow nie są unikalne");
                lista_nazw_pigmentow.add(pigment.getNazwa());
                lista_nazw_pigmentow_do_tabeli.add(pigment.getNazwaDoTabeli());
            }
        } catch (IOException ex) {
            Logger.getLogger(MaszynaDoProdukcjiFarb.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Brak bliku def_pigmentow");
            JOptionPane.showMessageDialog(null, "Brak bliku def_pigmentow");
            System.exit(0);
        } catch(NumberFormatException e)
        {
            System.err.println("Wczytywanie pigmentow zakonczone niepowodzeniem. Sprawdz definicje pigmentow");
            JOptionPane.showMessageDialog(null, "Wczytywanie pigmentow zakonczone niepowodzeniem. Sprawdz definicje pigmentow");
            System.exit(0);
        } catch(IllegalArgumentException e)
        {
            System.err.println(e.getMessage());
            JOptionPane.showMessageDialog(null, e);
            System.exit(0);
        }
    }
    
    public MojaMaszyna()
    {
//        System.out.println("Tworze sie");
        this.lista_farb = new ArrayList<>();
        this.lista_nazw_farb = new ArrayList<>();
        this.lista_pigmentow = new ArrayList<>();
        this.lista_nazw_pigmentow = new ArrayList<>();
        this.lista_nazw_pigmentow_do_tabeli = new ArrayList<>();
        
        File configuracja = new File("src/my/projekt1/maszyna.conf");
        if(configuracja.isFile())
        {
            try
            {
                List<String> linijki_pliku = Files.readAllLines(configuracja.toPath(), Charset.defaultCharset());
                if(linijki_pliku.size() != 2) throw new IllegalArgumentException("Nie poprawna ilosc linijek w pliku maszyna.conf");
                this.def_farb = new File(linijki_pliku.get(0));
                this.def_pigmentow = new File(linijki_pliku.get(1));
            }catch(IOException e)
            {
                System.err.println("Problem przy czytaniu pliku maszyna.conf");
                JOptionPane.showMessageDialog(null, "Problem przy czytaniu pliku maszyna.conf");
                System.exit(0);
            }
        }
        else
        {
            System.err.println("Brak pliku maszyna.conf w folderze z którego uruchomiono aplikacje");
            JOptionPane.showMessageDialog(null, "Brak pliku maszyna.conf w folderze z którego uruchomiono aplikacje");
            System.exit(0);
        }
        
        if(this.def_farb.isFile() == false || this.def_pigmentow.isFile() == false)
        {
            System.err.println("Brak pliku def_farb lub def_pigmentow w wskazanym miejscu przez maszyna.conf . Sprawdz lokalizacje plikow.");
            JOptionPane.showMessageDialog(null, "Brak pliku def_farb lub def_pigmentow w wskazanym miejscu przez maszyna.conf . Sprawdz lokalizacje plikow.");
            System.exit(0);
            
        }
//        System.out.println("Stworzylem sie");
        ustawFarby();
        ustawPigmenty();
    }
    
    public String[] getTablicaNazwPigmentow()
    {
        String[] tablica = this.lista_nazw_pigmentow_do_tabeli.toArray(new String[lista_pigmentow.size()]);
        return tablica;
    }
    
    public String[] getTablicaNazwFarb()
    {
        return this.lista_nazw_farb.toArray(new String[lista_nazw_farb.size()]);
    }
    
    public Farba getFarba(int numer)
    {
        return this.lista_farb.get(numer);
    }
    
    public List<Farba> getListaFarb()
    {
        return this.lista_farb;
    }
    
    public Pigment getPigment(int numer)
    {
        return this.lista_pigmentow.get(numer);
    }
    
    public List<Pigment> getListaPigmentow()
    {
        return this.lista_pigmentow;
    }
    
    private String losujNazweFarby()
    {
        int dlugosc_nazwy = rand.nextInt(10) + 5;
        char[] nazwa = new char[dlugosc_nazwy];
        nazwa[0] = (char)(rand.nextInt(26) + 'a');
//        System.out.println(nazwa[0]);
        char znak;
        for(int i = 1; i < dlugosc_nazwy; i++)
        {
            int r = rand.nextInt(26 + 10 + 1);
            if(r < 26) znak = (char)(rand.nextInt(26) + 'a');
            else if(r < 36)
            {
                znak = (char)(rand.nextInt(10) + '0');
            }
            else znak = '-';
            nazwa[i] = znak;
        }
        return String.valueOf(nazwa);
    }
    
    private String losujNazwePigmentu() // to samo co dla farby tylko że bez myślnika
    {
        int dlugosc_nazwy = rand.nextInt(10) + 5;
        char[] nazwa = new char[dlugosc_nazwy];
        nazwa[0] = (char)(rand.nextInt(26) + 'a');
        System.out.println(nazwa[0]);
        char znak;
        for(int i = 1; i < dlugosc_nazwy; i++)
        {
            int r = rand.nextInt(26 + 10);
            if(r < 26) znak = (char)(rand.nextInt(26) + 'a');
            else
            {
                znak = (char)(rand.nextInt(10) + '0');
            }
            nazwa[i] = znak;
        }
        return String.valueOf(nazwa);
    }
    
    public void dodajLosowaFarbe()
    {
        // public Farba(String kolor, float toksycznosc, float jakosc)
        boolean jest_taka_nazwa = true;
        String nowa_nazwa = "";
        while(jest_taka_nazwa == true)
        {
            jest_taka_nazwa = false;
//            System.out.println("Przed losowaniem nazwy");
            nowa_nazwa = losujNazweFarby();
//            System.out.println("Po losowaniu nazwy, nazwa = " + nowa_nazwa);
            for(String nazwa : lista_nazw_farb)
            {
                if(nazwa.equals(nowa_nazwa)) jest_taka_nazwa = true;
            }
//            System.out.println("Czy jest taka nazwa : " + jest_taka_nazwa);
        }
        float toksycznosc = rand.nextInt(101);
        float jakosc = rand.nextInt(101);
        Farba farba = new Farba(nowa_nazwa, toksycznosc, jakosc);
        this.lista_farb.add(farba);
        this.lista_nazw_farb.add(nowa_nazwa);  
    }
    
    public void dodajFarbe(Farba farba)
    {
        int numer_do_usuniecia = -1;
        int numer = 0;
        for(String nazwa : lista_nazw_farb)
        {
            if(nazwa.equals(farba.getKolor())) numer_do_usuniecia = numer;
            numer++;
        }
        
        if(numer_do_usuniecia != -1)
        {
            this.lista_farb.remove(numer_do_usuniecia);
            this.lista_nazw_farb.remove(numer_do_usuniecia);
            
        }
        this.lista_farb.add(farba);
        this.lista_nazw_farb.add(farba.getKolor());
        
    }
    
    public void usunFarbe(int numer)
    {
        this.lista_farb.remove(numer);
        this.lista_nazw_farb.remove(numer);
    }
    
    public void dodajLosowyPigment()
    {
        boolean jest_taka_nazwa = true;
        String nowa_nazwa = "";
        while(jest_taka_nazwa == true)
        {
            jest_taka_nazwa = false;
//            System.out.println("Przed losowaniem nazwy");
            nowa_nazwa = losujNazwePigmentu();
//            System.out.println("Po losowaniu nazwy, nazwa = " + nowa_nazwa);
            for(String nazwa : lista_nazw_pigmentow)
            {
                if(nazwa.equals(nowa_nazwa)) jest_taka_nazwa = true;
            }
//            System.out.println("Czy jest taka nazwa : " + jest_taka_nazwa);
        }
        String farba_pocz = this.lista_nazw_farb.get(rand.nextInt(this.lista_nazw_farb.size()));
        String farba_kon = this.lista_nazw_farb.get(rand.nextInt(this.lista_nazw_farb.size()));
        float toksycznosc, jakosc;
        char znak_toks;
        // aby prawdopodobiensto wiekszych liczb przy mnozeniu bylo mniejsze, to będe 100 przez liczbe
        if(rand.nextInt(2) == 0)
        {
            znak_toks = 'x';
            toksycznosc = 100/(11 + rand.nextFloat()*190);
        }
        else
        {
            znak_toks = '+';
            toksycznosc = rand.nextFloat()*100%100 - 50;
        }
        char znak_jakosci;
        if(rand.nextInt(2) == 0)
        {
            znak_jakosci = 'x';
            jakosc = 100/(11 + rand.nextFloat()*190);
        }
        else
        {
            znak_jakosci = '+';
            jakosc = rand.nextFloat()*100%100 - 50;
        }
        // Prowizoryczne formatowanie do 2 liczb po przecinku :-)
        toksycznosc = (toksycznosc*100 - toksycznosc*100%1)/100;
        jakosc = (jakosc*100 - jakosc*100%1)/100;
        Pigment pigment = new Pigment(nowa_nazwa, farba_pocz, farba_kon, znak_toks, toksycznosc, znak_jakosci, jakosc);
        dodajPigment(pigment);
    }
    
    public void dodajPigment(Pigment pigment)
    {
        this.lista_pigmentow.add(pigment);
        this.lista_nazw_pigmentow.add(pigment.getNazwa());
        this.lista_nazw_pigmentow_do_tabeli.add(pigment.getNazwaDoTabeli());
    }
    
    public void usunPigment(int numer)
    {
        this.lista_pigmentow.remove(numer);
        this.lista_nazw_pigmentow.remove(numer);
        this.lista_nazw_pigmentow_do_tabeli.remove(numer);
    }
}
