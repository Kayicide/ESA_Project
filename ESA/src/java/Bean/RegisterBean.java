/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import Command.CommandFactory;
import DTO.UserDTO;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Kayde
 */
@Named(value = "registerBean")
@RequestScoped
public class RegisterBean {

    private String addressLine1, addressLine2,addressCity, addressCounty, addressPostcode;
    private String username, password, confirmPassword, firstname, surname, passportNumber;
    private String[] address;

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
    
    public void setAddressLine1(String addressLine1){
        this.addressLine1 = addressLine1;
    }
    
    public void setAddressLine2(String addressLine2){
        this.addressLine2 = addressLine2;
    }
    
    public void setAddressCity(String addressCity){
        this.addressCity = addressCity;
    }
    
    public void setAddressCounty(String addressCounty){
        this.addressCounty = addressCounty;
    }
    
    public void setAddressPostcode(String addressPostcode){
        this.addressPostcode = addressPostcode;
    }

    public void setAddress() {
       String[] adr = new String[5];
       
       adr[0] = addressLine1;
       adr[1] = addressLine2;
       adr[2] = addressCity;
       adr[3] = addressCounty;
       adr[4] = addressPostcode;
       
       
       System.out.println("ADDRESSLINE 1: " + addressLine1);
       if(adr != null){
           System.out.println("TESTING ARRAY: " + adr[0]);
       }
       this.address = adr;
    }


    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public String getFirstname() {
        return firstname;
    }
    public String getSurname() {
        return surname;
    }
    
    public String getAddressLine1(){
        return addressLine1;
    }
    
    public String getAddressLine2(){
        return addressLine2;
    }

    public String getAddressCity(){
        return addressCity;
    }
    
    public String getAddressCounty(){
        return addressCounty;
    }
    
    public String getAddressPostcode(){
        return addressPostcode;
    }
    public String[] getAddress() {
        return address;
    }


    public String getPassportNumber() {
        return passportNumber;
    }

    public String register() {
        if(!(password.equals(confirmPassword))){
            //display passwords do not match error!
            return null;
        }else{
            
            //creates the address array
            setAddress();
            
            //encrypts the password now that we know they match
            try{
                byte[] hash = MessageDigest.getInstance("SHA-256").digest(password.getBytes(StandardCharsets.UTF_8));
                password = Base64.getEncoder().encodeToString(hash);       
            }catch(NoSuchAlgorithmException e){
                //failed to encrypt password!
            }

            if((Boolean)CommandFactory.createCommand(CommandFactory.REGISTER_USER, new UserDTO(username, password, firstname, surname, address, passportNumber, false)).execute()){
                return "/login"; //user has been registered so forward them to the login page!
            }else{
                //display registation failed. Username may be taken or sql error!
                return null;
            }
        }
    }
}
