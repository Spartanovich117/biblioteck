/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tg.snovich.modeles_tables;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import tg.snovich.classes.Biblioteck;
import tg.snovich.classes.Client;
import tg.snovich.classes.Livre;

/**
 *
 * @author Spartanovich_117
 */
public class ModeleClient extends AbstractTableModel {
    
    private final ArrayList<Client> clients = Biblioteck.listeClients();
 
    private final String[] entetes = {"Nom", "Prénom", "Téléphone"};
 
    public ModeleClient() {
        super();
    }
 
    public int getRowCount() {
        return clients.size();
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
                return clients.get(rowIndex).getNom();
            case 1:
                return clients.get(rowIndex).getPrenom();
            case 2:
                return clients.get(rowIndex).getTelephone();
            default:
                return null; //Ne devrait jamais arriver
        }
    }
    
}
