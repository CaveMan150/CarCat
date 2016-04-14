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
@Table(name = "options")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Options.findAll", query = "SELECT o FROM Options o"),
    @NamedQuery(name = "Options.findByOptionID", query = "SELECT o FROM Options o WHERE o.optionID = :optionID"),
    @NamedQuery(name = "Options.findByOptionGroupID", query = "SELECT o FROM Options o WHERE o.optionGroupID = :optionGroupID"),
    @NamedQuery(name = "Options.findByOptionName", query = "SELECT o FROM Options o WHERE o.optionName = :optionName")})
public class Options implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "OptionID")
    private Integer optionID;
    @Column(name = "OptionGroupID")
    private Integer optionGroupID;
    @Column(name = "OptionName")
    private String optionName;

    public Options() {
    }

    public Options(Integer optionID) {
        this.optionID = optionID;
    }

    public Integer getOptionID() {
        return optionID;
    }

    public void setOptionID(Integer optionID) {
        this.optionID = optionID;
    }

    public Integer getOptionGroupID() {
        return optionGroupID;
    }

    public void setOptionGroupID(Integer optionGroupID) {
        this.optionGroupID = optionGroupID;
    }

    public String getOptionName() {
        return optionName;
    }

    public void setOptionName(String optionName) {
        this.optionName = optionName;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (optionID != null ? optionID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Options)) {
            return false;
        }
        Options other = (Options) object;
        if ((this.optionID == null && other.optionID != null) || (this.optionID != null && !this.optionID.equals(other.optionID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Options[ optionID=" + optionID + " ]";
    }
    
}
