/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Falbe
 */
@Entity
@Table(name = "products")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Products.findAll", query = "SELECT p FROM Products p"),
    @NamedQuery(name = "Products.findByProductID", query = "SELECT p FROM Products p WHERE p.productID = :productID"),
    @NamedQuery(name = "Products.findByProductSKU", query = "SELECT p FROM Products p WHERE p.productSKU = :productSKU"),
    @NamedQuery(name = "Products.findByProductName", query = "SELECT p FROM Products p WHERE p.productName = :productName"),
    @NamedQuery(name = "Products.findByProductPrice", query = "SELECT p FROM Products p WHERE p.productPrice = :productPrice"),
    @NamedQuery(name = "Products.findByProductWeight", query = "SELECT p FROM Products p WHERE p.productWeight = :productWeight"),
    @NamedQuery(name = "Products.findByProductCartDesc", query = "SELECT p FROM Products p WHERE p.productCartDesc = :productCartDesc"),
    @NamedQuery(name = "Products.findByProductShortDesc", query = "SELECT p FROM Products p WHERE p.productShortDesc = :productShortDesc"),
    @NamedQuery(name = "Products.findByProductThumb", query = "SELECT p FROM Products p WHERE p.productThumb = :productThumb"),
    @NamedQuery(name = "Products.findByProductImage", query = "SELECT p FROM Products p WHERE p.productImage = :productImage"),
    @NamedQuery(name = "Products.findByProductCategoryID", query = "SELECT p FROM Products p WHERE p.productCategoryID = :productCategoryID"),
    @NamedQuery(name = "Products.findByProductUpdateDate", query = "SELECT p FROM Products p WHERE p.productUpdateDate = :productUpdateDate"),
    @NamedQuery(name = "Products.findByProductStock", query = "SELECT p FROM Products p WHERE p.productStock = :productStock"),
    @NamedQuery(name = "Products.findByProductLive", query = "SELECT p FROM Products p WHERE p.productLive = :productLive"),
    @NamedQuery(name = "Products.findByProductUnlimited", query = "SELECT p FROM Products p WHERE p.productUnlimited = :productUnlimited"),
    @NamedQuery(name = "Products.findByProductLocation", query = "SELECT p FROM Products p WHERE p.productLocation = :productLocation")})
public class Products implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ProductID")
    private Integer productID;
    @Basic(optional = false)
    @Column(name = "ProductSKU")
    private String productSKU;
    @Basic(optional = false)
    @Column(name = "ProductName")
    private String productName;
    @Basic(optional = false)
    @Column(name = "ProductPrice")
    private float productPrice;
    @Basic(optional = false)
    @Column(name = "ProductWeight")
    private float productWeight;
    @Basic(optional = false)
    @Column(name = "ProductCartDesc")
    private String productCartDesc;
    @Basic(optional = false)
    @Column(name = "ProductShortDesc")
    private String productShortDesc;
    @Basic(optional = false)
    @Lob
    @Column(name = "ProductLongDesc")
    private String productLongDesc;
    @Basic(optional = false)
    @Column(name = "ProductThumb")
    private String productThumb;
    @Basic(optional = false)
    @Column(name = "ProductImage")
    private String productImage;
    @Column(name = "ProductCategoryID")
    private Integer productCategoryID;
    @Basic(optional = false)
    @Column(name = "ProductUpdateDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date productUpdateDate;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "ProductStock")
    private Float productStock;
    @Column(name = "ProductLive")
    private Boolean productLive;
    @Column(name = "ProductUnlimited")
    private Boolean productUnlimited;
    @Column(name = "ProductLocation")
    private String productLocation;

    public Products() {
    }

    public Products(Integer productID) {
        this.productID = productID;
    }

    public Products(Integer productID, String productSKU, String productName, float productPrice, float productWeight, String productCartDesc, String productShortDesc, String productLongDesc, String productThumb, String productImage, Date productUpdateDate) {
        this.productID = productID;
        this.productSKU = productSKU;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productWeight = productWeight;
        this.productCartDesc = productCartDesc;
        this.productShortDesc = productShortDesc;
        this.productLongDesc = productLongDesc;
        this.productThumb = productThumb;
        this.productImage = productImage;
        this.productUpdateDate = productUpdateDate;
    }

    public Integer getProductID() {
        return productID;
    }

    public void setProductID(Integer productID) {
        this.productID = productID;
    }

    public String getProductSKU() {
        return productSKU;
    }

    public void setProductSKU(String productSKU) {
        this.productSKU = productSKU;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public float getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(float productPrice) {
        this.productPrice = productPrice;
    }

    public float getProductWeight() {
        return productWeight;
    }

    public void setProductWeight(float productWeight) {
        this.productWeight = productWeight;
    }

    public String getProductCartDesc() {
        return productCartDesc;
    }

    public void setProductCartDesc(String productCartDesc) {
        this.productCartDesc = productCartDesc;
    }

    public String getProductShortDesc() {
        return productShortDesc;
    }

    public void setProductShortDesc(String productShortDesc) {
        this.productShortDesc = productShortDesc;
    }

    public String getProductLongDesc() {
        return productLongDesc;
    }

    public void setProductLongDesc(String productLongDesc) {
        this.productLongDesc = productLongDesc;
    }

    public String getProductThumb() {
        return productThumb;
    }

    public void setProductThumb(String productThumb) {
        this.productThumb = productThumb;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public Integer getProductCategoryID() {
        return productCategoryID;
    }

    public void setProductCategoryID(Integer productCategoryID) {
        this.productCategoryID = productCategoryID;
    }

    public Date getProductUpdateDate() {
        return productUpdateDate;
    }

    public void setProductUpdateDate(Date productUpdateDate) {
        this.productUpdateDate = productUpdateDate;
    }

    public Float getProductStock() {
        return productStock;
    }

    public void setProductStock(Float productStock) {
        this.productStock = productStock;
    }

    public Boolean getProductLive() {
        return productLive;
    }

    public void setProductLive(Boolean productLive) {
        this.productLive = productLive;
    }

    public Boolean getProductUnlimited() {
        return productUnlimited;
    }

    public void setProductUnlimited(Boolean productUnlimited) {
        this.productUnlimited = productUnlimited;
    }

    public String getProductLocation() {
        return productLocation;
    }

    public void setProductLocation(String productLocation) {
        this.productLocation = productLocation;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (productID != null ? productID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Products)) {
            return false;
        }
        Products other = (Products) object;
        if ((this.productID == null && other.productID != null) || (this.productID != null && !this.productID.equals(other.productID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Products[ productID=" + productID + " ]";
    }
    
}
