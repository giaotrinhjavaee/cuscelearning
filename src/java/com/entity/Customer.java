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
@Table(name = "customer")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Customer.findAll", query = "SELECT c FROM Customer c"),
    @NamedQuery(name = "Customer.findByCusername", query = "SELECT c FROM Customer c WHERE c.cusername = :cusername"),
    @NamedQuery(name = "Customer.findByCpassword", query = "SELECT c FROM Customer c WHERE c.cpassword = :cpassword"),
    @NamedQuery(name = "Customer.findByCfullname", query = "SELECT c FROM Customer c WHERE c.cfullname = :cfullname"),
    @NamedQuery(name = "Customer.findByCaddress", query = "SELECT c FROM Customer c WHERE c.caddress = :caddress")})
public class Customer implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "cusername")
    private String cusername;
    @Size(max = 50)
    @Column(name = "cpassword")
    private String cpassword;
    @Size(max = 255)
    @Column(name = "cfullname")
    private String cfullname;
    @Size(max = 255)
    @Column(name = "caddress")
    private String caddress;
    @OneToMany(mappedBy = "cusername")
    private Collection<Orderbook> orderbookCollection;

    public Customer() {
    }

    public Customer(String cusername) {
        this.cusername = cusername;
    }

    public String getCusername() {
        return cusername;
    }

    public void setCusername(String cusername) {
        this.cusername = cusername;
    }

    public String getCpassword() {
        return cpassword;
    }

    public void setCpassword(String cpassword) {
        this.cpassword = cpassword;
    }

    public String getCfullname() {
        return cfullname;
    }

    public void setCfullname(String cfullname) {
        this.cfullname = cfullname;
    }

    public String getCaddress() {
        return caddress;
    }

    public void setCaddress(String caddress) {
        this.caddress = caddress;
    }

    @XmlTransient
    public Collection<Orderbook> getOrderbookCollection() {
        return orderbookCollection;
    }

    public void setOrderbookCollection(Collection<Orderbook> orderbookCollection) {
        this.orderbookCollection = orderbookCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cusername != null ? cusername.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Customer)) {
            return false;
        }
        Customer other = (Customer) object;
        if ((this.cusername == null && other.cusername != null) || (this.cusername != null && !this.cusername.equals(other.cusername))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entity.Customer[ cusername=" + cusername + " ]";
    }

}
