/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.io.Serializable;

/**
 *
 * @author Kayde
 */
public class UserDTO implements Serializable {

    private String username;
    private String password;
    private String firstName;
    private String surname;
    private String[] address = new String[5];
    private String passportNumber;
    private boolean isAdmin;
    
    public UserDTO(String username) {
        this.username = username;
    }
    
    public UserDTO(String username, String password) {
        this(username);
        this.password = password;
    }

    public UserDTO(String username, String password, String firstName, String surname, String[] address, String passportNumber) {
        this(username, password);
        this.firstName = firstName;
        this.surname = surname;
        this.address = address;
        this.passportNumber = passportNumber;
    }

    public UserDTO(String username, String password, String firstName, String surname, String[] address, String passportNumber, boolean isAdmin) {
        this(username, password, firstName, surname, address, passportNumber);
        this.isAdmin = isAdmin;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return firstName;
    }
    
    public String getSurname() {
        return surname;
    }

    public String[] getAddress() {
        return address;
    }


    public String getPassportNumber() {
        return passportNumber;
    }

    public boolean isIsAdmin() {
        return isAdmin;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setAddress(String[] address) {
        this.address = address;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public void setIsAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }
}
