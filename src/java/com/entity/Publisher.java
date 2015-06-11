package com.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Le Thi Minh Loan
 */
@Entity
@Table(name = "publisher")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Publisher.findAll", query = "SELECT p FROM Publisher p"),
    @NamedQuery(name = "Publisher.findByPubid", query = "SELECT p FROM Publisher p WHERE p.pubid = :pubid"),
    @NamedQuery(name = "Publisher.findByPubname", query = "SELECT p FROM Publisher p WHERE p.pubname = :pubname"),
    @NamedQuery(name = "Publisher.findByPubaddress", query = "SELECT p FROM Publisher p WHERE p.pubaddress = :pubaddress")})
public class Publisher implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pubid")
    private Integer pubid;
    @Size(max = 255)
    @Column(name = "pubname")
    private String pubname;
    @Size(max = 255)
    @Column(name = "pubaddress")
    private String pubaddress;
    @OneToMany(mappedBy = "pubid")
    private Collection<Book> bookCollection;

    public Publisher() {
    }

    public Publisher(Integer pubid) {
        this.pubid = pubid;
    }

    public Integer getPubid() {
        return pubid;
    }

    public void setPubid(Integer pubid) {
        this.pubid = pubid;
    }

    public String getPubname() {
        return pubname;
    }

    public void setPubname(String pubname) {
        this.pubname = pubname;
    }

    public String getPubaddress() {
        return pubaddress;
    }

    public void setPubaddress(String pubaddress) {
        this.pubaddress = pubaddress;
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
        hash += (pubid != null ? pubid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Publisher)) {
            return false;
        }
        Publisher other = (Publisher) object;
        if ((this.pubid == null && other.pubid != null) || (this.pubid != null && !this.pubid.equals(other.pubid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entity.Publisher[ pubid=" + pubid + " ]";
    }

}
