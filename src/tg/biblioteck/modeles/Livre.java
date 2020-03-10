/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tg.biblioteck.modeles;

import java.sql.Date;

/**
 *
 * @author Spartanovich_117
 */
public class Livre {
    private int id;
    private String isbn;
    private String titre;
    private Date date_ajout;
    private String etat;

    public int getId() {
        return id;
    }

    public String getIsbn() {
        return isbn;
    }

    public Date getDate_ajout() {
        return date_ajout;
    }

    public String getEtat() {
        return etat;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setDate_ajout(Date date_ajout) {
        this.date_ajout = date_ajout;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public Livre() {
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }
    
    
}
