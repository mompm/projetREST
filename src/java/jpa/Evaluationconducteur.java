/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Windows7
 */
@Entity
@Table(name = "EVALUATIONCONDUCTEUR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Evaluationconducteur.findAll", query = "SELECT e FROM Evaluationconducteur e")
    , @NamedQuery(name = "Evaluationconducteur.findByIdevaluationconducteur", query = "SELECT e FROM Evaluationconducteur e WHERE e.idevaluationconducteur = :idevaluationconducteur")
    , @NamedQuery(name = "Evaluationconducteur.findByNote", query = "SELECT e FROM Evaluationconducteur e WHERE e.note = :note")
    , @NamedQuery(name = "Evaluationconducteur.findByCommentaire", query = "SELECT e FROM Evaluationconducteur e WHERE e.commentaire = :commentaire")})
public class Evaluationconducteur implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDEVALUATIONCONDUCTEUR")
    private Integer idevaluationconducteur;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NOTE")
    private int note;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "COMMENTAIRE")
    private String commentaire;
    @JoinColumn(name = "IDVOYAGE", referencedColumnName = "IDVOYAGE")
    @ManyToOne(optional = false)
    private Voyage idvoyage;

    public Evaluationconducteur() {
    }

    public Evaluationconducteur(Integer idevaluationconducteur) {
        this.idevaluationconducteur = idevaluationconducteur;
    }

    public Evaluationconducteur(Integer idevaluationconducteur, int note, String commentaire) {
        this.idevaluationconducteur = idevaluationconducteur;
        this.note = note;
        this.commentaire = commentaire;
    }

    public Integer getIdevaluationconducteur() {
        return idevaluationconducteur;
    }

    public void setIdevaluationconducteur(Integer idevaluationconducteur) {
        this.idevaluationconducteur = idevaluationconducteur;
    }

    public int getNote() {
        return note;
    }

    public void setNote(int note) {
        this.note = note;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public Voyage getIdvoyage() {
        return idvoyage;
    }

    public void setIdvoyage(Voyage idvoyage) {
        this.idvoyage = idvoyage;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idevaluationconducteur != null ? idevaluationconducteur.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Evaluationconducteur)) {
            return false;
        }
        Evaluationconducteur other = (Evaluationconducteur) object;
        if ((this.idevaluationconducteur == null && other.idevaluationconducteur != null) || (this.idevaluationconducteur != null && !this.idevaluationconducteur.equals(other.idevaluationconducteur))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.Evaluationconducteur[ idevaluationconducteur=" + idevaluationconducteur + " ]";
    }
    
}
