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
@Table(name = "author")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Author.findAll", query = "SELECT a FROM Author a"),
    @NamedQuery(name = "Author.findByAuid", query = "SELECT a FROM Author a WHERE a.auid = :auid"),
    @NamedQuery(name = "Author.findByAufullname", query = "SELECT a FROM Author a WHERE a.aufullname = :aufullname"),
    @NamedQuery(name = "Author.findByAuaddress", query = "SELECT a FROM Author a WHERE a.auaddress = :auaddress")})
public class Author implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "auid")
    private Integer auid;
    @Size(max = 255)
    @Column(name = "aufullname")
    private String aufullname;
    @Size(max = 255)
    @Column(name = "auaddress")
    private String auaddress;
    @OneToMany(mappedBy = "auid")
    private Collection<Book> bookCollection;

    public Author() {
    }

    public Author(Integer auid) {
        this.auid = auid;
    }

    public Integer getAuid() {
        return auid;
    }

    public void setAuid(Integer auid) {
        this.auid = auid;
    }

    public String getAufullname() {
        return aufullname;
    }

    public void setAufullname(String aufullname) {
        this.aufullname = aufullname;
    }

    public String getAuaddress() {
        return auaddress;
    }

    public void setAuaddress(String auaddress) {
        this.auaddress = auaddress;
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
        hash += (auid != null ? auid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Author)) {
            return false;
        }
        Author other = (Author) object;
        if ((this.auid == null && other.auid != null) || (this.auid != null && !this.auid.equals(other.auid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entity.Author[ auid=" + auid + " ]";
    }

}
