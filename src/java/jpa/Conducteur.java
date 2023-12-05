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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Windows7
 */
@Entity
@Table(name = "CONDUCTEUR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Conducteur.findAll", query = "SELECT c FROM Conducteur c")
    , @NamedQuery(name = "Conducteur.findByIdconducteur", query = "SELECT c FROM Conducteur c WHERE c.idconducteur = :idconducteur")
    , @NamedQuery(name = "Conducteur.findByEmployeur", query = "SELECT c FROM Conducteur c WHERE c.employeur = :employeur")})
public class Conducteur implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDCONDUCTEUR")
    private Integer idconducteur;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "EMPLOYEUR")
    private String employeur;
    @JoinColumn(name = "IDUTILISATEUR", referencedColumnName = "IDUTILISATEUR")
    @ManyToOne(optional = false)
    private Utilisateur idutilisateur;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idconducteur")
    private Collection<Trajet> trajetCollection;

    public Conducteur() {
    }

    public Conducteur(Integer idconducteur) {
        this.idconducteur = idconducteur;
    }

    public Conducteur(Integer idconducteur, String employeur) {
        this.idconducteur = idconducteur;
        this.employeur = employeur;
    }

    public Integer getIdconducteur() {
        return idconducteur;
    }

    public void setIdconducteur(Integer idconducteur) {
        this.idconducteur = idconducteur;
    }

    public String getEmployeur() {
        return employeur;
    }

    public void setEmployeur(String employeur) {
        this.employeur = employeur;
    }

    public Utilisateur getIdutilisateur() {
        return idutilisateur;
    }

    public void setIdutilisateur(Utilisateur idutilisateur) {
        this.idutilisateur = idutilisateur;
    }

    @XmlTransient
    public Collection<Trajet> getTrajetCollection() {
        return trajetCollection;
    }

    public void setTrajetCollection(Collection<Trajet> trajetCollection) {
        this.trajetCollection = trajetCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idconducteur != null ? idconducteur.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Conducteur)) {
            return false;
        }
        Conducteur other = (Conducteur) object;
        if ((this.idconducteur == null && other.idconducteur != null) || (this.idconducteur != null && !this.idconducteur.equals(other.idconducteur))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.Conducteur[ idconducteur=" + idconducteur + " ]";
    }
    
    
    
}
