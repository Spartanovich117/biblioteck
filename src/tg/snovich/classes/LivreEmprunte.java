/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tg.snovich.classes;

import java.sql.Date;

/**
 *
 * @author Spartanovich_117
 */
public class LivreEmprunte {
    private String isbn;
    private Date date_emprunt;
    private String titre;

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getIsbn() {
        return isbn;
    }

    public Date getDate_emprunt() {
        return date_emprunt;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setDate_emprunt(Date date_emprunt) {
        this.date_emprunt = date_emprunt;
    }

    public LivreEmprunte() {
    }
    
    
}
