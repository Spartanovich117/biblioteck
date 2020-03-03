/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tg.snovich.modeles_tables;

import java.awt.Color;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import tg.snovich.classes.Biblioteck;
import tg.snovich.classes.Livre;

/**
 *
 * @author Spartanovich_117
 */
public class ModeleLivres extends AbstractTableModel {
 
    public enum Sport {
        TENNIS,
        FOOTBALL,
        NATATION,
        RIEN;
    }
    
    private final ArrayList<Livre> livres = Biblioteck.listeLivres();
 
    private final String[] entetes = {"id", "ISBN", "Date d'ajout", "Etat livre"};
 
    public ModeleLivres() {
        super();
    }
 
    public int getRowCount() {
        return livres.size();
    }
 
    public int getColumnCount() {
        return entetes.length;
    }
 
    public String getColumnName(int columnIndex) {
        return entetes[columnIndex];
    }
 
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0:
                return livres.get(rowIndex).getId();
            case 1:
                return livres.get(rowIndex).getIsbn();
            case 2:
                return livres.get(rowIndex).getDate_ajout();
            case 3:
                return livres.get(rowIndex).getEtat();
            default:
                return null; //Ne devrait jamais arriver
        }
    }
}
