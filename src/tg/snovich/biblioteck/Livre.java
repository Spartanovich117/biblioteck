/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tg.snovich.biblioteck;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 *
 * @author Spartanovich_117
 */
@Entity
@Table(name = "livre", catalog = "biblioteck_db", schema = "")
@NamedQueries({
    @NamedQuery(name = "Livre.findAll", query = "SELECT l FROM Livre l"),
    @NamedQuery(name = "Livre.findById", query = "SELECT l FROM Livre l WHERE l.id = :id"),
    @NamedQuery(name = "Livre.findByIsbn", query = "SELECT l FROM Livre l WHERE l.isbn = :isbn"),
    @NamedQuery(name = "Livre.findByDateAjout", query = "SELECT l FROM Livre l WHERE l.dateAjout = :dateAjout"),
    @NamedQuery(name = "Livre.findByEtat", query = "SELECT l FROM Livre l WHERE l.etat = :etat")})
public class Livre implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "isbn")
    private String isbn;
    @Column(name = "date_ajout")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateAjout;
    @Column(name = "etat")
    private String etat;

    public Livre() {
    }

    public Livre(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        Integer oldId = this.id;
        this.id = id;
        changeSupport.firePropertyChange("id", oldId, id);
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        String oldIsbn = this.isbn;
        this.isbn = isbn;
        changeSupport.firePropertyChange("isbn", oldIsbn, isbn);
    }

    public Date getDateAjout() {
        return dateAjout;
    }

    public void setDateAjout(Date dateAjout) {
        Date oldDateAjout = this.dateAjout;
        this.dateAjout = dateAjout;
        changeSupport.firePropertyChange("dateAjout", oldDateAjout, dateAjout);
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        String oldEtat = this.etat;
        this.etat = etat;
        changeSupport.firePropertyChange("etat", oldEtat, etat);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Livre)) {
            return false;
        }
        Livre other = (Livre) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tg.snovich.biblioteck.Livre[ id=" + id + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
