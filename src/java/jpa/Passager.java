/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Windows7
 */
@Entity
@Table(name = "PASSAGER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Passager.findAll", query = "SELECT p FROM Passager p")
    , @NamedQuery(name = "Passager.findByIdpassager", query = "SELECT p FROM Passager p WHERE p.idpassager = :idpassager")})
public class Passager implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDPASSAGER")
    private Integer idpassager;
    @JoinTable(name = "VOYAGE_HAS_PASSAGER", joinColumns = {
        @JoinColumn(name = "IDPASSAGER", referencedColumnName = "IDPASSAGER")}, inverseJoinColumns = {
        @JoinColumn(name = "IDVOYAGE", referencedColumnName = "IDVOYAGE")})
    @ManyToMany
    private Collection<Voyage> voyageCollection;
    @JoinColumn(name = "IDUTILISATEUR", referencedColumnName = "IDUTILISATEUR")
    @ManyToOne(optional = false)
    private Utilisateur idutilisateur;

    public Passager() {
    }

    public Passager(Integer idpassager) {
        this.idpassager = idpassager;
    }

    public Integer getIdpassager() {
        return idpassager;
    }

    public void setIdpassager(Integer idpassager) {
        this.idpassager = idpassager;
    }

    @XmlTransient
    public Collection<Voyage> getVoyageCollection() {
        return voyageCollection;
    }

    public void setVoyageCollection(Collection<Voyage> voyageCollection) {
        this.voyageCollection = voyageCollection;
    }

    public Utilisateur getIdutilisateur() {
        return idutilisateur;
    }

    public void setIdutilisateur(Utilisateur idutilisateur) {
        this.idutilisateur = idutilisateur;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpassager != null ? idpassager.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Passager)) {
            return false;
        }
        Passager other = (Passager) object;
        if ((this.idpassager == null && other.idpassager != null) || (this.idpassager != null && !this.idpassager.equals(other.idpassager))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.Passager[ idpassager=" + idpassager + " ]";
    }
    
}
