/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Windows7
 */
@Entity
@Table(name = "TRAJET")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Trajet.findAll", query = "SELECT t FROM Trajet t")
    , @NamedQuery(name = "Trajet.findByIdtrajet", query = "SELECT t FROM Trajet t WHERE t.idtrajet = :idtrajet")
    , @NamedQuery(name = "Trajet.findByHeurerdv", query = "SELECT t FROM Trajet t WHERE t.heurerdv = :heurerdv")
    , @NamedQuery(name = "Trajet.findByAdresserdv", query = "SELECT t FROM Trajet t WHERE t.adresserdv = :adresserdv")
    , @NamedQuery(name = "Trajet.findByDaterdv", query = "SELECT t FROM Trajet t WHERE t.daterdv = :daterdv")
    , @NamedQuery(name = "Trajet.findByAdressefin", query = "SELECT t FROM Trajet t WHERE t.adressefin = :adressefin")
    , @NamedQuery(name = "Trajet.findByNbpassager", query = "SELECT t FROM Trajet t WHERE t.nbpassager = :nbpassager")
    , @NamedQuery(name = "Trajet.findByActiver", query = "SELECT t FROM Trajet t WHERE t.activer = :activer")})
public class Trajet implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDTRAJET")
    private Integer idtrajet;
    @Basic(optional = false)
    @NotNull
    @Column(name = "HEURERDV")
    @Temporal(TemporalType.TIME)
    private Date heurerdv;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "ADRESSERDV")
    private String adresserdv;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DATERDV")
    @Temporal(TemporalType.DATE)
    private Date daterdv;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "ADRESSEFIN")
    private String adressefin;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NBPASSAGER")
    private int nbpassager;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ACTIVER")
    private Boolean activer;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idtrajet")
    private Collection<Voyage> voyageCollection;
    @JoinColumn(name = "IDCONDUCTEUR", referencedColumnName = "IDCONDUCTEUR")
    @ManyToOne(optional = false)
    private Conducteur idconducteur;

    public Trajet() {
    }

    public Trajet(Integer idtrajet) {
        this.idtrajet = idtrajet;
    }

    public Trajet(Integer idtrajet, Date heurerdv, String adresserdv, Date daterdv, String adressefin, int nbpassager, Boolean activer) {
        this.idtrajet = idtrajet;
        this.heurerdv = heurerdv;
        this.adresserdv = adresserdv;
        this.daterdv = daterdv;
        this.adressefin = adressefin;
        this.nbpassager = nbpassager;
        this.activer = activer;
    }

    public Integer getIdtrajet() {
        return idtrajet;
    }

    public void setIdtrajet(Integer idtrajet) {
        this.idtrajet = idtrajet;
    }

    public Date getHeurerdv() {
        return heurerdv;
    }

    public void setHeurerdv(Date heurerdv) {
        this.heurerdv = heurerdv;
    }

    public String getAdresserdv() {
        return adresserdv;
    }

    public void setAdresserdv(String adresserdv) {
        this.adresserdv = adresserdv;
    }

    public Date getDaterdv() {
        return daterdv;
    }

    public void setDaterdv(Date daterdv) {
        this.daterdv = daterdv;
    }

    public String getAdressefin() {
        return adressefin;
    }

    public void setAdressefin(String adressefin) {
        this.adressefin = adressefin;
    }

    public int getNbpassager() {
        return nbpassager;
    }

    public void setNbpassager(int nbpassager) {
        this.nbpassager = nbpassager;
    }

    public Boolean getActiver() {
        return activer;
    }

    public void setActiver(Boolean activer) {
        this.activer = activer;
    }

    @XmlTransient
    public Collection<Voyage> getVoyageCollection() {
        return voyageCollection;
    }

    public void setVoyageCollection(Collection<Voyage> voyageCollection) {
        this.voyageCollection = voyageCollection;
    }

    public Conducteur getIdconducteur() {
        return idconducteur;
    }

    public void setIdconducteur(Conducteur idconducteur) {
        this.idconducteur = idconducteur;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtrajet != null ? idtrajet.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Trajet)) {
            return false;
        }
        Trajet other = (Trajet) object;
        if ((this.idtrajet == null && other.idtrajet != null) || (this.idtrajet != null && !this.idtrajet.equals(other.idtrajet))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.Trajet[ idtrajet=" + idtrajet + " ]";
    }
    
}
