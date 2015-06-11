package com.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Le Thi Minh Loan
 */
@Entity
@Table(name = "orderdetail")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Orderdetail.findAll", query = "SELECT o FROM Orderdetail o"),
    @NamedQuery(name = "Orderdetail.findByObid", query = "SELECT o FROM Orderdetail o WHERE o.orderdetailPK.obid = :obid"),
    @NamedQuery(name = "Orderdetail.findByBid", query = "SELECT o FROM Orderdetail o WHERE o.orderdetailPK.bid = :bid"),
    @NamedQuery(name = "Orderdetail.findByQuantity", query = "SELECT o FROM Orderdetail o WHERE o.quantity = :quantity")})
public class Orderdetail implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected OrderdetailPK orderdetailPK;
    @Column(name = "quantity")
    private Integer quantity;
    @JoinColumn(name = "bid", referencedColumnName = "bid", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Book book;
    @JoinColumn(name = "obid", referencedColumnName = "obid", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Orderbook orderbook;

    public Orderdetail() {
    }

    public Orderdetail(OrderdetailPK orderdetailPK) {
        this.orderdetailPK = orderdetailPK;
    }

    public Orderdetail(int obid, String bid) {
        this.orderdetailPK = new OrderdetailPK(obid, bid);
    }

    public OrderdetailPK getOrderdetailPK() {
        return orderdetailPK;
    }

    public void setOrderdetailPK(OrderdetailPK orderdetailPK) {
        this.orderdetailPK = orderdetailPK;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Orderbook getOrderbook() {
        return orderbook;
    }

    public void setOrderbook(Orderbook orderbook) {
        this.orderbook = orderbook;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (orderdetailPK != null ? orderdetailPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Orderdetail)) {
            return false;
        }
        Orderdetail other = (Orderdetail) object;
        if ((this.orderdetailPK == null && other.orderdetailPK != null) || (this.orderdetailPK != null && !this.orderdetailPK.equals(other.orderdetailPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entity.Orderdetail[ orderdetailPK=" + orderdetailPK + " ]";
    }

}
