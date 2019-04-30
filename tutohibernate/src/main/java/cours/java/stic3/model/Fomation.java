/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cours.java.stic3.model;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ddthe
 */
@Entity
@Table(name = "fomation")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Fomation.findAll", query = "SELECT f FROM Fomation f")
    , @NamedQuery(name = "Fomation.findById", query = "SELECT f FROM Fomation f WHERE f.id = :id")
    , @NamedQuery(name = "Fomation.findByNom", query = "SELECT f FROM Fomation f WHERE f.nom = :nom")
    , @NamedQuery(name = "Fomation.findByDatedebut", query = "SELECT f FROM Fomation f WHERE f.datedebut = :datedebut")
    , @NamedQuery(name = "Fomation.findByDuree", query = "SELECT f FROM Fomation f WHERE f.duree = :duree")})
public class Fomation implements Serializable {

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
    @Column(name = "datedebut")
    @Temporal(TemporalType.DATE)
    private Date datedebut;
    @Basic(optional = false)
    @Column(name = "duree")
    private int duree;
    @JoinColumn(name = "idu", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private User idu;
    @JoinColumn(name = "idl", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Lieu idl;

    public Fomation() {
    }

    public Fomation(Integer id) {
        this.id = id;
    }

    public Fomation(Integer id, String nom, Date datedebut, int duree) {
        this.id = id;
        this.nom = nom;
        this.datedebut = datedebut;
        this.duree = duree;
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

    public Date getDatedebut() {
        return datedebut;
    }

    public void setDatedebut(Date datedebut) {
        this.datedebut = datedebut;
    }

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    public User getIdu() {
        return idu;
    }

    public void setIdu(User idu) {
        this.idu = idu;
    }

    public Lieu getIdl() {
        return idl;
    }

    public void setIdl(Lieu idl) {
        this.idl = idl;
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
        if (!(object instanceof Fomation)) {
            return false;
        }
        Fomation other = (Fomation) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cours.java.stic3.model.Fomation[ id=" + id + " ]";
    }
    
}
