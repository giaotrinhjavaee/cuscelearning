package com.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Le Thi Minh Loan
 */
@Entity
@Table(name = "administrator")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Administrator.findAll", query = "SELECT a FROM Administrator a"),
    @NamedQuery(name = "Administrator.findByAusername", query = "SELECT a FROM Administrator a WHERE a.ausername = :ausername"),
    @NamedQuery(name = "Administrator.findByApassword", query = "SELECT a FROM Administrator a WHERE a.apassword = :apassword"),
    @NamedQuery(name = "Administrator.findByAphone", query = "SELECT a FROM Administrator a WHERE a.aphone = :aphone")})
public class Administrator implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "ausername")
    private String ausername;
    @Size(max = 50)
    @Column(name = "apassword")
    private String apassword;
    @Size(max = 12)
    @Column(name = "aphone")
    private String aphone;

    public Administrator() {
    }

    public Administrator(String ausername) {
        this.ausername = ausername;
    }

    public String getAusername() {
        return ausername;
    }

    public void setAusername(String ausername) {
        this.ausername = ausername;
    }

    public String getApassword() {
        return apassword;
    }

    public void setApassword(String apassword) {
        this.apassword = apassword;
    }

    public String getAphone() {
        return aphone;
    }

    public void setAphone(String aphone) {
        this.aphone = aphone;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ausername != null ? ausername.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Administrator)) {
            return false;
        }
        Administrator other = (Administrator) object;
        if ((this.ausername == null && other.ausername != null) || (this.ausername != null && !this.ausername.equals(other.ausername))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entity.Administrator[ ausername=" + ausername + " ]";
    }

}
