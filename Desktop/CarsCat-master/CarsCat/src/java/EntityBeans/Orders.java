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
@Table(name = "orders")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Orders.findAll", query = "SELECT o FROM Orders o"),
    @NamedQuery(name = "Orders.findByOrderID", query = "SELECT o FROM Orders o WHERE o.orderID = :orderID"),
    @NamedQuery(name = "Orders.findByOrderUserID", query = "SELECT o FROM Orders o WHERE o.orderUserID = :orderUserID"),
    @NamedQuery(name = "Orders.findByOrderAmount", query = "SELECT o FROM Orders o WHERE o.orderAmount = :orderAmount"),
    @NamedQuery(name = "Orders.findByOrderShipName", query = "SELECT o FROM Orders o WHERE o.orderShipName = :orderShipName"),
    @NamedQuery(name = "Orders.findByOrderShipAddress", query = "SELECT o FROM Orders o WHERE o.orderShipAddress = :orderShipAddress"),
    @NamedQuery(name = "Orders.findByOrderShipAddress2", query = "SELECT o FROM Orders o WHERE o.orderShipAddress2 = :orderShipAddress2"),
    @NamedQuery(name = "Orders.findByOrderCity", query = "SELECT o FROM Orders o WHERE o.orderCity = :orderCity"),
    @NamedQuery(name = "Orders.findByOrderState", query = "SELECT o FROM Orders o WHERE o.orderState = :orderState"),
    @NamedQuery(name = "Orders.findByOrderZip", query = "SELECT o FROM Orders o WHERE o.orderZip = :orderZip"),
    @NamedQuery(name = "Orders.findByOrderCountry", query = "SELECT o FROM Orders o WHERE o.orderCountry = :orderCountry"),
    @NamedQuery(name = "Orders.findByOrderPhone", query = "SELECT o FROM Orders o WHERE o.orderPhone = :orderPhone"),
    @NamedQuery(name = "Orders.findByOrderFax", query = "SELECT o FROM Orders o WHERE o.orderFax = :orderFax"),
    @NamedQuery(name = "Orders.findByOrderShipping", query = "SELECT o FROM Orders o WHERE o.orderShipping = :orderShipping"),
    @NamedQuery(name = "Orders.findByOrderTax", query = "SELECT o FROM Orders o WHERE o.orderTax = :orderTax"),
    @NamedQuery(name = "Orders.findByOrderEmail", query = "SELECT o FROM Orders o WHERE o.orderEmail = :orderEmail"),
    @NamedQuery(name = "Orders.findByOrderDate", query = "SELECT o FROM Orders o WHERE o.orderDate = :orderDate"),
    @NamedQuery(name = "Orders.findByOrderShipped", query = "SELECT o FROM Orders o WHERE o.orderShipped = :orderShipped"),
    @NamedQuery(name = "Orders.findByOrderTrackingNumber", query = "SELECT o FROM Orders o WHERE o.orderTrackingNumber = :orderTrackingNumber")})
