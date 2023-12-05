/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Windows7
 */
@Entity
@Table(name = "VOYAGE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Voyage.findAll", query = "SELECT v FROM Voyage v")
    , @NamedQuery(name = "Voyage.findByIdvoyage", query = "SELECT v FROM Voyage v WHERE v.idvoyage = :idvoyage")
    , @NamedQuery(name = "Voyage.findByNbvoyageur", query = "SELECT v FROM Voyage v WHERE v.nbvoyageur = :nbvoyageur")
    , @NamedQuery(name = "Voyage.findByIdconducteur", query = "SELECT v FROM Voyage v WHERE v.idconducteur = :idconducteur")})
public class Voyage implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDVOYAGE")
    private Integer idvoyage;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NBVOYAGEUR")
    private int nbvoyageur;
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDCONDUCTEUR")
    private int idconducteur;
    @ManyToMany(mappedBy = "voyageCollection")
    private Collection<Passager> passagerCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idvoyage")
    private Collection<Evaluationconducteur> evaluationconducteurCollection;
    @JoinColumn(name = "IDTRAJET", referencedColumnName = "IDTRAJET")
    @ManyToOne(optional = false)
    private Trajet idtrajet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idvoyage")
    private Collection<Evaluationpasager> evaluationpasagerCollection;

    public Voyage() {
    }

    public Voyage(Integer idvoyage) {
        this.idvoyage = idvoyage;
    }

    public Voyage(Integer idvoyage, int nbvoyageur, int idconducteur) {
        this.idvoyage = idvoyage;
        this.nbvoyageur = nbvoyageur;
        this.idconducteur = idconducteur;
    }

    public Integer getIdvoyage() {
        return idvoyage;
    }

    public void setIdvoyage(Integer idvoyage) {
        this.idvoyage = idvoyage;
    }

    public int getNbvoyageur() {
        return nbvoyageur;
    }

    public void setNbvoyageur(int nbvoyageur) {
        this.nbvoyageur = nbvoyageur;
    }

    public int getIdconducteur() {
        return idconducteur;
    }

    public void setIdconducteur(int idconducteur) {
        this.idconducteur = idconducteur;
    }

    @XmlTransient
    public Collection<Passager> getPassagerCollection() {
        return passagerCollection;
    }

    public void setPassagerCollection(Collection<Passager> passagerCollection) {
        this.passagerCollection = passagerCollection;
    }

    @XmlTransient
    public Collection<Evaluationconducteur> getEvaluationconducteurCollection() {
        return evaluationconducteurCollection;
    }

    public void setEvaluationconducteurCollection(Collection<Evaluationconducteur> evaluationconducteurCollection) {
        this.evaluationconducteurCollection = evaluationconducteurCollection;
    }

    public Trajet getIdtrajet() {
        return idtrajet;
    }

    public void setIdtrajet(Trajet idtrajet) {
        this.idtrajet = idtrajet;
    }

    @XmlTransient
    public Collection<Evaluationpasager> getEvaluationpasagerCollection() {
        return evaluationpasagerCollection;
    }

    public void setEvaluationpasagerCollection(Collection<Evaluationpasager> evaluationpasagerCollection) {
        this.evaluationpasagerCollection = evaluationpasagerCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idvoyage != null ? idvoyage.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Voyage)) {
            return false;
        }
        Voyage other = (Voyage) object;
        if ((this.idvoyage == null && other.idvoyage != null) || (this.idvoyage != null && !this.idvoyage.equals(other.idvoyage))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.Voyage[ idvoyage=" + idvoyage + " ]";
    }
    
}
