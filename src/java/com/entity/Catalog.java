package com.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
 * @author Le Thi Minh Loan
 */
@Entity
@Table(name = "catalog")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Catalog.findAll", query = "SELECT c FROM Catalog c"),
    @NamedQuery(name = "Catalog.findByCaid", query = "SELECT c FROM Catalog c WHERE c.caid = :caid"),
    @NamedQuery(name = "Catalog.findByCadesc", query = "SELECT c FROM Catalog c WHERE c.cadesc = :cadesc")})
public class Catalog implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "caid")
    private Integer caid;
    @Size(max = 255)
    @Column(name = "cadesc")
    private String cadesc;
    @OneToMany(mappedBy = "caid")
    private Collection<Book> bookCollection;

    public Catalog() {
    }

    public Catalog(Integer caid) {
        this.caid = caid;
    }

    public Integer getCaid() {
        return caid;
    }

    public void setCaid(Integer caid) {
        this.caid = caid;
    }

    public String getCadesc() {
        return cadesc;
    }

    public void setCadesc(String cadesc) {
        this.cadesc = cadesc;
    }

    @XmlTransient
    public Collection<Book> getBookCollection() {
        return bookCollection;
    }

    public void setBookCollection(Collection<Book> bookCollection) {
        this.bookCollection = bookCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (caid != null ? caid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Catalog)) {
            return false;
        }
        Catalog other = (Catalog) object;
        if ((this.caid == null && other.caid != null) || (this.caid != null && !this.caid.equals(other.caid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entity.Catalog[ caid=" + caid + " ]";
    }

}
