/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author Kayde
 */
public class UserDTO {
    private String UserID;
    private String password;
    private String fullName;
    private String address;
    private int age;
    private int passportNumber;
    private boolean isAdmin;
    
    public UserDTO(String userID, String password){
        this.UserID = userID;
    }
    public UserDTO(String userID, String password, String fullName, String address, int age, int passportNumber){
        this(userID, password);
        this.fullName = fullName;
        this.address = address;
        this.age = age;
        this.passportNumber = passportNumber;
    }
    public UserDTO(String userID, String password, String fullName, String address, int age, int passportNumber, boolean isAdmin){
        this(userID, password, fullName,address, age, passportNumber);
        this.isAdmin = isAdmin;
    }

    public String getUserID() {
        return UserID;
    }
    public String getPassword() {
        return password;
    }
    public String getFullName() {
        return fullName;
    }

    public String getAddress() {
        return address;
    }

    public int getAge() {
        return age;
    }

    public int getPassportNumber() {
        return passportNumber;
    }

    public boolean isIsAdmin() {
        return isAdmin;
    }

    public void setUserID(String UserID) {
        this.UserID = UserID;
    }
    
    public void setPassword(String password){
        this.password = password;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setPassportNumber(int passportNumber) {
        this.passportNumber = passportNumber;
    }

    public void setIsAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }
}
