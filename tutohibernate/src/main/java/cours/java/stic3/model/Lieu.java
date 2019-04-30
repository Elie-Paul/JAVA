/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cours.java.stic3.model;

import java.io.Serializable;
import java.util.List;
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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ddthe
 */
@Entity
@Table(name = "lieu")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Lieu.findAll", query = "SELECT l FROM Lieu l")
    , @NamedQuery(name = "Lieu.findById", query = "SELECT l FROM Lieu l WHERE l.id = :id")
    , @NamedQuery(name = "Lieu.findByNom", query = "SELECT l FROM Lieu l WHERE l.nom = :nom")
    , @NamedQuery(name = "Lieu.findByLatitude", query = "SELECT l FROM Lieu l WHERE l.latitude = :latitude")
    , @NamedQuery(name = "Lieu.findByLongitude", query = "SELECT l FROM Lieu l WHERE l.longitude = :longitude")})
public class Lieu implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "nom")
    private String nom;
    @Basic(optional = false)
    @Column(name = "latitude")
    private double latitude;
    @Basic(optional = false)
    @Column(name = "longitude")
    private double longitude;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idl")
    private List<Fomation> fomationList;
    @JoinColumn(name = "idu", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private User idu;

    public Lieu() {
    }

    public Lieu(Integer id) {
        this.id = id;
    }

    public Lieu(Integer id, String nom, double latitude, double longitude) {
        this.id = id;
        this.nom = nom;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    @XmlTransient
    public List<Fomation> getFomationList() {
        return fomationList;
    }

    public void setFomationList(List<Fomation> fomationList) {
        this.fomationList = fomationList;
    }

    public User getIdu() {
        return idu;
    }

    public void setIdu(User idu) {
        this.idu = idu;
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
        if (!(object instanceof Lieu)) {
            return false;
        }
        Lieu other = (Lieu) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cours.java.stic3.model.Lieu[ id=" + id + " ]";
    }
    
}
