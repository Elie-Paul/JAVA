/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cours.java.stic3.model;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Elie
 */
@Entity
@Table(name = "tache")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tache.findAll", query = "SELECT t FROM Tache t")
    , @NamedQuery(name = "Tache.findByTacheId", query = "SELECT t FROM Tache t WHERE t.tacheId = :tacheId")
    , @NamedQuery(name = "Tache.findByNom", query = "SELECT t FROM Tache t WHERE t.nom = :nom")
    , @NamedQuery(name = "Tache.findByDescription", query = "SELECT t FROM Tache t WHERE t.description = :description")
    , @NamedQuery(name = "Tache.findByDatedebut", query = "SELECT t FROM Tache t WHERE t.datedebut = :datedebut")
    , @NamedQuery(name = "Tache.findByDatefin", query = "SELECT t FROM Tache t WHERE t.datefin = :datefin")})
public class Tache implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "tacheId")
    private Integer tacheId;
    @Basic(optional = false)
    @Column(name = "nom")
    private String nom;
    @Basic(optional = false)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @Column(name = "datedebut")
    @Temporal(TemporalType.DATE)
    private Date datedebut;
    @Column(name = "datefin")
    @Temporal(TemporalType.DATE)
    private Date datefin;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tacheId")
    private List<Participation> participationList;
    @JoinColumn(name = "projetId", referencedColumnName = "projetId")
    @ManyToOne(optional = false)
    private Projet projetId;

    public Tache() {
    }

    public Tache(Integer tacheId) {
        this.tacheId = tacheId;
    }

    public Tache(Integer tacheId, String nom, String description, Date datedebut) {
        this.tacheId = tacheId;
        this.nom = nom;
        this.description = description;
        this.datedebut = datedebut;
    }

    public Integer getTacheId() {
        return tacheId;
    }

    public void setTacheId(Integer tacheId) {
        this.tacheId = tacheId;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDatedebut() {
        return datedebut;
    }

    public void setDatedebut(Date datedebut) {
        this.datedebut = datedebut;
    }

    public Date getDatefin() {
        return datefin;
    }

    public void setDatefin(Date datefin) {
        this.datefin = datefin;
    }

    @XmlTransient
    public List<Participation> getParticipationList() {
        return participationList;
    }

    public void setParticipationList(List<Participation> participationList) {
        this.participationList = participationList;
    }

    public Projet getProjetId() {
        return projetId;
    }

    public void setProjetId(Projet projetId) {
        this.projetId = projetId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tacheId != null ? tacheId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tache)) {
            return false;
        }
        Tache other = (Tache) object;
        if ((this.tacheId == null && other.tacheId != null) || (this.tacheId != null && !this.tacheId.equals(other.tacheId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nom;
    }
    
}
