package com.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Le Thi Minh Loan
 */
@Entity
@Table(name = "orderbook")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Orderbook.findAll", query = "SELECT o FROM Orderbook o"),
    @NamedQuery(name = "Orderbook.findByObid", query = "SELECT o FROM Orderbook o WHERE o.obid = :obid"),
    @NamedQuery(name = "Orderbook.findByObdeliveryaddress", query = "SELECT o FROM Orderbook o WHERE o.obdeliveryaddress = :obdeliveryaddress"),
    @NamedQuery(name = "Orderbook.findByObinvoicedate", query = "SELECT o FROM Orderbook o WHERE o.obinvoicedate = :obinvoicedate")})
public class Orderbook implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "obid")
    private Integer obid;
    @Size(max = 255)
    @Column(name = "obdeliveryaddress")
    private String obdeliveryaddress;
    @Column(name = "obinvoicedate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date obinvoicedate;
    @JoinColumn(name = "cusername", referencedColumnName = "cusername")
    @ManyToOne
    private Customer cusername;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "orderbook")
    private Collection<Orderdetail> orderdetailCollection;

    public Orderbook() {
    }

    public Orderbook(Integer obid) {
        this.obid = obid;
    }

    public Integer getObid() {
        return obid;
    }

    public void setObid(Integer obid) {
        this.obid = obid;
    }

    public String getObdeliveryaddress() {
        return obdeliveryaddress;
    }

    public void setObdeliveryaddress(String obdeliveryaddress) {
        this.obdeliveryaddress = obdeliveryaddress;
    }

    public Date getObinvoicedate() {
        return obinvoicedate;
    }

    public void setObinvoicedate(Date obinvoicedate) {
        this.obinvoicedate = obinvoicedate;
    }

    public Customer getCusername() {
        return cusername;
    }

    public void setCusername(Customer cusername) {
        this.cusername = cusername;
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
        hash += (obid != null ? obid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Orderbook)) {
            return false;
        }
        Orderbook other = (Orderbook) object;
        if ((this.obid == null && other.obid != null) || (this.obid != null && !this.obid.equals(other.obid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entity.Orderbook[ obid=" + obid + " ]";
    }

}
