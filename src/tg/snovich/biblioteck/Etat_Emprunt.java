/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tg.snovich.biblioteck;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import tg.snovich.modeles_tables.ModeleEtatEmprunt;

public class Etat_Emprunt extends JFrame {
    
    public enum Sport {
        TENNIS,
        FOOTBALL,
        NATATION,
        RIEN;
    }
    
    public Etat_Emprunt() {
        super();
 
        setTitle("Etat de mes emprunts");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        JTable tableau = new JTable(new ModeleEtatEmprunt());
 
        getContentPane().add(new JScrollPane(tableau), BorderLayout.CENTER);
 
        pack();
    }
 
    public static void main(String[] args) {
        new Liste_Livres().setVisible(true);
    }
}