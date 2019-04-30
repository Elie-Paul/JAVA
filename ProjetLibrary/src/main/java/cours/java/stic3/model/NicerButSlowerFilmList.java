/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cours.java.stic3.model;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Elie
 */
@Entity
@Table(name = "nicer_but_slower_film_list")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "NicerButSlowerFilmList.findAll", query = "SELECT n FROM NicerButSlowerFilmList n")
    , @NamedQuery(name = "NicerButSlowerFilmList.findByFid", query = "SELECT n FROM NicerButSlowerFilmList n WHERE n.fid = :fid")
    , @NamedQuery(name = "NicerButSlowerFilmList.findByTitle", query = "SELECT n FROM NicerButSlowerFilmList n WHERE n.title = :title")
    , @NamedQuery(name = "NicerButSlowerFilmList.findByCategory", query = "SELECT n FROM NicerButSlowerFilmList n WHERE n.category = :category")
    , @NamedQuery(name = "NicerButSlowerFilmList.findByPrice", query = "SELECT n FROM NicerButSlowerFilmList n WHERE n.price = :price")
    , @NamedQuery(name = "NicerButSlowerFilmList.findByLength", query = "SELECT n FROM NicerButSlowerFilmList n WHERE n.length = :length")
    , @NamedQuery(name = "NicerButSlowerFilmList.findByRating", query = "SELECT n FROM NicerButSlowerFilmList n WHERE n.rating = :rating")})
public class NicerButSlowerFilmList implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "FID")
    private Short fid;
    @Column(name = "title")
    private String title;
    @Lob
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @Column(name = "category")
    private String category;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "price")
    private BigDecimal price;
    @Column(name = "length")
    private Short length;
    @Column(name = "rating")
    private String rating;
    @Lob
    @Column(name = "actors")
    private String actors;

    public NicerButSlowerFilmList() {
    }

    public Short getFid() {
        return fid;
    }

    public void setFid(Short fid) {
        this.fid = fid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Short getLength() {
        return length;
    }

    public void setLength(Short length) {
        this.length = length;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getActors() {
        return actors;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }
    
}
