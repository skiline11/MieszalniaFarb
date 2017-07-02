/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.projekt1;

import java.awt.Color;
import java.io.File;
//import java.io.IOException;
//import java.nio.charset.Charset;
//import java.nio.file.Files;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.logging.Level;
//import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author skiline11
 */
public class MaszynaDoProdukcjiFarb extends javax.swing.JFrame {
    private String[] poczatkowa_tablica_nazw_farb;
    private String[] poczatkowa_tablica_nazw_pigmentow;
    
    private Maszyna maszyna;
    
    Farba aktualnie_wybrana_farba;
    Farba aktualnie_wybrana_farba_do_edycji;
    Pigment aktualnie_wybrany_pigment_do_edycji;
    int numer_farby_do_edycji;
    int numer_pigmentu_do_edycji;
    boolean czy_edycja_farby;
    boolean czy_rozpoczete_mieszanie = false;
    /**
     * Creates new form MaszynaDoProdukcjiFarb
     */
    
    public void ukryj_wszystkie_napisy()
    {
        napis_edycja.setVisible(false);
        napis_lewy_1.setVisible(false);
        napis_lewy_2.setVisible(false);
        napis_lewy_3.setVisible(false);
        pole_napisu_1.setVisible(false);
        pole_napisu_2.setVisible(false);
        pole_napisu_3.setVisible(false);
        napis_toksycznosc.setVisible(false);
        napis_jakosc.setVisible(false);
        pole_napisu_toksycznosc.setVisible(false);
        pole_napisu_jakosc.setVisible(false);
        jComboBox1.setVisible(false);
        jComboBox2.setVisible(false);
        
        pole_napisu_toksycznosc.setEditable(true);
        pole_napisu_jakosc.setEditable(true);
        
        Przycisk_zapisz.setVisible(false);
        Przycisk_uzyj_pigmentu.setEnabled(false);
    }
    
    public void pokaz_wybrana_farbe()
    {
        if(aktualnie_wybrana_farba == null)
        {
            ukryj_wszystkie_napisy();
            return;
        }
        napis_edycja.setVisible(true);
        napis_lewy_1.setVisible(true);
        napis_lewy_2.setVisible(true);
        napis_lewy_3.setVisible(true);
        pole_napisu_1.setVisible(true);
        pole_napisu_2.setVisible(true);
        pole_napisu_3.setVisible(true);
        napis_toksycznosc.setVisible(false);
        napis_jakosc.setVisible(false);
        pole_napisu_toksycznosc.setVisible(false);
        pole_napisu_jakosc.setVisible(false);
        jComboBox1.setVisible(false);
        jComboBox2.setVisible(false);
        
        napis_edycja.setText("Wybrana farba");
        napis_lewy_1.setText("kolor");
        napis_lewy_2.setText("toksycznosc");
        napis_lewy_3.setText("jakosc");
        
        pole_napisu_1.setText(aktualnie_wybrana_farba.getKolor());
        pole_napisu_2.setText(String.valueOf(aktualnie_wybrana_farba.getToksycznosc()));
        pole_napisu_3.setText(String.valueOf(aktualnie_wybrana_farba.getJakosc()));
        
        pole_napisu_1.setEditable(false);
        pole_napisu_2.setEditable(false);
        pole_napisu_3.setEditable(false);
        
        Przycisk_zapisz.setVisible(false);
    }
    
