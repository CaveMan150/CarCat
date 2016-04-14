/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import Entity.Users;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import query.exceptions.NonexistentEntityException;
import query.exceptions.PreexistingEntityException;

/**
 *
 * @author falbellaihi
 */
@ManagedBean
@SessionScoped
public class Controller {
    private String username;
    private String password;
    private int type = -10;
   ;
    private long userID;
    private String fusername;

    

   
    private String WaterAmount;
    private Date WaterTime;
    private String FertilizerAmount;
    private Date StartDate;
    private Date ExpectedEndDate;
    private String OtherNotes;
   
    private String NewUsername;
    private String NewPassword;
    private int NewType;
    private String NewEmail;
    private String NameOfUser;
    private String PictureID = "Unknown";
    private String PhoneNumber;
    
    private String newGen;
    private String newSpec;
    private String NewPic;
    private String newTableN;
    private String newTableP;
    private String newOtherN;
    
    private CharSequence forgotuserID;
    private String returnPass;

   
    public String getFusername() {
        return fusername;
    }

    public void setFusername(String fusername) {
        this.fusername = fusername;
    }
    
    
    
    
   
    
 


    
    

    public long getUserID() {
        return userID;
    }

    public void setUserID(long userID) {
        this.userID = userID;
    }

   
 


   


    
    public String getNewGen() {
        return newGen;
    }

    public void setNewGen(String newGen) {
        this.newGen = newGen;
    }

    public String getNewSpec() {
        return newSpec;
    }

    public void setNewSpec(String newSpec) {
        this.newSpec = newSpec;
    }

    public String getNewPic() {
        return NewPic;
    }

    public void setNewPic(String NewPic) {
        this.NewPic = NewPic;
    }

    public String getNewTableN() {
        return newTableN;
    }

    public void setNewTableN(String newTableN) {
        this.newTableN = newTableN;
    }

    public String getNewTableP() {
        return newTableP;
    }

    public void setNewTableP(String newTableP) {
        this.newTableP = newTableP;
    }

    public String getNewOtherN() {
        return newOtherN;
    }

    public void setNewOtherN(String newOtherN) {
        this.newOtherN = newOtherN;
    }

   


    
    
    
    
    
    

   
    

    public String getNameOfUser() {
        return NameOfUser;
    }

    public void setNameOfUser(String NameOfUser) {
        this.NameOfUser = NameOfUser;
    }

    public String getPictureID() {
        return PictureID;
    }

    public void setPictureID(String PictureID) {
        this.PictureID = PictureID;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String PhoneNumber) {
        this.PhoneNumber = PhoneNumber;
    }
    

    
    public String getNewPassword() {
        return NewPassword;
    }

    public void setNewPassword(String NewPassword) {
        this.NewPassword = NewPassword;
    }

    public int getNewType() {
        return NewType;
    }

    public void setNewType(int NewType) {
        this.NewType = NewType;
    }

    public String getNewEmail() {
        return NewEmail;
    }

    public void setNewEmail(String NewEmail) {
        this.NewEmail = NewEmail;
    }
    /**
     * Creates a new instance of Controller
     */
    
    
    
    public Controller() {

    }



  


    public void setForgotuserID(CharSequence forgotuserID) {
        this.forgotuserID = forgotuserID;
    }

    
    public String getNewUsername() {
        return NewUsername;
    }

    public void setNewUsername(String NewUser) {
        this.NewUsername = NewUser;
    }

 
    
    public String getWaterAmount() {
        return WaterAmount;
    }

    public void setWaterAmount(String WaterAmount) {
        this.WaterAmount = WaterAmount;
    }

    public Date getWaterTime() {
        return WaterTime;
    }

    public void setWaterTime(Date WaterTime) {
        this.WaterTime = WaterTime;
    }

    public String getFertilizerAmount() {
        return FertilizerAmount;
    }

    public void setFertilizerAmount(String FertilizerAmount) {
        this.FertilizerAmount = FertilizerAmount;
    }

    public Date getStartDate() {
        return StartDate;
    }

    public void setStartDate(Date StartDate) {
        this.StartDate = StartDate;
    }

    public Date getExpectedEndDate() {
        return ExpectedEndDate;
    }

    public void setExpectedEndDate(Date ExpectedEndDate) {
        this.ExpectedEndDate = ExpectedEndDate;
    }

    public String getOtherNotes() {
        return OtherNotes;
    }

    public void setOtherNotes(String OtherNotes) {
        this.OtherNotes = OtherNotes;
    }





    public String getReturnPass() {
        return returnPass;
    }

    public void setReturnPass(String returnPass) {
        this.returnPass = returnPass;
    }
    

    

    

   

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getType(int t) {
        switch (t) {
            case 0:
                return "Admin";
            case 1:
                return "Student";
            case 2:
                return "Donator";

        }
        return "Unknown";
    }


  

    public String login() {
        System.out.println("\n\n\n test test " + username + " -- " + password);
         
        Users user = null; //= uController.login(username, password, type);
        if (user == null) {
            return null;
            
        } else {
            System.out.println("\n\n\n test test ");
           
           
           
            switch (type) {
                case 0:

                    return "indx.xhtml";
                case 1:
                    return "indx.xhtml";
                case 2:
                    return "indx.xhtml";

                default:
                    return "indx.xhtml";
            }

        }
    }

    public String logout() {

        username = null;
        password = null;
        type = -10;
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "index.xhtml";

    }
    
    
    
    
}
