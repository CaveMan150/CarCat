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
@Table(name = "users")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Users.findAll", query = "SELECT u FROM Users u"),
    @NamedQuery(name = "Users.findByUserID", query = "SELECT u FROM Users u WHERE u.userID = :userID"),
    @NamedQuery(name = "Users.findByUserEmail", query = "SELECT u FROM Users u WHERE u.userEmail = :userEmail"),
    @NamedQuery(name = "Users.findByUserPassword", query = "SELECT u FROM Users u WHERE u.userPassword = :userPassword"),
    @NamedQuery(name = "Users.findByUserFirstName", query = "SELECT u FROM Users u WHERE u.userFirstName = :userFirstName"),
    @NamedQuery(name = "Users.findByUserLastName", query = "SELECT u FROM Users u WHERE u.userLastName = :userLastName"),
    @NamedQuery(name = "Users.findByUserCity", query = "SELECT u FROM Users u WHERE u.userCity = :userCity"),
    @NamedQuery(name = "Users.findByUserState", query = "SELECT u FROM Users u WHERE u.userState = :userState"),
    @NamedQuery(name = "Users.findByUserZip", query = "SELECT u FROM Users u WHERE u.userZip = :userZip"),
    @NamedQuery(name = "Users.findByUserEmailVerified", query = "SELECT u FROM Users u WHERE u.userEmailVerified = :userEmailVerified"),
    @NamedQuery(name = "Users.findByUserRegistrationDate", query = "SELECT u FROM Users u WHERE u.userRegistrationDate = :userRegistrationDate"),
    @NamedQuery(name = "Users.findByUserVerificationCode", query = "SELECT u FROM Users u WHERE u.userVerificationCode = :userVerificationCode"),
    @NamedQuery(name = "Users.findByUserIP", query = "SELECT u FROM Users u WHERE u.userIP = :userIP"),
    @NamedQuery(name = "Users.findByUserPhone", query = "SELECT u FROM Users u WHERE u.userPhone = :userPhone"),
    @NamedQuery(name = "Users.findByUserFax", query = "SELECT u FROM Users u WHERE u.userFax = :userFax"),
    @NamedQuery(name = "Users.findByUserCountry", query = "SELECT u FROM Users u WHERE u.userCountry = :userCountry"),
    @NamedQuery(name = "Users.findByUserAddress", query = "SELECT u FROM Users u WHERE u.userAddress = :userAddress"),
    @NamedQuery(name = "Users.findByUserAddress2", query = "SELECT u FROM Users u WHERE u.userAddress2 = :userAddress2")})
public class Users implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "UserID")
    private Integer userID;
    @Column(name = "UserEmail")
    private String userEmail;
    @Column(name = "UserPassword")
    private String userPassword;
    @Column(name = "UserFirstName")
    private String userFirstName;
    @Column(name = "UserLastName")
    private String userLastName;
    @Column(name = "UserCity")
    private String userCity;
    @Column(name = "UserState")
    private String userState;
    @Column(name = "UserZip")
    private String userZip;
    @Column(name = "UserEmailVerified")
    private Boolean userEmailVerified;
    @Column(name = "UserRegistrationDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date userRegistrationDate;
    @Column(name = "UserVerificationCode")
    private String userVerificationCode;
    @Column(name = "UserIP")
    private String userIP;
    @Column(name = "UserPhone")
    private String userPhone;
    @Column(name = "UserFax")
    private String userFax;
    @Column(name = "UserCountry")
    private String userCountry;
    @Column(name = "UserAddress")
    private String userAddress;
    @Column(name = "UserAddress2")
    private String userAddress2;

    public Users() {
    }

    public Users(Integer userID) {
        this.userID = userID;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserFirstName() {
        return userFirstName;
    }

    public void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    public String getUserCity() {
        return userCity;
    }

    public void setUserCity(String userCity) {
        this.userCity = userCity;
    }

    public String getUserState() {
        return userState;
    }

    public void setUserState(String userState) {
        this.userState = userState;
    }

    public String getUserZip() {
        return userZip;
    }

    public void setUserZip(String userZip) {
        this.userZip = userZip;
    }

    public Boolean getUserEmailVerified() {
        return userEmailVerified;
    }

    public void setUserEmailVerified(Boolean userEmailVerified) {
        this.userEmailVerified = userEmailVerified;
    }

    public Date getUserRegistrationDate() {
        return userRegistrationDate;
    }

    public void setUserRegistrationDate(Date userRegistrationDate) {
        this.userRegistrationDate = userRegistrationDate;
    }

    public String getUserVerificationCode() {
        return userVerificationCode;
    }

    public void setUserVerificationCode(String userVerificationCode) {
        this.userVerificationCode = userVerificationCode;
    }

    public String getUserIP() {
        return userIP;
    }

    public void setUserIP(String userIP) {
        this.userIP = userIP;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserFax() {
        return userFax;
    }

    public void setUserFax(String userFax) {
        this.userFax = userFax;
    }

    public String getUserCountry() {
        return userCountry;
    }

    public void setUserCountry(String userCountry) {
        this.userCountry = userCountry;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public String getUserAddress2() {
        return userAddress2;
    }

    public void setUserAddress2(String userAddress2) {
        this.userAddress2 = userAddress2;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userID != null ? userID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Users)) {
            return false;
        }
        Users other = (Users) object;
        if ((this.userID == null && other.userID != null) || (this.userID != null && !this.userID.equals(other.userID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Users[ userID=" + userID + " ]";
    }

    public Object getUsername() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
