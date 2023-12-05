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
@Table(name = "EVALUATIONPASAGER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Evaluationpasager.findAll", query = "SELECT e FROM Evaluationpasager e")
    , @NamedQuery(name = "Evaluationpasager.findByIdevaluationpasager", query = "SELECT e FROM Evaluationpasager e WHERE e.idevaluationpasager = :idevaluationpasager")
    , @NamedQuery(name = "Evaluationpasager.findByNote", query = "SELECT e FROM Evaluationpasager e WHERE e.note = :note")
    , @NamedQuery(name = "Evaluationpasager.findByCommentaire", query = "SELECT e FROM Evaluationpasager e WHERE e.commentaire = :commentaire")})
public class Evaluationpasager implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDEVALUATIONPASAGER")
    private Integer idevaluationpasager;
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

    public Evaluationpasager() {
    }

    public Evaluationpasager(Integer idevaluationpasager) {
        this.idevaluationpasager = idevaluationpasager;
    }

    public Evaluationpasager(Integer idevaluationpasager, int note, String commentaire) {
        this.idevaluationpasager = idevaluationpasager;
        this.note = note;
        this.commentaire = commentaire;
    }

    public Integer getIdevaluationpasager() {
        return idevaluationpasager;
    }

    public void setIdevaluationpasager(Integer idevaluationpasager) {
        this.idevaluationpasager = idevaluationpasager;
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
        hash += (idevaluationpasager != null ? idevaluationpasager.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Evaluationpasager)) {
            return false;
        }
        Evaluationpasager other = (Evaluationpasager) object;
        if ((this.idevaluationpasager == null && other.idevaluationpasager != null) || (this.idevaluationpasager != null && !this.idevaluationpasager.equals(other.idevaluationpasager))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.Evaluationpasager[ idevaluationpasager=" + idevaluationpasager + " ]";
    }
    
}
