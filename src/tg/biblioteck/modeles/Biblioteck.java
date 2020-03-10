/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tg.biblioteck.modeles;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import tg.biblioteck.vues.Login;

/**
 *
 * @author Spartanovich_117
 */
public class Biblioteck {
    
    public static Roles role = null;
    public static int ConnectedUserId = 0;
    
        
    public static boolean formIsValid(String[] formFields) {
        boolean one_field_is_empty = false;
        for(String field : formFields){
            if (field.equals(""))
            {
                one_field_is_empty = true;
            }
        }
        return !one_field_is_empty;
    }
    
    public static Roles authenticate(String mdp, String tel) {
        Connection db = Database.getConnection();   
        Statement statement = null;
        ResultSet rs = null;
        try {
            statement = db.createStatement();
            rs = statement.executeQuery("SELECT *, user.id as user_id FROM compte INNER JOIN user ON user.compte_id = compte.id");
            while(rs.next()) {
                if(rs.getString("mot_de_passe").equals(mdp) && rs.getString("telephone").equals(tel)) {
                    String test = rs.getString("roles");
                    role = rs.getString("roles").equals("employe") ? Roles.EMPLOYE : Roles.CLIENT; 
                    ConnectedUserId = Integer.parseInt(rs.getString("user_id"));
                    db.close();
                    break;
                }
                else {
                    role = Roles.KO;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        return role;
    }
    
    public static void logout(){
        Biblioteck.ConnectedUserId = 0;
        Biblioteck.role = null;
        Login login = new Login();
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
    
    public static ArrayList listeClients() {
        ArrayList<Client> listeClients = new ArrayList();
        Connection db = Database.getConnection();   
        Statement statement = null;
        ResultSet rs = null;
        try {
            statement = db.createStatement();
            rs = statement.executeQuery("SELECT * FROM user NATURAL JOIN compte");
            while(rs.next()) {
                Client client_temp = new Client();
                client_temp.setNom(rs.getString("nom"));
                client_temp.setPrenom(rs.getString("prenom"));
                client_temp.setTelephone(rs.getString("telephone"));
                client_temp.setId_client(rs.getString("id"));
                client_temp.setNumero_compte(rs.getString("numero_compte"));
                listeClients.add(client_temp);
                System.out.println(client_temp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listeClients;
    }
    
    public static ArrayList listeClientsEmprunts() {
        ArrayList<Client> listeClientsEmprunts = new ArrayList();
        Connection db = Database.getConnection();   
        Statement statement = null;
        ResultSet rs = null;
        try {
            statement = db.createStatement();
            rs = statement.executeQuery("SELECT nom, prenom, emprunt.id as code_emprunt FROM user INNER JOIN emprunt ON user.id=emprunt.user_id WHERE etat = \"emprunt\";");
            while(rs.next()) {
                Client client_temp = new Client();
                client_temp.setNom(rs.getString("nom"));
                client_temp.setPrenom(rs.getString("prenom"));
                client_temp.setCode_emprunt(rs.getString("code_emprunt"));
                listeClientsEmprunts.add(client_temp);
                System.out.println(client_temp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listeClientsEmprunts;
    }
    
    public static ArrayList listeLivresEmpruntesParClient(int code_emprunt) {
        ArrayList<Livre> contenuEmprunt = new ArrayList();
        Connection db = Database.getConnection();   
        Statement statement = null;
        ResultSet rs = null;
        try {
            statement = db.createStatement();
            rs = statement.executeQuery("SELECT isbn, titre FROM livre INNER JOIN contenu_emprunt ON livre.id=contenu_emprunt.livre_id WHERE emprunt_id = '"+ code_emprunt +"';");
            while(rs.next()) {
                Livre livre = new Livre();
                livre.setIsbn(rs.getString("isbn"));
                livre.setTitre(rs.getString("titre"));
                contenuEmprunt.add(livre);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        return contenuEmprunt;
    }
    
    public static ArrayList listeLivresEmpruntesParClient2(int code_utilisateur) {
        ArrayList<Livre> contenuEmprunt = new ArrayList();
        Connection db = Database.getConnection();   
        Statement statement = null;
        ResultSet rs = null;
        try {
            statement = db.createStatement();
            rs = statement.executeQuery("SELECT nom, prenom, isbn, titre FROM user INNER JOIN emprunt ON user.id=emprunt.user_id INNER JOIN contenu_emprunt ON emprunt.id=contenu_emprunt.emprunt_id INNER JOIN livre ON contenu_emprunt.livre_id=livre.id WHERE emprunt.etat=\"emprunt\" AND user.id='"+code_utilisateur+"'");
            while(rs.next()) {
                Livre livre = new Livre();
                livre.setIsbn(rs.getString("isbn"));
                livre.setTitre(rs.getString("titre"));
                contenuEmprunt.add(livre);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        return contenuEmprunt;
    }
    
    public static String inscrireClient(String nom, String prenom, String telephone, String numero_compte, String mot_de_passe) {
        String function_return_message = "N/A";
        Connection db = Database.getConnection();   
        PreparedStatement statement = null;
        boolean result;
        String num_compte = "CPT-" + numero_compte;
        try {
            statement = db.prepareStatement("INSERT INTO compte(numero_compte, mot_de_passe) VALUES(?,?)");
            statement.setString(1, num_compte);
            statement.setString(2, mot_de_passe);
            result = statement.execute();
            if(!result){
                statement = db.prepareStatement("INSERT INTO user(nom, prenom, telephone, numero_compte) VALUES(?,?,?,?)");
                statement.setString(1, nom);
                statement.setString(2, prenom);
                statement.setString(3, telephone);
                statement.setString(4, num_compte);
                statement.execute();
            }
        } catch (SQLIntegrityConstraintViolationException ex) {
            function_return_message = "Numéro de compte déjà existant dans la base";
        } catch (SQLException ex) {
            function_return_message = ex.getMessage();
        }
        
        return function_return_message;
    }
    
    public static String ajouterLivre(String isbn, String titre) {
        String function_return_message = "N/A";
        Connection db = Database.getConnection();   
        PreparedStatement statement = null;
        boolean result;
        try {
            statement = db.prepareStatement("INSERT INTO livre(isbn, titre) VALUES(?, ?);");
            statement.setString(1, isbn);
            statement.setString(2, titre);
            result = statement.execute();
            if(!result){ // Si la requete réussit
                function_return_message = "Livre enregistré !!!";
            }
        } catch (SQLIntegrityConstraintViolationException ex) {
            function_return_message = "Numéro LIVRE déjà existant dans la base";
        } catch (SQLException ex) {
            function_return_message = ex.getMessage();
        }
        
        return function_return_message;
    }
    
    
       
}