    public void pokaz_wybrana_farbe_do_edycji()
    {
        czy_edycja_farby = true;
        
        napis_edycja.setVisible(true);
        napis_lewy_1.setVisible(true);
        napis_lewy_2.setVisible(true);
        napis_lewy_3.setVisible(true);
        pole_napisu_1.setVisible(true);
        pole_napisu_2.setVisible(true);
        pole_napisu_3.setVisible(true);
        napis_toksycznosc.setVisible(false);
        napis_jakosc.setVisible(false);
        pole_napisu_toksycznosc.setVisible(false);
        pole_napisu_jakosc.setVisible(false);
        jComboBox1.setVisible(false);
        jComboBox2.setVisible(false);
        
        napis_edycja.setText("Edycja farby");
        napis_lewy_1.setText("kolor");
        napis_lewy_2.setText("toksycznosc");
        napis_lewy_3.setText("jakosc");
        
        pole_napisu_1.setText(aktualnie_wybrana_farba_do_edycji.getKolor());
        pole_napisu_2.setText(String.valueOf(aktualnie_wybrana_farba_do_edycji.getToksycznosc()));
        pole_napisu_3.setText(String.valueOf(aktualnie_wybrana_farba_do_edycji.getJakosc()));
        
        pole_napisu_1.setEditable(true);
        pole_napisu_2.setEditable(true);
        pole_napisu_3.setEditable(true);
        
        Przycisk_zapisz.setVisible(true);
    }
    
    public void pokaz_wybrany_pigment_do_edycji()
    {
        czy_edycja_farby = false;
        
        napis_edycja.setVisible(true);
        napis_lewy_1.setVisible(true);
        napis_lewy_2.setVisible(true);
        napis_lewy_3.setVisible(true);
        pole_napisu_1.setVisible(true);
        pole_napisu_2.setVisible(true);
        pole_napisu_3.setVisible(true);
        napis_toksycznosc.setVisible(true);
        napis_jakosc.setVisible(true);
        pole_napisu_toksycznosc.setVisible(true);
        pole_napisu_jakosc.setVisible(true);
        jComboBox1.setVisible(true);
        jComboBox2.setVisible(true);
        
        
        
        napis_edycja.setText("Edycja");
        napis_lewy_1.setText("nazwa");
        napis_lewy_2.setText("kolor pocz");
        napis_lewy_3.setText("kolor kon");
        
        pole_napisu_1.setText(aktualnie_wybrany_pigment_do_edycji.getNazwa());
        pole_napisu_2.setText(String.valueOf(aktualnie_wybrany_pigment_do_edycji.getKolor_Pocz()));
        pole_napisu_3.setText(String.valueOf(aktualnie_wybrany_pigment_do_edycji.getKolor_Kon()));
        
        pole_napisu_1.setEditable(true);
        pole_napisu_2.setEditable(true);
        pole_napisu_3.setEditable(true);
        
        pole_napisu_toksycznosc.setText(String.valueOf(aktualnie_wybrany_pigment_do_edycji.getWsp_toksycznosci()));
        pole_napisu_jakosc.setText(String.valueOf(aktualnie_wybrany_pigment_do_edycji.getWplyw_na_jakosc()));
        
        
        Przycisk_zapisz.setVisible(true);
    }
    
    public MaszynaDoProdukcjiFarb() {
        this.maszyna = new MojaMaszyna();
        
        this.poczatkowa_tablica_nazw_farb = this.maszyna.getTablicaNazwFarb();
        
        this.poczatkowa_tablica_nazw_pigmentow = this.maszyna.getTablicaNazwPigmentow();
        
        initComponents();
        
        ukryj_wszystkie_napisy();
    }    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList<>();
        Przycisk_uzyj_pigmentu = new javax.swing.JButton();
        Przycisk_usun_pigment = new javax.swing.JButton();
        Przycisk_edytuj_pigment = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        Przycisk_mieszaj = new javax.swing.JButton();
        Przycisk_usun_farbe = new javax.swing.JButton();
        Przycisk_edytuj_farbe = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        napis_lewy_1 = new javax.swing.JLabel();
        napis_lewy_2 = new javax.swing.JLabel();
        napis_lewy_3 = new javax.swing.JLabel();
        napis_edycja = new javax.swing.JLabel();
        Przycisk_zapisz = new javax.swing.JButton();
        pole_napisu_1 = new javax.swing.JTextField();
        pole_napisu_2 = new javax.swing.JTextField();
        pole_napisu_3 = new javax.swing.JTextField();
        napis_toksycznosc = new javax.swing.JLabel();
        napis_jakosc = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        pole_napisu_toksycznosc = new javax.swing.JTextField();
        pole_napisu_jakosc = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        przycisk_dodaj_farbe = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        przycisk_dodaj_pigment = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jTextField1.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMaximumSize(new java.awt.Dimension(1100, 580));
        setMinimumSize(new java.awt.Dimension(1100, 580));
        setPreferredSize(new java.awt.Dimension(1100, 580));
        setSize(new java.awt.Dimension(1100, 580));

