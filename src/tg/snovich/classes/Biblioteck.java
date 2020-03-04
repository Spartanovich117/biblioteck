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
            rs = statement.executeQuery("SELECT * FROM compte INNER JOIN user ON user.compte_id = compte.id");
            while(rs.next()) {
                if(rs.getString("mot_de_passe").equals(mdp) && rs.getString("telephone").equals(tel)) {
                    role = rs.getString("role");
                    db.close();
                    break;
                }
                else {
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
                livre_temp.setTitre(rs.getString("titre"));
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
    
    public static ArrayList listeLivresEmpruntes() {
        ArrayList<LivreEmprunte> listeLivresEmpruntes = new ArrayList();
        Connection db = Database.getConnection();   
        Statement statement = null;
        ResultSet rs = null;
        try {
            statement = db.createStatement();
            rs = statement.executeQuery("SELECT isbn, date_emprunt, nom, prenom FROM contenu_emprunt INNER JOIN emprunt ON emprunt_id=emprunt.id INNER JOIN livre on livre_id=livre.id INNER JOIN user ON user.id=user_id;");
            while(rs.next()) {
                LivreEmprunte livre_temp = new LivreEmprunte();
                livre_temp.setDate_emprunt(rs.getDate("date_emprunt"));
                livre_temp.setIsbn(rs.getString("isbn"));
                livre_temp.setTitre(rs.getString("titre"));
                listeLivresEmpruntes.add(livre_temp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listeLivresEmpruntes;
    }
    
    public static void inscrireClient(String nom, String prenom, String telephone, String id, String mot_de_passe, String role) {
        Connection db = Database.getConnection();   
        Statement statement = null;
        boolean result;
        String[] user_params = {nom, prenom, telephone, id};
        String[] compte_params = {id, mot_de_passe, role}; 
        try {
            statement = db.createStatement();
            result = statement.execute("INSERT INTO compte(id, mot_de_passe, role) VALUES(?,?,?)", compte_params);
            if(result)
                statement.execute("INSERT INTO user(nom, prenom, telephone, compte_id) VALUES(?,?,?,?)", user_params);
        } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
