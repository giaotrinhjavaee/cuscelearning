package com.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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
 * @author Le Thi Minh Loan
 */
@Entity
@Table(name = "book")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Book.findAll", query = "SELECT b FROM Book b"),
    @NamedQuery(name = "Book.findByBid", query = "SELECT b FROM Book b WHERE b.bid = :bid"),
    @NamedQuery(name = "Book.findByIsdn", query = "SELECT b FROM Book b WHERE b.isdn = :isdn"),
    @NamedQuery(name = "Book.findByBtitle", query = "SELECT b FROM Book b WHERE b.btitle = :btitle"),
    @NamedQuery(name = "Book.findByBprice", query = "SELECT b FROM Book b WHERE b.bprice = :bprice"),
    @NamedQuery(name = "Book.findByBlanguage", query = "SELECT b FROM Book b WHERE b.blanguage = :blanguage"),
    @NamedQuery(name = "Book.findByBsummary", query = "SELECT b FROM Book b WHERE b.bsummary = :bsummary")})
public class Book implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "bid")
    private String bid;
    @Size(max = 64)
    @Column(name = "isdn")
    private String isdn;
    @Size(max = 255)
    @Column(name = "btitle")
    private String btitle;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "bprice")
    private Double bprice;
    @Size(max = 255)
    @Column(name = "blanguage")
    private String blanguage;
    @Size(max = 255)
    @Column(name = "bsummary")
    private String bsummary;
    @JoinColumn(name = "auid", referencedColumnName = "auid")
    @ManyToOne
    private Author auid;
    @JoinColumn(name = "pubid", referencedColumnName = "pubid")
    @ManyToOne
    private Publisher pubid;
    @JoinColumn(name = "caid", referencedColumnName = "caid")
    @ManyToOne
    private Catalog caid;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "book")
    private Collection<Orderdetail> orderdetailCollection;

    public Book() {
    }

    public Book(String bid) {
        this.bid = bid;
    }

    public String getBid() {
        return bid;
    }

    public void setBid(String bid) {
        this.bid = bid;
    }

    public String getIsdn() {
        return isdn;
    }

    public void setIsdn(String isdn) {
        this.isdn = isdn;
    }

    public String getBtitle() {
        return btitle;
    }

    public void setBtitle(String btitle) {
        this.btitle = btitle;
    }

    public Double getBprice() {
        return bprice;
    }

    public void setBprice(Double bprice) {
        this.bprice = bprice;
    }

    public String getBlanguage() {
        return blanguage;
    }

    public void setBlanguage(String blanguage) {
        this.blanguage = blanguage;
    }

    public String getBsummary() {
        return bsummary;
    }

    public void setBsummary(String bsummary) {
        this.bsummary = bsummary;
    }

    public Author getAuid() {
        return auid;
    }

    public void setAuid(Author auid) {
        this.auid = auid;
    }

    public Publisher getPubid() {
        return pubid;
    }

    public void setPubid(Publisher pubid) {
        this.pubid = pubid;
    }

    public Catalog getCaid() {
        return caid;
    }

    public void setCaid(Catalog caid) {
        this.caid = caid;
    }

    @XmlTransient
    public Collection<Orderdetail> getOrderdetailCollection() {
        return orderdetailCollection;
    }

    public void setOrderdetailCollection(Collection<Orderdetail> orderdetailCollection) {
        this.orderdetailCollection = orderdetailCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bid != null ? bid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Book)) {
            return false;
        }
        Book other = (Book) object;
        if ((this.bid == null && other.bid != null) || (this.bid != null && !this.bid.equals(other.bid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entity.Book[ bid=" + bid + " ]";
    }

}