        jPanel2.setBackground(new java.awt.Color(255, 255, 102));
        jPanel2.setMaximumSize(new java.awt.Dimension(470, 450));
        jPanel2.setMinimumSize(new java.awt.Dimension(470, 450));
        jPanel2.setPreferredSize(new java.awt.Dimension(470, 450));

        jLabel2.setText("Wybierz pigment");

        jList2.setModel(new javax.swing.AbstractListModel<String>() {
            //    String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            //    String[] strings = lista_nazw_pigmentow.toArray(new String[lista_pigmentow.size()]);
            String[] strings = poczatkowa_tablica_nazw_pigmentow;

            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(jList2);

        Przycisk_uzyj_pigmentu.setText("Użyj pigmentu");
        Przycisk_uzyj_pigmentu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Przycisk_uzyj_pigmentuActionPerformed(evt);
            }
        });

        Przycisk_usun_pigment.setText("Usun");
        Przycisk_usun_pigment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Przycisk_usun_pigmentActionPerformed(evt);
            }
        });

        Przycisk_edytuj_pigment.setText("Edytuj");
        Przycisk_edytuj_pigment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Przycisk_edytuj_pigmentActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(Przycisk_uzyj_pigmentu, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Przycisk_usun_pigment, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(Przycisk_edytuj_pigment, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 507, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 44, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Przycisk_edytuj_pigment)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Przycisk_uzyj_pigmentu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Przycisk_usun_pigment, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(51, 255, 102));

        jLabel1.setText("Wybierz farbę");

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = poczatkowa_tablica_nazw_farb;
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        Przycisk_mieszaj.setText("Mieszaj");
        Przycisk_mieszaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Przycisk_mieszajActionPerformed(evt);
            }
        });

        Przycisk_usun_farbe.setText("Usun");
        Przycisk_usun_farbe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Przycisk_usun_farbeActionPerformed(evt);
            }
        });

        Przycisk_edytuj_farbe.setText("Edytuj");
        Przycisk_edytuj_farbe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Przycisk_edytuj_farbeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Przycisk_edytuj_farbe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(Przycisk_mieszaj, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Przycisk_usun_farbe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 6, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Przycisk_edytuj_farbe, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Przycisk_usun_farbe)
                    .addComponent(Przycisk_mieszaj, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel6.setBackground(new java.awt.Color(153, 255, 255));
        jPanel6.setMaximumSize(new java.awt.Dimension(288, 444));
        jPanel6.setMinimumSize(new java.awt.Dimension(288, 444));
        jPanel6.setPreferredSize(new java.awt.Dimension(288, 444));

        napis_lewy_1.setText("napis_lewy_1");

        napis_lewy_2.setText("napis_lewy_2");

        napis_lewy_3.setText("napis_lewy 3");

        napis_edycja.setText("Edycja");

        Przycisk_zapisz.setText("Zapisz");
        Przycisk_zapisz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Przycisk_zapiszActionPerformed(evt);
            }
        });

        pole_napisu_1.setColumns(10);
        pole_napisu_1.setText("jTextField2");
        pole_napisu_1.setMinimumSize(new java.awt.Dimension(0, 0));
        pole_napisu_1.setName(""); // NOI18N

        pole_napisu_2.setColumns(10);
        pole_napisu_2.setText("jTextField2");
        pole_napisu_2.setMinimumSize(new java.awt.Dimension(0, 0));
        pole_napisu_2.setName(""); // NOI18N

        pole_napisu_3.setColumns(10);
        pole_napisu_3.setText("jTextField2");
        pole_napisu_3.setMinimumSize(new java.awt.Dimension(0, 0));
        pole_napisu_3.setName(""); // NOI18N

        napis_toksycznosc.setText("toksycznosc");

        napis_jakosc.setText("jakosc");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "+", "x"}));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "+", "x" }));

        pole_napisu_toksycznosc.setColumns(6);
        pole_napisu_toksycznosc.setText("jTextField2");
        pole_napisu_toksycznosc.setMinimumSize(new java.awt.Dimension(0, 0));
        pole_napisu_toksycznosc.setName(""); // NOI18N

        pole_napisu_jakosc.setColumns(6);
        pole_napisu_jakosc.setText("jTextField2");
        pole_napisu_jakosc.setMinimumSize(new java.awt.Dimension(0, 0));
        pole_napisu_jakosc.setName(""); // NOI18N

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(napis_edycja)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(napis_toksycznosc)
                            .addComponent(napis_jakosc))
                        .addGap(62, 69, Short.MAX_VALUE)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(pole_napisu_jakosc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(pole_napisu_toksycznosc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(Przycisk_zapisz, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(napis_lewy_1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pole_napisu_1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(napis_lewy_2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pole_napisu_2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(napis_lewy_3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pole_napisu_3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(napis_edycja)
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(napis_lewy_1)
                                    .addComponent(pole_napisu_1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(napis_lewy_2))
                            .addComponent(pole_napisu_2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(napis_lewy_3))
                    .addComponent(pole_napisu_3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(napis_toksycznosc)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pole_napisu_toksycznosc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(napis_jakosc))
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(pole_napisu_jakosc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Przycisk_zapisz, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel7.setBackground(new java.awt.Color(255, 153, 0));

        przycisk_dodaj_farbe.setText("Dodaj farbe");
        przycisk_dodaj_farbe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                przycisk_dodaj_farbeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(przycisk_dodaj_farbe, javax.swing.GroupLayout.DEFAULT_SIZE, 409, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(przycisk_dodaj_farbe, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel8.setBackground(new java.awt.Color(153, 102, 255));

        przycisk_dodaj_pigment.setText("Dodaj pigment");
        przycisk_dodaj_pigment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                przycisk_dodaj_pigmentActionPerformed(evt);
            }
        });

        jLabel3.setText("Wykonane przez : Michał Radecki (mr371591)");
        jLabel3.setForeground(Color.WHITE);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(przycisk_dodaj_pigment, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(przycisk_dodaj_pigment, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 563, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void updateFarby()
    {
        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = maszyna.getTablicaNazwFarb();
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);
    }
    
    public void updatePigmenty()
    {
        jList2.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = maszyna.getTablicaNazwPigmentow();
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(jList2);
    }
    
    private void Przycisk_uzyj_pigmentuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Przycisk_uzyj_pigmentuActionPerformed
        if(jList2.getSelectedValue() == null) return;
        if(aktualnie_wybrana_farba == null) return;
        int numer = jList2.getSelectedIndex();
        Pigment wybrany_pigment = this.maszyna.getPigment(numer);
        if(aktualnie_wybrana_farba.getKolor().equals(wybrany_pigment.getKolor_Pocz()))
        {
            System.out.println("Dodawany pigment : " + wybrany_pigment.getNazwa());
            aktualnie_wybrana_farba.dodajPigment(wybrany_pigment);
            System.out.println("Aktuala farba : kolor(" + aktualnie_wybrana_farba.getKolor() +
                "), toksycznosc(" + aktualnie_wybrana_farba.getToksycznosc() +
                "), jakosc(" + aktualnie_wybrana_farba.getJakosc() + ")");
            pokaz_wybrana_farbe();
        }
        else
        {
            System.err.println("Niepoprawny pigment. Dodaj taki pigment który da się zmieszać z wybraną farbą!");
            JOptionPane.showMessageDialog(null, "Niepoprawny pigment. Dodaj taki pigment który da się zmieszać z wybraną farbą!");
        }
    }//GEN-LAST:event_Przycisk_uzyj_pigmentuActionPerformed

    private void Przycisk_mieszajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Przycisk_mieszajActionPerformed
        if(jList1.getSelectedValue() == null) return;
        int numer = jList1.getSelectedIndex();
        Farba f = this.maszyna.getFarba(numer);
        aktualnie_wybrana_farba = new Farba(f.getKolor(), f.getToksycznosc(), f.getJakosc());
        System.out.println("Zaczynam mieszanie");
        System.out.println("Aktuala farba : kolor(" + aktualnie_wybrana_farba.getKolor() +
                "), toksycznosc(" + aktualnie_wybrana_farba.getToksycznosc() +
                "), jakosc(" + aktualnie_wybrana_farba.getJakosc() + ")");
        Przycisk_uzyj_pigmentu.setEnabled(true);
        pokaz_wybrana_farbe();
        czy_rozpoczete_mieszanie = true;
    }//GEN-LAST:event_Przycisk_mieszajActionPerformed

    private void Przycisk_usun_farbeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Przycisk_usun_farbeActionPerformed
        if(jList1.isSelectionEmpty()) return;
        int numer = jList1.getSelectedIndex();
        this.maszyna.usunFarbe(numer);
        updateFarby();        
    }//GEN-LAST:event_Przycisk_usun_farbeActionPerformed

    private void Przycisk_usun_pigmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Przycisk_usun_pigmentActionPerformed
        if(jList2.isSelectionEmpty()) return;
        int numer = jList2.getSelectedIndex();
        maszyna.usunPigment(numer);
        updatePigmenty();
    }//GEN-LAST:event_Przycisk_usun_pigmentActionPerformed

    private void przycisk_dodaj_farbeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_przycisk_dodaj_farbeActionPerformed
        maszyna.dodajLosowaFarbe();
        updateFarby();
    }//GEN-LAST:event_przycisk_dodaj_farbeActionPerformed

    private void przycisk_dodaj_pigmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_przycisk_dodaj_pigmentActionPerformed
        maszyna.dodajLosowyPigment();
        updatePigmenty();
    }//GEN-LAST:event_przycisk_dodaj_pigmentActionPerformed

    private void Przycisk_edytuj_farbeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Przycisk_edytuj_farbeActionPerformed
        if(jList1.getSelectedValue() == null) return;
        int numer = jList1.getSelectedIndex();
        this.aktualnie_wybrana_farba_do_edycji = this.maszyna.getFarba(numer);
        this.numer_farby_do_edycji = numer;
        pokaz_wybrana_farbe_do_edycji();
    }//GEN-LAST:event_Przycisk_edytuj_farbeActionPerformed

    private boolean czy_wprowadzone_dane_sa_niepoprawne()
    {
        System.out.println("Jestem w czy_wprowadzone_dane_sa_niepoprawne");
        System.out.println("Czy edycja farby : " + czy_edycja_farby);
        if(czy_edycja_farby)
        {
            try
            {
                Float toks = Float.valueOf(pole_napisu_2.getText());
                Float jakosc = Float.valueOf(pole_napisu_3.getText());
                if(toks < 0 || toks > 100 || jakosc < 0 || jakosc > 100) throw new NumberFormatException();
            } catch (NumberFormatException e)
            {
                System.err.println("Wprowadzone dane są niepoprawne");
                JOptionPane.showMessageDialog(null, "Wprowadzone dane są niepoprawne");
                return true;
            }
        }
        else
        {
            try
            {
                System.out.println("Edytuje pigment");
                Float toks = Float.valueOf(pole_napisu_toksycznosc.getText());
                Float jakosc = Float.valueOf(pole_napisu_jakosc.getText());
                System.out.println("toks = " + toks + ", jakosc = " + jakosc);
                if(jComboBox1.getSelectedItem().toString().charAt(0) == 'x' && toks < 0) throw new NumberFormatException();
                if(jComboBox2.getSelectedItem().toString().charAt(0) == 'x' && jakosc < 0) throw new NumberFormatException();
            } catch (NumberFormatException e)
            {
                System.err.println("Wprowadzone dane są niepoprawne");
                JOptionPane.showMessageDialog(null, "Wprowadzone dane są niepoprawne");
                return true;
            }
        }
        return false;
    }
    
    private void Przycisk_zapiszActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Przycisk_zapiszActionPerformed
        if(czy_rozpoczete_mieszanie)
        {
            System.out.println("Koniec mieszania");
            Przycisk_uzyj_pigmentu.setEnabled(false);
            ukryj_wszystkie_napisy();
            czy_rozpoczete_mieszanie = false;
            czy_edycja_farby = false;
            return;
        }
        if(czy_wprowadzone_dane_sa_niepoprawne()) return;
        if(czy_edycja_farby)
        {
            maszyna.usunFarbe(this.numer_farby_do_edycji);
            Farba f = new Farba(pole_napisu_1.getText(), Float.valueOf(pole_napisu_2.getText()), Float.valueOf(pole_napisu_3.getText()));
            maszyna.dodajFarbe(f);
            updateFarby();
            pokaz_wybrana_farbe();
        }
        else
        {
            maszyna.usunPigment(this.numer_pigmentu_do_edycji);
            String nazwa_pigmentu = pole_napisu_1.getText();
            String pocz = pole_napisu_2.getText();
            String kon = pole_napisu_3.getText();
            char znak_toks = jComboBox1.getSelectedItem().toString().charAt(0);
            Float toksycznosc = Float.valueOf(pole_napisu_toksycznosc.getText());
            char znak_jakosci = jComboBox2.getSelectedItem().toString().charAt(0);
            Float jakosc = Float.valueOf(pole_napisu_jakosc.getText());
            Pigment p = new Pigment(nazwa_pigmentu, pocz, kon, znak_toks, toksycznosc, znak_jakosci, jakosc);
            maszyna.dodajPigment(p);
            updatePigmenty();
            pokaz_wybrana_farbe();
        }
    }//GEN-LAST:event_Przycisk_zapiszActionPerformed

    private void Przycisk_edytuj_pigmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Przycisk_edytuj_pigmentActionPerformed
        if(jList2.getSelectedValue() == null) return;
        int numer = jList2.getSelectedIndex();
        this.aktualnie_wybrany_pigment_do_edycji = this.maszyna.getPigment(numer);
        this.numer_pigmentu_do_edycji = numer;
        pokaz_wybrany_pigment_do_edycji();
    }//GEN-LAST:event_Przycisk_edytuj_pigmentActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
    }//GEN-LAST:event_jComboBox1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MaszynaDoProdukcjiFarb.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MaszynaDoProdukcjiFarb.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MaszynaDoProdukcjiFarb.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MaszynaDoProdukcjiFarb.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MaszynaDoProdukcjiFarb().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Przycisk_edytuj_farbe;
    private javax.swing.JButton Przycisk_edytuj_pigment;
    private javax.swing.JButton Przycisk_mieszaj;
    private javax.swing.JButton Przycisk_usun_farbe;
    private javax.swing.JButton Przycisk_usun_pigment;
    private javax.swing.JButton Przycisk_uzyj_pigmentu;
    private javax.swing.JButton Przycisk_zapisz;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JList<String> jList1;
    private javax.swing.JList<String> jList2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel napis_edycja;
    private javax.swing.JLabel napis_jakosc;
    private javax.swing.JLabel napis_lewy_1;
    private javax.swing.JLabel napis_lewy_2;
    private javax.swing.JLabel napis_lewy_3;
    private javax.swing.JLabel napis_toksycznosc;
    private javax.swing.JTextField pole_napisu_1;
    private javax.swing.JTextField pole_napisu_2;
    private javax.swing.JTextField pole_napisu_3;
    private javax.swing.JTextField pole_napisu_jakosc;
    private javax.swing.JTextField pole_napisu_toksycznosc;
    private javax.swing.JButton przycisk_dodaj_farbe;
    private javax.swing.JButton przycisk_dodaj_pigment;
    // End of variables declaration//GEN-END:variables
}