public class Orders implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "OrderID")
    private Integer orderID;
    @Basic(optional = false)
    @Column(name = "OrderUserID")
    private int orderUserID;
    @Basic(optional = false)
    @Column(name = "OrderAmount")
    private float orderAmount;
    @Basic(optional = false)
    @Column(name = "OrderShipName")
    private String orderShipName;
    @Basic(optional = false)
    @Column(name = "OrderShipAddress")
    private String orderShipAddress;
    @Basic(optional = false)
    @Column(name = "OrderShipAddress2")
    private String orderShipAddress2;
    @Basic(optional = false)
    @Column(name = "OrderCity")
    private String orderCity;
    @Basic(optional = false)
    @Column(name = "OrderState")
    private String orderState;
    @Basic(optional = false)
    @Column(name = "OrderZip")
    private String orderZip;
    @Basic(optional = false)
    @Column(name = "OrderCountry")
    private String orderCountry;
    @Basic(optional = false)
    @Column(name = "OrderPhone")
    private String orderPhone;
    @Basic(optional = false)
    @Column(name = "OrderFax")
    private String orderFax;
    @Basic(optional = false)
    @Column(name = "OrderShipping")
    private float orderShipping;
    @Basic(optional = false)
    @Column(name = "OrderTax")
    private float orderTax;
    @Basic(optional = false)
    @Column(name = "OrderEmail")
    private String orderEmail;
    @Basic(optional = false)
    @Column(name = "OrderDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date orderDate;
    @Basic(optional = false)
    @Column(name = "OrderShipped")
    private boolean orderShipped;
    @Column(name = "OrderTrackingNumber")
    private String orderTrackingNumber;

    public Orders() {
    }

    public Orders(Integer orderID) {
        this.orderID = orderID;
    }

    public Orders(Integer orderID, int orderUserID, float orderAmount, String orderShipName, String orderShipAddress, String orderShipAddress2, String orderCity, String orderState, String orderZip, String orderCountry, String orderPhone, String orderFax, float orderShipping, float orderTax, String orderEmail, Date orderDate, boolean orderShipped) {
        this.orderID = orderID;
        this.orderUserID = orderUserID;
        this.orderAmount = orderAmount;
        this.orderShipName = orderShipName;
        this.orderShipAddress = orderShipAddress;
        this.orderShipAddress2 = orderShipAddress2;
        this.orderCity = orderCity;
        this.orderState = orderState;
        this.orderZip = orderZip;
        this.orderCountry = orderCountry;
        this.orderPhone = orderPhone;
        this.orderFax = orderFax;
        this.orderShipping = orderShipping;
        this.orderTax = orderTax;
        this.orderEmail = orderEmail;
        this.orderDate = orderDate;
        this.orderShipped = orderShipped;
    }

    public Integer getOrderID() {
        return orderID;
    }

    public void setOrderID(Integer orderID) {
        this.orderID = orderID;
    }

    public int getOrderUserID() {
        return orderUserID;
    }

    public void setOrderUserID(int orderUserID) {
        this.orderUserID = orderUserID;
    }

    public float getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(float orderAmount) {
        this.orderAmount = orderAmount;
    }

    public String getOrderShipName() {
        return orderShipName;
    }

    public void setOrderShipName(String orderShipName) {
        this.orderShipName = orderShipName;
    }

    public String getOrderShipAddress() {
        return orderShipAddress;
    }

    public void setOrderShipAddress(String orderShipAddress) {
        this.orderShipAddress = orderShipAddress;
    }

    public String getOrderShipAddress2() {
        return orderShipAddress2;
    }

    public void setOrderShipAddress2(String orderShipAddress2) {
        this.orderShipAddress2 = orderShipAddress2;
    }

    public String getOrderCity() {
        return orderCity;
    }

    public void setOrderCity(String orderCity) {
        this.orderCity = orderCity;
    }

    public String getOrderState() {
        return orderState;
    }

    public void setOrderState(String orderState) {
        this.orderState = orderState;
    }

    public String getOrderZip() {
        return orderZip;
    }

    public void setOrderZip(String orderZip) {
        this.orderZip = orderZip;
    }

    public String getOrderCountry() {
        return orderCountry;
    }

    public void setOrderCountry(String orderCountry) {
        this.orderCountry = orderCountry;
    }

    public String getOrderPhone() {
        return orderPhone;
    }

    public void setOrderPhone(String orderPhone) {
        this.orderPhone = orderPhone;
    }

    public String getOrderFax() {
        return orderFax;
    }

    public void setOrderFax(String orderFax) {
        this.orderFax = orderFax;
    }

    public float getOrderShipping() {
        return orderShipping;
    }

    public void setOrderShipping(float orderShipping) {
        this.orderShipping = orderShipping;
    }

    public float getOrderTax() {
        return orderTax;
    }

    public void setOrderTax(float orderTax) {
        this.orderTax = orderTax;
    }

    public String getOrderEmail() {
        return orderEmail;
    }

    public void setOrderEmail(String orderEmail) {
        this.orderEmail = orderEmail;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public boolean getOrderShipped() {
        return orderShipped;
    }

    public void setOrderShipped(boolean orderShipped) {
        this.orderShipped = orderShipped;
    }

    public String getOrderTrackingNumber() {
        return orderTrackingNumber;
    }

    public void setOrderTrackingNumber(String orderTrackingNumber) {
        this.orderTrackingNumber = orderTrackingNumber;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (orderID != null ? orderID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Orders)) {
            return false;
        }
        Orders other = (Orders) object;
        if ((this.orderID == null && other.orderID != null) || (this.orderID != null && !this.orderID.equals(other.orderID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Orders[ orderID=" + orderID + " ]";
    }
    
}
