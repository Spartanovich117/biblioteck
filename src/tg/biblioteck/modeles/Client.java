/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tg.biblioteck.modeles;

/**
 *
 * @author Spartanovich_117
 */
public class Client {
    private String nom;
    private String prenom;
    private String telephone;
    private String id_client;
    private String code_emprunt;
    private String numero_compte;

    public String getNumero_compte() {
        return numero_compte;
    }

    public void setNumero_compte(String numero_compte) {
        this.numero_compte = numero_compte;
    }
    
    

    public String getCode_emprunt() {
        return code_emprunt;
    }

    public void setCode_emprunt(String code_emprunt) {
        this.code_emprunt = code_emprunt;
    }
    
    

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getId_client() {
        return id_client;
    }

    public void setId_client(String id_client) {
        this.id_client = id_client;
    }
    
    public Client() {
    }
    
    
}
