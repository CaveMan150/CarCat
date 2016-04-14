/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Falbe
 */
@Entity
@Table(name = "optiongroups")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Optiongroups.findAll", query = "SELECT o FROM Optiongroups o"),
    @NamedQuery(name = "Optiongroups.findByOptionGroupID", query = "SELECT o FROM Optiongroups o WHERE o.optionGroupID = :optionGroupID"),
    @NamedQuery(name = "Optiongroups.findByOptionGroupName", query = "SELECT o FROM Optiongroups o WHERE o.optionGroupName = :optionGroupName")})
public class Optiongroups implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "OptionGroupID")
    private Integer optionGroupID;
    @Column(name = "OptionGroupName")
    private String optionGroupName;

    public Optiongroups() {
    }

    public Optiongroups(Integer optionGroupID) {
        this.optionGroupID = optionGroupID;
    }

    public Integer getOptionGroupID() {
        return optionGroupID;
    }

    public void setOptionGroupID(Integer optionGroupID) {
        this.optionGroupID = optionGroupID;
    }

    public String getOptionGroupName() {
        return optionGroupName;
    }

    public void setOptionGroupName(String optionGroupName) {
        this.optionGroupName = optionGroupName;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (optionGroupID != null ? optionGroupID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Optiongroups)) {
            return false;
        }
        Optiongroups other = (Optiongroups) object;
        if ((this.optionGroupID == null && other.optionGroupID != null) || (this.optionGroupID != null && !this.optionGroupID.equals(other.optionGroupID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Optiongroups[ optionGroupID=" + optionGroupID + " ]";
    }
    
}
