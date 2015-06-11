package com.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Le Thi Minh Loan
 */
@Embeddable
public class OrderdetailPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "obid")
    private int obid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "bid")
    private String bid;

    public OrderdetailPK() {
    }

    public OrderdetailPK(int obid, String bid) {
        this.obid = obid;
        this.bid = bid;
    }

    public int getObid() {
        return obid;
    }

    public void setObid(int obid) {
        this.obid = obid;
    }

    public String getBid() {
        return bid;
    }

    public void setBid(String bid) {
        this.bid = bid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) obid;
        hash += (bid != null ? bid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrderdetailPK)) {
            return false;
        }
        OrderdetailPK other = (OrderdetailPK) object;
        if (this.obid != other.obid) {
            return false;
        }
        if ((this.bid == null && other.bid != null) || (this.bid != null && !this.bid.equals(other.bid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entity.OrderdetailPK[ obid=" + obid + ", bid=" + bid + " ]";
    }

}
