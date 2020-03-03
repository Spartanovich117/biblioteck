/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tg.snovich.modeles_tables;

import java.awt.Color;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Spartanovich_117
 */
public class ModeleStatique extends AbstractTableModel {
 
    public enum Sport {
        TENNIS,
        FOOTBALL,
        NATATION,
        RIEN;
    }
    
    private final Object[][] donnees;
 
    private final String[] entetes = {"Prénom", "Nom", "Couleur favorite", "Homme", "Sport"};
 
    public ModeleStatique() {
        super();
 
        donnees = new Object[][]{
                {"Johnathan", "Sykes", Color.red, true, Sport.TENNIS},
                {"Nicolas", "Van de Kampf", Color.black, true, Sport.FOOTBALL},
                {"Damien", "Cuthbert", Color.cyan, true, Sport.RIEN},
                {"Corinne", "Valance", Color.blue, false, Sport.NATATION},
                {"Emilie", "Schrödinger", Color.magenta, false, Sport.FOOTBALL},
                {"Delphine", "Duke", Color.yellow, false, Sport.TENNIS},
                {"Eric", "Trump", Color.pink, true, Sport.FOOTBALL},
        };
    }
 
    public int getRowCount() {
        return donnees.length;
    }
 
    public int getColumnCount() {
        return entetes.length;
    }
 
    public String getColumnName(int columnIndex) {
        return entetes[columnIndex];
    }
 
    public Object getValueAt(int rowIndex, int columnIndex) {
        return donnees[rowIndex][columnIndex];
    }
}