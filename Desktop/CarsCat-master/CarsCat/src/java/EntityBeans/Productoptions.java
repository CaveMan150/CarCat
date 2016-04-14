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
@Table(name = "productoptions")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Productoptions.findAll", query = "SELECT p FROM Productoptions p"),
    @NamedQuery(name = "Productoptions.findByProductOptionID", query = "SELECT p FROM Productoptions p WHERE p.productOptionID = :productOptionID"),
    @NamedQuery(name = "Productoptions.findByProductID", query = "SELECT p FROM Productoptions p WHERE p.productID = :productID"),
    @NamedQuery(name = "Productoptions.findByOptionID", query = "SELECT p FROM Productoptions p WHERE p.optionID = :optionID"),
    @NamedQuery(name = "Productoptions.findByOptionPriceIncrement", query = "SELECT p FROM Productoptions p WHERE p.optionPriceIncrement = :optionPriceIncrement"),
    @NamedQuery(name = "Productoptions.findByOptionGroupID", query = "SELECT p FROM Productoptions p WHERE p.optionGroupID = :optionGroupID")})
public class Productoptions implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ProductOptionID")
    private Integer productOptionID;
    @Basic(optional = false)
    @Column(name = "ProductID")
    private int productID;
    @Basic(optional = false)
    @Column(name = "OptionID")
    private int optionID;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "OptionPriceIncrement")
    private Double optionPriceIncrement;
    @Basic(optional = false)
    @Column(name = "OptionGroupID")
    private int optionGroupID;

    public Productoptions() {
    }

    public Productoptions(Integer productOptionID) {
        this.productOptionID = productOptionID;
    }

    public Productoptions(Integer productOptionID, int productID, int optionID, int optionGroupID) {
        this.productOptionID = productOptionID;
        this.productID = productID;
        this.optionID = optionID;
        this.optionGroupID = optionGroupID;
    }

    public Integer getProductOptionID() {
        return productOptionID;
    }

    public void setProductOptionID(Integer productOptionID) {
        this.productOptionID = productOptionID;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public int getOptionID() {
        return optionID;
    }

    public void setOptionID(int optionID) {
        this.optionID = optionID;
    }

    public Double getOptionPriceIncrement() {
        return optionPriceIncrement;
    }

    public void setOptionPriceIncrement(Double optionPriceIncrement) {
        this.optionPriceIncrement = optionPriceIncrement;
    }

    public int getOptionGroupID() {
        return optionGroupID;
    }

    public void setOptionGroupID(int optionGroupID) {
        this.optionGroupID = optionGroupID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (productOptionID != null ? productOptionID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Productoptions)) {
            return false;
        }
        Productoptions other = (Productoptions) object;
        if ((this.productOptionID == null && other.productOptionID != null) || (this.productOptionID != null && !this.productOptionID.equals(other.productOptionID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Productoptions[ productOptionID=" + productOptionID + " ]";
    }
    
}
