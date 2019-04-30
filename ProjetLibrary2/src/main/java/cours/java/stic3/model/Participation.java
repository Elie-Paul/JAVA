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
 * @author Elie
 */
@Entity
@Table(name = "participation")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Participation.findAll", query = "SELECT p FROM Participation p")
    , @NamedQuery(name = "Participation.findByParticipationId", query = "SELECT p FROM Participation p WHERE p.participationId = :participationId")
    , @NamedQuery(name = "Participation.findByDate", query = "SELECT p FROM Participation p WHERE p.date = :date")
    , @NamedQuery(name = "Participation.findByDescription", query = "SELECT p FROM Participation p WHERE p.description = :description")})
public class Participation implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "participationId")
    private Integer participationId;
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Column(name = "description")
    private String description;
    @JoinColumn(name = "tacheId", referencedColumnName = "tacheId")
    @ManyToOne(optional = false)
    private Tache tacheId;
    @JoinColumn(name = "participantId", referencedColumnName = "participantId")
    @ManyToOne(optional = false)
    private Participant participantId;

    public Participation() {
    }

    public Participation(Integer participationId) {
        this.participationId = participationId;
    }

    public Integer getParticipationId() {
        return participationId;
    }

    public void setParticipationId(Integer participationId) {
        this.participationId = participationId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Tache getTacheId() {
        return tacheId;
    }

    public void setTacheId(Tache tacheId) {
        this.tacheId = tacheId;
    }

    public Participant getParticipantId() {
        return participantId;
    }

    public void setParticipantId(Participant participantId) {
        this.participantId = participantId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (participationId != null ? participationId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Participation)) {
            return false;
        }
        Participation other = (Participation) object;
        if ((this.participationId == null && other.participationId != null) || (this.participationId != null && !this.participationId.equals(other.participationId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cours.java.stic3.model.Participation[ participationId=" + participationId + " ]";
    }
    
}
