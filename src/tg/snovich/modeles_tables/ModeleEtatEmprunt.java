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
import tg.snovich.classes.LivreEmprunte;

/**
 *
 * @author Spartanovich_117
 */
public class ModeleEtatEmprunt extends AbstractTableModel {
    
    private final ArrayList<LivreEmprunte> livres_empruntes = Biblioteck.listeLivresEmpruntes();
 
    private final String[] entetes = {"ISBN", "Date d'emprunt"};
 
    public ModeleEtatEmprunt() {
        super();
    }
 
    public int getRowCount() {
        return livres_empruntes.size();
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
                return livres_empruntes.get(rowIndex).getIsbn();
            case 1:
                return livres_empruntes.get(rowIndex).getDate_emprunt();
            default:
                return null; //Ne devrait jamais arriver
        }
    }
}
