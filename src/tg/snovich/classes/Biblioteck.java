/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tg.snovich.classes;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Spartanovich_117
 */
public class Biblioteck {
    
    public static String role = null;
    
    public static String authenticate(String mdp, String tel) {
        Connection db = Database.getConnection();   
        Statement statement = null;
        ResultSet rs = null;
        try {
            statement = db.createStatement();
            rs = statement.executeQuery("SELECT * FROM compte INNER JOIN utilisateur ON utilisateur.compte_id = compte.id");
            while(rs.next()) {
                if(rs.getString("mot_de_passe").equals(mdp) && rs.getString("telephone").equals(tel)) {
                    role = rs.getString("role");
                    db.close();
                    break;
                }
                else {
                    db.close();
                    role = "KO";
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        return role;
    }
    
    public static ArrayList listeLivres() {
        ArrayList<Livre> listeLivres = new ArrayList();
        Connection db = Database.getConnection();   
        Statement statement = null;
        ResultSet rs = null;
        try {
            statement = db.createStatement();
            rs = statement.executeQuery("SELECT * FROM livre");
            while(rs.next()) {
                Livre livre_temp = new Livre();
                livre_temp.setId(rs.getInt("id"));
                livre_temp.setDate_ajout(rs.getDate("date_ajout"));
                livre_temp.setEtat(rs.getString("etat"));
                livre_temp.setIsbn(rs.getString("isbn"));
                listeLivres.add(livre_temp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listeLivres;
    }
}
