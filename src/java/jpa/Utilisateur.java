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
@Table(name = "UTILISATEUR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Utilisateur.findAll", query = "SELECT u FROM Utilisateur u")
    , @NamedQuery(name = "Utilisateur.findByIdutilisateur", query = "SELECT u FROM Utilisateur u WHERE u.idutilisateur = :idutilisateur")
    , @NamedQuery(name = "Utilisateur.findByNom", query = "SELECT u FROM Utilisateur u WHERE u.nom = :nom")
    , @NamedQuery(name = "Utilisateur.findByPrenom", query = "SELECT u FROM Utilisateur u WHERE u.prenom = :prenom")
    , @NamedQuery(name = "Utilisateur.findByDatenaissance", query = "SELECT u FROM Utilisateur u WHERE u.datenaissance = :datenaissance")
    , @NamedQuery(name = "Utilisateur.findByEmail", query = "SELECT u FROM Utilisateur u WHERE u.email = :email")
    , @NamedQuery(name = "Utilisateur.findByMobile", query = "SELECT u FROM Utilisateur u WHERE u.mobile = :mobile")
    , @NamedQuery(name = "Utilisateur.findByEstconducteur", query = "SELECT u FROM Utilisateur u WHERE u.estconducteur = :estconducteur")})
public class Utilisateur implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDUTILISATEUR")
    private Integer idutilisateur;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "NOM")
    private String nom;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "PRENOM")
    private String prenom;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DATENAISSANCE")
    @Temporal(TemporalType.DATE)
    private Date datenaissance;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "EMAIL")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "MOBILE")
    private String mobile;
    @Column(name = "ESTCONDUCTEUR")
    private Boolean estconducteur;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idutilisateur")
    private Collection<Passager> passagerCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idutilisateur")
    private Collection<Conducteur> conducteurCollection;

    public Utilisateur() {
    }

    public Utilisateur(Integer idutilisateur) {
        this.idutilisateur = idutilisateur;
    }

    public Utilisateur(Integer idutilisateur, String nom, String prenom, Date datenaissance, String email, String mobile) {
        this.idutilisateur = idutilisateur;
        this.nom = nom;
        this.prenom = prenom;
        this.datenaissance = datenaissance;
        this.email = email;
        this.mobile = mobile;
    }

    public Integer getIdutilisateur() {
        return idutilisateur;
    }

    public void setIdutilisateur(Integer idutilisateur) {
        this.idutilisateur = idutilisateur;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Date getDatenaissance() {
        return datenaissance;
    }

    public void setDatenaissance(Date datenaissance) {
        this.datenaissance = datenaissance;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Boolean getEstconducteur() {
        return estconducteur;
    }

    public void setEstconducteur(Boolean estconducteur) {
        this.estconducteur = estconducteur;
    }

    @XmlTransient
    public Collection<Passager> getPassagerCollection() {
        return passagerCollection;
    }

    public void setPassagerCollection(Collection<Passager> passagerCollection) {
        this.passagerCollection = passagerCollection;
    }

    @XmlTransient
    public Collection<Conducteur> getConducteurCollection() {
        return conducteurCollection;
    }

    public void setConducteurCollection(Collection<Conducteur> conducteurCollection) {
        this.conducteurCollection = conducteurCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idutilisateur != null ? idutilisateur.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Utilisateur)) {
            return false;
        }
        Utilisateur other = (Utilisateur) object;
        if ((this.idutilisateur == null && other.idutilisateur != null) || (this.idutilisateur != null && !this.idutilisateur.equals(other.idutilisateur))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.Utilisateur[ idutilisateur=" + idutilisateur + " ]";
    }
    
}
